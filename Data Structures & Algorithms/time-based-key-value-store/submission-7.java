class TimeMap {

    HashMap<String, List<Pair<Integer,String>>> map;

    public TimeMap() {
        this.map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String>> values;

        if(this.map.containsKey(key))
        {
            values = this.map.get(key); 
        }
        else
        {
            values = new ArrayList<>();
        }
        Pair<Integer, String> pair = new Pair<>(timestamp,value);
        values.add(pair);
        this.map.put(key, values);
        
    }
    
    public String get(String key, int timestamp) {

        if(!this.map.containsKey(key))
            return "";
        
        List<Pair<Integer, String>> values = this.map.get(key);

        if(values.size() == 0)
            return "";

        return binarySearch(values, timestamp);
        
    }

    private String binarySearch(List<Pair<Integer, String>> values, int timestamp)
    {
        int left = 0, right = values.size() - 1;

        String res = "";

        while(left <= right)
        {
            int mid = (left + right)/2;

            int ts = values.get(mid).getKey();

            if(ts == timestamp)
                return values.get(mid).getValue();

            if(ts <= timestamp)
            {
                
                left = mid + 1;
                res = values.get(mid).getValue();
            }
            else
                right = mid - 1; 
        }
        return  res;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] kFrequent = new int[k];

        HashMap<Integer, Integer> frequency = new HashMap<>();

        for(int num : nums)
        {
            frequency.put(num, frequency.getOrDefault(num,0)+ 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>( new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2)
            {
                return  entry2.getValue() - entry1.getValue();
            }
        });

        for(Map.Entry<Integer, Integer> entry : frequency.entrySet())
        {
            queue.add(entry);
        }

        int i = 0;
        while(k > 0)
        {
            kFrequent[i++] = queue.poll().getKey();
            k--;
        }

        return kFrequent;

        
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> dict = new HashMap<>();

        int[] keyArr = new int[26];

        for(String str : strs)
        {
            String key = generateKey(str, keyArr);

            System.out.println(key);

            List<String> words = null;

            if(dict.containsKey(key))
            {
                words = dict.get(key);
            }
            else
            {
                words = new ArrayList<>();
            }

            words.add(str);

            dict.put(key, words);

            keyArr = new int[26];

        }

        List<List<String>> result = new ArrayList<>();

        for(List<String> lst : dict.values())
            result.add(lst);

        return result;
    
    }

    public String generateKey(String str, int[] keyArr)
    {
        StringBuilder key = new StringBuilder();
        for(char ch : str.toCharArray())
        {
            int index = ch - 'a';
            keyArr[index]++;
        }

        for(int i = 0 ; i < 26 ; i++)
        {
            if(keyArr[i] != 0)
            {
                key.append(i);
                key.append(keyArr[i]);
                key.append('#');
            }
        }

        return key.toString();
    }
}

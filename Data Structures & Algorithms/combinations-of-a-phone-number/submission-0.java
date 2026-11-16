class Solution {
    List<String> result;
    Map<Character, List<Character>> map;

    public List<String> letterCombinations(String digits) {

        result = new ArrayList<>();

        if(digits.isEmpty())
            return result;

        map = new HashMap<>();

        map.put('2',Arrays.asList('a','b','c'));
        map.put('3',Arrays.asList('d','e','f'));
        map.put('4',Arrays.asList('g','h','i'));
        map.put('5',Arrays.asList('j','k','l'));
        map.put('6',Arrays.asList('m','n','o'));
        map.put('7',Arrays.asList('p','q','r','s'));
        map.put('8',Arrays.asList('t','u','v'));
        map.put('9',Arrays.asList('w','x','y','z'));

        StringBuilder temp = new StringBuilder();

        backtracking(digits, 0, temp);

        return result;   
    }

    private void backtracking(String digits, int index, StringBuilder temp)
    {

        if(index > digits.length())
            return;

        if(temp.length() == digits.length())
        {
            result.add(new String(temp.toString()));
            return;
        }

        for(int i = index ; i < digits.length() ; i++)
        {
            for(Character ch : map.get(digits.charAt(i)))
            {
                temp.append(ch);
                backtracking(digits, i + 1, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }


    }
}

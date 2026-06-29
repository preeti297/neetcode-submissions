class Solution {

    public String encode(List<String> strs) {

        StringBuilder encodedString = new StringBuilder();

        for(String str : strs)
        {
            int len = str.length();

            encodedString.append(len);
            encodedString.append('#');
            encodedString.append(str);
        }

    return encodedString.toString();

    }

    public List<String> decode(String str) {

        int num = 0 ;

        int i = 0;

        char[] charArr = str.toCharArray();

        int l = charArr.length;

        List<String> result = new ArrayList<>();

        while(i < l)
        {
            if(Character.isDigit(charArr[i]))
            {
                while(Character.isDigit(charArr[i]))
                {
                    num = num * 10 + Character.getNumericValue(charArr[i]);
                    i++;

                    
                }

                if(charArr[i] == '#')
                {
                    i++;
                    result.add(str.substring(i, i + num));
                    i = i + num;
                }

                num = 0;
            }

            
        }

        return result;

    }
}

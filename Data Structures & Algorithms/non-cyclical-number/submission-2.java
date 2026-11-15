class Solution {
    public boolean isHappy(int n) {

        Set<Integer> seen = new HashSet<>();

        while(true)
        {
            int num = sumOfSquares(n);

            //System.out.println(num);

            if(num == 1)
                return true;
            
            if(seen.contains(num))
                return false;
            
            seen.add(num);

            n = num;
        }

        
    }

    private int sumOfSquares(int n)
    {

        int sum  =0 ;

        while(n > 0)
        {
            int digit = n % 10;

            n = n/10;

            sum += digit * digit;
        }

        return sum;
    }
}

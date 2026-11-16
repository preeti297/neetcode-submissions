class Solution {
    public double myPow(double x, int n) {

        /* Do it in power of 2's - actaully can write it as num * helper(num, n-1) - can cause stack overflow so do it in pwoers of 2*/
        if(x == 0)
            return 0;

        if(n == 0)
            return 1;

        double res = helper(x, Math.abs((long)n));
        return (n >= 0) ? res : 1/res;
        
    }

    private double helper(double x, long pow)
    {
        if( pow == 0)
            return 1;
        
        double res = 1;
        
        if(pow%2 == 0)
            res = helper(x*x, pow/2);
        else
            res = x*helper(x*x, pow/2);   

        return res;     

    }
}

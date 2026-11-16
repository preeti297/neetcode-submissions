class Solution {
    public double myPow(double x, int n) {

        /* Do it in pwoer of 2's*/
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
        
        double res = helper(x, pow/2);

        return (pow%2 == 0) ? res * res : res * res * x;
        

    }
}

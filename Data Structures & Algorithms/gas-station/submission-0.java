class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        /*
        Intuition greedy approach - to around the entire array starting at index i

        if tankDiff is <0, then cannot be started at that index

        and if totalDiff or cost >0 thats when its possible to go around
        
        Brute force - start at every index and see if a round can be completed
        
        */

        int totalDiff = 0, tankDiff = 0;

        int start = 0;

        for(int i = 0 ; i < gas.length ; i++)
        {
            tankDiff += gas[i] - cost[i];
            totalDiff += gas[i] - cost[i];

            if(tankDiff < 0)
            {
                start = i+1;
                tankDiff = 0;
            }

        }

        return totalDiff >= 0 ? start : -1;
        
    }
}

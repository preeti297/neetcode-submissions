class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        /*
        Intuition - brute force, try different combination triplets

        but in greedy approach, ignore triplets that doesnt match target values i mean greater than target values, and check which if any triplet matches the starget value add it to a hashset - if its size is 3 it means 1,2,3 indices then we are good, it can come from any triplet
        
        */

        Set<Integer> good = new HashSet<>();

        for(int[] t :  triplets)
        {
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2])
                continue;
            
            for(int i = 0 ; i < t.length ; i++)
            {
                if(t[i] == target[i])
                    good.add(i);
            }

        }

        return good.size() == 3;
        
    }
}

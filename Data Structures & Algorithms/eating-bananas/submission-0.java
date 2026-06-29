class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int right = 0;

        for(int pile : piles)
            right = Math.max(right, pile);

        int left = 1;

        while(left < right)
        {
            int mid = (left + right)/2;

            if(isPossible(piles, mid, h))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
   
    }

    public boolean isPossible(int[] piles, int k, int h)
    {
        int countHours = 0;

        for(int pile : piles)
        {
            countHours += pile/k;
            if(pile % k != 0)
                countHours += 1;
        }

        return countHours <= h ? true : false;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        List<int[]> cars = new ArrayList<>();
        int l = position.length;

        for(int i = 0 ; i < l ; i++)
        {
            int[] car = new int[2];
            car[0] = position[i];
            car[1] = speed[i];

            cars.add(car);
        }

        Collections.sort(cars, (a,b) -> b[0]-a[0]);

        List<Double> times = new ArrayList<>();

        for(int[] car : cars)
        {
            double time = (double)(target - car[0])/car[1];
            times.add(time);
        }

        Stack<Double> stack = new Stack<>();

        for(double time : times)
        {
            if(!stack.isEmpty() && stack.peek() >= time)
            {
                continue;
            }
            else
            {
            stack.push(time);
            }
        }

        return stack.size();
        
    }
}

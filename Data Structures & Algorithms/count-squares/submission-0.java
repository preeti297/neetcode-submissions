class CountSquares {

    /*
    Intuition - to count points - if the points are on diagonals then the abs diff of x and y are the same, you can figure out other points as its parallel to x and y axis. 
    */

    List<int[]> points;
    Map<List<Integer>, Integer> countPoints;

    public CountSquares() {

        points = new ArrayList<>();
        countPoints = new HashMap<>(); // to handle duplicates
        
    }
    
    public void add(int[] point) {

        points.add(point);

        List<Integer> pt = new ArrayList<>();
        pt.add(point[0]);
        pt.add(point[1]);

        countPoints.put(pt, countPoints.getOrDefault(pt,0) + 1);
        
    }
    
    public int count(int[] point) {

        int res = 0 ;

        int px = point[0], py = point[1];

        for(int[] p : points)
        {
            int x = p[0], y = p[1];

            if(Math.abs(x-px) != Math.abs(y-py) || x == px || y == py)
                continue;
            
            res += countPoints.getOrDefault(Arrays.asList(x,py), 0) * countPoints.getOrDefault(Arrays.asList(px,y), 0);

        }

        return res;
        
    }
}

class DetectSquares {
    Map<String, Integer> map;

    public DetectSquares() {
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        String key=point[0]+","+point[1];
        map.put(key,map.getOrDefault(key,0)+1);
        
    }
    
    public int count(int[] point) {
        int x=point[0];
        int y=point[1];

        int result=0;

        for(String key: map.keySet()){
            String coordinates[]=key.split(",");
            int x1=Integer.parseInt(coordinates[0]);
            int y1=Integer.parseInt(coordinates[1]);

            if(Math.abs(x-x1)!=Math.abs(y-y1)|| y==y1) continue;

            String point2=x+","+y1;
            String point3=x1+","+y;

            int count1=map.get(key);
            int count2=map.getOrDefault(point2,0);
            int count3=map.getOrDefault(point3,0);

            result+=count1*count2*count3;
        }

        return result;
        
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
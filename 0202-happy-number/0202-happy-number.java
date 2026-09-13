class Solution {
    public boolean isHappy(int n) {

        Set<Integer> seen=new HashSet<>();

        while(n!=1){
            if(seen.contains(n)) return false;

            seen.add(n);

            n=transform(n);
        }return true;
        
    }

    int transform(int n){
        int sum=0;

        while(n>0){
            sum+=(n%10)*(n%10);
            n=n/10;
        }return sum;
    }
}
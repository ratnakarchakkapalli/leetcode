class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        // int maxPile=0;
        // for(int pile: piles){
        //     maxPile=Math.max(maxPile, pile);

        // }


        // for(int k=1;k<=maxPile;k++){
        //     long hours=0;
        //     for(int pile:piles){
        //         //if(pile%k==0) hours+=pile/k;
        //         //else hours+=pile/k+1;
        //         hours+=pile/k;

        //         if(pile%k!=0) hours++; 
                
        //     }

        //     if(hours<=h) return k;
        // }return 0;


        int left=1;
        int right=0;
        for(int pile: piles){
            right=Math.max(right, pile);

        }


        while(left<right){

            int mid=left+(right-left)/2;

            int hours=0;

            for (int pile:piles){
                hours+=pile/mid;

                if(pile%mid!=0) hours++;  
            }

            if(hours<=h) right=mid;

            else left=mid+1;


        }return right;
        
    }
}
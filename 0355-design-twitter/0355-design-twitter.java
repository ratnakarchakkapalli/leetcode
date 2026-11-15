class Twitter {


    class Tweet{
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId, int time){
            this.tweetId=tweetId;
            this.time=time;
        }
    }

    Map<Integer, Tweet> tweets;
    Map<Integer, Set<Integer>> following;
    int time;

    public Twitter() {
        tweets=new HashMap<>();
        following=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet=new Tweet(tweetId, time++);
        newTweet.next=tweets.get(userId);

        tweets.put(userId, newTweet);

        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result=new ArrayList<>();

        PriorityQueue<Tweet> pq=new PriorityQueue<>((a,b)->b.time-a.time);

        if(tweets.containsKey(userId)) pq.offer(tweets.get(userId));

        Set<Integer> followees = following.getOrDefault(userId, new HashSet<>());

        for(int followeeId:followees){
            if(tweets.containsKey(followeeId)){
                pq.offer(tweets.get(followeeId));
            }
        }

        while(!pq.isEmpty() && result.size()<10){
            Tweet current=pq.poll();

            result.add(current.tweetId);

            if(current.next!=null) pq.offer(current.next);
        } 

        return result;
        
    }
    
    public void follow(int followerId, int followeeId) {

        
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {

        if(following.containsKey(followerId)){
            following.get(followerId).remove(followeeId);
        }
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
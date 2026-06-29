class Twitter {

    HashMap<Integer, List<Pair<Integer, Integer>>> tweets;
    HashMap<Integer, Set<Integer>> followers;
    int time;

    public Twitter() {
        tweets = new HashMap<>();
        followers = new HashMap<>();
        time = 0;   
    }
    
    public void postTweet(int userId, int tweetId) {

        List<Pair<Integer, Integer>> twt = tweets.get(userId);

        if(twt == null)
            twt = new ArrayList<>();
        
        twt.add(new Pair<>(tweetId, time));

        tweets.put(userId, twt);

        time++;
        
    }
    
    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>()
        {
            public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b)
            {
                return b.getValue() - a.getValue();
            }
        });

        Set<Integer> follwers = new HashSet<>();
        follwers.add(userId);

        if(followers.get(userId) != null)
        {
            follwers.addAll(followers.get(userId));
        }


        for(int followerId : follwers)
        {
            List<Pair<Integer, Integer>> lst = tweets.get(followerId);

            if(lst != null)
            {

                for(Pair<Integer, Integer> twt : lst)
                {
                    pq.add(twt);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        int i = 0 ;

        while( i < 10)
        {
            if(!pq.isEmpty())
            {
            ans.add(pq.poll().getKey());
            }
            i++;
        }

        return ans;
        
    }
    
    public void follow(int followerId, int followeeId) {

        Set<Integer> follw = followers.get(followerId);

        if(follw == null)
            follw = new HashSet<>();
        
        follw.add(followeeId);

        followers.put(followerId, follw);
  
    }
    
    public void unfollow(int followerId, int followeeId) {

        if(followers.containsKey(followerId))
        {
            followers.get(followerId).remove(followeeId);
        }
        
    }
}

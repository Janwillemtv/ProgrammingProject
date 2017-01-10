package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by janwillem on 1/10/17.
 */
public class VoteList {
    private Map<String, Integer> votes;

    public VoteList(){
        votes = new HashMap<>();
    }

    public void addVote(String v){
            if (votes.containsKey(v)) {
                votes.put(v, votes.get(v) + 1);
            }
            else {
                votes.put(v, 1);
            }
    }

    public Map<String, Integer> getVotes(){
        return votes;
    }

}

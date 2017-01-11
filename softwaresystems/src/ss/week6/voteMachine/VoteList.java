package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Created by janwillem on 1/10/17.
 */
public class VoteList extends Observable {
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
            setChanged();
            notifyObservers("vote");
    }

    public Map<String, Integer> getVotes(){
        return votes;
    }

}

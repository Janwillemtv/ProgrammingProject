package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by janwillem on 1/10/17.
 */
public class PartyList {
    private List<String> parties;

    public PartyList(){
        parties = new ArrayList<>();
    }


    public void addParty(String p){
        if(!hasParty(p)){
            parties.add(p);
        }

    }

    public boolean hasParty(String p){
        return parties.contains(p);
    }

    public List<String> getParties(){
        return parties;
    }
}

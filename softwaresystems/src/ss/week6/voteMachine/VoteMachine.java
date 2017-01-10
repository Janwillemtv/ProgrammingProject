package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;

/**
 * Created by janwillem on 1/10/17.
 */
public class VoteMachine {

    private PartyList partyList;
    private VoteList voteList;
    private VoteView view;

    public VoteMachine() {
        view = new VoteTUIView(this);
        partyList = new PartyList();
        voteList = new VoteList();

    }

    public void addParty(String party) {
        partyList.addParty(party);
    }

    public void vote(String party) {
        voteList.addVote(party);
    }

    public List<String> getParties() {
        return partyList.getParties();
    }

    public Map<String, Integer> getVotes() {
        return voteList.getVotes();
    }

    public void start() {
        view.start();

    }

    public static void main(String[] args) {
        VoteMachine machine = new VoteMachine();
        machine.start();
    }
}

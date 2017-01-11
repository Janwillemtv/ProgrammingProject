package ss.week6.voteMachine;
import java.util.*;

/**
 * Created by janwillem on 1/10/17.
 */
public class VoteTUIView implements VoteView, Observer{

    Scanner scanner = new Scanner(System.in);

    private VoteMachine controller;

    public VoteTUIView(VoteMachine controller) {
        this.controller = controller;
    }

    public void start() {
        boolean end = false;

        System.out.println("Please enter your choice");
        do {
            if(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String word[] = line.split("\\s+");

                switch (word[0]) {
                    case "VOTE":
                        if(word.length == 2) {
                            //Vote for the party
                            String party = word[1];
                            controller.vote(party);
                            System.out.println("you have voted for: " + word[1]);
                        }else showError("Invalid Command");
                        break;
                    case "ADD":
                        if(word[1].equals("PARTY")){
                            if(word.length == 3) {
                                String party = word[2];
                                controller.addParty(party);
                                System.out.println("Added party " + party);
                            }else showError("Invalid Command");
                        }
                        break;
                    case "VOTES":
                        showVotes(controller.getVotes());
                        break;
                    case "PARTIES":
                        showParties(controller.getParties());
                        break;
                    case "EXIT":
                        end = true;
                        break;
                    case "HELP":
                        break;
                    default:
                        showError("Invalid Command");
                        break;
                }


            }


        } while(!end);
        System.out.println("End of programme.");

    }

    public void showParties(List<String> p){
        System.out.println(p.toString());
    }

    public void showVotes(Map<String, Integer> v) {
        System.out.println(v.toString());
    }


    public void showError(String e){
        System.out.println("Error: " + e);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("vote")) {
            System.out.println("Vote was added");
        } else if (arg.equals("party")) {
            System.out.println("Party was added");
        }
    }
}

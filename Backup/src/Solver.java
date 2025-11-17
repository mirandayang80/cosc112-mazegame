import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Solver {

    //List to hold states not just the location
    ArrayList<State> holdStates = new ArrayList<>();


    public Solver(State givenState) throws FileNotFoundException {

        //Put starting state on the list (use arraylist)
        holdStates.add(givenState);

    }

    //Check can this be part of the State?
    //Do not check against a solution, check against the legal moves
    public String solved() {

        //While the arraylist isn't empty
        while (!holdStates.isEmpty()) {

            //Take a state from the list
            State s = holdStates.getFirst();
            holdStates.removeFirst();

            //If the state is a goal, done (check from game)
            if (s.getLoc().isGoalReached()) {
                System.out.println("**Solution Found**");

                Information pastInfo = s.getInfo();
                //State past = pastInfo.getS();

                //Print out the steps to get to the solution
                while(pastInfo != null && pastInfo.getS() != null){

                    System.out.println(pastInfo.getS().getLoc());
                    System.out.println("________________");

                    pastInfo = pastInfo.prevInformation;

                }

                return "Solution Start";

            }

            //Get all transitions that can be taken
            ArrayList<TransitionInterface> storedT = s.getLoc().getPossibleMOT(s);

            //From where you are, search until you find goal
            for (int i = 0; i < storedT.size(); i++){

                //For each of these, get the new state and put it on the list
                TransitionInterface possibleT = storedT.get(i);
                State newS = possibleT.makeTransition(s);
                Information pastInfo = s.getInfo();

                //State past = pastInfo.getS();
                //System.out.println(past.getLoc());

                boolean foundEqual = false;

                //Check if we have been in that state before to avoid infinite loops
                while(pastInfo != null && pastInfo.getS() != null){

                    if(newS.doesNotEqual(pastInfo.getS())){

                        pastInfo = pastInfo.prevInformation;

                    }
                    else{
                        foundEqual = true;
                        break;
                    }
                }

                if(!foundEqual) {

                    holdStates.add(newS);
                }

            }


        }

        return "**Solution Not Found**";

    }



}

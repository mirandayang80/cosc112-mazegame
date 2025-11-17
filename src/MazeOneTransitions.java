import java.util.ArrayList;

public class MazeOneTransitions implements TransitionInterface {

    //Contains the target location (where the user clicked)
    private MazeOneLocation targetLocation;

    public static MazeOneLocation goal;

    public MazeOneTransitions(MazeOneLocation target){
        targetLocation = target;
    }

    // Given a state, decide whether transition applies
    public boolean validTransition(State givenState) {

        //If given state is at goal, no valid transition
        if (givenState.getLoc().equalLoc(goal)) {
            return false;
        }

        //Check if where the user clicked is valid
        //by checking if where they clicked is contained in the list of possible transitions from the location they are at
        ArrayList<TransitionInterface> s = givenState.getLoc().getPossibleMOT(null);

        for(int i = 0; i < s.size(); i++){

            if(this.equals(s.get(i))){
                return true;
            }
        }

        return false;
    }

    //Make the transition - given a state, produce a new state
    public State makeTransition(State givenState) {

        if (!validTransition(givenState)) {
            return null;
        }

        Information newI = new Information(givenState.getInfo());
        //System.out.println(targetLocation);
        return new State(newI, targetLocation);
    }

    public void setTargetLocation(MazeOneLocation targetLocation) {
        this.targetLocation = targetLocation;
    }

    public MazeOneLocation getTargetLocation() {
        return targetLocation;
    }

}

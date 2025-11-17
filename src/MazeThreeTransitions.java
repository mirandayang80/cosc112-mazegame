import java.util.ArrayList;

public class MazeThreeTransitions implements TransitionInterface {

    //Contains the target location (where the user clicked)
    private MazeThreeLocation targetLocation;

    public static MazeThreeLocation goal;
    public String direction;


    public MazeThreeTransitions(MazeThreeLocation target) {
        targetLocation = target;
    }

    // Given a state, decide whether transition applies
    public boolean validTransition(State givenState) {
        ArrayList<TransitionInterface> st = givenState.getLoc().getPossibleMOT(givenState);

        for (int k = 0; k < st.size(); k++) {

            if (this.equals(st.get(k))) {
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

        LocationInterface initial = givenState.getLoc();
        LocationInterface end = targetLocation;

        //Based on the initial and end location, find the new direction
        int iRI = initial.getRowIndex();
        int iCI = initial.getColumnIndex();

        int eRI = end.getRowIndex();
        int eCI = end.getColumnIndex();

        String direction = "";
        if(eRI > iRI){
             direction = "Down";
        }

        if(eRI < iRI){
            direction = "Up";
        }

        if(eCI > iCI){
            direction = "Right";
        }

        if(eCI < iCI){
            direction = "Left";
        }
        this.direction = direction;

        Information newI = new Information(givenState.getInfo());
        //System.out.println(targetLocation);
        return new State(newI, targetLocation, direction);
    }

    public void setTargetLocation(MazeThreeLocation targetLocation) {
        this.targetLocation = targetLocation;
    }

    public MazeThreeLocation getTargetLocation() {
        return targetLocation;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return targetLocation.toString();
    }
}

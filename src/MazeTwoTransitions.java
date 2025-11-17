import java.util.ArrayList;

public class MazeTwoTransitions implements TransitionInterface {

    //Contains the target location (where the user clicked)
    private MazeTwoLocation targetLocation;

    public static MazeTwoLocation goal;
    public int color;

    public MazeTwoTransitions(MazeTwoLocation target) {
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
        ArrayList<TransitionInterface> s = givenState.getLoc().getPossibleMOT(givenState);

        for (int i = 0; i < s.size(); i++) {

            if (this.equals(s.get(i))) {
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

        LocationInterface initialLoc = givenState.getLoc();
        LocationInterface endLoc = targetLocation;

        int initialSColor = givenState.getColor();
        int initialSRBY = givenState.getRby();

        int initialColor = initialLoc.getColor();
        int endColor = endLoc.getColor();

        int endRBY = initialSRBY; //or targetLocation.getRby();

        //If entering white, store the next order color in rby
        if (endColor == 4 && initialColor != 4) {

            if (initialColor == 1) {
                endRBY = 2;
            }
            if (initialColor == 2) {
                endRBY = 3;
            }
            if (initialColor == 3) {
                endRBY = 1;
            }

//            System.out.println("@@@@@@@@@@@@@@ END RBY :" + endRBY + "@@@@@@@@@@@@@@@@@@@@@");

        }


//        System.out.println("TRANSITIONS___________________");
//        System.out.println("INITIAL ST COLOR : " + initialSColor + " | INITIAL RBY :" + initialSRBY);
//        System.out.println("INITIAL COLOR : " + initialColor + " | INIT RBY :" + initialSRBY);
//        System.out.println("ENDCOLOR:" + endColor + " | END RBY :" + endRBY);
//        System.out.println("TRANSITIONSEND___________________");

        Information newI = new Information(givenState.getInfo());

        State newState = new State(newI, targetLocation, givenState);

        newState.setColor(endColor);
        newState.setRby(endRBY);

        return newState;
    }

    public void setTargetLocation(MazeTwoLocation targetLocation) {
        this.targetLocation = targetLocation;
    }

    public MazeTwoLocation getTargetLocation() {
        return targetLocation;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int i) {
        color = i;
    }
}

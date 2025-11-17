public interface TransitionInterface {

    public boolean validTransition(State givenState);

    //Make the transition - given a state, produce a new state
    public State makeTransition(State givenState);


}



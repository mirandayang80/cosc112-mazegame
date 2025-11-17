import java.util.ArrayList;

public class MazeOneLocation implements LocationInterface {

    //Contains list of transitions
    private ArrayList<TransitionInterface> possibleMOT;
    private boolean goalReached;
    private int rowIndex;
    private int columnIndex;

    public MazeOneLocation(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        possibleMOT = new ArrayList<>();
    }

    public ArrayList<TransitionInterface> getPossibleMOT(State s){
        return possibleMOT;
    }

    public void addPossibleMOT(MazeOneTransitions toAdd){
        possibleMOT.add(toAdd);
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }


    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public boolean isGoalReached() {
        return goalReached;
    }

    public void setGoalReached(boolean goalReached) {
        this.goalReached = goalReached;
    }

    //Check if MazeOneLocation are the same (not necessarily same transitions)
    public boolean equalLoc(MazeOneLocation otherLoc) {
        return (rowIndex == otherLoc.rowIndex && columnIndex == otherLoc.columnIndex);
    }

    public boolean completelyEqual(MazeOneLocation otherLoc) {

        boolean eqL = equalLoc(otherLoc);

        boolean transitionEqual = true;

        for (int i = 0; i < possibleMOT.size(); i++) {
            if (possibleMOT.get(i) != otherLoc.possibleMOT.get(i)) {
                transitionEqual = false;
            }
        }

        return eqL && transitionEqual;

    }

    public String toString(){
        return "Row: " + rowIndex + "\n" + "Column: " + columnIndex;
    }

    public String getDirection() {
        return null;
    }

    @Override
    public int getColor() {
        return 0;
    }

    @Override
    public int getRby() {
        return 0;
    }

    @Override
    public void setColor(int i) {

    }

    @Override
    public void setRby(int i) {

    }

    @Override
    public boolean equalLoc(LocationInterface loc) {
        return true;
    }


}

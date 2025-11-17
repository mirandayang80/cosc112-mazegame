import java.util.ArrayList;

public class MazeThreeLocation extends MazeOneLocation implements LocationInterface {

    //Contains list of transitions
    public ArrayList<TransitionInterface> possibleMOT;
    private boolean goalReached;
    private int rowIndex;
    private int columnIndex;
    String direction;


    public MazeThreeLocation(int rowIndex, int columnIndex) {
        super(rowIndex, columnIndex);
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        possibleMOT = new ArrayList<>();
    }

    public ArrayList<TransitionInterface> getPossibleMOT(State sta){
        possibleMOT.clear();

        int i = sta.getLoc().getRowIndex();
        int j = sta.getLoc().getColumnIndex();
        if (MazeThree.allLoc[i][j] != null) {
            direction = MazeThree.allTransit[i][j].getDirection();

            int currentNum = MazeThree.coord[i][j];
            int[][] coord = MazeThree.coord;

            //Is a possible transition if doesn't go off border or to a wall and target matches color or shape
            //Generate all possible transitions from the locations
            //System.out.println("DIRECTION SOMETHING: " + direction);
            if (currentNum != 11) {

                int numSteps = 1;
                boolean hitWall = false;

                //If facing up, can't go down
                if (!direction.equals("Up")) {
                    while (i + numSteps < 6) {
                        //Check first digit
                        int fD = (currentNum / 10) % 10;

                        //Check second digit
                        int sD = currentNum % 10;

                        if (coord[i + numSteps][j] != 11) {

                            int fD2 = (coord[i + numSteps][j] / 10) % 10;
                            int sD2 = coord[i + numSteps][j] % 10;

                            //If at least shape or color match, then the target location is a possible transition
                            if (fD == fD2 || sD == sD2) {
                                MazeThreeTransitions transit = MazeThree.allTransit[i + numSteps][j];
                                addPossibleMOT(transit);
                            }
                        }
                        numSteps++;
                    }
                }

                numSteps = 1;

                //If facing down, can't go up
                if (!direction.equals("Down")) {
                    while (i - numSteps >= 0) {
                        //Check first digit
                        int fD = (currentNum / 10) % 10;

                        //Check second digit
                        int sD = currentNum % 10;

                        if (coord[i - numSteps][j] != 11) {

                            int fD2 = (coord[i - numSteps][j] / 10) % 10;
                            int sD2 = coord[i - numSteps][j] % 10;

                            //If at least shape or color match, then the target location is a possible transition
                            if (fD == fD2 || sD == sD2) {
                                MazeThreeTransitions transit = MazeThree.allTransit[i - numSteps][j];
                                addPossibleMOT(transit);
                            }
                        }
                        numSteps++;
                    }
                }

                numSteps = 1;
                //If facing left, can't go right
                if (!direction.equals("Left")) {
                    while (j + numSteps < 6) {
                        //Check first digit
                        int fD = (currentNum / 10) % 10;

                        //Check second digit
                        int sD = currentNum % 10;

                        if (coord[i][j + numSteps] != 11) {

                            int fD2 = (coord[i][j + numSteps] / 10) % 10;
                            int sD2 = coord[i][j + numSteps] % 10;

                            //If at least shape or color match, then the target location is a possible transition
                            if (fD == fD2 || sD == sD2) {
                                MazeThreeTransitions transit = MazeThree.allTransit[i][j + numSteps];
                                addPossibleMOT(transit);
                            }
                        }
                        numSteps++;
                    }
                }

                numSteps = 1;
                //If facing right, can't go left
                if (!direction.equals("Right")) {
                    while (j - numSteps >= 0) {
                        //Check first digit
                        int fD = (currentNum / 10) % 10;

                        //Check second digit
                        int sD = currentNum % 10;

                        if (coord[i][j - numSteps] != 11) {

                            int fD2 = (coord[i][j - numSteps] / 10) % 10;
                            int sD2 = coord[i][j - numSteps] % 10;

                            if (fD == fD2 || sD == sD2) {
                                MazeThreeTransitions transit = MazeThree.allTransit[i][j - numSteps];
                                MazeThree.allLoc[i][j].addPossibleMOT(transit);
                            }
                        }
                        numSteps++;
                    }
                }

            }

        }
        return possibleMOT;
    }

    public void addPossibleMOT(MazeThreeTransitions toAdd){
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

    //Check if MazeThreeLocation are the same (not necessarily same transitions)
    public boolean equalLoc(MazeThreeLocation otherLoc) {
        return (rowIndex == otherLoc.rowIndex && columnIndex == otherLoc.columnIndex);
    }

    public boolean completelyEqual(MazeThreeLocation otherLoc) {

        boolean eqL = equalLoc(otherLoc);

        boolean transitionEqual = true;

        for (int i = 0; i < possibleMOT.size(); i++) {
            if (possibleMOT.get(i) != otherLoc.possibleMOT.get(i)) {
                transitionEqual = false;
            }
        }

        return eqL && transitionEqual;

    }

    public String getDirection() {
        return direction;
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

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String toString(){
        return "Row: " + rowIndex + "\n" + "Column: " + columnIndex ;
    }


}


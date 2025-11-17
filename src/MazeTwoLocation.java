import java.util.ArrayList;

public class MazeTwoLocation extends MazeOneLocation implements LocationInterface {

    //Contains list of transitions
    private ArrayList<TransitionInterface> possibleMOT;
    private boolean goalReached;
    private int rowIndex;
    private int columnIndex;
    private int color;
    private int rby;

    public MazeTwoLocation(int rowIndex, int columnIndex) {
        super(rowIndex, columnIndex);
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        possibleMOT = new ArrayList<>();

    }

    public ArrayList<TransitionInterface> getPossibleMOT(State s) {
        possibleMOT.clear();

        int i = s.getLoc().getRowIndex();
        int j = s.getLoc().getColumnIndex();

        if (MazeTwo.allLoc[i][j] != null) {
            int color = s.getColor();
            int rbyColor = s.getRby();

//            System.out.println("%%%%%%%%%%%%%LOC%%%%%%%%%%%%%");
//            System.out.println("COLOR : " + color);
//            System.out.println("S.GETRBY: " + rbyColor);
//            System.out.println("%%%%%%%%%%%%%LOCEND%%%%%%%%%%");

            int[][] coord = MazeTwo.coord;
            int currentNum = coord[i][j];

            int step = 1;

            if (currentNum == 4) {

//                int prevRI = s.getLoc().getRowIndex();
//                int prevCI = s.getLoc().getColumnIndex();
//
//                //No u-turn
//                if(s.getPrevState() != null) {
//                    prevRI = s.getPrevState().getLoc().getRowIndex();
//                    prevCI = s.getPrevState().getLoc().getColumnIndex();
//                }
//
//                //System.out.println(prevRI + " "  + prevCI);
//
//                boolean canTurnUp = true;
//                boolean canTurnDown = true;
//                boolean canTurnRight = true;
//                boolean canTurnLeft = true;
//
//                if (prevRI > i) {
//                    canTurnDown = false;
//                }
//                if (prevRI < i) {
//                    canTurnUp = false;
//                }
//                if (prevCI > j) {
//                    canTurnRight = false;
//                }
//                if (prevCI < j) {
//                    canTurnLeft = false;
//                }
//
//
//                if(canTurnDown) {
//                    if (coord[i + 1][j] == 4) {
//                        MazeTwoTransitions transit = MazeTwo.allTransit[i + 1][j];
//                        addPossibleMOT(transit);
//                    }
//                }
//
//                if(canTurnUp) {
//                    if (coord[i - 1][j] == 4) {
//                        MazeTwoTransitions transit = MazeTwo.allTransit[i - 1][j];
//                        addPossibleMOT(transit);
//                    }
//                }
//
//                if(canTurnRight) {
//                    if (coord[i][j + 1] == 4) {
//                        MazeTwoTransitions transit = MazeTwo.allTransit[i][j + 1];
//                        addPossibleMOT(transit);
//                    }
//                }
//
//                if(canTurnLeft) {
//
//                    if (coord[i][j - 1] == 4) {
//                        MazeTwoTransitions transit = MazeTwo.allTransit[i][j - 1];
//                        addPossibleMOT(transit);
//                    }
//                }

                int steps = 1;

                //Change path from white (can't move around 3x3 white but from white square, can click on the next color path according to the order)
                while(steps <=3) {

                    //Down
                    if(steps == 1 || steps == 3) {
                        if (coord[i + steps][j] == rbyColor) {
                            MazeTwoTransitions transit = MazeTwo.allTransit[i + steps][j];
                            addPossibleMOT(transit);

                        }

                        if(steps == 3) {
                            //Two white squares down, right 2, down
                            if (coord[i][j + 1] == 4 && coord[i + 1][j] == 4) {
                                if (coord[i + steps][j + 2] == rbyColor) {
                                    MazeTwoTransitions transit = MazeTwo.allTransit[i + steps][j + 2];
                                    addPossibleMOT(transit);
                                }
                            }

                            //Two white squares down, left 2, down
                            if (coord[i][j - 1] == 4 && coord[i + 1][j] == 4) {
                                if (coord[i + steps][j - 2] == rbyColor) {
                                    MazeTwoTransitions transit = MazeTwo.allTransit[i + steps][j - 2];
                                    addPossibleMOT(transit);
                                }
                            }
                        }


                    }

                    if(steps == 2) {

                        //Two white squares down, left
                        if (coord[i + steps][j] == 4 && coord[i][j + 1] == 4) {
                            if (coord[i + steps][j - 1] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i + steps][j - 1];
                                addPossibleMOT(transit);
                            }

                        }

                        //Two white squares down, right
                        if (coord[i + steps][j] == 4 && coord[i][j - 1] == 4) {
                            if (coord[i + steps][j + 1] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i + steps][j + 1];
                                addPossibleMOT(transit);
                            }
                        }

                        //Two white squares down, right 3
                        if (coord[i + steps][j] == 4 && coord[i][j + 1] == 4) {
                            if (coord[i + steps][j + 3] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i + steps][j + 3];
                                addPossibleMOT(transit);
                            }
                        }

                        //Two white squares down, left 3
                        if (coord[i + steps][j] == 4 && coord[i][j - 1] == 4) {
                            if (coord[i + steps][j - 3] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i + steps][j - 3];
                                addPossibleMOT(transit);
                            }
                        }
                    }

                    //Up
                    if(steps == 1 || steps == 3) {
                        if (coord[i - steps][j] == rbyColor) {
                            MazeTwoTransitions transit = MazeTwo.allTransit[i - steps][j];
                            addPossibleMOT(transit);
                        }

                        if(steps == 3) {
                            //Two white squares up, left 2, up
                            if (coord[i][j - 1] == 4 && coord[i - 1][j] == 4) {
                                if (coord[i - steps][j - 2] == rbyColor) {
                                    MazeTwoTransitions transit = MazeTwo.allTransit[i - steps][j - 2];
                                    addPossibleMOT(transit);
                                }
                            }

                            //Two white squares up, right 2, up
                            if (coord[i][j + 1] == 4 && coord[i - 1][j] == 4) {
                                if (coord[i - steps][j + 2] == rbyColor) {
                                    MazeTwoTransitions transit = MazeTwo.allTransit[i - steps][j + 2];
                                    addPossibleMOT(transit);
                                }
                            }
                        }


                    }

                    if(steps == 2) {
                        //Two white squares up, left
                        if (coord[i - steps][j] == 4  && coord[i][j + 1] == 4) {
                            if (coord[i - steps][j - 1] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i - steps][j - 1];
                                addPossibleMOT(transit);
                            }

                        }

                        //Two white squares up, right
                        if (coord[i - steps][j] == 4  && coord[i][j - 1] == 4) {
                            if (coord[i - steps][j + 1] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i - steps][j + 1];
                                addPossibleMOT(transit);
                            }
                        }


                        //Two white squares up, right 3
                        if (coord[i - steps][j] == 4  && coord[i][j + 1] == 4) {
                            if (coord[i - steps][j + 3] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i - steps][j + 3];
                                addPossibleMOT(transit);
                            }
                        }

                        //Two white squares up, left 3
                        if (coord[i - steps][j] == 4  && coord[i][j - 1] == 4) {
                            if (coord[i - steps][j - 3] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i - steps][j - 3];
                                addPossibleMOT(transit);
                            }
                        }
                    }

                    //Right
                    if(steps == 1 || steps == 3) {
                        if (coord[i][j + steps] == rbyColor) {
                            MazeTwoTransitions transit = MazeTwo.allTransit[i][j + steps];
                            addPossibleMOT(transit);
                        }

                        if(steps == 3) {
                            //Two white right, up 2, right
                            if (coord[i][j + 1] == 4 && coord[i - 1][j] == 4) {
                                if (coord[i - 2][j + steps] == rbyColor) {
                                    MazeTwoTransitions transit = MazeTwo.allTransit[i - 2][j + steps];
                                    addPossibleMOT(transit);
                                }
                            }

                            //Two white right, down 2, right
                            if (coord[i][j + 1] == 4 && coord[i + 1][j] == 4) {
                                if (coord[i + 2][j + steps] == rbyColor) {
                                    MazeTwoTransitions transit = MazeTwo.allTransit[i + 2][j + steps];
                                    addPossibleMOT(transit);
                                }
                            }
                        }


                    }

                    if(steps == 2) {

                        //Two white squares right, down
                        if (coord[i][j + steps] == 4  && coord[i - 1][j] == 4) {
                            if (coord[i + 1][j + steps] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i + 1][j + steps];
                                addPossibleMOT(transit);
                            }

                        }

                        //Two white squares right, up
                        if (coord[i][j + steps] == 4  && coord[i + 1][j] == 4) {
                            if (coord[i - 1][j + steps] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i - 1][j + steps];
                                addPossibleMOT(transit);
                            }
                        }

                        //Two white squares right, up 3
                        if (coord[i][j + steps] == 4  && coord[i - 1][j] == 4) {
                            if (coord[i - 3][j + steps] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i - 3][j + steps];
                                addPossibleMOT(transit);
                            }
                        }

                        //Two white squares right, down 3
                        if (coord[i][j + steps] == 4  && coord[i + 1][j] == 4) {
                            if (coord[i + 3][j + steps] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i + 3][j + steps];
                                addPossibleMOT(transit);
                            }
                        }

                    }


                    //Left
                    if(steps == 1 || steps == 3) {
                        if (coord[i][j - steps] == rbyColor) {
                            MazeTwoTransitions transit = MazeTwo.allTransit[i][j - steps];
                            addPossibleMOT(transit);
                        }

                        if(steps == 3) {
                            //Two white left, up 2, left
                            if (coord[i][j - 1] == 4 && coord[i - 1][j] == 4) {
                                if (coord[i - 2][j - steps] == rbyColor) {
                                    MazeTwoTransitions transit = MazeTwo.allTransit[i - 2][j - steps];
                                    addPossibleMOT(transit);
                                }
                            }

                            //Two white left, down 2, left
                            if (coord[i][j - 1] == 4 && coord[i + 1][j] == 4) {
                                if (coord[i + 2][j - steps] == rbyColor) {
                                    MazeTwoTransitions transit = MazeTwo.allTransit[i + 2][j - steps];
                                    addPossibleMOT(transit);
                                }
                            }
                        }


                    }

                    if(steps == 2) {

                        //Two white squares left, up
                        if (coord[i][j - steps] == 4  && coord[i + 1][j] == 4) {
                            if (coord[i - 1][j - steps] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i - 1][j - steps];
                                addPossibleMOT(transit);
                            }

                        }

                        //Two white squares left, down
                        if (coord[i][j - steps] == 4  && coord[i - 1][j] == 4) {
                            if (coord[i + 1][j - steps] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i + 1][j - steps];
                                addPossibleMOT(transit);
                            }
                        }

                        //Two white squares left, down 3
                        if (coord[i][j - steps] == 4  && coord[i + 1][j] == 4) {
                            if (coord[i + 3][j + steps] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i + 3][j - steps];
                                addPossibleMOT(transit);
                            }
                        }

                        //Two white squares left, up 3
                        if (coord[i][j - steps] == 4  && coord[i - 1][j] == 4) {
                            if (coord[i - 3][j + steps] == rbyColor) {
                                MazeTwoTransitions transit = MazeTwo.allTransit[i - 3][j - steps];
                                addPossibleMOT(transit);
                            }
                        }
                    }

                    steps++;
                }

            } else {

                //If not black
                if (currentNum != 6) {

                    int prevRI = s.getLoc().getRowIndex();
                    int prevCI = s.getLoc().getColumnIndex();

                    //No u-turn
                    if(s.getPrevState() != null) {
                        prevRI = s.getPrevState().getLoc().getRowIndex();
                        prevCI = s.getPrevState().getLoc().getColumnIndex();
                    }

                    boolean canTurnUp = true;
                    boolean canTurnDown = true;
                    boolean canTurnRight = true;
                    boolean canTurnLeft = true;

                    if (prevRI > i) {
                        canTurnDown = false;
                    }
                    if (prevRI < i) {
                        canTurnUp = false;
                    }
                    if (prevCI > j) {
                        canTurnRight = false;
                    }
                    if (prevCI < j) {
                        canTurnLeft = false;
                    }

                    //If next block is same color along the same path or reached white or gray
                    if (canTurnDown) {
                        //Turning down
                        if (i + step < 21 && (coord[i + step][j] == currentNum || coord[i + step][j] == 4 || coord[i + step][j] == 5)) {
                            MazeTwoTransitions transit = MazeTwo.allTransit[i + step][j];
                            addPossibleMOT(transit);
                        }
                    }

                    if (canTurnUp) {
                        if (coord[i - step][j] == currentNum || coord[i - step][j] == 4 || coord[i - step][j] == 5) {
                            MazeTwoTransitions transit = MazeTwo.allTransit[i - step][j];
                            addPossibleMOT(transit);
                        }
                    }

                    if (canTurnRight) {
                        if (coord[i][j + step] == currentNum || j + step < 21 && (coord[i][j + step] == 4 ||  coord[i][j + step] == 5)) {
                            MazeTwoTransitions transit = MazeTwo.allTransit[i][j + step];
                            addPossibleMOT(transit);
                        }
                    }

                    if(canTurnLeft) {
                        if (coord[i][j - step] == currentNum || coord[i][j - step] == 4 || coord[i][j - step] == 5) {
                            MazeTwoTransitions transit = MazeTwo.allTransit[i][j - step];
                            addPossibleMOT(transit);
                        }
                    }

                }
            }
        }

        return possibleMOT;
    }

    public void addPossibleMOT(MazeTwoTransitions toAdd) {

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

    @Override
    public String getDirection() {
        return null;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getRby() {
        return rby;
    }

    public void setRby(int rby) {
        this.rby = rby;
    }

    @Override
    public boolean equalLoc(LocationInterface loc) {


        return (rowIndex == loc.getRowIndex() && columnIndex == loc.getColumnIndex());
    }


    public void setGoalReached(boolean goalReached) {
        this.goalReached = goalReached;
    }

    //Check if MazeTwoLocation are the same (not necessarily same transitions)
    public boolean equalLoc(MazeTwoLocation otherLoc) {
        return (rowIndex == otherLoc.rowIndex && columnIndex == otherLoc.columnIndex);
    }

    public boolean completelyEqual(MazeTwoLocation otherLoc) {

        boolean eqL = equalLoc(otherLoc);

        boolean transitionEqual = true;

        for (int i = 0; i < possibleMOT.size(); i++) {
            if (possibleMOT.get(i) != otherLoc.possibleMOT.get(i)) {
                transitionEqual = false;
            }
        }

        return eqL && transitionEqual;

    }

    public String toString() {
        return "Row: " + rowIndex + "\n" + " Column: " + columnIndex ;
    }

}

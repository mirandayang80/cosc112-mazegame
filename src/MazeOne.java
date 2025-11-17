import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazeOne implements MazeInterface {

    private int[][] coord;
    private State startState;
    private MazeOneLocation[][] allLoc = new MazeOneLocation[7][7];
    public MazeOneTransitions[][] allTransit = new MazeOneTransitions[7][7];

    public MazeOne() throws FileNotFoundException {

        //Reads MazeOne file
        File m1 = new File("C:\\Users\\miran\\IdeaProjects\\COSC112\\FinalProject\\out\\production\\FinalProject\\MazeOne.txt");

        Scanner readFile = new Scanner(m1);

        try {
            readFile = new Scanner(m1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        coord = new int[7][7];

        int row = coord.length;
        int column = coord[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                coord[i][j] = readFile.nextInt();

                //Get all possible locations
                MazeOneLocation currentLoc = new MazeOneLocation(i, j);
                allLoc[i][j] = currentLoc;

                //Get all possible transitions
                MazeOneTransitions tr = new MazeOneTransitions(currentLoc);
                allTransit[i][j] = tr;

            }

        }

        startState = new State(new Information(null), allLoc[0][0]);
        MazeOneTransitions.goal = allLoc[6][6];
        allLoc[6][6].setGoalReached(true);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int currentNum = coord[i][j];

                //If doesn't go off border, is a possible transition
                //Generate all possible transitions from the locations
                if (i + currentNum <= 6) {

                    MazeOneTransitions transit = allTransit[i + currentNum][j];
                    allLoc[i][j].addPossibleMOT(transit);
                }

                if (i - currentNum >= 0) {

                    MazeOneTransitions transit = allTransit[i - currentNum][j];
                    allLoc[i][j].addPossibleMOT(transit);
                }

                if (j + currentNum <= 6) {
                    MazeOneTransitions transit = allTransit[i][j + currentNum];
                    allLoc[i][j].addPossibleMOT(transit);
                }

                if (j - currentNum >= 0) {
                    MazeOneTransitions transit = allTransit[i][j - currentNum];
                    allLoc[i][j].addPossibleMOT(transit);
                }


            }
        }
    }

    public int[][] getCoord() {
        return coord;
    }

    //Returns start state
    @Override
    public State startState() {

        return startState;
    }


}

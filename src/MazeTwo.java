import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazeTwo implements MazeInterface {

    public static int[][] coord;
    private State startState;
    public static MazeTwoLocation[][] allLoc = new MazeTwoLocation[21][21];
    public static MazeTwoTransitions[][] allTransit = new MazeTwoTransitions[21][21];

    public MazeTwo() throws FileNotFoundException {

        //Reads MazeTwo file
        File m2 = new File("C:\\Users\\miran\\IdeaProjects\\COSC112\\FinalProject\\out\\production\\FinalProject\\MazeTwo.txt");

        Scanner readFile = new Scanner(m2);

        try {
            readFile = new Scanner(m2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        coord = new int[21][21];

        int row = coord.length;
        int column = coord[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                coord[i][j] = readFile.nextInt();

                if (coord[i][j] == 6) {
                    allLoc[i][j] = null;
                    allTransit[i][j] = null;
                } else {

                    //Get all possible locations
                    MazeTwoLocation currentLoc = new MazeTwoLocation(i, j);
                    allLoc[i][j] = currentLoc;
                    allLoc[i][j].setColor(coord[i][j]);

                    //Get all possible transitions
                    MazeTwoTransitions tr = new MazeTwoTransitions(currentLoc);
                    allTransit[i][j] = tr;


                }

            }

        }

        startState = new State(new Information(null), allLoc[20][9]);
        startState.setRby(1);
        startState.setColor(1);

        for(int a = 9; a <= 11; a++){
            for(int b = 9; b <= 11; b++){
                MazeTwoTransitions.goal = allLoc[a][b];
                allLoc[a][b].setGoalReached(true);
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
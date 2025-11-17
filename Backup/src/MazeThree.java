import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazeThree implements MazeInterface {

    public static int[][] coord;
    private State startState;
    public static MazeThreeLocation[][] allLoc = new MazeThreeLocation[6][6];
    public static MazeThreeTransitions[][] allTransit = new MazeThreeTransitions[6][6];

    public MazeThree() throws FileNotFoundException {

        //Reads MazeThree file
        File m3 = new File("C:\\Users\\miran\\IdeaProjects\\COSC112\\FinalProject\\out\\production\\FinalProject\\MazeThree.txt");

        Scanner readFile;

        try {
            readFile = new Scanner(m3);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        coord = new int[6][6];

        int row = coord.length;
        int column = coord[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                coord[i][j] = readFile.nextInt();

                if (coord[i][j] == 11) {
                    allLoc[i][j] = null;
                    allTransit[i][j] = null;
                } else {

                    //Get all possible locations
                    MazeThreeLocation currentLoc = new MazeThreeLocation(i, j);
                    allLoc[i][j] = currentLoc;
                    allLoc[i][j].setDirection("");

                    //Get all possible transitions
                    MazeThreeTransitions tr = new MazeThreeTransitions(currentLoc);
                    allTransit[i][j] = tr;
                    allTransit[i][j].setDirection("");
                }

            }

        }

        startState = new State(new Information(null), allLoc[5][1], "Up");
        MazeThreeTransitions.goal = allLoc[0][2];
        allLoc[0][2].setGoalReached(true);
        allLoc[0][2].setDirection("Up");

    }

    public int[][] getCoord() {
        return coord;
    }

    public MazeThreeLocation[][] getAllLoc() {
        return allLoc;
    }

    //Returns start state
    @Override
    public State startState() {

        return startState;
    }
}
import java.util.ArrayList;

public interface LocationInterface {


    public int getRowIndex();

    int getColumnIndex();

    ArrayList<TransitionInterface> getPossibleMOT(State s);

    boolean isGoalReached();

    boolean equalLoc(MazeOneLocation goal);

    public String getDirection();

    int getColor();


    void setColor(int i);
    int getRby();

    void setRby(int i);

    boolean equalLoc(LocationInterface loc);
}

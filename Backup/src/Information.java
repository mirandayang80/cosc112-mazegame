import java.util.ArrayList;

public class Information {

    //Stores whether the player has been here
    Information prevInformation;
    State s;

    //Maze one
    public Information(Information info){
        prevInformation = info;
        s= null;
    }

    public Information getPrevInformation() {
        return prevInformation;
    }

    public State getS() {
        return s;
    }

    public void setS(State s) {
        this.s = s;
    }



}

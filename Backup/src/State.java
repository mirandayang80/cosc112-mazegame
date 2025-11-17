public class State {

    //Consists of location and information
    private LocationInterface loc;
    private Information info;
    private String direc = "";
    private State prevState;
    private int color;
    private int rby;

    //Maze one
    public State(Information info, LocationInterface loc){
        this.info = info;
        this.loc = loc;
        info.setS(this);
    }

    //Maze two
    public State(Information info, LocationInterface loc, State prev){
        this.info = info;
        this.loc = loc;
        info.setS(this);
        prevState = prev;
    }

    //Maze three
    public State(Information info, LocationInterface loc, String direc){
        this.info = info;
        this.loc = loc;
        info.setS(this);
        this.direc = direc;
    }


    public LocationInterface getLoc(){
        return loc;
    }

    public Information getInfo(){
        return info;
    }

    public void setInfo(Information info) {
        this.info = info;
    }

    public void setLoc(LocationInterface loc) {
        this.loc = loc;
    }

    public void setPrevState(State prevState) {
        this.prevState = prevState;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public State getPrevState() {
        return prevState;
    }

    public boolean doesNotEqual(State given){

        return (this.getLoc() != given.getLoc() || !this.getLoc().equalLoc(given.getLoc()) || this.getRby() != given.getRby() || this.getColor() != given.getColor());
    }
    @Override
    public String toString() {


        return loc.toString() + " direction: " + direc;
    }


    public int getRby() {
        return rby;
    }

    public void setRby(int endRBY) {
        rby = endRBY;
    }
}

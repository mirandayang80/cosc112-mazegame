import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeTwoActionListener implements ActionListener {

    //Stores associated transition
    private MazeTwoTransitions whereUserClicks;
    private ColoredButton button;


    public MazeTwoActionListener(MazeTwoTransitions whereUserClicks, ColoredButton button){

        whereUserClicks.setTargetLocation(whereUserClicks.getTargetLocation());
        this.whereUserClicks = whereUserClicks;
        this.button = button;
    }


    public void actionPerformed(ActionEvent e) {

        //Check if valid transition
        boolean valid = whereUserClicks.validTransition(Frame.curState);

        LocationInterface l = Frame.curState.getLoc();
        int r = l.getRowIndex();
        int c = l.getColumnIndex();

        int color = MazeTwo.allLoc[r][c].getColor();
        String co = "";

        if(color == 1){
            co = "Red";
        }
        if(color == 2){
            co = "Blue";
        }
        if(color == 3){
            co = "Yellow";
        }
        if(color == 4){
            co = "White";
        }

        //Show the updated state
        if(valid){

            //Change to original color
            Frame.buttons2[r][c].setColor(co);

            //Set current button to green
            button.setColor("Green");
            Frame.curState = whereUserClicks.makeTransition(Frame.curState);
        }


    }
}

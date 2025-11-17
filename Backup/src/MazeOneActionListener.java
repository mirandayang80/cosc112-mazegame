import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeOneActionListener implements ActionListener {

    //Stores associated transition
    private MazeOneTransitions whereUserClicks;
    private ColoredButton button;


    public MazeOneActionListener(MazeOneTransitions whereUserClicks, ColoredButton button){

        whereUserClicks.setTargetLocation(whereUserClicks.getTargetLocation());
        this.whereUserClicks = whereUserClicks;
        this.button = button;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //Check if valid transition
        boolean valid = whereUserClicks.validTransition(Frame.curState);

        LocationInterface l = Frame.curState.getLoc();
        int r = l.getRowIndex();
        int c = l.getColumnIndex();

        //Show the updated state - change the color of the button to green if they are there
        if(valid){
            //Set old buttons to original colors
            if(((7*r) + c) % 2 == 0){

                Frame.buttons[r][c].setColor("Purple");
            }
            else {
                Frame.buttons[r][c].setColor("Pink");

            }

            //Set current button to green
            button.setColor("Green");
            Frame.curState = whereUserClicks.makeTransition(Frame.curState);
        }


    }


}

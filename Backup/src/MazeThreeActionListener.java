import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeThreeActionListener implements ActionListener {

    //Stores associated transition
    private MazeThreeTransitions whereUserClicks;
    private PersonButton button;


    public MazeThreeActionListener(MazeThreeTransitions whereUserClicks, PersonButton button){

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


        //Show the updated state - show person and the eyeballs
        if(valid){
            //Set old buttons to original
            Frame.buttons3[r][c].setDir("");
            Frame.buttons3[r][c].setPer(false);

            //Set current button
            this.button.setPer(true);
            Frame.curState =  whereUserClicks.makeTransition(Frame.curState);
            String newDir = whereUserClicks.getDirection();
            this.button.setDir(newDir);

        }


    }
}

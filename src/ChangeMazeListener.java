import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeMazeListener implements ActionListener {

    private int whichMazeButton;

    private Frame f;


    public ChangeMazeListener(int i, Frame f) {
        whichMazeButton = i;
        this.f = f;

    }

    //Erase and set up appropriate panel
    @Override
    public void actionPerformed(ActionEvent e) {

        if(whichMazeButton == 0){
            f.getContentPane().removeAll();
            f.setPanel();
        }

        if (whichMazeButton == 1) {
            f.getContentPane().removeAll();
            f.m1SetPanel();
        }

        if (whichMazeButton == 2) {
            f.getContentPane().removeAll();
            f.m2SetPanel();
        }

        if (whichMazeButton == 3) {
            f.getContentPane().removeAll();
            f.m3SetPanel();

        }

    }
}

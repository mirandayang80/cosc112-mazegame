import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class SolutionActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

        //Show solution if clicked
        Solver s;
        try {
             s = new Solver(Frame.curState);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        System.out.println(s.solved());
    }


}

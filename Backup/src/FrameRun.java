import java.awt.*;

public class FrameRun {

    public static void main(String[] args) {

        try {
            javax.swing.UIManager.setLookAndFeel(new javax.swing.plaf.metal.MetalLookAndFeel());
        }
        catch(Exception e) {}

        Frame frame = new Frame();
        frame.setPanel();
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(1200, 800));


    }

}

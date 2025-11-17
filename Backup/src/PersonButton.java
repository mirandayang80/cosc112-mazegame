import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.text.StyleConstants.setIcon;

//Maze three button

public class PersonButton  extends JButton {

    private String s;
    private String c;
    private boolean per;
    private String dir;

    public PersonButton(String shape, String color, boolean person, String direction) {

        ImageIcon icon = null;

        if(person){
             icon = new ImageIcon("C:\\Users\\miran\\IdeaProjects\\COSC112\\FinalProject\\src\\Icons\\" + color + shape + direction + "Icon.jpg");

        }
        else {
             icon = new ImageIcon("C:\\Users\\miran\\IdeaProjects\\COSC112\\FinalProject\\src\\Icons\\" + color + shape + "Icon.jpg");
        }

        s = shape;
        c = color;
        per = person;
        dir = direction;

        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);

        setIcon(icon);
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorderPainted(true);


    }

    public PersonButton(){
        setText("WALL");
    }


    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;

        ImageIcon icon = null;

        icon = new ImageIcon("C:\\Users\\miran\\IdeaProjects\\COSC112\\FinalProject\\src\\Icons\\" + c + s + dir + "Icon.jpg");

        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);

        setIcon(icon);
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorderPainted(true);

    }

    public boolean isPer() {
        return per;
    }

    public void setPer(boolean per) {
        this.per = per;

        ImageIcon icon = null;

        if(per){
            icon = new ImageIcon("C:\\Users\\miran\\IdeaProjects\\COSC112\\FinalProject\\src\\Icons\\" + c + s + dir + "Icon.jpg");

        }
        else {
            icon = new ImageIcon("C:\\Users\\miran\\IdeaProjects\\COSC112\\FinalProject\\src\\Icons\\" + c + s + "Icon.jpg");
        }

        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);

        setIcon(icon);
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorderPainted(true);
    }
}
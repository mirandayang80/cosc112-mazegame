import java.awt.*;
import javax.swing.*;

public class ColoredButton extends JButton {

    private String color;

    //Maze one and maze two button
    public ColoredButton(String text, String color) {
        setOpaque(true);
        setBorderPainted(true);

        if(color.equals("Purple")) {
            setBackground(new Color(224, 199, 215));
        }

        if(color.equals("Pink")){
            setBackground(new Color(250, 218, 221));
        }

        if(color.equals("Blue")) {
            setBackground(new Color(198, 220, 229, 255));
        }

        if(color.equals("Red")){
            setBackground(new Color(243, 84, 101));
        }

        if(color.equals("Yellow")){
            setBackground(new Color(255, 241, 10));
        }
        if(color.equals("White")){
            setBackground(new Color(255, 255, 255));
        }
        if(color.equals("Black")){
            setBackground(new Color(0, 0, 0));
        }
        if(color.equals("Gray")){
            setBackground(new Color(94, 92, 92, 255));
        }

        setText(text);
        setForeground(Color.WHITE);
    }


    public void setColor(String color){

        this.color = color;

        switch (color) {
            case "Purple" -> setBackground(new Color(224, 199, 215));
            case "Pink" -> setBackground(new Color(250, 218, 221));
            case "Blue" -> setBackground(new Color(198, 220, 229, 255));
            case "Red" -> setBackground(new Color(243, 84, 101));
            case "Yellow" -> setBackground(new Color(255, 241, 10));
            case "White" -> setBackground(new Color(255, 255, 255));
            case "Gray" -> setBackground(new Color(94, 92, 92, 255));
            default -> setBackground(new Color(160, 243, 211, 187));
        }
    }


    }

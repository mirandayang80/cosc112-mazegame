import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class Frame extends JFrame {

    public static ColoredButton[][] buttons = new ColoredButton[7][7];
    public static ColoredButton[][] buttons2 = new ColoredButton[21][21];
    public static PersonButton[][] buttons3 = new PersonButton[6][6];
    private MazeOne m1Instance;
    private MazeTwo m2Instance;
    private MazeThree m3Instance;
    public static State curState;

    //Maze one current button
    public static ColoredButton m1CurButton;


    //Sets up the panel
    public void setPanel() {

        Container contentPane = getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Starting screen
        contentPane.setLayout(new GridLayout());

        //Sets rows and columns
        JPanel jp1 = new JPanel();
        //jp1.setLayout(new FlowLayout(1, 3));
        jp1.setLayout(new GridLayout(1, 1));

        //Title
        JLabel chooseMaze = new JLabel("Choose your maze", SwingConstants.CENTER);
        chooseMaze.setFont(new Font("Courier New", Font.BOLD, 50));
        jp1.add(chooseMaze);

        JPanel jp2 = new JPanel();
        jp2.setLayout(new GridLayout(3, 1));

        //Create buttons
        ColoredButton m1Button = new ColoredButton("Numbers Maze", "Pink");
        ColoredButton m2Button = new ColoredButton("Colored Paths", "Pink");
        ColoredButton m3Button = new ColoredButton("Colored Shapes Maze", "Pink");

        m1Button.setFont(new Font("Courier New", Font.BOLD, 30));
        m2Button.setFont(new Font("Courier New", Font.BOLD, 30));
        m3Button.setFont(new Font("Courier New", Font.BOLD, 30));

        //Add buttons to panel
        jp2.add(m1Button);
        jp2.add(m2Button);
        jp2.add(m3Button);

        //Add panels to content pane
        contentPane.add(jp1);
        contentPane.add(jp2);

        //Add action listeners to buttons
        ChangeMazeListener cm1 = new ChangeMazeListener(1, this);
        ChangeMazeListener cm2 = new ChangeMazeListener(2, this);
        ChangeMazeListener cm3 = new ChangeMazeListener(3, this);

        m1Button.addActionListener(cm1);
        m2Button.addActionListener(cm2);
        m3Button.addActionListener(cm3);

        contentPane.validate();

    }


    //Maze One Frame
    public void m1SetPanel() {

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(7, 7));

        JPanel jp2 = new JPanel();
        jp2.setLayout(new GridLayout(2, 1));

        MazeOne m = null;
        try {
            m = new MazeOne();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        m1Instance = m;
        curState = m1Instance.startState();

        int[][] store = m.getCoord();


        boolean pink = false;
        ColoredButton button;
        for (int i = 0; i < store.length; i++) {
            for (int j = 0; j < store[0].length; j++) {

                if (store[i][j] == 0) {
                    button = new ColoredButton("Goal", "Purple");
                    button.setFont(new Font("Courier New", Font.BOLD, 17));
                    jp1.add(button);
                } else if (!pink) {
                    button = new ColoredButton("" + store[i][j], "Purple");
                    button.setFont(new Font("Courier New", Font.BOLD, 35));
                    jp1.add(button);
                    pink = true;
                } else {
                    button = new ColoredButton("" + store[i][j], "Pink");
                    button.setFont(new Font("Courier New", Font.BOLD, 35));
                    jp1.add(button);
                    pink = false;
                }
                buttons[i][j] = button;

                if (i == 0 && j == 0) {
                    m1CurButton = button;
                }

                MazeOneActionListener isClicked = new MazeOneActionListener(m.allTransit[i][j], button);
                button.addActionListener(isClicked);

                //Make the button user are at turn green
                if (i == 0 && j == 0) {
                    button.setColor("Green");
                }

            }
        }

        //Button to go to the main menu
        ColoredButton menuButton = new ColoredButton("Menu", "Blue");
        menuButton.setFont(new Font("Courier New", Font.BOLD, 30));
        ChangeMazeListener changeToMenu = new ChangeMazeListener(0, this);
        menuButton.addActionListener(changeToMenu);

        //Button to show solutions
        ColoredButton solutionButton = new ColoredButton("Solution", "Blue");
        solutionButton.setFont(new Font("Courier New", Font.BOLD, 30));
        SolutionActionListener showSol = new SolutionActionListener();
        solutionButton.addActionListener(showSol);

        jp2.add(menuButton);
        jp2.add(solutionButton);
        contentPane.add(jp1);
        contentPane.add(jp2);
        contentPane.validate();

    }


        public void m2SetPanel() {

            Container contentPane = this.getContentPane();
            contentPane.setLayout(new GridLayout());
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel jp1 = new JPanel();
            jp1.setLayout(new GridLayout(21, 21));

            JPanel jp2 = new JPanel();
            jp2.setLayout(new GridLayout(2, 1));

            MazeTwo m2 = null;
            try {
                m2 = new MazeTwo();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            //Set values for start state
            m2Instance = m2;
            curState = m2Instance.startState();
            curState.getLoc().setColor(1);
            curState.getLoc().setRby(1);

            int[][] store2 = m2.getCoord();

            //Display maze buttons
            ColoredButton button2 = null;
            for (int i = 0; i < store2.length; i++) {
                for (int j = 0; j < store2[0].length; j++) {

                    if (store2[i][j] == 6) {
                        button2 = new ColoredButton("", "Black");
                        jp1.add(button2);
                    }
                    if (store2[i][j] == 1) {
                        button2 = new ColoredButton("", "Red");
                        jp1.add(button2);
                    }
                    if (store2[i][j] == 2) {
                        button2 = new ColoredButton("", "Blue");
                        jp1.add(button2);
                    }
                    if (store2[i][j] == 3) {
                        button2 = new ColoredButton("", "Yellow");
                        jp1.add(button2);
                    }
                    if (store2[i][j] == 4) {
                        button2 = new ColoredButton("", "White");
                        jp1.add(button2);
                    }
                    if (store2[i][j] == 5) {
                        button2 = new ColoredButton("", "Gray");
                        jp1.add(button2);
                    }

                    buttons2[i][j] = button2;

                    if (MazeTwo.allTransit[i][j] != null) {
                        MazeTwoActionListener isClicked2 = new MazeTwoActionListener(MazeTwo.allTransit[i][j], button2);
                        button2.addActionListener(isClicked2);

                    }
                    //Make the button user are at turn green
                    if (i == 20 && j == 9) {
                        button2.setColor("Green");
                    }

                }
            }

            //Button to go to the main menu
            ColoredButton menuButton = new ColoredButton("Menu", "Blue");
            menuButton.setFont(new Font("Courier New", Font.BOLD, 30));
            ChangeMazeListener changeToMenu = new ChangeMazeListener(0, this);
            menuButton.addActionListener(changeToMenu);

            //Button to show solutions
            ColoredButton solutionButton = new ColoredButton("Solution", "Blue");
            solutionButton.setFont(new Font("Courier New", Font.BOLD, 30));
            SolutionActionListener showSol2 = new SolutionActionListener();
            solutionButton.addActionListener(showSol2);

            jp2.add(menuButton);
            jp2.add(solutionButton);
            contentPane.add(jp1);
            contentPane.add(jp2);
            contentPane.validate();


        }


    public void m3SetPanel() {

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(6, 6));

        JPanel jp2 = new JPanel();
        jp2.setLayout(new GridLayout(2, 1));

        MazeThree m3 = null;
        try {
            m3 = new MazeThree();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        m3Instance = m3;
        curState = m3Instance.startState();

        int[][] store = m3.getCoord();

        for (int i = 0; i < store.length; i++) {
            for (int j = 0; j < store[0].length; j++) {

                PersonButton button3 = null;

                if (store[i][j] == 11) {
                    button3 = new PersonButton();
                    button3.setFont(new Font("Courier New", Font.BOLD, 20));
                    jp1.add(button3);
                }

                if (store[i][j] == 16) {
                    button3 = new PersonButton("Sun", "Purple", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }
                if (store[i][j] == 17) {
                    button3 = new PersonButton("Moon", "Purple", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }
                if (store[i][j] == 18) {
                    button3 = new PersonButton("Drop", "Purple", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }
                if (store[i][j] == 19) {
                    button3 = new PersonButton("Cloud", "Purple", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }

                if (store[i][j] == 26) {
                    button3 = new PersonButton("Sun", "Yellow", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }

                if (store[i][j] == 27) {
                    button3 = new PersonButton("Moon", "Yellow", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }
                if (store[i][j] == 28) {
                    button3 = new PersonButton("Drop", "Yellow", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }

                if (store[i][j] == 29) {
                    button3 = new PersonButton("Cloud", "Yellow", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }

                if (store[i][j] == 36) {
                    button3 = new PersonButton("Sun", "Pink", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }

                if (store[i][j] == 37) {
                    button3 = new PersonButton("Moon", "Pink", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }

                if (store[i][j] == 38) {
                    button3 = new PersonButton("Drop", "Pink", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }

                if (store[i][j] == 39) {
                    button3 = new PersonButton("Cloud", "Pink", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }

                if (store[i][j] == 46) {
                    button3 = new PersonButton("Sun", "Blue", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }

                if (store[i][j] == 47) {
                    button3 = new PersonButton("Moon", "Blue", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }
                if (store[i][j] == 48) {
                    button3 = new PersonButton("Drop", "Blue", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }

                if (store[i][j] == 49) {
                    button3 = new PersonButton("Cloud", "Blue", false, "");
                    button3.setFont(new Font("Courier New", Font.BOLD, 15));
                    jp1.add(button3);
                }

                MazeThreeLocation[][] locArr = m3.getAllLoc();

                if(locArr[i][j] != null) {
                    if (i == 5 && j == 1) {
                        button3.setPer(true);
                        button3.setDir("Up");
                    }
                }

                buttons3[i][j] = button3;

                if (MazeThree.allTransit[i][j] != null) {
                    MazeThreeActionListener isClicked = new MazeThreeActionListener(MazeThree.allTransit[i][j], button3);
                    button3.addActionListener(isClicked);
                }

            }
        }

        //Button to go to the main menu
        ColoredButton menuButton = new ColoredButton("Menu", "Blue");
        menuButton.setFont(new Font("Courier New", Font.BOLD, 30));
        ChangeMazeListener changeToMenu = new ChangeMazeListener(0, this);
        menuButton.addActionListener(changeToMenu);

        //Button to show solutions
        ColoredButton solutionButton = new ColoredButton("Solution", "Blue");
        solutionButton.setFont(new Font("Courier New", Font.BOLD, 30));
        SolutionActionListener showSol3 = new SolutionActionListener();
        solutionButton.addActionListener(showSol3);

        jp2.add(menuButton);
        jp2.add(solutionButton);
        contentPane.add(jp1);
        contentPane.add(jp2);
        contentPane.validate();

    }

}


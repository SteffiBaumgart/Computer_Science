
/**
 * Created by Baumgart on 2015/09/07.
 */

//IMPORTS
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Scrabble extends JFrame implements ActionListener {

    //INSTANCE VARIABLES
    private int seconds = 150;
    private Tile currTile = null;
    private JLabel scoreLabel = null;
    private JLabel score = null;
    private boolean tripleWord = false;
    private boolean doubleWord = false;
    private boolean addTime= false;
    private int letterVal = 0;
    private String WORD = "";
    private int i = 0;
    private int prevSelected = 0;
    private int tileNo = 1;
    private JButton button = null;
    private boolean valid = false;
    private int finalScore = 0;
    private JLabel timeLabel = null;

    private TileGUI[] grid = null;
    private String[] dictionary = null;
    private ArrayList<Tile> currWord = new ArrayList<>();
    private ArrayList<TileGUI> currWordGUI = new ArrayList<>();
    Timer time = new Timer(1000, new TimeClass());


    public Scrabble() {

        //Read text file into array
            try{
                dictionary = FileToArray.read("EnglishWords.txt");

            }
            catch(IOException io) {
            System.out.println("Error: The file that you are trying to import does not exist, or is not in the right location.");
        }


        //GUI COMPONENTS
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.PINK);
        UI.put("Panel.background", Color.PINK);
        JOptionPane.showMessageDialog(rootPane, "          Welcome to SCRABBLE.\n Please note that you have a time limit\n" +
                        " to get as many words as you can.\n                Click OK to begin!  ",
                "                        WELCOME", JOptionPane.INFORMATION_MESSAGE);


        this.setSize(1500, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel board = new JPanel();
        JPanel options = new JPanel();
        options.setBackground(Color.BLACK);
        JPanel instructions = new JPanel();
        instructions.setBackground(Color.BLACK);

        setLayout(new BorderLayout());
        add(options, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);
        add(instructions, BorderLayout.SOUTH);


        JLabel instruc = new JLabel("INSTRUCTIONS: \n" +
                "Select adjacent tiles to a form word & click ENTER." +
                " Try to aim for bonus squares!\n    ");
        instruc.setForeground(Color.WHITE);
        instruc.setFont(new Font("Candy Round BTN", Font.BOLD, 16));
        instructions.add(instruc);

        JLabel pink = new JLabel("\nPINK tiles: Triple the score of the word    ");
        pink.setForeground(Color.pink);
        pink.setFont(new Font("Candy Round BTN", Font.BOLD, 16));
        instructions.add(pink);

        JLabel purple = new JLabel("\nPURPLE tiles: Double the score of the word    ");
        purple.setForeground(Color.MAGENTA);
        purple.setFont(new Font("Candy Round BTN", Font.BOLD, 16));
        instructions.add(purple);

        JLabel blue = new JLabel("\nBLUE tiles: Add 10 seconds to the timer");
        blue.setForeground(Color.cyan);
        blue.setFont(new Font("Candy Round BTN", Font.BOLD, 16));
        instructions.add(blue);

        JButton enter = new JButton("ENTER");
        enter.setForeground(Color.MAGENTA);
        enter.setBackground(Color.darkGray);
        options.add(enter);
        enter.addActionListener(this);

        JLabel scoreLabel = new JLabel("    Score: ");
        scoreLabel.setFont(new Font("Candy Round BTN", Font.BOLD, 30));
        scoreLabel.setForeground(Color.MAGENTA);
        scoreLabel.setBackground(Color.darkGray);
        options.add(scoreLabel);
        scoreLabel.setVisible(true);

        score = new JLabel("0");
        score.setFont(new Font("Candy Round BTN", Font.BOLD, 30));
        score.setForeground(Color.MAGENTA);
        score.setBackground(Color.darkGray);
        options.add(score);
        score.setVisible(true);


        JLabel space = new JLabel("   ");
        options.add(space);
        space.setVisible(true);

        JLabel timeLeft = new JLabel("Time: ");
        timeLeft.setForeground(Color.MAGENTA);
        timeLeft.setBackground(Color.darkGray);
        timeLeft.setFont(new Font("Candy Round BTN", Font.BOLD, 30));
        options.add(timeLeft);
        timeLeft.setVisible(true);

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Candy Round BTN", Font.BOLD, 30));
        timeLabel.setForeground(Color.MAGENTA);
        timeLabel.setBackground(Color.darkGray);
        options.add(timeLabel);
        timeLabel.setVisible(true);

        JButton end = new JButton("END GAME");
        end.setForeground(Color.MAGENTA);
        end.setBackground(Color.darkGray);
        options.add(end);
        end.addActionListener(this);

        time.start();

        board.setLayout(new GridLayout(6, 6));
        grid = new TileGUI[36];
        TileCollection tc = new TileCollection();


        //ADD TILES TO BOARD
        for (int i = 0; i < grid.length; i++) {

            currTile = new Tile(tc.removeOne().letter(), tc.removeOne().value());
            grid[i] = new TileGUI(currTile);
            board.add(grid[i]);

            //PINK (Triple Word)
            if (i == 0 || i == 5 || i == 30 || i == 35) {
                grid[i].setBackground(Color.PINK);
                grid[i].setForeground(Color.white);
                grid[i].addActionListener(this);

            }


            //PURPLE (Double Word)
            else if (i == 7 || i == 10 || i == 25 || i == 28) {
                grid[i].setBackground(Color.magenta);
                grid[i].setForeground(Color.white);
                grid[i].addActionListener(this);
            }


            //BlUE (Adds 10 seconds to timer)
            else if (i == 14 || i == 15 || i == 20 || i == 21) {
                grid[i].setBackground(Color.cyan);
                grid[i].setForeground(Color.white);
                grid[i].addActionListener(this);
            }


            //DARK_GRAY (Normal Score)
            else {
                grid[i].setBackground(Color.darkGray);
                grid[i].setForeground(Color.white);
                grid[i].addActionListener(this);
            }
        }

    }



    //WORD VALIDATION & SCORE CALCULATION
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if (action.equalsIgnoreCase("ENTER")) {

            tripleWord = false;
            doubleWord = false;
            addTime = false;

            valid = false;
            tileNo = 1;

            for (i = 0; i < grid.length; i++) {
                button = grid[i];

                //ScoreMultipiliers
                if (button.getBackground() == Color.LIGHT_GRAY) {

                    //PINK (Triple Word)
                    if (i == 0 || i == 5 || i == 30 || i == 35)
                        tripleWord = true;


                    //PURPLE (Double Word)
                    else if (i == 7 || i == 10 || i == 25 || i == 28)
                        doubleWord = true;


                    //BlUE (Adds 10 seconds to timer)
                    else if (i == 14 || i == 15 || i == 20 || i == 21)
                        addTime = true;

                }

            }

            //Adding selected letters to form word
            for (int a = 0; a < currWord.size(); a++) {
                Tile temp = currWord.get(a);
                letterVal = letterVal + temp.value();
                WORD = WORD + temp.letter();
            }


            for (String word : dictionary) {
                if (word.equalsIgnoreCase(WORD)) {
                    valid = true;

                    if(tripleWord)
                        letterVal = letterVal*3;

                    if(doubleWord)
                        letterVal = letterVal*2;

                    if(addTime)
                        seconds += 10;

                    finalScore = finalScore + letterVal;
                    score.setText("" + finalScore);



                    //Turn black if valid
                    for (i = 0; i < grid.length; i++) {
                        button = grid[i];

                        if (button.getBackground()==Color.LIGHT_GRAY) {
                            button.setBackground(Color.BLACK);

                        }

                    }

                    break;
                }
            }

            //if the word is not in dictionary
            if (!valid) {

                tripleWord = false;
                doubleWord = false;
                addTime = false;

                JOptionPane.showMessageDialog(rootPane, "This word doesn't exit in the current dictionary");
                Board();
            }
            refresh();
        }


        else if (action.equalsIgnoreCase("End Game")) {

            time.stop();
            JOptionPane.showMessageDialog(null, "Final Score: " + finalScore +
                                                 "\nThank you for playing!");

            System.exit(0); }


        else {

            for (i = 0; i < grid.length; i++) {
                if (grid[i].equals(e.getSource())) {
                    button = grid[i];


                    int temp = this.Validate(i);
                    prevSelected = i;

                    if (temp == 1) {
                        tileNo++;

                        //SELECTION TURNS LIGHT GREY
                        button.setBackground(Color.lightGray);
                        button.setForeground(Color.darkGray);

                        //Adds tiles to currWord
                        currWord.add(grid[i].getTile());
                        currWordGUI.add(grid[i]);
                        button.setSelected(true);
                    }


                    //Deselects last button selected TURNS WHITE
                    else if (temp == 2) {

                        currWordGUI.remove(currWordGUI.size() - 1);
                        currWord.remove(currWord.size() - 1);

                        button.setBackground(Color.WHITE);
                        button.setSelected(false);


                    }

                }
            }

        }
    }

    // CHANGE COLOUR BACK TO ORIGINAL if not legal word
    public void Board() {

        for (i = 0; i < grid.length; i++) {
            button = grid[i];

            //If button is a temp selection or a mistake click
            if (button.getBackground()==Color.LIGHT_GRAY  || button.getBackground()==Color.WHITE) {

                //PINK (Triple Word)
                if (i == 0 || i == 5 || i == 30 || i == 35) {
                    grid[i].setBackground(Color.PINK);
                    grid[i].setForeground(Color.white);
                    //grid[i].LetterMultiplier(1);
                }


                //PURPLE (Double Word)
                else if (i == 7 || i == 10 || i == 25 || i == 28) {
                    grid[i].setBackground(Color.magenta);
                    grid[i].setForeground(Color.white);
                }


                //BlUE (Adds 10 seconds to timer)
                else if (i == 14 || i == 15 || i == 20 || i == 21) {
                    grid[i].setBackground(Color.cyan);
                    grid[i].setForeground(Color.white);
                }


                //DARK_GRAY (Normal Score)
                else {
                    grid[i].setBackground(Color.darkGray);
                    grid[i].setForeground(Color.white);
                }



            }

        }

    }



    //CHECK IF TILE SELECTED IS "VALID"
    public int Validate (int i) {

        //Adjacent tiles to previously selected
        int adjacentCheck[] = {-1, 1, -5, 5, -6, 6, -7, 7};


        int j = 0;
        for (j = 0; j < adjacentCheck.length; j++) {

            //1st tile selected
            if (tileNo == 1)
                return 1;



            else if (i + adjacentCheck[j] == prevSelected)
                return 1;


            //Tile pressed twice
            else if (button.isSelected() && i == prevSelected)
                return 2;


        }


        //Tile has already been included in a previous legal word
        if (button.getBackground() == Color.BLACK)
            return 0;


        //Not adjacent
        else {
            JOptionPane.showMessageDialog(rootPane, "ERROR: This is an illegal selection.");
            return 0; }


    }



    //TIMER (Starts at 150 seconds)
    public class TimeClass implements ActionListener{

        public void actionPerformed(ActionEvent evt){
            seconds--;
            timeLabel.setText("" + seconds + "    ");
            if(seconds <= 0){
                time.stop();
                JOptionPane.showMessageDialog(rootPane,"        GAME OVER\nYour final score is: " + finalScore + "\nThanks for playing!");

                //Write high-score to text file
                try{
                    File f = new File (System.out.println(finalScore));
                    BufferedWriter b = new BufferedWriter (new FileWriter(f);
                    b.write(finalScore);
                    b.close();
                }

                catch (IOException)
                   { System.out.println("Not found"); }


                System.exit(0);
            }


        }
    }


    //REFRESH ENTERED LETTER AND WORD VALUES
    public void refresh(){
        currWord.clear();
        currWordGUI.clear();
        WORD = "";
        letterVal = 0;
    }

} 
          

   



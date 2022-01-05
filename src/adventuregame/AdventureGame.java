
// This program is an interactive choose your own adventure game in which the 
// player assumes the role of a famous swordsman who is tasked with slaying
// monsters in a mysterious and dangerous dungeon. 
// The player is given 10 points of health at the beginning of the game that
// will decrease based on the attacks that the player sustains from enemies. 
// During each step of the game, the player will be presented with a brief 
// section of text that provides detail about the story or about what has 
// transpired since their last decision. They will be prompted to make a 
// decision from 2-3 possible options concerning their next move.
// They may be able to choose to run away, attack an enemy, or choose
// where they would like to go next in the dungeon. 
// If the player chooses to run away at any point during the story, they will
// be presented with a game over screen, which may also include which monsters
// they have killed before leaving the dungeon. This will be accomplished using
// an array that will store all the monsters' names that the player encounters
// during their playthrough. The elements of this array would then be displayed
// on this game over screen. 
// During an individual playthrough, a player will only be able to counter 
// a maximum of two enemy monsters. One monster that they encounter shortly 
// after choosing which direction they would like to walk in during the dungeon,
// and the final one is the dragon that will appear regardless of which 
// direction they choose. 
// The damage that an enemy monster takes off the player's health is a random
// number generated using the Random class.
// In addition, during the player's battle with the dragon, the damage will
// be calculated twice in a for loop, and then the final amount will be deducted
// from the player's health. Furthermore, the damage taken off the player's
// health is stored and displayed using an array. 
// If the player manages to defeat the dragon and survive, then they will
// have successfully won the game and will be presented a screen that informs
// them of all the monsters they have killed along with a congratulatory 
// message. 
// This video game's soundtrack is composed of a song called Kingdom of Bards
// composed by Adrian Von Ziegler. 

package adventuregame;

import java.awt.Color; // You must include this line at the top of your 
// program to instantiate the Color class. The Color class from the 
// Abstract Window Toolkit (AWT) package defines several methods that create
// color by using either given RGBA values or by using presets for basic
// colors such as but not limited to: blue, white, black, red, etc. In this
// case they will be used to set the color of panels, labels, buttons, and
// text. 
import java.awt.FlowLayout; // You must include this line at the top of your 
// program to instantiate the FlowLayout class. The FlowLayout class from the 
// Abstract Window Toolkit (AWT) package provides very simple layout manager 
// methods that is used by JPanel objects. In this case, it will be used to
// position the buttons that the player can select (in conjunction with the 
// GridLayout class). 
import java.awt.Font; // You must include this line at the top of your 
// program to instantiate the Font class. The Font class from the 
// Abstract Window Toolkit (AWT) package defines several methods that can be 
// used to render text in a visible way. It will be used to specify the font
// size, and style of all the text in our game. 
import java.awt.GridLayout; // You must include this line at the top of your 
// program to instantiate the GridLayout class. The GridLayout class from the 
// Abstract Window Toolkit (AWT) package provides very simple layout manager 
// methods that is used by JPanel objects. In this case, it will be used to
// help position the buttons that the player can select (in conjunction with the 
// FlowLayout class). 
import java.awt.event.ActionEvent; // You must include this line at the top 
// of your program to instantiate the ActionEvent class. The ActionEvent class 
// from the Abstract Window Toolkit (AWT) package is a semantic event that
// indicates that a component-defined action occured. In this case, it will be 
// used to help inform the program when a mouse-click has occured to start the
// game or when a choice has been made. It will work in conjunction with the
// ActionListener class. 
import java.awt.event.ActionListener; // You must include this line at the top 
// of your program to instantiate the ActionListener class. The ActionListener  
// class from the Abstract Window Toolkit (AWT) package is an interface 
// for receiving action events and processing an action event  In this case, 
// it will be used to help process what to do when a mouse-click has occured to 
// start the game or when a choice has been made. It will work in conjunction 
// with the ActionEvent class. 
import java.io.File; // You must include this line at the top of your 
// program to instantiate the File class. The File class in the input/ouput 
// package can be used to be an abstract representation of a file on a computer,
// and in this case, will be used to help play the soundtrack of the game, 
// which is a .wav file. 
import javax.sound.sampled.AudioInputStream; // You must include this line at 
// the top of your program to instantiate the AudioInputStream class. The 
// AudioInputStream class in the sound sampled package creates an input stream 
// with a specified audio format and length. It can be used to obtain 
// an audio input stream from an external audio file, stream, or URL. In this
// case, it will be used to help play the soundtrack of the game
import javax.sound.sampled.AudioSystem; // You must include this line at 
// the top of your program to instantiate the AudioSystem class. The 
// AudioSystem class in the sound sampled package defines several methods
// for converting audio data between different formats. In this case, it will be 
// used to help play the soundtrack of the game
import javax.sound.sampled.Clip; // You must include this line at 
// the top of your program to instantiate the Clip class. The Clip class in
// the sound sampled package provides an interface that can load audio data 
// prior to playback, instead of being streamed in real time. In this case, 
// it will be used to help play the soundtrack of the game
import javax.swing.JPanel; // You must include this line at the top of your 
// program to instantiate the JPanel class. The JPanel class in the swing 
// package is a simple container class to attach any other component to a 
// window. It will be used to help place the majority of the graphics and text  
// in the game. 
import javax.swing.JFrame; // You must include this line at the top of your 
// program to instantiate the JFrame class. The JFrame class in the swing 
// package works like the main window where components like labels, buttons, 
// and textfields are added to create a GUI. It will be used to help create the 
// GUI of this game. 
import javax.swing.JLabel; // You must include this line at the top of your 
// program to instantiate the JLabel class. The JLabel class in the swing 
// package can be used to place text in a container. It is used to display a 
// single line of read only text. It will be used in this game to display the
// title of the game at the start screen. It will also be used to display the
// amount of health the player has. 
import javax.swing.JButton; // You must include this line at the top of your 
// program to instantiate the JButton class. The JButton class in the swing 
// package is used to create a labeled button and will be used to create the
// button for start and the buttons for the choices that are presented to the
// user. 
import javax.swing.JTextArea; // You must include this line at the top of your 
// program to instantiate the JTextArea class. The JTextArea class in the swing 
// package is a multi line region that displays text. It will be used to display
// the text for the game's story, to the reader. It will also be used for the
// messages in the win and game over screens. 
import java.util.Random; // You must include this line at the top of your 
// program to instantiate the Random class. The Random class in the java.util 
// package defines several methods that are useful in generating random
// numbers, and in this case, will help in generating the numbers for the amount
// of damage that a monster's attack does. 

public class AdventureGame 
{// start of the AdventureGame object
    
  public static void main(String[] args) 
    {// start of main 
     // First, you need to declare all your variables if there are any, and 
     // instantiate objects. 
        
        AllGameFunctions newgame = new AllGameFunctions(); // Since the 
        // AllGameFunctions class is in the same package as this one, 
        // we simply have to instantiate the object so that we can use the 
        // methods that we created within it. The AllGameFunctions class 
        // contains various methods for almost all of the game's processes and
        // functions that lead into each other. 
        
            GameMusic("The Dungeon Music.wav"); // defines that the 
            // "the Dungeon Music.wav" file which is found in the project folder 
            // for this program is the formal argument that will be used for the 
            // GameMusic() method. It also calls this method to activate and 
            // to begin to play music. 
            newgame.GameScreen(); // calls the GameScreen() method from the
            // AllGameFunctions class. 
            
    }// end of main
  
    public static void GameMusic(String filepath)
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Static is used to specify that this is a method that can be accessed
    // without requiring an instantiation of the class to which it belongs. 
    // Void is used to specify that the method does not return any value.
    // This method will start playing the audio file for our video game 
    // soundtrack and loop it continously.
    // The "String filepath" is the formal argument.
    // Citation: ODidily, Max. "How to Play, Loop, Pause and 
    // Stop Music in Java", YouTube, 28 Nov. 2018, 
    // www.youtube.com/watch?v=TErboGLHZGA&t=527s.
    // This try/catch statement is a MODIFIED version of the try/catch statement
    // displayed in Max O'Didily's video called "How to Play, Loop, Pause and 
    // Stop Music in Java" that can be found on www.youtube.com/watch?v=TErboGL
    // HZGA&t=527s. I am using it because I needed to create a music loop in
    // my program to play the video game soundtrack. 
               
        {// start of the GameMusic() method
 
                try // A try statement contains a set of statements where an
                // exception can occur. In this case, we are trying to access
                // a file from the project folder of this program and will try
                // to play it continously. However these statements should 
                // execute successfully each time the program is run, so no
                // statements need to be followed after the catch statement. 
                {
                    File music = new File (filepath); // We create the file
                    // object called music and it will have the filepath of
                    // the formal argument that is specified. 
                    AudioInputStream audio = AudioSystem.getAudioInputStream(music);
                    // We created the object "audio" that will be responsible  
                    // for bringing the music from the filepath of the object  
                    // called "music", that we defined above, into this program. 
                    Clip clip = AudioSystem.getClip(); // We will use the Clip
                    // class to play the music, and in this step we are getting 
                    // audio stream from the "audio" object that we defined 
                    // above. 
                    clip.open(audio); // opens the clip so that the clip class
                    // can start playing it. 
                    clip.start(); // causes the clip class to starts to play 
                    // the audio or the music.
                    clip.loop(Clip.LOOP_CONTINUOUSLY); // tells the clip class
                    // to start looping the audio indefinitely. 

                }
                catch (Exception e) // If an exception occurs in the try 
                // statement then the control of execution is passed to this 
                // corresponding catch statement. However since we do not want 
                // anything to appear or to be executed if there is an exception
                // in the try statement, we will not include anything in this
                // section. Nevertheless whenever we use a try statement, we 
                // must follow it with a catch statement. 
                {

                }
                
        }// end of the GameMusic() method      
    
} // end of the AdventureGame object

class AllGameFunctions 
{ // start of the AllGameFunctions class
  // First, you need to declare all your variables and instantiate objects.
    
    int health=10; // this will carry the numerical amount of heatlh during
    // gameplay, that will be displayed within the healthLabelNumber JLabel. 
    // It's amount will fluctuate depending on how much damage that the player 
    // received. Since the player starts with a base of 10 points of health
    // at the beginning of the game, we will set it to 10. 
    String area=null; // this will carry the string value for which area of
    // the game that the player is in. This variable is vital to the 
    // functionality of the game as it will be used heavily in a switch 
    // statement that will dictate which methods to activate, which in turn,   
    // will determine what the player will be displayed based on the choices
    // they make. 
    String allMonsters[] = new String [2]; // this will hold the string values 
    // for the names of all the monsters that the player defeats in their 
    // playthrough. These values will then be displayed on the game over screen
    // that will inform the player of all the enemies they defeated, if any. 
    // Since a player can only fight a maximum of two enemies in a single
    // playthrough, the size of the this array will only be two elements. 
    int damage1=0; // this will hold the integer value for the amount of damage
    // generated in the first battle. We will set it to 0 for now because
    // the damage is yet to be generated. 
    int damage2=0; // this will hold the integer value for the amount of damage
    // generated in the second battle. In the second battle, damage is generated
    // twice in a for loop, so this variable receives more than one value. 
    // However before the loop is run again, the variable's value is copied to
    // the damage array. 
    int damageTotal=0; // this will hold the integer value for sum of the two 
    // values of damage2 that were inputted into the damage array, during
    // the second battle. The reason for this is because you cannot display 
    // the added sum of two array elements in the JTextArea, so this additional
    // variable was required to show the total damage in the JTextArea. 
    int damage [] = new int [3]; // this will hold the integer values for the 
    // amount of damage that the player receives after it is calculated within
    // the other "damage" variables. The values in this array will also be
    // displayed to the player when the game states how much damage they 
    // receive after an enemy attacks them. 
    
    JFrame gameScreen=null; // the main window where components like labels,
    // buttons, and textfields are added to create a GUI.
    JPanel gameTitlePanel=null; // a container that will be used to help place 
    // the video game's title on the start screen. 
    JLabel gameTitleLabel=null; // used to display the game title on the start
    // screen. 
    JPanel startButtonPanel=null; // a container that will be used to help place 
    // the start button on the video game's start screen. 
    JButton startButton=null; // used to create the start button that will be
    // placed on the video game's start screen. 
    JPanel storyTextPanel=null; // a container that will be used to help place 
    // the text for the video game's story, the outcome of a player's 
    // decision, and the amount of damage that they received from an enemy
    // on the screen. 
    JTextArea storyText=null; // used to display the text for the video game's
    // story, the outcome of a player's decision, the amount of damage that 
    // they received from an enemy, and the game over screen. 
    JPanel optionsPanel=null; // a container that will be used to help place 
    // the video game's various possible options (that will be programmed as
    // individual buttons. 
    JButton option1=null; // used to create the first option/choice button 
    // that will be placed for each instance that the player needs to make a 
    // choice. 
    JButton option2=null; // used to create the second option/choice button 
    // that will be placed for each instance that the player needs to make a 
    // choice. 
    JButton option3=null; // used to create the third option/choice button 
    // that will be placed for each instance that the player needs to make a 
    // choice. 
    JPanel healthPanel=null; // a container that will be used to help place 
    // the text and information related to the player's health during gameplay.
    JLabel healthLabel=null; // used to display the "player health" subtitle 
    // during gameplay. 
    JLabel healthLabelNumber=null; // used to display the numerical amount of
    // health during gameplay. 

    StartButtonFunction startButtonFunction = new StartButtonFunction(); 
    // This helps add functionality to the start button. When the start button
    // is clicked by the player, the startButtonFunction object will be 
    // activated by the ActionListener class. Once this happens, 
    // startButtonFunction will activate the StartButtonFunction class. Overall, 
    // will allow the program to transition to the gameplay after the start 
    // button is pressed. 
    OptionPicker optionPicker = new OptionPicker();
    // This helps add functionality to the option buttons. When the option is
    // chosen and clicked by the player, the optionPicker object will be 
    // activated by the ActionListener class. Once this happens, optionPicker
    // will activate the OptionPicker class. Overall, this allow the program
    // to display the enxt gameplay segement based on the player's choice. 
    Color bloodred = new Color(139,0,0); // This creates a custom color called
    // bloodred that will be used various times in the code to specify the color
    // of a JLabel or a JTextArea. Instead of always inputting the specific
    // color values each time I want this specific shade of red to be utilized,
    // I created the bloodred object to streamline the process. 
    Font gameTitleFont = new Font ("Times New Roman", Font.BOLD, 96);
    // This creates the font that I would like to use for the game title that
    // will be displayed on the start screen. 
    // In the brackets I specify the name of the font that I want to use, which 
    // is Times New Roman. Afterwards I specify which style I want the font to
    // be displayed in, which in this case, is bold because I want to put 
    // emphasis on this text. Finally, I indicate which size I want the text to
    // be, which in this case, is size 96. 
    Font startButtonFont = new Font ("Times New Roman", Font.PLAIN, 40);
    // This creates the font that I would like to use for the start button that
    // will be displayed on the start screen. 
    // In the brackets I specify the name of the font that I want to use, which 
    // is Times New Roman. Afterwards I specify which style I want the font to
    // be displayed in, which in this case, is plain because I do not need this 
    // text to be emphasized. Finally, I indicate which size I want the text to
    // be, which in this case, is size 40. 
    Font storyFont = new Font ("Times New Roman", Font.PLAIN, 35);
    // This creates the font that I would like to use for the story text that
    // will be displayed after the start screen. 
    // In the brackets I specify the name of the font that I want to use, which 
    // is Times New Roman. Afterwards I specify which style I want the font to
    // be displayed in, which in this case, is plain because I do not need this 
    // text to be emphasized. Finally, I indicate which size I want the text to
    // be, which in this case, is size 35. 
    Font regularFont = new Font ("Times New Roman", Font.PLAIN, 28);
    // This creates the font that I would like to use for the text that
    // will be used for anything besides the main story text, such as the text
    // that will be used for each option button and the text that will be used
    // for the health bar. 
    // In the brackets I specify the name of the font that I want to use, which 
    // is Times New Roman. Afterwards I specify which style I want the font to
    // be displayed in, which in this case, is plain because I do not need this 
    // text to be emphasized. Finally, I indicate which size I want the text to
    // be, which in this case, is size 28. 
    
    public void GameScreen()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.
    // This method will set up some basic graphic components for the game and
    // will set up the title screen of the game. 
    {//start of the GameScreen()
        
        gameScreen = new JFrame(); // this intializes the object gameScreen
        // within this method. This object is used to create the main window 
        // where components like labels, buttons, and textfields are added to
        // create a GUI.
        gameTitlePanel = new JPanel(); // this intializes the object 
        // gameTitlePanel within this method. It will be used to help place 
        // the video game's title on the start screen. 
        startButtonPanel = new JPanel(); // this intializes the object 
        // startButtonPanel within this method. It will be used to help place 
        // the start button on the video game's start screen. 
        gameTitleLabel = new JLabel("THE DUNGEON"); // this intializes the
        // object, gameTiteLabel within this method. It will be used to 
        // display the game title, which is written in the brackets. 
        startButton = new JButton("START"); // this intializes the
        // object, startButton within this method. It will be used to 
        // create the start button on the start screen. 

        
            gameScreen.setSize(800, 600); // sets the size of the game screen
            // window that will be 800 pixels wide and 600 pixels in length. 
            gameScreen.getContentPane().setBackground(Color.black); // sets
            // the background color of the window black. 
            gameScreen.setLayout(null); // disables a default layout and allows 
            // us to create our own layout. 
            gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // allows the user to exit the application when they click the close
            // button in the corner of the window.

            gameTitlePanel.setBounds(0, 100, 800, 130);
            // Sets the size and position of the panel for the video game's 
            // title by int x, int y, int width, int height, which are the 
            // values for the pixel measurements in the brackets. 
            gameTitlePanel.setBackground(Color.black);
            // Sets the background color of the panel to black.
            gameTitleLabel.setLocation(100, 100);
            // Sets the location of the video game title to the pixel 
            // coordinates (100, 100) on the window, for the start screen. 
            gameTitleLabel.setForeground(bloodred);
            // Sets the text color of the video game title on the start screen
            // to my custom color, "bloodred".
            gameTitleLabel.setFont(gameTitleFont);
            // Sets the font of the video game title to the my custom font style
            // called "gameTitleFont". 
            gameTitlePanel.add(gameTitleLabel);
            // This places the video game title on the panel for the video
            // game title.
            gameScreen.add(gameTitlePanel);
            // adds the panel for the game title to the game screen.

            startButtonPanel.setBounds(300, 370, 200, 100);
            // Sets the size and position of the panel for the start button 
            // by int x, int y, int width, int height, which are the 
            // values for the pixel measurements in the brackets. 
            startButtonPanel.setBackground(Color.black);
            // Sets the background color of the panel to black.
            startButton.setBackground(Color.black);
            // Sets the background color of the button to black. 
            startButton.setForeground(bloodred); 
            // Sets the text color of the button to my custom color, "bloodred". 
            startButton.setOpaque(true);
            // This sets the opacity of the button to true so you see the 
            // background color of the button. 
            startButton.setBorderPainted(false);
            // This removes the focus border used to show which button has
            // focus. 
            startButton.setFont(startButtonFont);
            // Sets the font that is used by the button to the my custom font
            // style called "startButtonFont". 
            startButtonPanel.add(startButton);
            // This places the start button on the panel for the start button.
            gameScreen.add(startButtonPanel);
            // adds the panel for the start button to the game screen.

            startButton.addActionListener(startButtonFunction);
            // Adds functionality to the start button; when it is clicked, it
            // will recognize the click and activate startButtonFunction.
            // startButtonFunction calls the StartButtonFunction class, 
            // which will activate certain methods that will allow the title
            // screen to transition to the gameplay screen. 

            gameScreen.setVisible(true);
            // sets the visibility of the game screen to true, so it can be
            // seen. 
            
    }//end of the GameScreen()

    public class StartButtonFunction implements ActionListener
    // Public is used to specify that this class is visible to all other 
    // classes. 
    // This class utilizes the ActionListener class which will be used to help 
    // process what to do when a mouse-click has occured on the start button. 
    // I learned how the ActionListener class works in conjunction with buttons
    // by using the same citation that I listed above. However, I did not copy
    // any code directly from that site.
    {//start of the StartButtonFunction class

        
        public void actionPerformed (ActionEvent event)
        // Public is used to specify that this method is visible to all other 
        // classes. 
        // Void is used to specify that the method does not return any value.
        // The ActionEvent class will be used to help inform the program what to
        // do in the event that a mouse-click has occured. It will work in 
        // conjunction with the ActionListener class. 
        // Public is used to specify that this method is visible to all other 
        // classes.             
        // Void is used to specify that the method does not return any value.
        {//start of the actionPerformed method
            
            GameplayWindow(); // calls the GameplayWindow() method, which will
            // cause the game screen to switch from the start screen to the 
            // gameplay screen. 
            
        }//end of the actionPerformed method
        
    }//end of the StartButtonFunction class

    public void GameplayWindow()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.   
    // This method will set up the main graphic components for gameplay section
    // of this game. 
    // I learned how to code a GUI from this website, however, I did not copy
    // any code directly from this site to contstruct the GUI of this program.
    // Citation: "Learn Java Swing", CodeJava, 6 July. 2019,
    // www.codejava.net/java-se/swing/jframe-basic-tutorial-and-examples. 
    {//start of the GameplayWindow() method
        
        storyTextPanel = new JPanel(); // this intializes the object 
        // storyTextPanel within this method. It will be used to help place 
        // all the text for the main story on the screen.  
        storyText= new JTextArea(); // this intializes the object 
        // storyText within this method. It will be used to used to display the 
        // text for the video game's story. 
        optionsPanel = new JPanel(); // this intializes the object 
        // optionsPanel within this method. It will be used to help place 
        // all the player's options onto the screen. 
        option1 = new JButton(); // this intializes the object, option1 within
        // this method. It will be used to create the first option button during
        // the gameplay segment of the game. 
        option2 = new JButton(); // this intializes the object, option2 within
        // this method. It will be used to create the first option button during
        // the gameplay segment of the game. 
        option3 = new JButton(); // this intializes the object, option3 within
        // this method. It will be used to create the first option button during
        // the gameplay segment of the game. 
        healthPanel = new JPanel(); // this intializes the object healthPanel 
        // within this method. It will be used to help place the information
        // concerning the player's health onto it. 
        healthLabel = new JLabel("Player Health: "); // this intializes the
        // object, healthLabel within this method. It will be used to 
        // display the subtitle "Player Health" onto the screen.   
        healthLabelNumber = new JLabel("" + health); // this intializes the
        // object, healthLabelNumber within this method. It will be used to 
        // display the numerical number of the Player's Health onto the screen.
        // the current value of the player's health is stored as an integer
        // value in the variable health. Currently, since the game just started,
        // it is 10. 
        
            gameTitlePanel.setVisible(false); // sets the visibility of the game
            // title panel to false; it hides it from view. 
            startButtonPanel.setVisible(false); // sets the visibility of the 
            // start button panel to false; it hides it from view. 

            storyTextPanel.setBounds (100, 100, 600, 250);
            // Sets the size and position of the panel for the story text panel 
            // by int x, int y, int width, int height, which are the 
            // values for the pixel measurements in the brackets. It is the
            // same measurements as the story text. 
            storyTextPanel.setBackground(Color.black); 
            // Sets the background color of the panel to black.
            gameScreen.add(storyTextPanel);
            // adds the panel for the story text to the game screen. 

            storyText.setBounds (100, 100, 600, 250);
            // Sets the size and position of the panel for the story text itself
            // by int x, int y, int width, int height, which are the 
            // values for the pixel measurements in the brackets. It is the
            // same measurements as the story text panel. 
            // This code is quite like creating a text box. 
            storyText.setBackground(Color.black);
            // Sets the story text background to black, 
            storyText.setForeground(bloodred);
            // Sets the text color to my custom color, "bloodred". 
            storyText.setFont(storyFont);
            // Sets the font that is used by the text for the story to the my 
            // custom font style called "storyFont". 
            storyText.setLineWrap(true);
            // the line wont exceed a certain length in the panel
            storyText.setEditable(false); 
            // does not allow the story text to be edited by the player
            storyText.setWrapStyleWord(true);
            // The story text lines will be wrapped at word boundaries 
            // (whitespace) if they are too long to fit within the 
            // allocated width.
            storyTextPanel.add(storyText);
            // This places the story text on the panel for the story text.            

            optionsPanel.setBounds(100, 350, 500, 150);
            // Sets the size and position of the panel for the options panel
            // by int x, int y, int width, int height, which are the 
            // values for the pixel measurements in the brackets. 
            optionsPanel.setBackground(Color.black);
            // Sets the background color of the panel to black.
            optionsPanel.setLayout(new GridLayout(3,1));
            // This organizes the panel using the GridLayout class. It places
            // one button in a horizontal row, and three in a column. This helps
            // the screen look organized, formatted, and not cluttered. 
            optionsPanel.setLayout(new FlowLayout (FlowLayout.LEFT));
            // This organizes the panel using the FlowLayout class. It places
            // alls the buttons to the left of the panel. This helps the screen
            // look organized, formatted, and not cluttered. 
            gameScreen.add(optionsPanel);
            // adds the panel for the options to the game screen.

            option1.setBackground(Color.black);
            // Sets the background color of the button to black. 
            option1.setForeground(Color.white);
            // Sets the text color of the button to white.
            option1.setFont(regularFont);
            // Sets the font that is used by the option buttons in the game to 
            // my custom font style called "regularFont". 
            option1.setOpaque(true);
            // This sets the opacity of the button to true so you see the 
            // background color of the button. 
            option1.setBorderPainted(false);
            // This removes the focus border used to show which button has
            // focus. 
            option1.addActionListener(optionPicker);
            // Adds functionality to the option 1 button; when it is clicked, it
            // will recognize the click and activate optionPicker.
            // optionPicker calls the OptionPicker class, 
            // which will activate a certain method to transition to player to
            // the next part of the story based on their decision. 
            option1.setActionCommand("decision1");
            // Sets the command name for the action event fired by this button. 
            // The method that corresponds to this command will activate if 
            // this button is clicked. 
            optionsPanel.add(option1);
            // This places the button on the panel for all the options.            

            option2.setBackground(Color.black);
            // Sets the background color of the button to black. 
            option2.setForeground(Color.white);
            // Sets the text color of the button to white.
            option2.setFont(regularFont);
            // Sets the font that is used by the option buttons in the game to 
            // my custom font style called "regularFont". 
            option2.setOpaque(true);
            // This sets the opacity of the button to true so you see the 
            // background color of the button. 
            option2.setBorderPainted(false);
            // This removes the focus border used to show which button has
            // focus. 
            option2.addActionListener(optionPicker);
            // Adds functionality to the option 2 button; when it is clicked, it
            // will recognize the click and activate optionPicker.
            // optionPicker calls the OptionPicker class, 
            // which will activate a certain method to transition to player to
            // the next part of the story based on their decision. 
            option2.setActionCommand("decision2");
            // Sets the command name for the action event fired by this button. 
            // The method that corresponds to this command will activate if 
            // this button is clicked. 
            optionsPanel.add(option2);
            // This places the button on the panel for all the options.            

            option3.setBackground(Color.black);
            // Sets the background color of the button to black. 
            option3.setForeground(Color.white);
            // Sets the text color of the button to white.
            option3.setFont(regularFont);
            // Sets the font that is used by the option buttons in the game to 
            // my custom font style called "regularFont". 
            option3.setOpaque(true);
            // This sets the opacity of the button to true so you see the 
            // background color of the button. 
            option3.setBorderPainted(false);
            // This removes the focus border used to show which button has
            // focus. 
            option3.addActionListener(optionPicker);
            // Adds functionality to the option 3 button; when it is clicked, it
            // will recognize the click and activate optionPicker.
            // optionPicker calls the OptionPicker class, 
            // which will activate a certain method to transition to player to
            // the next part of the story based on their decision. 
            option3.setActionCommand("decision3");
            // Sets the command name for the action event fired by this button. 
            // The method that corresponds to this command will activate if 
            // this button is clicked. 
            optionsPanel.add(option3);
            // This places the button on the panel for all the options.            
            
            healthPanel.setBounds (100, 15, 370, 50);
            // Sets the size and position of the panel for the health 
            // panel by int x, int y, int width, int height, which are the 
            // values for the pixel measurements in the brackets. 
            healthPanel.setBackground (Color.black); 
            // Sets the background color of the panel to black.
            healthPanel.setLayout (new GridLayout (1,2));
            // This organizes the panel using the GridLayout class. It places
            // one componennt in a column, and two in a column.
            gameScreen.add(healthPanel); 
            // adds the panel for the health information to the game screen.

            healthLabel.setForeground (Color.green); 
            // Sets the text color of the player health subtitle to green.
            healthLabel.setFont(regularFont);
            // Sets the font that is used by the player health subtitle to 
            // my custom font style called "regularFont". 
            healthPanel.add(healthLabel);
            // This places the subtitle for the player's health on the panel
            // for all the health information.           
            healthLabelNumber.setFont(regularFont);
            // Sets the font that is used by the current value of the player's
            // health to my custom font style called "regularFont". 
            healthLabelNumber.setForeground(Color.green);
            // Sets the text color of the amount of health to green.
            healthPanel.add(healthLabelNumber); 
            // This places the current value of the player's health on the panel
            // for all the health information.            
            
            

            DungeonGate(); // calls the DungeonGate() method
            
    }//end of the GameplayWindow() method
    
    public void DungeonGate()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.
    // This method sets up the gameplay area called DungeonGate, gives the
    // player some context, and provides them with options to make a decision.
    {//start of the DungeonGate() method
        
        area = "DungeonGate"; // sets the area variable, created to
        // specify where the player is located, to this area of the game. 
        
        allMonsters [0] = "none"; // sets the first element in allMonsters array
        // to none. It is set to none because if the player chooses to run away
        // from the dungeon they will receive a game over screen. The game over
        // screen will display a slightly altered message depending on if
        // the player has killed any monsters, in which case, this index would 
        // not be equal to "none" but the name of a monster. 

            storyText.setText("You are a famous swordsman, sent to defeat the monsters in this dungeon.\nRight now you are at the dungeon gate!\n(Make your decision by clicking on the option you want)");
            // sets the text for the story and this text informs the player of
            // what is currently happening in the game's story, and provides
            // them enough context before they make their next decision. 
            
            option1.setText("1. Enter the dungeon"); 
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option2.setText("2. Talk to the gatekeeper");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option3.setText("3. Run away from the dungeon");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 

    }//end of the DungeonGate() method
    
    public void EnterDungeon()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.
    // This method sets up the gameplay area called EnterDungeon, gives the
    // player some context, and provides them with options to make a decision.
    {//start of the EnterDungeon() method
        
        area = "EnterDungeon"; // sets the area variable, created to
        // specify where the player is located, to this area of the game. 
        
            storyText.setText("You enter the dungeon and begin to walk down a dark corridor.\n\nThe corridor splits off into three paths! ");
            // sets the text for the story and this text informs the player of
            // what is currently happening in the game's story, and provides
            // them enough context before they make their next decision. 
            
            option1.setText("1. Keep walking straight");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option2.setText("2. Turn to the right");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option3.setText("3. Turn to the left");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            
    }//end of the EnterDungeon() method
    
    public void TalkWithGateKeeper()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.
    // This method sets up the gameplay area called TalkWithGateKeeper, gives 
    // the player some context, and provides them with options to make a
    // decision.
    {//start of the TalkWithGateKeeper() method
        
        area = "TalkWithGateKeeper"; // sets the area variable, created 
        // to specify where the player is located, to this area of the game. 
        
            storyText.setText("The gatekeeper says,\"Good day to you sir and best of luck on your journey into the dungeon. However, I warn you, many have tried to slay the monsters that lie within, but none have suceeded.\"");
            // sets the text for the story and this text informs the player of
            // what is currently happening in the game's story, and provides
            // them enough context before they make their next decision. 
            
            option1.setText("1. Enter the dungeon");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option2.setText("2. Run away from the dungeon");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option3.setText("");
            // sets the text for this option button, but in this case no text
            // will be displayed because this button will not be available for
            // the player to choose and there will not be another decision for
            // the player to make besides the ones already listed. 
            
    }//end of the TalkWithGateKeeper() method
    
    public void RunAway()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.        
    // This method sets up the gameplay area called RunAway, gives the
    // player some context, and provides them with options to make a decision.
    {//start of the RunAway() method
        
                if (allMonsters [0].equals("none"))
                // if the string value for the first element in the allMonsters 
                // array is equal to "none", then show this message. The "none"
                // represents that the player has not killed any monsters yet. 
                    storyText.setText("You decided to run away from the dungeon.\n\nGAME OVER!");
                    // sets the text for the story and this text informs the  
                    // player of what has transpired from running away and that
                    // the game is over. 
                else
                // in any other scenario, where the first element in the 
                // allMonsters array is equal to anything except "none", then 
                // show this message.
                    storyText.setText("You decided to run away from the dungeon.\nYou killed " + allMonsters[0] + ".\n\nGAME OVER!");
                    // sets the text for the story and this text informs the  
                    // player of what has transpired from running away. It also
                    // indicates the name of the monster they had killed while
                    // in the dungeon and that the game is now over. 

            optionsPanel.setVisible(false); // hides the options panel and  
            // all the option buttons from the view of the player.
            healthPanel.setVisible(false); // hides the player health panel and  
            // all of its related information from the view of the player.
            
    }//end of the RunAway() method

    public void Straight()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.        
    // This method sets up the gameplay area called Straight, gives the
    // player some context, and provides them with options to make a decision.
    {//start of the Straight() method
        
        area = "Straight"; // sets the area variable, created to
        // specify where the player is located, to this area of the game. 
        
            storyText.setText("You decide to continue to walk straight down this dark path.\nAll of a sudden, you encounter a Cyclops!");
            // sets the text for the story and this text informs the player of
            // what is currently happening in the game's story, and provides
            // them enough context before they make their next decision. 
            
            option1.setText("1. Fight the Cyclops");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option2.setText("2. Run away from the Cyclops");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option3.setText("");
            // sets the text for this option button, but in this case no text
            // will be displayed because this button will not be available for
            // the player to choose and there will not be another decision for
            // the player to make besides the ones already listed. 
            
    }//end of the Straight() method
    
    public void Right()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.        
    // This method sets up the gameplay area called Right, gives the
    // player some context, and provides them with options to make a decision.
    {//start of the Right() method
        
        area = "Right"; // sets the area variable, created to
        // specify where the player is located, to this area of the game. 
        
            storyText.setText("You decide to turn right and walk down this dark path.\nAll of a sudden, you encounter a Minotaur!");
            // sets the text for the story and this text informs the player of
            // what is currently happening in the game's story, and provides
            // them enough context before they make their next decision.

            option1.setText("1. Fight the Minotaur");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option2.setText("2. Run away from the Minotaur");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option3.setText("");
            // sets the text for this option button, but in this case no text
            // will be displayed because this button will not be available for
            // the player to choose and there will not be another decision for
            // the player to make besides the ones already listed. 
            
    }//end of the Right() method
    
    public void Left()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.        
    // This method sets up the gameplay area called Left, gives the
    // player some context, and provides them with options to make a decision.
    {//start of the Left() method
        
        area = "Left"; // sets the area variable, created to
        // specify where the player is located, to this area of the game. 
        
            storyText.setText("You decide to turn right and walk down this dark path.\nAll of a sudden, you encounter a Skeleton!");
            // sets the text for the story and this text informs the player of
            // what is currently happening in the game's story, and provides
            // them enough context before they make their next decision.

            option1.setText("1. Fight the Skeleton");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option2.setText("2. Run away from the Skeleton");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option3.setText("");
            // sets the text for this option button, but in this case no text
            // will be displayed because this button will not be available for
            // the player to choose and there will not be another decision for
            // the player to make besides the ones already listed. 
            
    }//end of the Left() method
    
    public void FightCyclops()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.        
    // This method sets up the gameplay area called FightCyclops, gives the
    // player some context, and provides them with options to make a decision.
    {//start of the FightCyclops() method
        
        area = "FightCyclops"; // sets the area variable, created to
        // specify where the player is located, to this area of the game. 
        damage1= ((int) (Math.random() * 5) + 1); // generates a random value
        // for the amount of damage caused by the monster's attack, between 
        // 1 to 5 inclusive, and inputs it into the damage1 variable.
        damage [0] = damage1; // inputs the value just generated and inputted
        // into the damage1 variable and inputs it into the damage array at
        // index 0. 
        health = health - damage[0]; // deducts the damage caused by the attack
        // from the player health variable.
        allMonsters [0] = "the Cyclops"; // inputs the name of this monster into
        // the allMonsters array at index 0.
        
            healthLabelNumber.setText("" + health); // updates the JLabel for
            // the player's numerical health value to its current amount. 
        
            storyText.setText("You decided to attack the Cyclops.\nYou are dealt " +damage[0]+ " damage from it.\nYou win the battle!");
            // Sets the text for the story and this text informs the player of
            // what is currently happening in the game's story, and provides
            // them enough context before they make their next decision.
            // It also indicates the amount of damage they received from 
            // attacking the monster and that they won the battle. 

            option1.setText("1. Continue down the dungeon");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option2.setText("2. Run away from the dungeon");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option3.setText("");
            // sets the text for this option button, but in this case no text
            // will be displayed because this button will not be available for
            // the player to choose and there will not be another decision for
            // the player to make besides the ones already listed. 
            
    }//end of the FightCyclops() method
    
    public void FightMinotaur()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.        
    // This method sets up the gameplay area called FightMinotaur, gives the
    // player some context, and provides them with options to make a decision.
    {//start of the FightMinotaur() method
        
        area = "FightMinotaur"; // sets the area variable, created to
        // specify where the player is located, to this area of the game. 
        damage1= ((int) (Math.random() * 5) + 1); // generates a random value
        // for the amount of damage caused by the monster's attack, between 
        // 1 to 5 inclusive, and inputs it into the damage1 variable.
        damage [0] = damage1; // inputs the value just generated and inputted
        // into the damage1 variable and inputs it into the damage array at
        // index 0. 
        health = health - damage[0]; // deducts the damage caused by the attack
        // from the player health variable.
        allMonsters [0] = "the Minotaur"; // inputs the name of this monster 
        // into the allMonsters array at index 0.
            
            healthLabelNumber.setText("" + health); // updates the JLabel for
            // the player's numerical health value to its current amount. 
            
            storyText.setText("You decided to attack the Minotaur.\nYou are dealt "+damage[0]+" damage from it.\nYou win the battle!");
            // Sets the text for the story and this text informs the player of
            // what is currently happening in the game's story, and provides
            // them enough context before they make their next decision.
            // It also indicates the amount of damage they received from 
            // attacking the monster and that they won the battle. 

            option1.setText("1. Continue down the dungeon");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option2.setText("2. Run away from the dungeon");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option3.setText("");
            // sets the text for this option button, but in this case no text
            // will be displayed because this button will not be available for
            // the player to choose and there will not be another decision for
            // the player to make besides the ones already listed. 
            
    }//end of the FightMinotaur() method
    
    public void FightSkeleton()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.        
    // This method sets up the gameplay area called FightSkeleton, gives the
    // player some context, and provides them with options to make a decision.
    {//start of the FightSkeleton() method
        
        area = "FightSkeleton"; // sets the area variable, created to
        // specify where the player is located, to this area of the game. 
        damage1= ((int) (Math.random() * 5) + 1); // generates a random value
        // for the amount of damage caused by the monster's attack, between 
        // 1 to 5 inclusive, and inputs it into the damage1 variable.
        damage [0] = damage1; // inputs the value just generated and inputted
        // into the damage1 variable and inputs it into the damage array at
        // index 0. 
        health = health - damage[0]; // deducts the damage caused by the attack
        // from the player health variable.
        allMonsters [0] = "the Skeleton"; // inputs the name of this monster 
        // into the allMonsters array at index 0.

            healthLabelNumber.setText("" + health); // updates the JLabel for
            // the player's numerical health value to its current amount. 
        
            storyText.setText("You decided to attack the Skeleton.\nYou are dealt "+damage[0]+" damage from it.\nYou win the battle!");
            // Sets the text for the story and this text informs the player of
            // what is currently happening in the game's story, and provides
            // them enough context before they make their next decision.
            // It also indicates the amount of damage they received from 
            // attacking the monster and that they won the battle. 
            
            option1.setText("1. Continue down the dungeon");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option2.setText("2. Run away from the dungeon");
            // sets the text for this option button and the text informs the
            // player of what choosing this option means in the context of the 
            // game's story or their character's actions. 
            option3.setText("");
            // sets the text for this option button, but in this case no text
            // will be displayed because this button will not be available for
            // the player to choose and there will not be another decision for
            // the player to make besides the ones already listed. 
            
    }//end of the FightSkeleton() method
    
    public void FightDragon()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.
    // This method sets up the gameplay area called FightDragon, gives the
    // player some context, and sets up the final battle. 
    {//start of the FightDragon() method
        
        area = "FightDragon"; // sets the area variable, created to
        // specify where the player is located, to this area of the game. 
        allMonsters [1] = "the Dragon"; // inputs the name of the dragon 
        // into the allMonsters array at index 1.
        
                for (int counter = 1; counter < 3; counter++)
                // The variable counter is declared and assigned in the for 
                // loop.
                // The variable, counter, is only intialized and active in the
                // for loop, after that it dies. This is called variable 
                // scope. 
                // The for loop initializes the loop control variable counter 
                // to 1.
                // Then the statement inside the loop is executed if the
                // boolean expression evaluates to true. The loop control 
                // variable counter is then incremented by 1 and the condition 
                // is tested again. This continues until the boolean 
                // expression evaluates to false.    
                // In this case, the boolean expression is evaluated to true
                // while the value of the counter variable is less than
                // 3. I wrote this boolean expression so that the
                // program only runs for a maximum of 2 iterations.
                    {
                        damage2 = (int) (Math.random() * 5) + 1;
                        // generates a random value for the amount of damage 
                        // caused by the dragon's attack between 1 to 3
                        // inclusive, and inputs it into the damage2 variable.
                        damage [counter] = damage2;
                        // inputs the value just generated and inputted into the 
                        // damage2 variable and inputs it into the damage array 
                        // at the index number that corresponds to the current
                        // value of the loop control variable counter. 
                        health = health - damage[counter]; 
                        // deducts the damage caused by the dragon's attack 
                        // from the player health variable.
                    }
                
            damageTotal = damage[2]+damage[1]; // makes the damageTotal variable
            // equal to the sum of the element in the damage array at index 1 
            // and the element in the damage array at index 2. 
            healthLabelNumber.setText("" + health); // updates the JLabel for
            // the player's numerical health value to its current amount.      
            
                if (health>0)
                // if the player health variable is more than 0, perform the
                // following action
                   storyText.setText("You decided to continue down the dungeon!\nYou run into the dungeon's most fearsome creature, a DRAGON!\nYou were dealt " + damageTotal + " damage during the battle but survive!");
                   // Sets the text for the story and this text informs the 
                   // player of what is currently happening in the game's story, 
                   // It also indicates the amount of damage they received from
                   // attacking the dragon and that they won the battle.
                else if (health<=0)
                // if the player health variable is less than or equal to 0, 
                // perform the following action
                   storyText.setText("You decided to continue down the dungeon!\nYou run into the dungeon's most fearsome creature, a DRAGON!\nYou were dealt " + damageTotal + " damage during the battle and die!");
                   // Sets the text for the story and this text informs the 
                   // player of what is currently happening in the game's story, 
                   // It also indicates the amount of damage they received from
                   // attacking the dragon and that they lost the battle.
                
            optionsPanel.setBounds(73, 370, 250, 150);
            // Resizes and repositions the panel for the option buttons by int
            // x, int y, int width, int height, which are the values for the 
            // pixel measurements in the brackets. 
            option1.setVisible(false); 
            // hides the option button from the view of the player, thus, 
            // stopping any decisions to be made and restricting its use. 
            option2.setVisible(false);
            // hides the option button from the view of the player, thus, 
            // stopping any decisions to be made and restricting its use.  
            option3.setText(">Continue");
            // sets the text for this option button and the text simply informs
            // the player that clicking this button will allow them to proceed
            // onwards to the game's final screen. 
            
    }//end of the FightDragon() method
    
    public void YouDied()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.
    // This method displays the user the final screen of the game if they die
    // during their fight with the dragon.
    {//start of the YouDied() method
        
            storyText.setText("You died during the battle against the dragon.\nBut you still slayed "+allMonsters[0]+"!\nGAME OVER!");
            // Sets the text for the story and this text displays the player  
            // what has transpired in the story, the name of the monster that
            // they defeated while in the dungeon, and a message that states 
            // that the game is now over. 
            
            option3.setVisible(false);
            // hides the option button from the view of the player, thus, 
            // stopping any decisions to be made and restricting its use. 
            healthPanel.setVisible(false); // hides the player health panel and  
            // all of its related information from the view of the player.
            
    }//end of the YouDied() method
    
    public void YouWin()
    // Public is used to specify that this method is visible to all other 
    // classes. 
    // Void is used to specify that the method does not return any value.
    // This method displays the user the final screen of the game if they win.
    {//start of the YouWin() method
        
            storyText.setText("You defeated the dungeon.\nYou slayed "+allMonsters[0]+ " and " + allMonsters[1]+"!\n\nCONGRATULATIONS!");
            // Sets the text for the story and this text displays the player  
            // what has transpired in the story, the names of monsters that
            // they defeated while in the dungeon, and a congratulatory message.
            
            option3.setVisible(false);
            // hides the option button from the view of the player, thus, 
            // stopping any decisions to be made and restricting its use. 
            healthPanel.setVisible(false); // hides the player health panel and  
            // all of its related information from the view of the player.
            
    }//end of the YouWin() method
    
    public class OptionPicker implements ActionListener
    // Public is used to specify that this class is visible to all other 
    // classes. 
    // This class utilizes the ActionListener class which will be used to help 
    // process what to do when a mouse-click has occured on one of the option
    // buttons.         
    {//start of the OptionPicker class
        public void actionPerformed (ActionEvent event)
        // Public is used to specify that this method is visible to all other 
        // classes. 
        // Void is used to specify that the method does not return any value.
        // The ActionEvent class will be used to help inform the program what to
        // do in the event that a mouse-click has occured. It will work in 
        // conjunction with the ActionListener class. 
        // Public is used to specify that this method is visible to all other 
        // classes.             
        // Void is used to specify that the method does not return any value.       
        {//start of the actionPerformed method
            String playerDecision = event.getActionCommand();
            // The corresponding ActionCommand for each of the option buttons
            // (decision1, decision2, decision3) will be taken and inputted 
            // into the string called playerDecision.
            
                    switch(area)
                    {// The switch statement in Java allows you to select one of
                     // many possible statements to execute based on a value.
                     // The switch keyword is followed by a parenthesized
                     // integer expression, which is followed by the cases, all
                     // enclosed in braces. The switch statement executes the 
                     // case corresponding to the value of the expression. 
                     // Normally the code in a case clause ends with a break 
                     // statement, which exits the switch statement and 
                     // continues with the statement following the switch. 
                     // If there is no corresponding case value, the default
                     // clause is executed. If no case matched and there is no
                     // default clause, execution continues after the end of the
                     // switch statement. 
                     // Depending on the position or area that the player is in,
                     // the switch statement will activate a different method
                     // based on the option button that is clicked. An option
                     // button will activate a different method dependong on
                     // which area the player is in. The methods represent
                     // a section of gameplay or a part of the video game's many
                     // pathways. 

                        case "DungeonGate": // In this area of the game, have  
                        // these methods correspond to each option button and 
                        // its action command. 
                                switch(playerDecision) // Based on the action
                                // command which corresponds to the option  
                                // button pressed, activate this method.
                                {
                                    case "decision1": EnterDungeon(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision2": TalkWithGateKeeper(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision3": RunAway(); break;
                                    // activate this method and then terminate 
                                    // this case
                                }
                        break; //terminate this case
                            
                        case "EnterDungeon": // In this area of the game, have  
                        // these methods correspond to each option button and 
                        // its action command.
                                switch(playerDecision) // Based on the action
                                // command which corresponds to the option  
                                // button pressed, activate this method.
                                {
                                    case "decision1": Straight(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision2": Right(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision3": Left (); break;
                                    // activate this method and then terminate 
                                    // this case
                                }
                        break; //terminate this case
                            
                        case "TalkWithGateKeeper": // In this area of the game,   
                        // have these methods correspond to each option button  
                        // and its action command.
                                switch(playerDecision) // Based on the action
                                // command which corresponds to the option  
                                // button pressed, activate this method.
                                {
                                    case "decision1": EnterDungeon(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision2": RunAway(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision3": break;
                                    // terminate this case
                                }
                        break; //terminate this case
                            
                        case "Straight": // In this area of the game, have  
                        // these methods correspond to each option button and 
                        // its action command.
                                switch(playerDecision) // Based on the action
                                // command which corresponds to the option  
                                // button pressed, activate this method.
                                {
                                    case "decision1": FightCyclops(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision2": RunAway(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision3": break;
                                    // terminate this case
                                }
                        break; //terminate this case
                            
                        case "Right": // In this area of the game, have  
                        // these methods correspond to each option button and 
                        // its action command.
                                switch(playerDecision) // Based on the action
                                // command which corresponds to the option  
                                // button pressed, activate this method.
                                {
                                    case "decision1": FightMinotaur(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision2": RunAway(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision3": break;
                                    // terminate this case
                                }
                        break; //terminate this case
                            
                        case "Left": // In this area of the game, have  
                        // these methods correspond to each option button and 
                        // its action command.
                                switch(playerDecision) // Based on the action
                                // command which corresponds to the option  
                                // button pressed, activate this method.
                                {
                                    case "decision1": FightSkeleton(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision2": RunAway(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision3": break;
                                    // terminate this case
                                }
                        break; //terminate this case
                            
                        case "FightCyclops": // In this area of the game, have  
                        // these methods correspond to each option button and 
                        // its action command.
                                switch(playerDecision) // Based on the action
                                // command which corresponds to the option  
                                // button pressed, activate this method.
                                {
                                    case "decision1": FightDragon(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision2": RunAway(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision3": break;
                                    // terminate this case
                                }
                        break; //terminate this case
                            
                        case "FightMinotaur": // In this area of the game, have  
                        // these methods correspond to each option button and 
                        // its action command.
                                switch(playerDecision) // Based on the action
                                // command which corresponds to the option  
                                // button pressed, activate this method.
                                {
                                    case "decision1": FightDragon(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision2": RunAway(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision3": break;
                                    // terminate this case
                                }
                        break; //terminate this case
                            
                        case "FightSkeleton": // In this area of the game, have  
                        // these methods correspond to each option button and 
                        // its action command.
                                switch(playerDecision) // Based on the action
                                // command which corresponds to the option  
                                // button pressed, activate this method.
                                {
                                    case "decision1": FightDragon(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision2": RunAway(); break;
                                    // activate this method and then terminate 
                                    // this case
                                    case "decision3": break; 
                                    // terminate this case
                                }
                        break; //terminate this case
                            
                        case "FightDragon": // In this area of the game, have  
                        // these methods correspond to each option button and 
                        // its action command.
                                switch(playerDecision) // Based on the action
                                // command which corresponds to the option  
                                // button pressed, activate this method.
                                {
                                    case "decision1": break; 
                                    // terminate this case
                                    case "decision2": break; 
                                    // terminate this case
                                    case "decision3": 
                                    // run this if statement to determine which
                                    // method to activate
                                        if (health>0)
                                        // if the player health is greater than
                                        // 0, perform the following set of
                                        // actions
                                        {
                                            YouWin(); // activate this method
                                            break; //terminate this case
                                        }
                                        else if (health<=0)
                                        // if the player health is less than or
                                        // equal to 0, perform the following set 
                                        // of actions
                                        {
                                            YouDied(); // activate this method
                                            break; //terminate this case
                                        }
                                }   
                        break; //terminate this case
                    }
                    
        }//end of the actionPerformed method

    }//end of the OptionPicker class
    
}//end of the AllGameFunctions class
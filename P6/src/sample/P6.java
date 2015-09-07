/**
 * Assignment 5 P6.java Due August 29th, 2015
 * login:  cs11vcd
 * @brief This JavaFX UI program displays a deck of playing card images,
 * shuffles, sorts in ascending and descending order using Buttons.
 * Layout Panes include: GridPane, BorderPane, and HBox
 * Random generates random numbers for the shuffle using the
 * System.currentTimeMillis() seed.
 * @author Justin J Wang
 * @version 1.0.0
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/">JavaFX docs</a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/">Java 1.8 API</a>
 */

package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
//import javax.swing.text.html.ImageView;  //incorrect ImageView - do not use


/**
 * class P6
 * extends Application
 * one private instance array is allocated
 * @author Justin J Wang
 * @version 1.0.0
 * @see <a href="https://docs.oracle.com/javase/8/javafx/api/">JavaFX docs</a>
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/">Java 1.8 API</a>
 */
public class P6 extends Application {
    final int ASIZE = 54;  //number of cards in deck
    final int ROWS = 6;
    final int COLS = 9;
    private int aCardDeck[] = new int[ASIZE];  //54 cards in a deck
    // (52+2 jokers)

    @Override
    /**
     * start()
     * initialize JavaFX application and starts execution
     * an ascending sorted order of 6 rows and 9 columns is displayed
     * upon start
     * new window appears displaying your card deck images
     * @Overrides the start method of the Application base class
     */
    public void start(Stage primaryStage) throws Exception{

        for (int k, i = k = 0; i < ASIZE; ++k, ++i)  // ASIZE is 54
            aCardDeck[i] = k+1 ;  // Populate with elements values 1-54

        GridPane gPane = new GridPane();  // Instantiate Grid for cards
        // in rows/cols

        for (int k, i = k = 0 ; i < ROWS && k < ASIZE; i++)  // 6 rows,
        // 9 columns
            for (int j = 0; j < COLS ; j++)
                gPane.add(new ImageView("file:///C:\\Users\\justw\\OneDrive" +
                        "\\cse11\\P6\\" + aCardDeck[k++] + ".png"),j,i);


        // Create a button to ascend sort
        Button btAscendSort = new Button("Ascend Sort");
        btAscendSort.setOnAction
            (e ->   //Lamda Event Handler
                {
                    // Like anonymous inner class
                    int r, c, n;
                    ascendSort();  // ascend sort
                    gPane.getChildren().clear();
                    for (r = n = 0; r < ROWS && n < ASIZE; r++)
                        for (c = 0; c < COLS; c++)
                            gPane.add(new ImageView("file:///C:\\Users\\" +
                                    "justw\\OneDrive\\cse11\\P6\\" +
                                    aCardDeck[n++] + ".png"), c, r);
                }
            );
        HBox hBox = new HBox(7);  // Row of buttons
        hBox.getChildren().add(btAscendSort);  // Add button to box
        // Repeat for 6 other buttons

        // Create a button to descend sort
        Button btDescendSort = new Button("Descend Sort");
        btDescendSort.setOnAction
        (e ->   //Lamda Event Handler
            {
                // Like anonymous inner class
                int r, c, n;
                descendSort();  // descend sort
                gPane.getChildren().clear();
                for (r = n = 0; r < ROWS && n < ASIZE; r++)
                    for (c = 0; c < COLS; c++)
                        gPane.add(new ImageView("file:///C:\\Users\\" +
                                "justw\\OneDrive\\cse11\\P6\\" +
                                aCardDeck[n++] + ".png"), c, r);
            }
        );
        hBox.getChildren().add(btDescendSort);  // Add button to box
        // Repeat for 6 other buttons


        // Create a button to shuffle
        Button btShuffle = new Button("Shuffle");
        btShuffle.setOnAction
        (e ->   //Lamda Event Handler
            {
                // Like anonymous inner class
                int r, c, n;
                shuffle();  // Random shuffle
                gPane.getChildren().clear();
                for (r = n = 0; r < ROWS && n < ASIZE; r++)
                    for (c = 0; c < COLS; c++)
                        gPane.add(new ImageView("file:///C:\\Users\\" +
                                "justw\\OneDrive\\cse11\\P6\\" +
                                aCardDeck[n++] + ".png"), c, r);
            }
        );
    hBox.getChildren().add(btShuffle);  // Add button to box
    // Repeat for 6 other buttons

        // Create a button to ascend rank
        Button btAscendRank = new Button("Ascend Rank");
        btAscendRank.setOnAction
                (e ->   //Lamda Event Handler
                        {
                            // Like anonymous inner class
                            int r, c, n;
                            ascendRankSort();  // ascend rank sort
                            gPane.getChildren().clear();
                            for (r = n = 0; r < ROWS && n < ASIZE; r++)
                                for (c = 0; c < COLS; c++)
                                    gPane.add(new ImageView("file:///C:" +
                                            "\\Users\\justw\\OneDrive" +
                                            "\\cse11\\P6\\" +
                                            aCardDeck[n++] + ".png"), c, r);
                        }
                );
        hBox.getChildren().add(btAscendRank);  // Add button to box
        // Repeat for 6 other buttons

        // Create a button to descend rank
        Button btDescendRank = new Button("Descend Rank");
        btDescendRank.setOnAction
            (e ->   //Lamda Event Handler
                {
                    // Like anonymous inner class
                    int r, c, n;
                    descendRankSort();  // descend rank sort
                    gPane.getChildren().clear();
                    for (r = n = 0; r < ROWS && n < ASIZE; r++)
                        for (c = 0; c < COLS; c++)
                            gPane.add(new ImageView("file:///" +
                                    "C:\\Users\\justw\\OneDrive" +
                                    "\\cse11\\P6\\" + aCardDeck[n++]
                                    + ".png"), c, r);
                }
            );
        hBox.getChildren().add(btDescendRank);  // Add button to box
        // Repeat for 6 other buttons

        // Create a button to deal
        Button btDeal = new Button("Deal");
        btDeal.setOnAction
            (e ->   //Lamda Event Handler
                {
                    // Like anonymous inner class
                    int r, c, n=0;
                    shuffle();  // Random shuffle, then deal
                    gPane.getChildren().clear();
                    for (c = 0; c < 5 && n < ASIZE; ++c)
                        for (r = 0; r < 2 ; ++r)
                            gPane.add(new ImageView("file:///C:\\" +
                                    "Users\\justw\\OneDrive\\cse11\\" +
                                    "P6\\" + aCardDeck[n++] + ".png"), c, r);
                }
            );
        hBox.getChildren().add(btDeal);  // Add button to box
        // Repeat for 6 other buttons

        // Create a button to exit
        Button btExit = new Button("Exit");
        btExit.setOnAction
            (e ->   //Lamda Event Handler
                {
                    // Like anonymous inner class
                    System.exit(0);
                }
            );
        hBox.getChildren().add(btExit);  // Add button to box
        // Repeat for 6 other buttons

    BorderPane pane = new BorderPane();
    pane.setCenter(gPane);  // Layout rows of cards in center
    pane.setBottom(hBox);  // Layout buttons at bottom
    BorderPane.setAlignment(hBox, Pos.CENTER);
    Scene scene = new Scene(pane, 650, 600);  // Create scene,// place
    // in stage
    primaryStage.setTitle("P6");  //Set the stage title
    primaryStage.setScene(scene);  // Place the scene in the stage
    primaryStage.show();  // Display the stage
    }

    /**
     * ascendSort()
     * sorts in ascending order, using the bubble sort algorithm
     */
    public void ascendSort(){
        for(int j=0; j<aCardDeck.length-1; ++j)  //bubble sort
            for(int k=aCardDeck.length-1; j<k; --k)
                if(aCardDeck[k-1]>aCardDeck[k]){
                    swap(k-1, k);  //swap adjacent elements
                }
    }

    /**
     * descendSort()
     * sorts in descending order, using the bubble sort algorithm
     */
    public void descendSort(){
        for(int j=0; j<aCardDeck.length-1; ++j)  //bubble sort
            for(int k=aCardDeck.length-1; j<k; --k)
                if(aCardDeck[k-1]<aCardDeck[k]){
                    swap(k-1, k);  //swap adjacent elements
                }


    }

    /**
     * shuffle()
     * random swap of cards
     * indexes through each element in the deck and swaps positions
     * with another element
     * chosen at random in the same deck of cards
     */
    public void shuffle(){
        //create local variable, Random object, and set the seed
        // with current time in milliseconds
        Random rand = new Random();  //local variable in shuffle()
        long seed = System.currentTimeMillis();  //current time
        // milliseconds type long
        rand.setSeed(seed);  //assign seed to random object
        for(int i=0; i<ASIZE; ++i){
            int r = rand.nextInt(ASIZE);
            System.out.println(r);
            swap(i, r);  //swap ith element with random position
        }
    }

    /**
     * swap()
     * swap of class array
     * @param j is the 1st parameter to be swapped
     * @param k is the 2nd parameter to be swapped
     */
    public void swap(int j, int k){
        int tmp = aCardDeck[j];  //swap the elements within the array
        aCardDeck[j] = aCardDeck[k];
        aCardDeck[k] = tmp;
    }

    /**
     * ascendRankSort()
     * This method sorts the deck by ascending rank, so that the aces,
     * etc. are grouped together.
     * It first calls descendRankSort, then reverses the array
     */
    public void ascendRankSort(){
        descendRankSort();  //first call descendRankSort
        //then reverse the array
        for(int i = 0; i < ASIZE / 2; ++i){
            int tmp = aCardDeck[i];      //reverse the array
            aCardDeck[i] = aCardDeck[ASIZE - i - 1]; //swap outer elements
            aCardDeck[ASIZE - i - 1] = tmp;
        }

    }


    /**
     * descendRankSort()
     * This method sorts the deck by descending rank, so that the
     * kings, etc. are grouped together.
     */
    public void descendRankSort(){
        final int numOfSuits = 4;
        int clubs = ASIZE-2;  //king of clubs
        int diamonds = (ASIZE-2)/(numOfSuits/3);  //king of diamonds
        int hearts = (ASIZE-2)/(numOfSuits/2);  //king of hearts
        int spades = (ASIZE-2)/numOfSuits;  //king of spades

        for (int i = 0; i < 2; ++i) {  //set the first two jokers
            aCardDeck[i] = ASIZE - i;
        }
        for (int i = 2; i < ASIZE; i += numOfSuits){//sort clubs
            aCardDeck[i] = clubs;
            --clubs;
        }
        for (int i = 3; i < ASIZE; i += numOfSuits){//sort diamonds
            aCardDeck[i] = diamonds;
            --diamonds;
        }
        for (int i = 4; i < ASIZE; i += numOfSuits){//sort hearts
            aCardDeck[i] = hearts;
            --hearts;
        }
        for (int i = 5; i < ASIZE; i += numOfSuits){//sort spades
            aCardDeck[i] = spades;
            --spades;
        }
    }


    /**
     * main(String[])
     * driver for the application that invokes launch method
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}

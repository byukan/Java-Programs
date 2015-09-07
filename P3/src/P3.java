/**
 * Assignment 3 P3.java Due August 15th, 2015
 * login:  cs11vcd
 * This application program sorts Strings using comparison methods into 1-D and
 * 2-D arrays.  The 1-D array will hold all words in sorted order.
 */

import java.util.Scanner;  //read sentence from keyboard

/**
 * @class P3
 * @brief sorts Strings using comparison methods into 1-D and
 * 2-D arrays
 * contains public static functions, main, sort1D and sort2D
 */
public class P3 {

    /**
     * main()
     * reads input, calls sort1D(), displays 1-D array, calls sort2D()
     * @param args
     */
    public static void main(String[] args) {
        String sentence;  //read line

        Scanner scan = new Scanner(System.in);  //read input from keyboard

        System.out.print("Enter your words to be sorted (exit ^D): ");
        do {
            sentence = scan.nextLine();  //read entire line
            String words[] = sentence.split(" +");  //allocate words input,
            // split on one or more spaces

            sort1D(words);  //sort 1-D array of Strings

            System.out.print("1-D Sorted: ");

            //place into array
            for (int i = 0; i < words.length; ++i)
                System.out.print(words[i] + " ");
            System.out.println();

            sort2D(words);  //sort 1-D array of Strings

            System.out.print("Enter your words to be sorted (exit ^D): ");
        } while (scan.hasNext());  //loop until no more input lines
        System.exit(0);  //terminates current JVM
    }

    /**
     * sort1D()
     * sorts words in sentence (case insensitive)
     * @param w is the sentence
     */
    public static void sort1D(String[] w){
        //bubble sort algorithm
        String tmp;  //temporary holder to swap elements
        for(int i=0; (i<w.length-1) && (w[i] != null); ++i)
            for(int j=w.length-1; i<j && (w[i] != null); --j)
                //sort words- case insensitive
                if(w[j-1].compareToIgnoreCase(w[j]) > 0) {
                    tmp = w[j-1];  //swap
                    w[j-1] = w[j];
                    w[j] = tmp;
                }
    }

    /**
     * sort2D()
     * sorts into 2-D table of 26 rows.  Each row represents words that begin
     * with same 1st letter.
     * Row[0] "A" words Row[1] "B" words... Row[25] "Z" words.
     * @param sw
     */
    public static void sort2D(String[] sw){
        final int ALPHA = 26;  //26 letters in the alphabet - # of rows

        boolean nextAlpha = false;  //sequence to next alpha letter
        char A = 'A';  //1st letter of alphabet uppercase
        char a = 'a';  //1st letter of alphabet lowercase
        int col=0;  //number of words start with letter

        String a2D[][] = new String[ALPHA][];  //allocate 26 rows for each
        // alpha letter

        //initialize a2D with nulls
        for(int i=0, m= a2D.length; i<m; ++i)
            a2D[i]=null;



        //allow 26 elements for alphabet
        for(int j, i=j=col=0; j<=a2D.length; ++j){
            //the length of each row is the number of 'A' words in input
            // sentence
            if(col>0) {        //allocate col columns for a2D[0]
                a2D[j - 1] = new String[col];  //alloc row with # words
                // start with letter
            }
            nextAlpha = false;

            for(col=0; (i<sw.length) && !nextAlpha; ++i) {
                if (sw[i] == null) {  //no words start with letter, skip
                // to next alpha
                    nextAlpha = true;
                    break;
                }
                /*
                if 1st letter of sw[i] matches 'A' or 'a' then increment
                col counter
                traverse sw[] and test if begins with 'A' or 'a', then
                 increment col
                else sequence to 'B' 'b'
                */
                if(sw[i].charAt(0)==A || sw[i].charAt(0)==a) {
                    ++col;
                }
                else{
                    ++A;  //move onto the next letter
                    ++a;        //repeat with each letter of alphabet
                    break;
                }
            }
        }
        //nested for loop to assign from sw[] into a 2D delimited by length
        // of each row
        for(int i=0, k=0; i<a2D.length; ++i) {
            //use length of each row "a2D[j].length" as a delimiter
            for(int j=0; (a2D[i]!=null && j<a2D[i].length); ++j){
                //assign 'A' words from sw[] into a2D[0]
                //check for null reference
                if(sw[k]!=null) {
                    a2D[i][j] = sw[k];
                    //print each element's indices and value
                    System.out.println("a2D[" + i + "][" + j + "]: " + sw[k]);
                    ++k;
                }
            }
            if(a2D[i]!=null)  //print a new line for nonempty rows
                System.out.println();

        }
    }

}
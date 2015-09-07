/**
 * Assignment 7 P7.java Due September 2nd, 2015
 * login:  cs11vcd
 * @brief This application program is for fundamental File I/O using command
 * line arguments.
 * Data is read from a simple plain text file, specified on the command line.
 * Use command line
 * arguments to open the file.  The command line argument will be found as an
 * index in the String args[].
 *
 * This program also uses exception handling for unchecked exceptions
 * ArrayIndexOutOfBoundsException and
 * NumberFormatException and also handle checked exception
 * FileNotFoundException.
 *
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
//import java.util.Scanner;  //read sentence from keyboard


/**
 * public class P7
 * @brief The program declares (not handles) the checked exception
 * IOException.  (throws)
 * An array of triangle sides is allocated, filled with input values,
 * and the triangle's perimeter is calculated.
 *
 */
public class P7 {
    private static final int ASIZE = 3;  //array size
    private static int[] aTri = new int[ASIZE];  //3 elements of triangle sides

    /**
     * main()
     * opens args[0] using FileReader and BufferReader ctors.
     * BufferedReader readLine() will read in triangle sides values from the
     * file and tokenize the input with String method "split()".
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        String inputStr = "";  //string for input line
        String[] s;  //array of strings for each word
        BufferedReader in;  //readLine() input from file

        //if program is run with no arguments
        if(args.length == 0) {
            System.err.println("Usage: java P7 [file]");
            System.exit(0);
        }

        try{  //file not found exception


            in = new BufferedReader(new FileReader(args[0]));  //might have
            // FileNotFoundException

            //repeat calculation until no more input is in the text file.
            while((inputStr = in.readLine()) != null) {  //read entire line

                try{  //try block for other Exceptions
                   s = inputStr.split(" ");  //parse into tokens


                    System.err.print("Input: " + inputStr);


                    if(s.length<ASIZE) {  //fewer elements than size of array
                        System.err.println("\n\t\tERROR!  Entered less than" +
                                " 3 sides.  Enter again.\n");
                        //loop back and read the next line of input
                        continue;
                    }
//                    if(s.length>ASIZE){  //more than desired number of
// elements
//
//
//                        //assign only the first 3 into the array
//                        calcPerimeter();
//                    }




                    for(int i=0, n=s.length; i<n; ++i) {  //traverse array
                        //convert token into integer
                        aTri[i] = Integer.parseInt(s[i]);  //convert triangle
                        // side
                    }

                    for(int i=0; i<ASIZE; ++i) {  //check that each element
                    // is in range 1-100
                        if (aTri[i] < 1 || aTri[i] > 100) {  //out of range
                            System.err.println("\n\t\tERROR!  Out of range" +
                                    " 1-100.  Enter again.\n");
                            //continue;
                        }
                    }

                    int a=aTri[0], b=aTri[1], c=aTri[2];
                    boolean check = true;
                    if(a+b<c || a+c<b || b+c<a){
                        System.err.println("Input: "+inputStr);
                        System.err.println("\t\tERROR!  Sum of 2 sides >" +
                                " 3rd side.\n");
                        check = false;
                    }

                    if(check) {
                        calcPerimeter();  //called after valid input of 3
                        // integers
                    }


                }catch(NumberFormatException e1){
                    //invalid integer value has been entered
                    System.err.println(" are not valid sides of a tria" +
                            "ngle.");//Input: "+inputStr+"
                    e1.printStackTrace();  //print stack trace
                }catch(ArrayIndexOutOfBoundsException e2) {
                    System.err.print("\n\t\tEntered more than 3 sid" +
                            "es.\n\t\tFirst 3 sides accepted.  Cont" +
                            "inuing ...");
                    //allow first 3 integers accepted into the array
                    calcPerimeter();
                }catch(Exception ex){
                    System.err.println(ex);  //display exception parameter
                    ex.printStackTrace();
                    System.exit(-1);  //exit with error
                }
            }

        }catch(FileNotFoundException e){
            System.err.println("File \""+args[0]+"\" is NOT found");
        }
    }

    /**
     * calcPerimeter()
     * This function displays the sum of the triangle sides in the array.
     */
    public static void calcPerimeter(){
        int perimeter=0;
        for(int i=0, n=ASIZE; i<n; ++i){
            perimeter += aTri[i];
        }
        System.err.println("\nTriangle: "+aTri[0]+" + "+aTri[1]+" + " +
                ""+aTri[2]);
        System.err.println("Perimeter: "+perimeter+"\n");
    }
}

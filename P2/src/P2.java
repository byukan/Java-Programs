/**
 * Assignment 2 P2.java Due August 12th, 2015
 * login:  cs11vcd
 * This application program displays the total price and unit price of a "Root
 * Beer Floats" drink order.  The user is allowed to repeat these calculations
 * until entering a word beginning with 'N' or 'n'.
 */

import java.util.Scanner;  //Scan input from keyboard

public class P2{
    private static final double HALF_PINT$$ = 1.89;
    private static final double PINT$$ = 3.19;
    private static final double QUART$$ = 4.59;

    private static final int OZ_HALF_PINT = 8;
    private static final int OZ_PINT = 16;
    private static final int OZ_QUART = 32;

    private static int totalDrinksOrdered = 0;  //total number of drinks ordered
    private static int totalFreeDrinks = 0;  //total number of free drinks

    /**
     * main()
     * The user is allowed to repeat these calculations until entering a word
     * beginning with 'N' or 'n'.  Handles input of number and type of drinks.
     * @param args
     */
    public static void main(String[] args){
        boolean invalidDrink = false;  //flag drink order
        boolean invalidNumDrinks = false;  //flag for testing correct input

        char choice;  //repeat loop
        char type = 0;  //a b or c
        int num = 0;

        double myPrice = 0;
        double savings;

        double totalSaved = 0;

        Scanner scan = new Scanner(System.in);  //read input from keyboard
        String inputStr = null;  //input string

        //display unit price once only
        unitPrice();  //calculate unit price string once

        do{  //do loop repeats entire program
            menu();  //create menu string w/o unit price

            while(!invalidDrink) {  //while loop for drink type input
                System.out.print("Enter Type of drink (A B or C): ");
                inputStr = scan.next();
                type = inputStr.charAt(0);  //assign 1st character

                if(type=='a' || type=='A' || type=='b'
                        || type=='B' || type=='c' || type=='C') {
                    invalidDrink = true;  //drink type is valid
                }
                else {
                    //output error message and prompt for input again
                    System.out.println("ERROR - only \"A B C\"");
                }
            }
            invalidDrink = false;  //reset flag to recheck valid drink type
            // for next iteration


            //display an error message if the valid number for drink of 1-5 is
            // not input
            while(!invalidNumDrinks){
                System.out.print("Enter Quantity (1-5): ");
                num = scan.nextInt();
                //check for invalid input for the number of drinks ordered
                if(num<1 || num>5) {
                    System.out.println("ERROR - only \"1-5\"!");
                }
                else {
                    invalidNumDrinks = true;
                    totalDrinksOrdered += num;
                }
            }
            invalidNumDrinks = false;  //reset flag to recheck valid number of
            // drinks for next iteration


            //call calcPrice upon valid input for type and number
            if(num == 1)
                myPrice += calcPrice(type);  //overloaded, only 1 drink
            else
                myPrice += calcPrice(type,num);  //overloaded, many drinks

            /*deduct the 6th drink order value from the total price as the
            "free drink" after 5 have been charged and print this total amount
             upon billing
            */
            savings = freeDrink(type);  //determine free drink price
            totalSaved += savings;


            System.out.print("Want more Root Beer Floats (y/n)?");
            inputStr = scan.next();
            choice = inputStr.charAt(0);  //assign 1st character

        }while(choice!='n' && choice!='N');

        /*print the total charges upon ending of drink order with a word or
         character starting with an 'n' or 'N' which also terminates program
        */
        payDrinks(myPrice, totalSaved);  //total bill, number of free drinks,
        // and amount saved are displayed

        scan.close();  //close this scanner
        System.exit(0);
    }

    /**
     * menu()
     * Create menu string without unit price
     * displays given types and prices of drink
     */
    public static void menu(){
        System.out.println("  *************** ROOT BEER FLOATS ***************");
        System.out.println("\t\t SIZE \t\t\t\t\t\t PRICE");
        System.out.println("\t ================= \t\t\t\t =======");
        System.out.printf("\t\t A) HALF_PINT(8oz) \t\t\t $%.2f", HALF_PINT$$);
        System.out.printf("\n\t\t B) PINT(16oz) \t\t\t\t $%.2f", PINT$$);
        System.out.printf("\n\t\t C) QUART(32oz) \t\t\t $%.2f", QUART$$);
        System.out.println("\n  *******************************************" +
                "*****");
    }

    /**
     * unitPrice()
     * calculate unit price string, the price per ounce and displays these
     * values
     */
    public static void unitPrice(){

        System.out.println("************************************************" +
                "***");
        System.out.printf("PRICE/OZ:  Half-Pint:$%.2f  Pint:$%.2f  " +
                "Quart:$%.2f", HALF_PINT$$/OZ_HALF_PINT, PINT$$/OZ_PINT,
                QUART$$/OZ_QUART);
        System.out.println("\n**********************************************" +
                "*****");
    }

    /**
     * calcPrice()
     * calculates the price of drink order for only one drink
     * @param typeDrink is the type of drink
     * @returns the correct price for the one drink
     */
    public static double calcPrice(char typeDrink){
        switch(typeDrink){
            case 'a':case'A':
                return HALF_PINT$$;
            case 'b':case'B':
                return PINT$$;
            case 'c':case'C':
                return QUART$$;
            default:
                return 0;
        }
    }

    /**
     * calcPrice()
     * @param typeDrink is the type of drink
     * @param numDrink is the number of orders of that type of drink
     * @returns correct price of the ordered drinks
     */
    public static double calcPrice(char typeDrink, int numDrink){
        switch(typeDrink){
            case 'a':case'A':
                return numDrink*HALF_PINT$$;
            case 'b':case'B':
                return numDrink*PINT$$;
            case 'c':case'C':
                return numDrink*QUART$$;
            default:
                return 0;
        }    }

    /**
     * freeDrink()
     * determines if a free drink is awarded, and adjusts counters
     * @param type is the last type of drink ordered
     * @returns the price of this free drink
     */
    public static double freeDrink(char type){

        if(totalDrinksOrdered >= 6){
            ++totalFreeDrinks;  //free drink is awarded
            totalDrinksOrdered -= 6;
            return calcPrice(type);
        }
        else return 0;
    }

    /**
     * payDrinks()
     * displays total bill, number of free drinks, and amount saved
     * @param price is the total bill without free drink deductions
     * @param moneySaved is the amount saved
     */
    public static void payDrinks(double price, double moneySaved){
        System.out.printf("Total:  $%.2f included "+totalFreeDrinks+
                " FREE drink(s)\n", price-moneySaved);
        System.out.printf("You SAVED $%.2f", moneySaved);
    }
}
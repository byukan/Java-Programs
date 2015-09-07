/**
 * Assignment 4 P4.java Due August 19th, 2015
 * login:  cs11vcd
 * This application program computes the monthly interest for savings accounts,
 * using classes, constructors, public methods, and private instance variables.
 *
 * @files P4.java, P4SavingsAcct.java
 */

import java.util.Scanner;  //Scan input from keyboard

/**
 * public class P4
 * @brief computes the monthly interest for savings accounts
 */
public class P4 {
    /**
     * main()
     * Instantiates P4SavingsAcct objects for beginning balances
     * application driver class instantiates P4SavingsAcct objects
     * @param args
     */
    public static void main(String[] args){
        final int    MON1  = 1;                 // 1st month to open account
        final double START_BAL = 2000;          // Starting balance
        final double START_INT_RATE = .5;  // Starting interest rate
        boolean isFirstRun = true;              // No input on first run
        boolean errIntRate = false;             // Valid savings balance?
        boolean errSaveBal = false;     //check for valid savings balance

        int     month;                          // Loop counter
        double  saveBal;                        // New savings balance
        double  intRate;  // New interest rate
        Scanner scan = new Scanner(System.in);  // Read input from keyboard
        String inputStr = new String();         // Repeat program

        P4SavingsAcct saver1 = new P4SavingsAcct(START_BAL); // Overloaded
        // double ctor
        P4SavingsAcct saver2 = new P4SavingsAcct();           // No arg ctor,
        // Start $1500

        P4SavingsAcct.modifyIntRate( START_INT_RATE );         // Starting
        // interest rate

        char choice;  //ask user if they want to repeat loop


        do{
            if(!isFirstRun){  //testing ctor, no input 1st run
                do {
                    saver1.setSaveBal(START_BAL);  //Start $2000 balance

                    //test input for new starting saving balance
                    System.out.print("Enter new savings balance: ");
                    saveBal = scan.nextDouble();

                    if(errSaveBal = !saver2.setSaveBal(saveBal)){
                        System.out.println("Error! Enter Positive Balance.");
                        errSaveBal = true;
                    }
                    else errSaveBal = false;
                }while(errSaveBal);
                do{
                    System.out.print("Enter new interest rate: ");
                    intRate = scan.nextDouble();
                    if(errIntRate = !saver2.modifyIntRate(intRate)){
                        System.out.print("Error!  Enter valid Range of ");
                        System.out.println(P4SavingsAcct.MIN + "-" +
                                P4SavingsAcct.MAX_RATE);
                        errIntRate = true;
                    }
                    else errIntRate = false;
                }while(errIntRate);
            }
            isFirstRun = false;  // Allow input after 1st run

            System.out.println( "\nMonthly balances for one year at "
                    + saver1.getRate() );

            System.out.printf("   %-6s%10s%12s\n", "MONTH", "SAVER 1",
                    "SAVER 2");
            System.out.printf( "   %-6s%11s%12s\n", "=====", "========",
                    "========" );
            System.out.printf("   %-6s%11s%12s\n", "Base",
                    saver1.toString(), saver2);

            for ( month = MON1 ; month <= P4SavingsAcct.MON12 ; month++ ) {
                saver1.calcMonthlyInt();
                saver2.calcMonthlyInt();
                System.out.printf( "    %-6d%10s%12s\n",
                        month,saver1.toString(), saver2);
            }
            System.out.printf( "   %-6s%11s%12s\n", "=====", "========",
                    "========");

            System.out.print("Want to calculate more savings (y/n)?   ");
            inputStr = scan.next();
            choice = inputStr.charAt(0);  //assign 1st character


        }while(choice!='n' && choice!='N');

        scan.close();
        System.exit(0);  //exit program


    }
}
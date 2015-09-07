/**
 * Assignment 4 P4.java Due August 19th, 2015
 * login:  cs11vcd
 * This application program computes the monthly interest for savings accounts,
 * using classes, constructors, public methods, and private instance variables.
 *
 * @files P4.java, P4SavingsAcct.java
 */

import java.util.Scanner;  //read sentence from keyboard


/**
 * @class P4SavingsAcct
 * @brief holds balance and interest rate data members/methods
 */
public class P4SavingsAcct {

    /**
     * P4SavingsAcct()
     * no argument constructor
     */
    public P4SavingsAcct(){
        //initialize balance data member to minimum balance of 1500
        balance = 1500;
    }

    /**
     * P4SavingsAcct(double bal)
     * ctor initialized with parameter
     * @param bal
     */
    public P4SavingsAcct(double bal){
        balance = bal;
    }


    /**
     * getRate()
     * @returns the annual interest rate
     */
    public double getRate(){
        return annualIntRate;
    }

    /**
     * setSaveBal(double bal)
     * @param bal
     * @returns true if a positive value, which gets assigned into instance
     * variables
     */
    public boolean setSaveBal(double bal){
        if(bal>=0) {
            balance = bal;
            return true;
        }
        else
            return false;
    }


    /**
     * modifyIntRate(double newRate)
     * @param newRate, valid range is 0-5.5
     * @returns true if modified interest rate set successfully
     */
    public static boolean modifyIntRate(double newRate){
        if(newRate>=0 && newRate<=5.5){  //check valid range
            System.out.println("rewfh3895");
            annualIntRate = newRate;  //set annual interest rate
            return true;
        }
        else
            return false;
    }

    /**
     * calcMonthlyInt() calculates the monthly interest rate
     */
    public void calcMonthlyInt(){

        //charge $3 monthly interest fee before interest paid
        if(balance<MINIMUM_BALANCE) {
            balance -= MONTHLY_INTEREST_FEE;
        }
        //calculates cumulative balance with annual interest rate divided
        // by 12 months
        balance *= 1 + (annualIntRate / (MON12 * 100));

    }


    /**
     * toString()
     * @returns a formatted "$%.2f" string, for balance
     */
    public String toString(){
        return String.format("$%.2f",balance);
    }

    final int MONTHLY_INTEREST_FEE = 3;  //monthly interest fee
    final int MINIMUM_BALANCE = 300;

    private final double INIT_MIN_BAL = 1500;  //initial balance for no arg ctor

    final static int MON12 = 12;  //12 months annual term
    final static double MIN = 0;  //minimum for rate and balance
    final static double MAX_RATE = 5.5;  //maximum for interest rate

    private static double annualIntRate = 0;  //int rate for all accounts
    // of class

    private double balance;  //balance for current account
}
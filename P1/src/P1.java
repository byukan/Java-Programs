/** Assignment 1  P1.java  Due August 8th, 2015
 * login:  cs11vcd
 * This program displays a table of 7 years of federal taxes and earned income, 403b, and net wages.  The program will
 * read in a real number hourly wage rate (1-500).  The 2015 Federal Tax Rate for the tax brackets is implemented.
 */

import java.util.Scanner;  //Scan input from keyboard

/** class P1
 * This program displays a table of 7 years of federal taxes and earned income, 403b, and net wages.  The program will
 * read in a real number hourly wage rate (1-500).  The 2015 Federal Tax Rate for the tax brackets is implemented.
 */
public class P1
{
    //main() accepts numerical input and prints table of taxes, 403b, and income
    public static void main(String[] args)
    {
        final int MIN = 1;  //minimum wages/hour
        final int HRS_WEEK = 45;  //45 work hours/week
        final int MAX_PAY = 500;  //paid MAX $500/hr
        final int WEEKS_IN_YR = 52;  //paid 52 weeks in year
        final int YEAR7 = 7;  //7 years on the job!
        final double HR_RAISE = .05;  //5% annual hourly raise

        final double TAX_RATE1 = .10;  //10% 0-$9224.99 Income taxed by FED
        final double TAX_RATE2 = .15;  //15% $9225-$37449.99 taxed by FED
        final double TAX_RATE3 = .25;  //25% to $90750 taxed by FED
        final double TAX_RATE4 = .28;  //28% to $189300 taxed by FED
        final double TAX_RATE5 = .33;  //33% to $411500 taxed by FED
        final double TAX_RATE6 = .35;  //35% to $413200 taxed by FED
        final double TAX_RATE7 = .396;  //39.6% > $413200 taxed by FED

        final double TAX_BRACK1 = 9225;  //10% 0-$9225 Income taxed by FED
        final double TAX_BRACK2 = 37450;  //15% $9225 - $37450 taxed by FED
        final double TAX_BRACK3 = 90750;  //25% $9225 - $37450 taxed by FED
        final double TAX_BRACK4 = 189300;  //28% $9225 - $37450 taxed by FED
        final double TAX_BRACK5 = 411500;  //33% $9225 - $37450 taxed by FED
        final double TAX_BRACK6 = 413200;  //35% $9225 - $37450 taxed by FED

        final double B403_RATE1 = .10;  //10% defer retirement plan
        final double B403_RATE2 = .15;  //15% defer retirement plan
        final double B403_RATE3 = .20;  //20% defer retirement plan
        final double B403_MAX = 18000;  //max contricution $18000 in 2015

        final double FIXED_TAXRATE1 = 922.50;
        final double FIXED_TAXRATE2 = 5156.25;
        final double FIXED_TAXRATE3 = 18481.25;
        final double FIXED_TAXRATE4 = 46075.25;
        final double FIXED_TAXRATE5 = 119401.25;
        final double FIXED_TAXRATE6 = 119996.25;

        boolean inputErr = true;  //input error flag
        char choice;  //repeat loop
        int yr = 1;  //year #1
        double hrWage = 0;  //input hourly wage
        double gross = 0;  //gross income for the year
        double inc = 0;  //reduced gross income for the year
        double taxRate = 0;  //federal tax rate from tax bracket
        double fedTax = 0;  //federal taxes paid
        double net = 0;  //net wages after taxes
        double b403 = 0;  //403B tax deferred retirement income

        Scanner scan = new Scanner(System.in);  //read input from keyboard
        String inputStr = null;  //input string

        do{  // do loop repeats entire program

            while(inputErr){  //while loop for hourly wage input
                System.out.print("\nEnter hourly wage to display 2015 income: ");
                hrWage = scan.nextDouble();  //assign to double for hourly wage

                if (hrWage >= MIN && hrWage <= MAX_PAY) {  //check range
                    inputErr = false;  //error false means within range
                }
                else {
                    //output error message if an invalid value is entered and prompt for input again
                    System.out.println("ERROR:  Enter a number [1-500] for hourly wages!");
                }
            }
            System.out.println("************* EARNED INCOME **************");

            //using a for loop, calculate the entries in the columns
            for(yr=1; yr<=YEAR7; ++yr){

                //gross annual wage determined from a 45 hour work week, the input hourly wage for 52 weeks
                gross = HRS_WEEK*WEEKS_IN_YR*hrWage;
                hrWage += hrWage*HR_RAISE;  //5% raise in hourly wage is accumulated each year


                //taxable gross earnings/wages is equal to gross salary minus 403b deduction
                //using a switch statement, calculate a 403b tared retirement income amount
                switch((int)gross/10000){
                    case 0:case 1:case 2:  //income less than 30000
                        b403 = gross*B403_RATE1;
                        break;
                    case 3:case 4:case 5:case 6:case 7:
                        b403 = gross*B403_RATE2;
                        break;
                    default:
                        b403 = gross*B403_RATE3;
                }



                //cap b403 at max
                if(b403>B403_MAX)
                    b403 = B403_MAX;
                //deduct the 403b amount from gross earnings/wages to be taxed
                inc = gross - b403;  //taxable gross earnings

                //fedTax = gross - b403*TAX_RATE1;
                if((int)inc>=0 && (int)inc<TAX_BRACK1)
                    fedTax = TAX_RATE1 * inc;
                if(inc>=TAX_BRACK1 && inc<TAX_BRACK2)
                    fedTax = FIXED_TAXRATE1 + (inc-TAX_BRACK1)*TAX_RATE2;
                if(inc>=TAX_BRACK2 && inc<TAX_BRACK3)
                    fedTax = FIXED_TAXRATE2 + (inc-TAX_BRACK2)*TAX_RATE3;
                if(inc>=TAX_BRACK3 && inc<TAX_BRACK4)
                    fedTax = FIXED_TAXRATE3 + (inc-TAX_BRACK3)*TAX_RATE4;
                if(inc>=TAX_BRACK4 && inc<TAX_BRACK5)
                    fedTax = FIXED_TAXRATE4 + (inc-TAX_BRACK4)*TAX_RATE5;
                if(inc>=TAX_BRACK5 && inc<TAX_BRACK6)
                    fedTax = FIXED_TAXRATE5 + (inc-TAX_BRACK5)*TAX_RATE6;
                if(inc>=TAX_BRACK6)
                    fedTax = FIXED_TAXRATE6 + (inc-TAX_BRACK6)*TAX_RATE7;

                net = gross - b403 - fedTax;

                System.out.printf("%4d%18.2f%16.2f%12.2f", yr, gross, b403, fedTax);
                System.out.printf("%14.2f\n", net);

            }

            System.out.print("\nWant to calculate another tax table (y/n)? ");
            inputStr = scan.next();
            choice = inputStr.charAt(0);  //assign 1st character...

            inputErr = true;  //set flag to check for valid input in next iteration
        }while(choice!='n' && choice!='N');

        scan.close();  //close this scanner
        System.exit(0);  //close connections
    }
}

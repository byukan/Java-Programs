/**
 * Assignment 5 P5.java Due August 26th, 2015
 * login:  cs11vcd
 * @brief This program calculates the area of an equilateral triangle (3 equal
 * length sides), surface area of a tetrahedron (4 equilateral triangles),
 * volume of a tetrahedron, area of a rectangle, surface area of a box, and
 * volume of a box, using an abstract class, classes, constructors, arrays,
 * and an inheritance hierarchy.
 *
 *
 * @files P5.java, P5Box.java, P5EquiTriangle.java, P5Rectangle.java,
 * P5Shape.java, P5Tetrahedron.java
 */

import java.util.Scanner;  //read sentence from keyboard

/**
 * public class P5
 * @brief application (driver program)
 */
public class P5 {
    private static final int SHAPES = 4;  //4 shape objects
    private static P5Shape[] a;  //array of shapes

    public static void main(String[] args) {
        char choice;  //repeat program
        double width, height, depth;  //input box/rect
        double side;  //input tetrahedron/triangle
        String inputStr = null;  //input String
        Scanner scan = new Scanner(System.in);


        a = new P5Shape[SHAPES];  //allocate 4 Shape ref
        a[0] = new P5EquiTriangle();  //instantiate objects
        a[1] = new P5Tetrahedron(2.2);
        a[2] = new P5Rectangle();
        a[3] = new P5Box(3.3, 4.4, 5.5);
        prt();  //display objects

        do {
            System.out.print("\nEnter TETRAHEDRON(side):         ");
            side = scan.nextDouble();

            System.out.print("Enter BOX (width height depth):  ");
            width = scan.nextDouble();
            height = scan.nextDouble();
            depth = scan.nextDouble();
            a[0].setDim(side);  // Reassign
            a[1].setDim(side);
            a[2].setDim(width, height);
            a[3].setDim(width, height, depth);
            prt();  // Display objects
            System.out.print("\nWant to compute area (y/n)? ");
            inputStr = scan.next();  // Read, assign to string
            choice = inputStr.charAt(0);  // Assign 1st character
        } while (choice!='n' && choice != 'N');  //loop until n or N
    }

    /**
     * prt()
     * prints the array of shapes
     * calls toString(), area(), volume()
     */
    public static void prt() {
        int i;
        for(i = 0; i < SHAPES; ++i)
            if(i%2 == 0)
            {
                System.out.print( a[i] + " has an area: ");
                System.out.printf("\t%.2f\n", a[i].area());  //2 places of
                // precision
            }
            else
            {
                System.out.print( a[i] + "\t has a surface area: ");
                System.out.printf("\t%.2f\n", a[i].area());
                System.out.printf("\t\t\t\t\t\t\t and volume: %.2f\n",
                        a[i].volume());
            }
    }

}
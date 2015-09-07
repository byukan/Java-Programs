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


/**
 * public class P5Rectangle
 * @brief subclass of P5Shape
 */
public class P5Rectangle extends P5Shape{

    /**
     * P5Rectangle()
     * no argument ctor
     */
    public P5Rectangle(){
        //initialize to one
        height = width = 1;
    }


    /**
     * P5Rectangle(w,h)
     * overloaded ctor
     * @param w
     * @param h
     */
    public P5Rectangle(double w, double h){
        width = w;  //initialize data to parameters
        height = h;
    }


    /**
     * toString()
     * @returns String format dimensions for printing to be called prt()
     */
    public String toString(){
        return (getName() + width + " x " + height);
    }



    /**
     * setDim(double)
     * assigns 1 dimension to the rectangle - a square
     * @param length is one sidelength of a square
     */
    public void setDim(double length){
        height = width = length;
    }


    /**
     * setDim()
     * @brief overloaded to assign the data members with two parameters
     * @param w is the width
     * @param h is the height
     */
    public void setDim(double w, double h){
        width = w;
        height = h;
    }


    /**
     * area()
     * @returns the area
     */
    public double area(){
        return width*height;
    }


    //all instance variables are protected access level
    protected double height;
    protected double width;
}
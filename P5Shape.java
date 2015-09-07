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
 * public class P5Shape
 * @brief abstract superclass of P5 EquiTriangle and P5Rectangle, methods are
 * declared so that they may be accessed through P5Shape array.
 */
public abstract class P5Shape {

    /**
     * toString()
     * format and return string dimensions of a shape
     * @returns the string dimensions of a shape
     */
    public String toString(){
        return "";
    }

    /**
     * getName()
     * @returns the name of the class object4
     */
    public String getName(){
        return (this.getClass().getName() + ": ");
    }

    /**
     * setDim(double)
     * assigns 1 dimension of a shape
     * abstract class, all derived classes override this method
     * @param width is one dimension of a shape
     */
    public abstract void setDim(double width);


    /**
     * setDim(double, double)
     * assigns 2 dimensions of a shape
     * @param width
     * @param height
     */
    public void setDim(double width, double height){}

    /**
     * setDim(double, double, double)
     * assigns 3 dimensions of a shape
     * @param width
     * @param height
     * @param depth
     */
    public void setDim(double width, double height, double depth){}


    /**
     * area()
     * calculates area of a shape
     * @returns the area
     */
    public abstract double area();

    /**
     * volume()
     * calculates volume of a shape
     * @returns the volume
     */
    public double volume(){return 0;}




}

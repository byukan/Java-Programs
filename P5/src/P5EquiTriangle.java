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
 * public class P5EquiTriangle
 * @brief subclass of P5Shape
 */
public class P5EquiTriangle extends P5Shape {

    /**
     * P5EquiTrianngle()
     * no arg ctor
     */
    public P5EquiTriangle(){
        side = 1;
    }

    /**
     * P5Equi?Trianngle()
     * @param base is a sidelength of the equilateral triangle
     */
    public P5EquiTriangle(double base){
        side = base;
    }


    /**
     * setDim()
     * @param l is the length of a side
     */
    public void setDim(double l){
        side = l;
    }

    /**
     * area()
     * @returns the area of the equilateral triangle
     */
    public double area(){
        //formula is .5*side*height
        //calculate height value using Pythagorea theorem
        double height = Math.sqrt(side*side - (side/2)*(side/2));
        return side*height/2;
    }

    /**
     * toString()
     * @returns String format of dimensions
     */
    public String toString(){
        return (getName() + side + " side ");
    }




    //all instance variables set as protected
    protected double side;
}

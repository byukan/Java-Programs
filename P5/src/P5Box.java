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
 * subclass of P5Rectangle
 */
public class P5Box extends P5Rectangle{
    //super calls

    /**
     * P5Box()
     * no arg ctor, initializing to 0
     */
    public P5Box(){
        depth = 0;
    }

    /**
     * P5Box(double, double, double)
     * overloaded ctor
     */
    public P5Box(double w, double h, double d){
        super(w,h);
        depth = d;
    }

    /**
     * toString()
     * @returns String format of dimensions
     */
    public String toString(){
        //format dimensions for printing to be called in prt()
        return (getName()+width+" x "+height+" x "+depth);
    }

    /**
     * setDim()
     * override, assign dimensions of a box
     */
    public void setDim(double sidelength){
        width = height = depth = sidelength;
    }


    /**
     * setDim(w,h,d)
     * @param w is the width
     * @param h is the height
     * @param d is the depth
     */
    public void setDim(double w, double h, double d){
        width = w;
        height = h;
        depth = d;

    }



    /**
     * area()
     * override method to calculate surface area
     * @returns surface area of box
     */
    public double area(){
        return 2*(width*height+height*depth+width*depth);  //6 sides of a box
    }

    /**
     * volume()
     * @returns the volume of the box
     */
    public double volume(){
        return width*height*depth;
    }


    //all instance variables are protected access level
    protected double depth;
}

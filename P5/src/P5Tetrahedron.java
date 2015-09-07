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
 * public class P5Tetrahedron
 * @brief subclass of P5EquiTriangle
 */
public class P5Tetrahedron extends P5EquiTriangle {
    //super calls

    /**
     * P5Tetrahedron()
     * no arg ctor
     */
    public P5Tetrahedron(){
        //implicit super() call
    }

    /**
     * P5Tetrahedron(double)
     * @param s is the side
     */
    public P5Tetrahedron(double s){
        //implicit super(double) call
        side = s;
    }

    /**
     * area()
     * @returns the surface area of a tetrahedron
     */
    public double area(){
        return 4*super.area();
    }



    /**
     * volume()
     * @returns the volume of hte P5Tetrahedron
     */
    public double volume(){
        return (Math.sqrt(2)/12)*side*side*side;
    }


    /**
     * toString()
     * @returns String format of dimensions
     */
    public String toString(){
        return (getName()+" " +side+"x"+side+"x"+side+"x"+side);
    }



}

// Write a program in Java to show the usefulness of Interfaces as a place to keep constant value of the program
// (i.e. static final variables).

interface len {
    final int l = 10;
}
class square implements len {
    public void area() {
        //l = 15;                                     line of error
        System.out.println("Area of square is " + l * l);
    }
}
class Peri_sqr implements len {
    public void area() {
        System.out.println("Perimeter of square is " + 4 * l);
    }
}
public class EXP6_Q3 {
    public static void main(String[] args) {
        square s = new square();
        Peri_sqr p = new Peri_sqr();
        s.area();
        p.area();
    }
}
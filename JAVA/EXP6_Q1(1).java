// Write a program to create interface named test.
//In this interface the member function is square.
//Implement this interface in arithmetic class.
//Create one new class called ToTestInt.
//In this class use the object of arithmetic class.

interface test
{
    int square(int x);
}
class arithmetic implements test
{
    public int square(int x)
    {
        return x*x;
    }
}
public class EXP6_Q1
{
    public static void main(String[] args)
    {
        arithmetic a = new arithmetic();
        System.out.println(a.square(5));
    }
}
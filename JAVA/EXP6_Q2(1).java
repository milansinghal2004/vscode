// Write a program to create interface A, in this interface we have two method meth1 and meth2.
// Implements this interface in another class named MyClass.

interface A
{
    void meth1();
    void meth2();
}
class MyClass implements A
{
    public void meth1()
    {
        System.out.println("This is method 1");
    }
    public void meth2()
    {
        System.out.println("This is method 2");
    }
}
public class EXP6_Q2 {
    public static void main(String[] args)
    {
        MyClass m = new MyClass();
        m.meth1();
        m.meth2();
    }
}

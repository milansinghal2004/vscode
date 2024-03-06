// Write a program to create an Interface having two methods division and modulus.
// Create a class, which overrides these methods.

interface methods
{
    int division(int a, int b);
    int modulus(int a, int b);
}
class aritmatic implements methods
{
    public int division(int a, int b)
    {
        return a/b;
    }
    public int modulus(int a, int b)
    {
        return a%b;
    }
}
public class EXP6_Q4 {
    public static void main(String[] args)
    {
        aritmatic a = new aritmatic();
        System.out.println("Divsion function over 10 & 2 gives: "+a.division(10, 2));
        System.out.println("Modulo function over 10 & 2 gives: "+a.modulus(10, 2));
    }    
}

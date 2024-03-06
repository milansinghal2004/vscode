import java.util.*;
class p1{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of days: ");
        int days = sc.nextInt();
        System.out.println("Year: " + (days/365));
        int month= sc.nextInt();
        System.out.println("Month: " + (days/12));
    }
}
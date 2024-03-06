import java.util.*;
class input
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Character Input
        System.out.print("Enter the character: ");
        char var1 = sc.next().charAt(0);
        System.out.println("You entered: "+ var1);

        // Integer Input
        System.out.print("Enter the Integer: ");
        int var2 = sc.nextInt();
        System.out.println("You entered: "+ var2);

        // String Input
        sc.nextLine();
        System.out.print("Enter the String: ");
        String var3 = sc.nextLine();
        System.out.println("You entered: "+ var3);

        // Array Input
        int[] arr = new int[5];
        System.out.print("Enter the array: ");
        for(int i=0; i<5; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Your array is: ");
        for(int i=0; i<5; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
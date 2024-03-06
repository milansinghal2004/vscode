// Write program to create an interface StackInterface having methods push (), pop () and display ().
// StackClass implements StackInterface.
// Class StackClass contains the main method which is having a switch case for selecting the particular operation of the stack.

import java.util.*;
interface StackInterface
{
    void push();
    void pop();
    void display();
}
class StackClass implements StackInterface
{
    Scanner sd = new Scanner(System.in);
    int ele = 0;
    int top = -1;
    int[] stack = new int[10];
    public void push()
    {
        if(top == 9)
        {
            System.out.println("Stack is full");
        }
        else    
        {
            System.out.print("Enter the element to be pushed: ");
            ele = sd.nextInt();
            top++;
            stack[top] = ele;
        }
        
    }
    public void pop()
    {
        if(top == -1)
        {
            System.out.println("Stack is empty");
        }
        else
        {
            System.out.println("Element popped is "+stack[top]);
            top--;
        }
    }
    public void display()
    {
        if(top == -1)
        {
            System.out.println("Stack is empty");
        }
        else
        {
            System.out.print("Stack is: ");
            for(int i = top; i >= 0; i--)
            {
                System.out.print(stack[i]+"\t");
            }
        }
        System.out.println("\n");
    }
    public void display(int i) {
    }
}
public class EXP6_Q5 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StackClass s = new StackClass();
        int choice = 0;
        while(true)
        {
            System.out.println("Stack Options");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.close();
            switch(choice)
            {
                case 1:
                    s.push();
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    s.display();
                    break;
                case 4:
                    System.exit(4);;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}

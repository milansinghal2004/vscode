#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>
#define max 5

int top = -1, stack[max];

void push(int n);
void pop();
void trav();

int main()
{
    int choice, n;
    while(1)
    {
        printf("\nMenu\n1.Push\n2.Pop\n3.Traverse\n4.Exit\nEnter your choice : ");
        scanf("%d", &choice);
        switch(choice)
        {
            case 1:
            push(n);
            break;

            case 2:
            pop();
            break;

            case 3:
            trav();
            break;

            default:
            exit(1);
        }
    }
}

void push(int n)
{
    int x;
    if (top == max - 1)
    {
        printf("Overflow!!");
    }
    else
    {
        printf("Enter the data : ");
        scanf("%d", &x);
        top = top + 1;
        stack[top] = x;
    }
}

void pop()
{
    if(top == -1)
    {
        printf("Underflow");
    }
    else
    {
        top = top - 1;
        printf("Popped\n");
    }
}

void trav()
{
    int i = top;
    if(top == -1)
    {
        printf("Underflow");
    }
    else
    {
        while(i >= 0)
        {
            printf("%d\t", stack[i]);
            i--;
        }
    }
}
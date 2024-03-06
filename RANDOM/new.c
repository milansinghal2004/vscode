/*#include<stdio.h>
#include<stdlib.h>
#define max 5

top = -1, stack[max];
void push(int data);
void pop();
void trav();

int main()
{
    int choice, data;
    printf("Menu\n1.Push\t2.Pop\t3.Traverse\nEnter your choice : ");
    scanf("%d", &choice);
    switch(choice)
    {
        case 1:
        push(data);

        case 2:
        pop();

        case 3:
        trav();

        default:
        exit(1);
    }
}

void push(int data)
{
    if(top == -1)
    {
        printf("Overflow :[\n");
    }
    else
    {
        top = top + 1;
        stack[top] = data;
    }
}

void pop()
{
    if(top == -1)
    {
        printf("Underflow :[\n");
    }
    else
    {
        top = top + 1;
        printf("DELETED\n");
    }
}

void trav()
{
    int i = top;
    if(top == -1)
    {
        print("No stack exist :[");
    }
    else
    {
        while(i != top)
        {
            print("%d", top)
        }
    }
}*/

#include<stdio.h>
int main() {
    int i, j, row, n;
    printf("Enter the number of row");
    scanf("%d",&row);
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <=n; j++) {
            printf("*");
        }
        printf("\n");
    }
    return 0;
}
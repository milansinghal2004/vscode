
#include <stdio.h>
#include<stdlib.h>
#define max 50

void enq();
void deq();
void trav();

int queue[max];
int rear = - 1;
int front = - 1;

int main()
{
    int choice, n;
    while (1)
    {
        printf("\n1.Insert element to queue\n2.Delete element from queue\n3.Display all elements of queue\n4.Quit\n");
        printf("Enter your choice : ");
        scanf("%d", &choice);
        switch(choice)
        {
            case 1:
            printf("Enter data : ");
            scanf("%d", &n);
            enq(n);
            break;
            case 2:
            deq();
            break;
            case 3:
            trav();
            break;
            case 4:
            exit(1);
            default:
            printf("Wrong choice n");
        }
    }
}

void enq(int n)
{
    if(rear >= max-1)
    {
        printf("Overflow");
    }
    else
    {
        if(rear == -1)
        {
            rear = front = 0;
            queue[rear] = n;
        }
        else
        {
            rear += 1;
            queue[rear] = n;
        }
    }
}

void deq()
{
    if(rear == -1 || front == -1)
    {
        printf("Underflow");
    }
    else
    {
        if(rear == 0)
        {
            rear = front = -1;
        }
        else
        {
            front += 1;
        }
    }
}

void trav()
{
    int i = front;
    if(rear == -1)
    {
        printf("Underflow");
    }
    else
    {
        while(i <= rear)
        {
            printf("%d\t", queue[i]);
            i = i + 1;
        }
    }
}

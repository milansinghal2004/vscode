#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>
#define max 5  // defining contant

int queue[max];
int front = -1, rear = -1;

void enq(int n);
void deq();
void trav();

int main()
{
    int choice, n;
    while(1)
    {
        printf("\nMenu\n1.Enqueue\n2.Dequeue\n3.Traverse\n4.Exit\nEnter your choice : ");
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

            case 3:
            trav();

            case 4:
            exit(1);

            default:
            printf("WRONG CHOICE :(");
        }
    }
}

void enq(int n)
{
    if((front == 0 && rear == max - 1 ) || ( front > 0 && rear == front - 1 ))
    {
        printf("OVERFLOW :(");
    }
    else
    {
        if(rear == -1)
        {
            front = rear = 0;
            queue[rear] = n;
        }
        else
        {
            rear = ( rear + 1 ) % max;
            queue[rear] = n;
        }
    }
}

void deq()
{
    if(front == -1)
    {
        printf("UNDERFLOW :(");
    }
    else
    {
        if(rear == front)
        {
            rear = front = -1;
        }
        else
        {
            front = ( front + 1 ) % max;
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
            i = ( i + 1 ) % max;
        }
    }
}


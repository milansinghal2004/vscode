#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>

struct node
{
    int data;
    struct node *next;
};
struct node *rear = NULL, *front=NULL;

void enq(struct node *new1);
void deq();
void trav();

int main()
{
    int choice;
    struct node *ptr;
    while(1)
    {
        printf("\nHELLO\nMENU\n1.ENQUEUE\n2.DEQUEUE\n3.TRAVERSE\nEnter your choice : ");
        scanf("%d", &choice);
        switch(choice)
        {
            case 1:
            ptr = (struct node *)malloc(sizeof(struct node));
            printf("Enter data : ");
            ptr->next = NULL;
            scanf("%d", &ptr -> data);
            enq(ptr);
            break;

            case 2:
            deq();
            break;

            case 3:
            trav();
            break;

            default:
            exit(1);
        }
    }
}
void enq(struct node *new1)
{
    if(rear == NULL)
    {
        rear = front = new1;
    }
    else
    {
        rear -> next = new1;
        // rear = new1; or we can say
        rear = rear -> next;
    }
}

void deq()
{
    if(rear == NULL)
    {
        printf("NO QUEUE EXIST :(");
    }
    else if (front == rear)
    {
        front = NULL;
        rear = NULL;
        printf("DELETED :)");
    }
    
    else
    {
        struct node *temp = front;
        front = front -> next;
        printf("%d is DELETED\n", temp -> data);
        free(temp);
        temp = NULL;
        //printf("DELETED :)");
    }
}

void trav()
{
    if(front == NULL)
    {
        printf("NO LIST EXIST :(");
    }
    else
    {
        struct node *temp = front;
        while(temp != NULL)
        {
            printf("%d \t", temp->data);
            temp = temp -> next;
        }
    }
}
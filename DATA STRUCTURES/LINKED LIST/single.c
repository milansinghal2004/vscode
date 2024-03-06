#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
struct node
{
    int data;
    struct node *next;
};
struct node *head = NULL;
void insert_at_beg(struct node *new);
void insert_at_end(struct node *new);
void del_beg();
void del_end();
void print();
int main()
{
    int choice;
    struct node *ptr;
    int x = 1;
    while (x == 1)
    {
        printf("press 1 for insertion in the beg;\tpress 2 for insertion at the end;\npress 3 for delition from the end;\tpress 4 to delition at the beg;\npress 5 to print all the entries \nEnter your choice: ");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            ptr = (struct node *)malloc(sizeof(struct node));
            printf("Enter the value: ");
            scanf("%d", &ptr->data);
            ptr->next = NULL;
            insert_at_beg(ptr);
            break;
        case 2:
            ptr = (struct node *)malloc(sizeof(struct node));
            printf("Enter the value: ");
            scanf("%d", &ptr->data);
            ptr->next = NULL;
            insert_at_end(ptr);
            break;
        case 3:
            del_end();
            break;
        case 4:
            del_beg();
            break;
        case 5:
            print();
            break;
        case 6:
            printf("This is the end of Linked list\n");
            x = 0;
            break;
        default:
            printf("Invalid input");
        }
    }
}
void insert_at_beg(struct node *new)
{
    if (head == NULL)
    {
        head = new;
    }
    else
    {
        new->next = head;
        head = new;
    }
}
void insert_at_end(struct node *new)
{
    if (head == NULL)
    {
        head = new;
    }
    else
    {
        struct node *temp = head;
        while (temp->next != NULL)
        {
            temp = temp->next;
        }
        temp->next = new;
    }
}
void del_beg()
{
    struct node *temp = head;
    if (head == NULL)
    {
        printf("Under Flow\n");
    }
    else if (head->next == NULL)
    {
        free(head);
        head = NULL;
    }
    else
    {
        head = head->next;
        temp->next = NULL;
        free(temp);
        temp = NULL;
    }
}
void del_end()
{
    struct node *temp, *temp1;
    temp = temp1 = head;
    if (head == NULL)
    {
        printf("Under Flow\n");
    }
    else if (head->next == NULL)
    {
        free(head);
        head = NULL;
    }
    else
    {
        while (temp->next != NULL)
        {
            temp = temp->next;
        }
        while (temp1->next != temp)
        {
            temp1 = temp1->next;
        }
        temp1->next = NULL;
        free(temp);
        temp = NULL;
    }
}
void print()
{
    struct node *temp = head;
    if (head == NULL)
    {
        printf("Under Flow\n");
    }
    else
    {
        while (temp->next != NULL)
        {
            printf("%d ", temp->data);
            temp = temp->next;
        }
        printf("%d\n", temp->data);
    }
}
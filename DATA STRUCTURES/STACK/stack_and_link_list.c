#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *next;
};
struct node *top = NULL;
typedef struct node node;
void push(node *new)
{
    if (top == NULL)
    {
        top = new;
    }
    else
    {
        new->next = top;
        top = new;
    }
}
void pop();
void _print();
void _peek();
int main()
{
    int choice;
    int x = 1, data;
    node *ptr;
    while (x == 1)
    {
        printf("Menu\n1.Insertion\n2.Deletion\n3.Traversal\n4.Printing peak value\n5.Exits");
        printf("\nEnter your choice: ");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
            ptr=(node *)malloc(sizeof(node));
            printf("Enter the data: ");
            scanf("%d", &ptr->data);
            ptr->next = NULL;
            push(ptr);
            break;
        case 2:
            pop();
            break;
        case 3:
            _print();
            break;
        case 4:
            _peek();
            break;
        case 5:
            x = 0;
            break;
        default:
            printf("Invalid input\n");
        }
    }
}
void pop()
{
    node *temp = top;
    top = top->next;
    free(temp);
    temp->next = NULL;
}
void _print()
{
    node *temp = top;
    while (temp != NULL)
    {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}
void _peek()
{
    printf("%d\n", top->data);
}
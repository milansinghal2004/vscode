#include<stdio.h>
#include<string.h>
#include<malloc.h>
struct node
{
    int data;
    struct node *next;
};
struct node *head=NULL;
void insert(struct node *new1);
void del();
void traverse();
void end(struct node *new1);
int main()
{
int choice;
struct node *new1;
while(1)
{
    printf("\nEnter your choice 1.insert 2.del 3.traverse 4.insert at end 5.exit\n");
    scanf("%d",&choice);
    switch(choice)
    {
    case 1: 
        
        new1=(struct node*)malloc(sizeof(struct node));
        scanf("%d",&new1->data);
        new1->next=NULL;
        insert(new1);
        break;
    case 2:
        del();
        break;
    case 3 :
        traverse();
        break;
    case 4:
        new1=(struct node *)malloc(sizeof(struct node));
        scanf("%d",&new1->data);
        new1->next=NULL;
        end(new1);
        break;
        default:
        exit(1);
    }
}
}   
void insert(struct node *new1)
{
    if(head==NULL){
        head=new1;
    }
    else{
        new1->next=head;
        head=new1;
    }
}
void del()
{
    if(head==NULL)
    {
        printf("No elements");
    }
}
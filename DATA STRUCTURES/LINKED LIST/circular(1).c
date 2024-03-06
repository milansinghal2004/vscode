#include<stdio.h>
#include<malloc.h>
struct node{
    int data;
    struct node *next;
};
struct node *head=NULL;
void ins(struct node *p);
void del();
void insend(struct node *p);
void delend();
void trav();
void search();
int main(){
    int ch;
    struct node *ptr;
    while(1){
        printf("\n1.Insertion at beggining \n2.Deletion at beggining");
        printf("\n3.Insertion at end \n4.Deletion at end");
        printf("\n5.Traverse\n6.Search\n7.Exit\n");
        printf("Enter choice:");
        scanf("%d",&ch);
        switch(ch){
            case(1):
            ptr=(struct node *)malloc(sizeof(struct node));
            printf("Enter data:");
            scanf("%d",&ptr->data);
            ptr->next=NULL;
            ins(ptr);
            break;
            case(2):
            del();
            break;
            case(3):
            ptr=(struct node *)malloc(sizeof(struct node));
            printf("Enter data:");
            scanf("%d",&ptr->data);
            ptr->next=NULL;
            insend(ptr);
            break;
            case(4):
            delend();
            break;
            case(5):
            trav();
            break;
            case(6):
            search();
            default:
            exit(1);
        }
    }
}
void ins(struct node*n1){
    if(head==NULL){
        head=n1;
        head->next=head;
    }
    else{
        struct node *t=head;
        while(t->next!=head){
            t=t->next;
        }
        t->next=n1;
        n1->next=head;
        head=n1;
    }
}
void del(){
    struct node *t,*t1;
    t=head;
    t1=head;
    if(head==NULL){
        printf("Underflow");
    }
    else{
        while(t->next!=head){
            t=t->next;
        }
        head=head->next;
        t->next=head;
        free(t1);
        t1=NULL;
    }
}
void trav(){
    struct node *t1=head;
    if(head==NULL){
        printf("Underflow");
    }
    else{
        while(t1->next!=head){
            printf("%d\t",t1->data);
            t1=t1->next;
        }
        printf("%d\t",t1->data);
    }
}
void delend(){
    struct node *temp,*temp1;
    temp=head;
    temp1=head;
    if(head==NULL){
        printf("Underflow");
    }
    else{
        while(temp->next!=head){
            temp=temp->next;
        }
        while(temp1->next!=temp){
            temp1=temp1->next;
        }
        temp1->next=head;
        temp->next=NULL;
        free(temp);
        temp=NULL;
    }
}
void insend(struct node *p){
    struct node*temp=head;
    if(head==NULL){
        head=p;
        head->next=head;
    }
    else{
        while(temp->next!=head){
            temp=temp->next;
        }
        temp->next=p;
        p->next=head;
    }
}
void search()
{
    int count = 0, n;
    struct node *temp = head;
    printf("Enter the element for search : ");
    scanf("%d", &n);
    while(temp -> data != n)
    {
        count++;
    }
    printf("Your searched element is on %d position", count);
}
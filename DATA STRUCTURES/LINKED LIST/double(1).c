    #include<stdio.h>
    #include<stdlib.h>
    #include<malloc.h>

    struct node
    {
        int data;
        struct node *next;
        struct node *prev;
    };
    struct node *head = NULL;

    void bins(struct node *new1);
    void eins(struct node *new1);
    void trav();
    void bdel();
    void edel();

    int main()
    {
        struct node *ptr;
        int choice;
        while(1)
        {
            printf("Menu\n1.Insert at begining\n2.Insert at end\n3.Traverse\n4.Delete from begining\n5.Delete from ending\n");
            printf("Enter your choice : ");
            scanf("%d", &choice);
            switch(choice)
            {
                case 1:
                ptr = (struct node *)malloc(sizeof(struct node));
                printf("Enetr the data : ");
                scanf("%d", &ptr->data);
                ptr -> next = NULL;
                bins(ptr);
                break;

                case 2:
                ptr = (struct node *)malloc(sizeof(struct node));
                printf("Enter the data : ");
                scanf("%d", &ptr->data);
                ptr -> next = NULL;
                eins(ptr);
                break;

                case 3:
                trav();

                case 4:
                bdel();

                case 5:
                edel();

                default:
                exit(1);
            }
        }
    }

    void bins(struct node *new1)
    {
        if(head == NULL)
        {
            head = new1;
        }
        else
        {
            new1 -> next = head;
            head -> prev = new1;
            head = new1;
        }
    }

    void eins(struct node *new1)
    {
        struct node *temp = head;
        if(head == NULL)
        {
            head = new1;
        }
        else
        {
            while(temp -> next != NULL)
            {
                temp = temp -> next;
            }
            temp -> next = new1;
            new1 -> next = NULL;
            new1 -> prev = temp;
        }
    }

    void trav()
    {
        struct node *temp = head;
        if(head == NULL)
        {
            printf("List does not exist");
        }
        else
        {
            while(temp != NULL)
            {
                printf("%d\t", temp->data);
                temp = temp -> next;
            }
        }
    }

    void bdel()
    {
        struct node *temp = head;
        if(head == NULL)
        {
            printf("Underflow");
        }
        else
        {
            head = head -> next;
            free(temp);
            temp = NULL;
            head -> prev = NULL;
        }
    }

    void edel()
    {
        struct node *temp = head, *temp1 = head;
        if(head == NULL)
        {
            printf("Underflow");
        }
        else
        {
            while(temp -> next != NULL)
            {
                temp = temp -> next;
            }
            while(temp1 -> next != temp)
            {
                temp1 = temp1 -> next;
            }
            temp1 -> next = NULL;
            temp -> prev = NULL;
            free(temp);
            temp = NULL;
        }
    }

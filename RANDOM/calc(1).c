#include<stdio.h>
int main()
{
    float a, b, c;
    int otpt;
    char opr;
    printf("List of operations - \n+\n-\n*\n/\n");
    printf("Enter the operation : ");
    scanf("%c", &opr);
    printf("Enter two operands : ");
    scanf("%d%d", &a, &b);
    printf("Enter '1' for integer output and '2' for decimal output\nEnter your choice : ");
    scanf("%ch", &otpt);
    if(otpt == "d")
    {
        switch(opr)
        {
            case '+':
            printf("%f + %f = %f", a, b ,a+b);
            break;

            case '-':
            printf("%f - %f = %f", a, b ,a-b);
            break;

            case '*':
            printf("%f * %f = %f", a, b ,a*b);
            break;

            case '/':
            printf("%f / %f = %f", a, b ,a/b);
            break;

            default:
            printf("Retry");
        }
    }
    else if (otpt == "i")
    {
        switch(opr)
        {
            case '+':
            printf("%f + %f = %d", a, b ,a+b);
            break;

            case '-':
            printf("%f - %f = %d", a, b ,a-b);
            break;

            case '*':
            printf("%f * %f = %d", a, b ,a*b);
            break;

            case '/':
            printf("%f / %f = %d", a, b ,a/b);
            break;

            default:
            printf("Retry");
        }
    }
    else
    {
        printf("Retry");
    }
}
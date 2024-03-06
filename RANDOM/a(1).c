#include<stdio.h>
int main()
{
    int a[5];
    int i;
    printf("Array: ");
    for(i=0;i<5;i++) 
    {
        scanf("%d",&a[i]);
    }
    printf("Answer: ");
    for(i=0;i<5;++i)
    {
        printf("%d\n",a[i]);
    } 
    return 0;
}
/*include<stdio.h>
struct stu
{
    float Math;
    float PPL;
    float LC;
}s1, s2, s3, s4, s5;
int main()
{
    printf("For student 1\n");
    printf("Enter marks of Math : ");
    scanf("%f", &s1.Math);
    printf("Enter marks of PPL : ");
    scanf("%f", &s1.PPL);
    printf("Enter marks of LC : ");
    scanf("%f", &s1.LC);
    printf("For student 2\n");
    printf("Enter marks of Math : ");
    scanf("%f", &s2.Math);
    printf("Enter marks of PPL : ");
    scanf("%f", &s2.PPL);
    printf("Enter marks of LC : ");
    scanf("%f", &s2.LC);
    printf("For student 3\n");
    printf("Enter marks of Math : ");
    scanf("%f", &s3.Math);
    printf("Enter marks of PPL : ");
    scanf("%f", &s3.PPL);
    printf("Enter marks of LC : ");
    scanf("%f", &s3.LC);
    printf("For student 4\n");
    printf("Enter marks of Math : ");
    scanf("%f", &s4.Math);
    printf("Enter marks of PPL : ");
    scanf("%f", &s4.PPL);
    printf("Enter marks of LC : ");
    scanf("%f", &s4.LC);
    printf("For student 5\n");
    printf("Enter marks of Math : ");
    scanf("%f", &s5.Math);
    printf("Enter marks of PPL : ");
    scanf("%f", &s5.PPL);
    printf("Enter marks of LC : ");
    scanf("%f", &s5.LC);
    if(s1.Math > s2.Math && s1.Math > s3.Math && s1.Math > s4.Math && s1.Math > s3.Math)
    {
        printf("Highest Marks in Math : %d", s1.Math);
    }
    else if(s2.Math > s1.Math && s2.Math > s3.Math && s2.Math > s4.Math && s2.Math > s3.Math)
    {
        printf("Highest Marks in Math : %d", s2.Math);
    }
}

*/

// Question 2
#include<stdio.h>
void insert( int r, int c)
{
    int arr[20][20];
    for(int i=0; i<r; i++)
    {
        for(int j=0; j<c; j++)
        {
            scanf("%d", &arr[i][j]);
        }
    }
    for(int i=0; i<r; i++)
    {
        for(int j=0; j<c; j++)
        {
            printf("%d\t", arr[i][j]);
        }
        print("\n");
    }
}
void check( int r, int c)
{
    int count = 0;
    int arr[20][20];
    for(int i=0; i<r; i++)
    {
        for(int j=0; j<c; j++)
        {
            if(arr[i][j]==5)
            {
                count+=1;
            }
        }
    }
    printf("No. of times 5 occoured is : %d", count);
}
int main()
{
    int r, c;
    printf("Enter the no. of rows and columns : ");
    scanf("%d%d", &r, &c);
    printf("Enter the elements : ");
    insert(r, c);
    check(r,c);
}
#include <stdio.h>
#include <math.h>

int isMultipleOf3(int n)
{
    int odd_count = 0;
    int even_count = 0;
 
    /* Make no positive if +n is multiple of 3
       then is -n. We are doing this to avoid
       stack overflow in recursion*/
    if(n < 0)   n = -n;
    if(n == 0) return 1;
    if(n == 1) return 0;
 
    while(n)
    {
        /* If odd bit is set then
           increment odd counter */
        if(n & 1) 
           odd_count++;
        n = n>>1;
 
        /* If even bit is set then
           increment even counter */
        if(n & 1)
            even_count++;
        n = n>>1;
    }
 
     return isMultipleOf3(abs(odd_count - even_count));
}
 
/* Program to test function isMultipleOf3 */
int main()
{
    int num = 23;
    if (isMultipleOf3(num))    
        printf("num is multiple of 3\n ");
    else
        printf("num is not a multiple of 3 \n");
    return 0;
}
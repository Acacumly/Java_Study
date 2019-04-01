//Êä³öÍ¼ĞÎ
#include<stdio.h>
#include<stdlib.h>
int main1() {
	int i, j;
	for (i=1; i <= 13; ++i){
		for (j=1; j <=((i<=7)?(2*i-1):(27-2*i)); ++j)
		{
			printf("*");
		}
		putchar('\n');
	}
	system("pause");
	return 0;
}

//函数实现两个数的交换
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
int swap(int* a, int* b) {
	int temp;
	temp = *a;
	*a = *b;
	*b = temp;
}

int main2() {
	int x,y;
	printf("请输入两个整数:");
	scanf("%d %d", &x, &y);
	printf("x=%d,y=%d\n", x, y);
	swap(&x, &y);
	printf("交换后:x=%d,y=%d\n", x, y);
	system("pause");
	return 0;
}
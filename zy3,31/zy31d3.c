//函数判断是否为闰年
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
int Is_leap(int n) {
	if (n % 400 == 0 || ((n % 4 == 0) && (n % 100 != 0))) {
		return 1;
	}
	return 0;
}
int main3() {
	int a;
	printf("请输入所要查询的年份:");
	scanf("%d", &a);
	if (Is_leap(a) == 1) {
		printf("%d是闰年\n", a);
	}
	else if (Is_leap(a) == 0) {
		printf("%d不是闰年\n", a);
	}
	system("pause");
	return 0;
}
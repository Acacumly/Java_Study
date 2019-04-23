//递归和非递归分别实现求第n个斐波那契数。
//斐波纳契数列（Fibonacci Sequence），
//又称黄金分割数列，指的是这样一个
//数列：1、1、2、3、5、8、13、21.....
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>

int fib(int n) {
	if (n <= 2) {
		return 1;
	}
	return fib(n - 1) + fib(n - 2);
}

int fibN(int n) {
	int an, an_1=1, an_2=1;
	int i;
	if (n <= 2) {
		return 1;
	}
	for (i = 2; i < n; ++i) {
		an = an_1 + an_2;
		an_1 = an_2;
		an_2 = an;
	}
	return an;
}
int main22() {
	int n;
	printf("请输入需要求的第n个斐波那契数为:");
	scanf("%d", &n);
	printf("递归方法斐波那契数为%d\n", fib(n));
	printf("非递归方法斐波那契数为%d\n", fibN(n));
	system("pause");
	return 0;
}

//�ݹ�ͷǵݹ�ֱ�ʵ�����n��쳲���������
//쳲��������У�Fibonacci Sequence����
//�ֳƻƽ�ָ����У�ָ��������һ��
//���У�1��1��2��3��5��8��13��21.....
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
	printf("��������Ҫ��ĵ�n��쳲�������Ϊ:");
	scanf("%d", &n);
	printf("�ݹ鷽��쳲�������Ϊ%d\n", fib(n));
	printf("�ǵݹ鷽��쳲�������Ϊ%d\n", fibN(n));
	system("pause");
	return 0;
}

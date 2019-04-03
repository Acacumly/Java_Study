//函数实现判断素数
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
int Judge_num(int n) {
	int i;
	for (i = 2; i < n; ++i) {
		if (n%i == 0) {
			return 0;
		}
	}
		return 1;
}

int main5() {
	int num = 0;
	printf("请输入一个数:");
	scanf("%d", &num);
	if (Judge_num(num) == 1) {
		printf("%d是素数\n", num);
	}
	else {
		printf("%d不是一个素数\n", num);
	}
	system("pause");
	return 0;
}
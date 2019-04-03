//函数实现输出乘法口诀表
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
void Menu(int n) {
	int i,j;
	for (i = 1; i <= n; ++i) {
		for (j = 1; j <= i; j++) {
			printf("%d*%d=%-3d", j, i, i*j);
		}
		printf("\n");
	}
}

int main1(){
	int n = 0;
	printf("请输入所需要的乘法口诀表的行数:");
	scanf("%d", &n);
	Menu(n);
	system("pause");
	return 0;

}
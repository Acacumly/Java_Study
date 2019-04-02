//猜数字
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int Menu(){
	printf("======================\n");
	printf(" 1.开始游戏\n");
	printf(" 0.退出游戏\n");
	printf("======================\n");
	printf("请输入您的选择: ");
	int choice = 0;
	scanf("%d", &choice);
	return choice;
}
void Game(){
	//1.随机生成一个数字 1~100之间
	//2.提示选择,进行猜数字游戏,输入一个整数
	//3.用户输入的数字和生成的数字进行比较
	//4.根据比较结果,提示信息
	int to_guess = rand() % 100 + 1;
	while (1){
		printf("请输入一个整数(1`100):");
		int num = 0;
		scanf("%d", &num);
		if (num > to_guess){
			printf("高了~\n");
		}
		else if (num < to_guess){
			printf("低了~\n");
		}
		else {
			printf("猜对了!\n");
			break;
		}
	}
}
int main(){
	srand((unsigned int)time(0));
	while (1){
		int choice = Menu();
		if (choice == 1){
			Game();
		}
		else if (choice == 0){
			printf("goodbye!\n");
			break;
		}
		else{
			printf("你的输入有误!\n");
		}
	}
	system("pause");
	return 0;
}
//������
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int Menu(){
	printf("======================\n");
	printf(" 1.��ʼ��Ϸ\n");
	printf(" 0.�˳���Ϸ\n");
	printf("======================\n");
	printf("����������ѡ��: ");
	int choice = 0;
	scanf("%d", &choice);
	return choice;
}
void Game(){
	//1.�������һ������ 1~100֮��
	//2.��ʾѡ��,���в�������Ϸ,����һ������
	//3.�û���������ֺ����ɵ����ֽ��бȽ�
	//4.���ݱȽϽ��,��ʾ��Ϣ
	int to_guess = rand() % 100 + 1;
	while (1){
		printf("������һ������(1`100):");
		int num = 0;
		scanf("%d", &num);
		if (num > to_guess){
			printf("����~\n");
		}
		else if (num < to_guess){
			printf("����~\n");
		}
		else {
			printf("�¶���!\n");
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
			printf("�����������!\n");
		}
	}
	system("pause");
	return 0;
}
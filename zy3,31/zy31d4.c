//����,��ʼ��,����,���
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
int arr[20] = { 0 };
void Menu1() {
	printf("==========================\n");
	printf("1.���������ʼ��\n");
	printf("2.��������Ԫ��\n");
	printf("3.�������\n");
	printf("==========================\n");
}
int Inti(int len) {
	int i = 0;
	for (i = 0; i < len; ++i) {
		printf("%d", arr[i]);
	}
	printf("\n");
	return 1;
}

int Empty(int len) {
	int i = 0;
	for (i = 0; i < len; ++i) {
		arr[i] = 0;
		printf("%d", arr[i]);
	}
	printf("\n");
	return 3;
}
int Reverse(int len) {
	int i = 0;
	int left = 0;
	int right = len - 1;
	while (left < right){
		int temp = 0;
		temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
		left++;
		right--;
	}
	for (i = 0; i < len; ++i) {
		printf("%d", arr[i]);
	}
	printf("\n");
	return 2;
}

int main() {
	int i = 0;
	int len = sizeof(arr) / sizeof(arr[0]);
	int num;
	printf("����������Ĵ�С:");
	scanf("%d", &len);
	printf("����������Ԫ��:");
	for (i = 0; i < len; ++i) {
		scanf("%d  ", &arr[i]);
	}
	do {
		Menu1();
		scanf("%d", &num);
		switch (num) {
		case 1: Inti(len);
			break;
		case 2: Reverse(len);
			break;
		case 3: Empty(len);
			break;
		default: printf("��������!\n");
			break;
		}
	} while (len);
	system("pasuse");
	return 0;
}

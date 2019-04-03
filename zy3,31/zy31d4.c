//数组,初始化,逆置,清空
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
int arr[20] = { 0 };
void Menu1() {
	printf("==========================\n");
	printf("1.进行数组初始化\n");
	printf("2.逆置数组元素\n");
	printf("3.清空数组\n");
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
	printf("请输入数组的大小:");
	scanf("%d", &len);
	printf("请输入数组元素:");
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
		default: printf("输入有误!\n");
			break;
		}
	} while (len);
	system("pasuse");
	return 0;
}

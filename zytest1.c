//��������
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main1() {
	int i;
	for ( i = 0; i < 3; ++i) {
		printf("����������: ");
		char password[20] = "";
		scanf("%s", password);
		if (strcmp(password, "abcde000") == 0) {
			printf("��½�ɹ�!\n");
			break;
		} else {
			printf("�����������!\n");
		}
	}
	if (i == 3) {
		printf("���������������,��ֹ��¼!\n");
	}
	system("pause");
	return 0;
}
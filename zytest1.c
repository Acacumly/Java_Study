// ‰»Î√‹¬Î
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main1() {
	int i;
	for ( i = 0; i < 3; ++i) {
		printf("«Î ‰»Î√‹¬Î: ");
		char password[20] = "";
		scanf("%s", password);
		if (strcmp(password, "abcde000") == 0) {
			printf("µ«¬Ω≥…π¶!\n");
			break;
		} else {
			printf("√‹¬Î ‰»Î¥ÌŒÛ!\n");
		}
	}
	if (i == 3) {
		printf("√‹¬Î ‰»Î¥ÌŒÛ»˝¥Œ,Ω˚÷πµ«¬º!\n");
	}
	system("pause");
	return 0;
}
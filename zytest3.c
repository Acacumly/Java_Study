//²éÕÒÊı×Ö
#include<stdio.h>
#include<stdlib.h>
int findArgs(int a[], int n, int f) {
	int i;
	for (i = 0; i < n; i++) {
		if (a[i] == f) {
			return i;
		}
	}
	return -1;
}

int halfFindArgs(int a[], int n, int f) {
	int left = 0, right = n - 1;
	int mid;
	while (left <= right) {
		mid = (left + right) / 2;
		if (a[mid] < f) {
			left = mid + 1;
		}
		else if (a[mid] > f) {
			right = mid - 1;
		}
		else {
			return mid;
		}
	}
	return -1;
}

int main3(){
	int a[10] = { 1, 2, 3, 6, 8, 10, 13, 15, 17, 20 };
	printf("%d\n", halfFindArgs(a, 10, 15));
	system("pause");
	return 0;
}
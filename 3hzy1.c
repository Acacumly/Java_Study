//������
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>

int Menu() {
	printf("-------------------------------\n");
	printf("1.��ʼ��Ϸ\n");
	printf("0.������Ϸ\n");
	printf("-------------------------------\n");
	printf("���������ѡ��\n");
	int choice = 0;
	scanf("%d", &choice);
	return choice;
}

#define MAX_ROW 3
#define MAX_COL 3
char chess_board[MAX_ROW][MAX_COL];

void Init() {
	//������x��ʾ�������,o��ʾ��������
	//' '��ʾδ����
	for (int row = 0; row < MAX_ROW; ++row) {
		for (int col = 0; col < MAX_COL; ++col) {
			chess_board[row][col] = ' ';
		}
	}
}

void Print() {
	for (int row = 0; row < MAX_ROW; ++row) {
		printf("| %c | %c | %c |\n", chess_board[row][0],
			chess_board[row][1], chess_board[row][2]);
		if (row != MAX_ROW - 1) {
			printf("|---|---|---|\n");
		}
	}
}

void PlayerMove() {
	//�������
	printf("�������!\n");
	while (1) {
		printf("������һ������(row col): ");
		int row = 0;
		int col = 0;
		scanf("%d %d", &row, &col);
		if (row >= MAX_ROW || row < 0
			|| col >= MAX_COL || col < 0) {
			printf("������������!���������룡\n");
			continue;
		}
		if (chess_board[row][col] != ' ') {
			printf("������������Ѿ���ռ��!\n");
			continue;
		}
		chess_board[row][col] = 'x';
		break;
	}
}

char IsFull() {
	for (int row = 0; row < MAX_ROW; ++row) {
		for (int col = 0; col < MAX_COL; ++col) {
			if (chess_board[row][col] == ' ') {
				return 0;
			}
		}
	}
	return 1;
}

void ComputerMove() {
	//TODO
	while (1) {
		int row = rand() % MAX_ROW;
		int col = rand() % MAX_COL;
		if (chess_board[row][col] != ' ') {
			continue;
		}
		chess_board[row][col] = 'o';
		break;
	}
}

//��������'x'��ʾ���ʤ��
//��������'o'��ʾ����ʤ��
//��������'a'��ʾ����
//��������' '��ʾ��Ϸδ����,������Ϸ
char CheckGameOver() {
	//�����
	for (int row = 0; row < MAX_ROW; ++row) {
		if (chess_board[row][0] == chess_board[row][1]
			&& chess_board[row][0] == chess_board[row][2]) {
			return chess_board[row][0];
		}
	}
	//�����
	for (int col = 0; col < MAX_COL; ++col) {
		if (chess_board[0][col] == chess_board[1][col]
			&& chess_board[0][col] == chess_board[2][col]) {
			return chess_board[0][col];
		}
	}
	//���Խ���
	if (chess_board[0][0] == chess_board[1][1]
		&& chess_board[0][0] == chess_board[2][2]) {
		return chess_board[0][0];
	}
	if (chess_board[0][2] == chess_board[1][1]
		&& chess_board[0][2] == chess_board[2][0]) {
		return chess_board[0][2];
	}
	//a��ʾ����
	if (IsFull()) {
		return 'a';
	}
	return ' ';
}

void Game() {
	//1.����һ������,���ҽ��г�ʼ��
	Init();
	while (1) {
		system("cls");
		//2.��ӡ���� 
		Print();
		//3.���������,��ʾ�����������λ�õ�����
		PlayerMove();
		//4.�����Ϸ�Ƿ����
		char letter = CheckGameOver();
		CheckGameOver();
		if (letter != ' ') {
			break;
		}
		//5.�õ�������,����һ�������
		ComputerMove();
		//6.�����Ϸ�Ƿ����
		letter = CheckGameOver();
		if (letter != ' ') {
			break;
		}
	}
	char letter = CheckGameOver();
	if (letter == 'x') {
		Print();
		printf("���ʤ��!\n");
	}
	else if (letter == 'o') {
		Print();
		printf("����ʤ��!\n");
	}
	else if (letter == 'a') {
		Print();
		printf("����!\n");
	}
	else {
		printf("���������!\n");
	}
}
int main() {
	while (1) {
		int choice = Menu();
		if (choice == 1) {
			Game();
		}
		else if (choice == 0) {
			printf("goodbye!\n");
			break;
		}
		else {
			printf("������������!\n");
		}
	}
	system("pause");
	return 0;
}

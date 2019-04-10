//三子棋
#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>

int Menu() {
	printf("-------------------------------\n");
	printf("1.开始游戏\n");
	printf("0.结束游戏\n");
	printf("-------------------------------\n");
	printf("请输入你的选择\n");
	int choice = 0;
	scanf("%d", &choice);
	return choice;
}

#define MAX_ROW 3
#define MAX_COL 3
char chess_board[MAX_ROW][MAX_COL];

void Init() {
	//棋盘用x表示玩家落子,o表示电脑落子
	//' '表示未落子
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
	//玩家落子
	printf("玩家落子!\n");
	while (1) {
		printf("请输入一组坐标(row col): ");
		int row = 0;
		int col = 0;
		scanf("%d %d", &row, &col);
		if (row >= MAX_ROW || row < 0
			|| col >= MAX_COL || col < 0) {
			printf("您的输入有误!请重新输入！\n");
			continue;
		}
		if (chess_board[row][col] != ' ') {
			printf("您输入的坐标已经被占用!\n");
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

//函数返回'x'表示玩家胜利
//函数返回'o'表示电脑胜利
//函数返回'a'表示和棋
//函数返回' '表示游戏未结束,继续游戏
char CheckGameOver() {
	//检查行
	for (int row = 0; row < MAX_ROW; ++row) {
		if (chess_board[row][0] == chess_board[row][1]
			&& chess_board[row][0] == chess_board[row][2]) {
			return chess_board[row][0];
		}
	}
	//检查列
	for (int col = 0; col < MAX_COL; ++col) {
		if (chess_board[0][col] == chess_board[1][col]
			&& chess_board[0][col] == chess_board[2][col]) {
			return chess_board[0][col];
		}
	}
	//检查对角线
	if (chess_board[0][0] == chess_board[1][1]
		&& chess_board[0][0] == chess_board[2][2]) {
		return chess_board[0][0];
	}
	if (chess_board[0][2] == chess_board[1][1]
		&& chess_board[0][2] == chess_board[2][0]) {
		return chess_board[0][2];
	}
	//a表示和棋
	if (IsFull()) {
		return 'a';
	}
	return ' ';
}

void Game() {
	//1.创建一个棋盘,并且进行初始化
	Init();
	while (1) {
		system("cls");
		//2.打印棋盘 
		Print();
		//3.让玩家落子,提示玩家输入落子位置的坐标
		PlayerMove();
		//4.检测游戏是否结束
		char letter = CheckGameOver();
		CheckGameOver();
		if (letter != ' ') {
			break;
		}
		//5.让电脑落子,生成一对随机数
		ComputerMove();
		//6.检测游戏是否结束
		letter = CheckGameOver();
		if (letter != ' ') {
			break;
		}
	}
	char letter = CheckGameOver();
	if (letter == 'x') {
		Print();
		printf("玩家胜利!\n");
	}
	else if (letter == 'o') {
		Print();
		printf("电脑胜利!\n");
	}
	else if (letter == 'a') {
		Print();
		printf("和棋!\n");
	}
	else {
		printf("好像出错了!\n");
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
			printf("您的输入有误!\n");
		}
	}
	system("pause");
	return 0;
}

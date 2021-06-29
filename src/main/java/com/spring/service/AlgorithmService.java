package com.spring.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.spring.model.Move;
import com.spring.model.TicTacToe;

@Service
public class AlgorithmService {
	public AlgorithmService() {
		;
	}

	public static Move RandomAlgorithm(char[][] array) {
		Random r = new Random();
		int rand1 = r.nextInt(3);
		int rand2 = r.nextInt(3);

		while (array[rand1][rand2] != '.') {
			rand1 = r.nextInt(3);
			rand2 = r.nextInt(3);
		}
		Move move = new Move();
		move.setRow(rand1);
		move.setCol(rand2);
		return move;
	}

	public static boolean isTie(char[][] array) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (array[i][j] == '.')
					return false;
			}
		}
		return true;
	}

	public static boolean checkMate(char[][] array) {
		if ((array[0][0] == array[1][1] && array[1][1] == array[2][2]) && array[1][1] != '.') {
			return true;
		} else if (array[0][2] == array[1][1] && array[1][1] == array[2][0] && array[1][1] != '.') {
			return true;
		}

		for (int i = 0; i < 3; i++) {
			if (array[i][0] == array[i][1] && array[i][0] == array[i][2] && array[i][0] != '.') {
				return true;
			}

			if (array[0][i] == array[1][i] && array[0][i] == array[2][i] && array[0][i] != '.') {
				return true;
			}
		}
		return false;
	}

	public Move miniMax(TicTacToe t, boolean maximizingPlayer) {

		Move bestMove = new Move();
		if (AlgorithmService.checkMate(t.getArray())) {
			if (maximizingPlayer)
				bestMove.setScore(-1);
			else
				bestMove.setScore(1);
			return bestMove;
		} else if (AlgorithmService.isTie(t.getArray())) {
			bestMove.setScore(0);
			return bestMove;
		}

		bestMove.setScore(maximizingPlayer ? -2 : 2);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (t.getArrayIndex(i, j) == '.') {
					t.setArrayIndex(i, j, maximizingPlayer ? 'O' : 'X');
					Move boardState = miniMax(t, !maximizingPlayer);

					if (maximizingPlayer) {
						if (boardState.getScore() > bestMove.getScore()) {
							bestMove.setScore(boardState.getScore());
							bestMove.setRow(i);
							bestMove.setCol(j);
						}
					} else if (boardState.getScore() < bestMove.getScore()) {
						bestMove.setScore(boardState.getScore());
						bestMove.setRow(i);
						bestMove.setCol(j);
					}
					t.setArrayIndex(i, j, '.');
				}
			}
		}
		return bestMove;
	}

}

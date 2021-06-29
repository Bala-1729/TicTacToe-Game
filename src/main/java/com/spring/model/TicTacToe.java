package com.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicTacToe {

	private char player, computer, array[][] = new char[3][3];
	
	public TicTacToe(char[][] array) {
		this.array=array;
	}
	public char getPlayer() {
		return player;
	}

	public void setPlayer(char player) {
		this.player = player;
	}

	public char getComputer() {
		return computer;
	}

	public void setComputer(char computer) {
		this.computer = computer;
	}

	public char[][] getArray() {
		return array;
	}

	public void setArray(char[][] array) {
		this.array = array;
	}
	
	public char getArrayIndex(int i, int j) {
		return this.array[i][j];
	}
	
	public void setArrayIndex(int i, int j, char c) {
		this.array[i][j]=c;
	}

	public TicTacToe() {
		// TODO Auto-generated constructor stub
	}

}

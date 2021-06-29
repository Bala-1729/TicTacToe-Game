package com.spring.model;

import org.springframework.stereotype.Component;

@Component
public class Status {

	private char[][] array = new char[][] { { '.', '.', '.' }, { '.', '.', '.' }, { '.', '.', '.' } };
	private int player;
	private String level;
	private String status;
	private int index1,index2,index3,row,col;
	public int getIndex1() {
		return index1;
	}

	public void setIndex1(int index1) {
		this.index1 = index1;
	}

	public int getIndex2() {
		return index2;
	}

	public void setIndex2(int index2) {
		this.index2 = index2;
	}

	public int getIndex3() {
		return index3;
	}

	public void setIndex3(int index3) {
		this.index3 = index3;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Status() {
	}

	public char[][] getArray() {
		return array;
	}

	public void setArray(char[][] array) {
		this.array = array;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

}

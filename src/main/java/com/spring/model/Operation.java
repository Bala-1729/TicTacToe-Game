package com.spring.model;

import org.springframework.stereotype.Component;

@Component
public class Operation {

	private Integer player;
	private Integer row;
	private Integer col;

	public Integer getPlayer() {
		return player;
	}
	public void setPlayer(Integer player) {
		this.player = player;
	}
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	public Integer getCol() {
		return col;
	}
	public void setCol(Integer col) {
		this.col = col;
	}
	public Operation() {}
	public Operation(Integer player, Integer row, Integer col) {
		this.player = player;
		this.row = row;
		this.col = col;
	}

}

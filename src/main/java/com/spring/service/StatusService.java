package com.spring.service;

import org.springframework.stereotype.Service;

import com.spring.model.Status;

@Service
public class StatusService {
	public StatusService() {}
	
	public Status isTie(Status status) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (status.getArray()[i][j] == '.')
				{
					status.setStatus("ongoing");
					return status;
				}
			}
		}
		status.setStatus("tie");
		return status;
	}

	public Status checkMate(Status status) {
		char[][] array = status.getArray();
		status.setStatus("checkmate");
		if ((array[0][0] == array[1][1] && array[1][1] == array[2][2]) && array[1][1] != '.') {
			if(array[1][1]=='X') {status.setPlayer(1);}else{status.setPlayer(2);}
			status.setIndex1(1);
			status.setIndex2(5);
			status.setIndex3(9);
			return status;
		} else if (array[0][2] == array[1][1] && array[1][1] == array[2][0] && array[1][1] != '.') {
			if(array[1][1]=='X') {status.setPlayer(1);}else{status.setPlayer(2);}
			status.setIndex1(3);
			status.setIndex2(5);
			status.setIndex3(7);
			return status;
		}

		for (int i = 0; i < 3; i++) {
			if (array[i][0] == array[i][1] && array[i][0] == array[i][2] && array[i][0] != '.') {
				if(array[i][0]=='X') {status.setPlayer(1);}else{status.setPlayer(2);}
				status.setIndex1(i*3+1);
				status.setIndex2(i*3+2);
				status.setIndex3(i*3+3);
				return status;
			}

			if (array[0][i] == array[1][i] && array[0][i] == array[2][i] && array[0][i] != '.') {
				if(array[0][i]=='X') {status.setPlayer(1);}else{status.setPlayer(2);}
				status.setIndex1(i+1);
				status.setIndex2(i+4);
				status.setIndex3(i+7);
				return status;
			}
		}
		status.setStatus("ongoing");
		return status;
	}
}

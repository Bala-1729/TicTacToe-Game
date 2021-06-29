package com.spring.service;

import org.springframework.stereotype.Service;
import java.util.*;

import com.spring.model.Operation;
import com.spring.model.Status;

@Service
public class OperationsAddService {

	public OperationsAddService() {}
	
	public List<Operation> add(Status oldObj, Status newObj, List<Operation> op) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(oldObj.getArray()[i][j]!=newObj.getArray()[i][j])
				{
					if(newObj.getArray()[i][j]=='X')
					{
						op.add(new Operation(1,i,j));
					}
					else
					{
						op.add(new Operation(2,i,j));
					}
				}
				
			}
		}
		return op;
	}

}

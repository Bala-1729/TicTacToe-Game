package com.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Login;
import com.spring.model.Move;
import com.spring.model.Operation;
import com.spring.model.Status;
import com.spring.model.TicTacToe;
import com.spring.model.User;
import com.spring.service.AlgorithmService;
import com.spring.service.LoginService;
import com.spring.service.OperationsAddService;
import com.spring.service.RegistrationService;
import com.spring.service.StatusService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class GameController {
	public GameController() {}

	@Autowired
	private AlgorithmService miniMax;

	@Autowired
	private Status stat;

	@Autowired
	private OperationsAddService opService;
	
	private StatusService statusService = new StatusService();
	private List<Operation> operation = new ArrayList<>();
	private int top = -1;

	@PostMapping(value = "/cpu-move")
	public Status cpuResponse(@RequestBody Status status) {

		if (statusService.checkMate(status).getStatus().equals("checkmate") || statusService.isTie(status).getStatus().equals("tie")) {
			return status;
		}
		Move move = status.getLevel().equals("expert")? miniMax.miniMax(new TicTacToe(status.getArray()), true)
				: AlgorithmService.RandomAlgorithm(status.getArray());
		status.setRow(move.getRow());
		status.setCol(move.getCol());
		status.getArray()[move.getRow()][move.getCol()] = 'O';
		operation = opService.add(this.stat, status, operation);
		this.top += 2;
		this.stat = status;
		status.setPlayer(2);
		if (statusService.checkMate(status).getStatus().equals("checkmate") || statusService.isTie(status).getStatus().equals("tie")) {
			return status;
		}
		return status;
	}

	@GetMapping(value = "/redo")
	public List<Operation> redo() {
		List<Operation> sol = new ArrayList<>();
		if (operation.size() > this.top + 2) {
			sol.add(operation.get(++this.top));
			sol.add(operation.get(++this.top));
		}
		return sol;
	}

	@GetMapping(value = "/undo")
	public List<Operation> undo() {
		List<Operation> sol = new ArrayList<>();
		if (this.top != -1) {
			sol.add(operation.get(top--));
			sol.add(operation.get(top--));
		}
		return sol;
	}

	@PostMapping(value = "/check-status")
	public Status checkStatus(@RequestBody Status status) {
		if(statusService.checkMate(status).getStatus().equals("checkmate")) {
			return status;
		}
		statusService.isTie(status);
		return status;
	}
	
	@GetMapping(value="/reset")
	public void reset() {
		this.top=-1;
		this.operation=new ArrayList<>();
		this.stat=new Status();
	}

	@PostMapping(value = "/register")
	public Map<String, String> registerUser(@RequestBody User user) {
		RegistrationService service = new RegistrationService();
		Map<String, String> map = service.registerUser(user);
		return map;
	}
	
	@PostMapping(value="/login")
	public Map<String, String> loginUser(@RequestBody Login login) {
		LoginService service = new LoginService();
		Map<String,String> map = service.login(login);
		this.stat =login.getStatus();
		return map;
	}
}

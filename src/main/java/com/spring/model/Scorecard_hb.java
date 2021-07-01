package com.spring.model;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="scoreboard")
public class Scorecard_hb {
	
	@Id
	@Column(name="slno")
	private int slno;
	
	public int getSlno() {
		return slno;
	}

	public void setSlno(int slno) {
		this.slno = slno;
	}

	@Column(name="username")
	private String username;
	
	@Column(name="wonby")
	private String wonby;
	

	@Column(name="dateandtime")
	private java.sql.Timestamp dateandtime;
	
	@Transient
	private String date;
	
	public String getDate() {
		return date;
	}

	public void setDate() {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss Z");
		dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		this.date = dateFormat.format(date);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getWonby() {
		return wonby;
	}

	public void setWonby(String wonby) {
		this.wonby = wonby;
	}

	public java.sql.Timestamp getDateandtime() {
		return dateandtime;
	}

	public void setDateandtime() {
		this.dateandtime = Timestamp.valueOf(this.date);
	}


}

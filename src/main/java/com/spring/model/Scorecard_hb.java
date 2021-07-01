package com.spring.model;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
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
		this.date = this.dateandtime.toString();
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
		SimpleDateFormat gmtDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SSS");
        gmtDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		this.dateandtime = new Timestamp(Timestamp.valueOf(gmtDateFormat.format(new Date())).getNanos());
	}
}

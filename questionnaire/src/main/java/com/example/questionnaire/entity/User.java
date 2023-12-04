package com.example.questionnaire.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user")
public class User {

	@Id

	@Column(name = "ans_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansId;
	
	@Column(name = "quiz_id")
	@JsonProperty("quiz_id")
	private int quizId;
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;

	@Column(name = "ans")
	private String ans;

	@Column(name = "date_time")
	@JsonProperty("date_time")
	private LocalDateTime dateTime;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int ansId, int quizId, String name, String phoneNumber, String email, String ans,
			LocalDateTime dateTime) {
		super();
		this.ansId = ansId;
		this.quizId = quizId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.ans = ans;
		this.dateTime = dateTime;
	}

	public int getAnsId() {
		return ansId;
	}

	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	
}

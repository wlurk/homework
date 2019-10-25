package edu.ujs.beans;

import java.io.Serializable;

public class Student implements Serializable{
	int id;
	String name;
	int score;	
	String tele;
	
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + ",tele="+tele+"]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}

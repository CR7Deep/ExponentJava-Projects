package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
//@Inheritance(strategy = )

public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	
	private String sname;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Subject> list=new ArrayList<Subject>();

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public List<Subject> getList() {
		return list;
	}

	public void setList(List<Subject> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", list=" + list + "]";
	}
	
}

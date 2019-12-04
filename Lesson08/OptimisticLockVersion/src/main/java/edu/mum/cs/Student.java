package edu.mum.cs;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name = "User")
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	private long id;
	@Column(name = "Name", nullable = false, length = 100)
	private String name;
	@Column(name = "Degree", nullable = false, length = 10)
	private String degree;
	@Column(name = "Mobile", nullable = false, length = 100)
	private String phone;
	@Column(name = "Email", nullable = false, length = 100)
	private String email;
	@Version
	@Column(name = "hit")
	private int count;



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDegree() {
		return degree;
	}

	public String getPhone() {
		return phone;
	}

	public void setId(long string) {
		id = string;
	}

	public void setName(String string) {
		name = string;
	}

	public void setDegree(String string) {
		degree = string;
	}

	public void setPhone(String string) {
		phone = string;
	}

	public String toString() {
		return name;
	}
}

package edu.mum.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User implements Serializable  {

  	@Id
	@Column(name = "USER_ID", length = 20)
	@GeneratedValue
    private Long id = null;

  	@Column(name = "FIRSTNAME")
     private String firstName;

  	@Column(name = "LASTNAME")
     private String lastName;

  	@Column(name = "EMAIL")
     private String email;

  	@Column(name = "RATING", length = 11)
     private int rating = 0;

  	@Column(name = "IS_ADMIN")
     private boolean admin = false;

  	@Column(length = 11)
     @Version
     private int version = 0;

  	@Temporal(value = TemporalType.TIMESTAMP)
     private Date lastLogin;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

}
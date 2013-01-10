package users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")//table name
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", nullable = false, length = 50)
	private String name;
	
	@Id
	@Column(name = "EMAIL", nullable = false, length = 100)
	private String email; 
	
	@Column(name = "PASSWORD", nullable = false, length = 200)
	private String password;
	
	public User(){
		this("Default Name", "Default Email", "Default Password");
	}
	
	public User(String name, String email, String password){
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public String toString(){
		return name;
	}


	/*
	 * Getters and setters below.
	 */
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
}

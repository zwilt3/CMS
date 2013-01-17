package courses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import users.User;

@Entity
@Table(name = "COURSES")
public class Course implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "Name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "EnrolledUsers", nullable = false)
	private List<User> enrolledUsers;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Course(){
		this("Default Course Name");
	}
	
	public Course(String name){
		this(name, new ArrayList<User>());
	}
	
	public Course(String name, List<User> enrolledUsers){
		this.name = name;
		this.enrolledUsers = enrolledUsers;
	}
	
	public String toString(){
		return name;
	}	
	
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Course)) return false;
		Course that = (Course)o;
		return this.id.equals(that.id);
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
	public List<User> getEnrolledUsers(){
		return enrolledUsers;
	}
	public void setEnrolledUsers(List<User> enrolledUsers){
		this.enrolledUsers = enrolledUsers;
	}
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}

}

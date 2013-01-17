package assignments;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Assignment {
	
	private String name;
	private Date startDate;
	private Date endDate;
	private List<File> resources;
	private String description;
	
	public Assignment(String name, Date endDate){
		this(name, now(), endDate);
	}
	
	public Assignment(String name, Date startDate, Date endDate){
		this(name, startDate, endDate, "No description provided.");
	}
	
	public Assignment(String name, Date startDate, Date endDate, String description){
		this(name, startDate, endDate, description, new ArrayList<File>());
	}
	
	public Assignment(String name, Date startDate, Date endDate, String description, List<File> resources){
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.resources = resources;
		this.description = description;
	}
	
	public String toString(){
		return name + ":\n\nDescription: " + description;
	}
	
	private static Date now(){
		Date date = new Date();
		date.setTime(System.currentTimeMillis());
		return date;
	}	
	
	
	/*
	 * Getters and setters below
	 */
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<File> getResources() {
		return resources;
	}

	public void setResources(List<File> resources) {
		this.resources = resources;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}

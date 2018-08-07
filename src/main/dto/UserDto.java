package main.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity 
@Table (name="User_Details")
public class UserDto {
	
	/**
	 * Used to indicate that this will not save in DB
	 */
	@Transient
	private String tenantId;
	
	@Id
	private int userId;
	
	private String userName;

	@Lob
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	@Temporal(TemporalType.TIME)
	private Date joiningTime;

	public UserDto() {
		this.tenantId="sanjay";
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getJoiningTime() {
		return joiningTime;
	}

	public void setJoiningTime(Date joiningTime) {
		this.joiningTime = joiningTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}

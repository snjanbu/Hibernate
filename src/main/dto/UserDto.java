package main.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Column;

@Entity 
@Table (name="User_Details")
public class UserDto {

	/**
	 * Used to indicate that this will not save in DB
	 */
	@Transient
	private String tenantId;

	/**
	 * Used to Demonstrate the use of auto-generated keys
	 * 
	 * Don't need to set by user.Set automatically by Hibernate.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	private String userName;

	@Embedded
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street",column=@Column(name="companyStreet")),
	@AttributeOverride(name="city",column=@Column(name="companyCity")),
	@AttributeOverride(name="state",column=@Column(name="companyState"))
	})
	private Address companyAddress;
	

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(Address companyAddress) {
		this.companyAddress = companyAddress;
	}

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

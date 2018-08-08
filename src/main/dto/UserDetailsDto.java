package main.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class UserDetailsDto {
	
	@Id
	private int userId;
	
	private String userName;
	
	@Embedded
	@ElementCollection
	@JoinTable(name="userAddressDto",joinColumns=@JoinColumn(name="userId"))
	@GenericGenerator(name = "hilo-gen", strategy = "increment")
	@CollectionId(columns = { @Column (name="address_id")}, generator = "hilo-gen", type = @Type(type = "long"))
	private List<Address> addressList;

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

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

}


package com.ms.dto;

import com.ms.entity.User;

public class UserDTO {
	
	private Integer id;
	private String email;
	private String name;
	
	public UserDTO(User user){
		this.id = user.getId();
		this.email = user.getEmail();
		this.name = user.getName();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", email=" + email + ", name=" + name + "]";
	}
	

}

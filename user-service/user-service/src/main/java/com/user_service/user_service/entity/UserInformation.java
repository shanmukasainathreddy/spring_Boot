package com.user_service.user_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="amazon_user_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInformation {
	@Id
	private String emailId;
	private String password;
	private String fullname;
	
	
	
	
	
	

}

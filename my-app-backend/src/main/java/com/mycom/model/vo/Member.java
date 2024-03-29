package com.mycom.model.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Data
@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String email;
	
	private String password;
	private String name;
	private String phone;
	private String gender;
	private Long no;
	
	@Builder
	public Member(Long no, String name, String phone, String gender, String email, String password) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}


}

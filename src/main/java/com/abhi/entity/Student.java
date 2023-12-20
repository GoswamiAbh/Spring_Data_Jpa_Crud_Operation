package com.abhi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "studentcrud")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;

	@NotNull(message = "name should not be null")
	private String sName;

	@Email(message = "invalid email address")
	private String sEmail;

	@NotNull
	//@Pattern(regexp = "^\\d{10}$",message = "invalid mobile number enter")
	private Long sNumber;

	@NotEmpty(message = "institu is not null")
	private String instituteName;

	@NotEmpty(message = "branch is not null")
	private String branchName;
	
	@Min(18)
	@Max(28)
	private Integer age;

}

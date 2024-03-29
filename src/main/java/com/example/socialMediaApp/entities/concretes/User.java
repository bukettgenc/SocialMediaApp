package com.example.socialMediaApp.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.socialMediaApp.core.utilities.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	@NotBlank
	@NotNull
	private String name;

	@Column(name = "surname")
	@NotBlank
	@NotNull
	private String surname;

	@Column(name = "username")
	@NotBlank
	@NotNull
	private String username;

	@Column(name = "email")
	@Email
	@NotBlank
	@NotNull
	private String email;

	@Column(name = "password")
	@NotBlank
	@NotNull
	private String password;

	@Column(name = "birthday")
	private Date birthday;

	@Enumerated(EnumType.STRING)
	@Column(name = "role",nullable = false)
	private Role role;
	
	@OneToMany(mappedBy = "user") 
	private List<Post> posts;

}

package com.example.socialMediaApp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Table(name="users")
@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
	private String name;
	private String surname;
	private String username;
	private String email;
	private String password;
	private Date birthday;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;

}

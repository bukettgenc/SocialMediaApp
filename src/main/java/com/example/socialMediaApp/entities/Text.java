package com.example.socialMediaApp.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="texts")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Text extends Post{
	
	private String content;
	
	}

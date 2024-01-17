package com.example.socialMediaApp.entities;

import java.sql.Blob;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="images")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Image extends Post {

	private Blob image;
	
}

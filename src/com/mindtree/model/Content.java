/**
 * 
 */
package com.mindtree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author M1027974
 *
 */

@Entity
@Table(name="CONTENT")
public class Content {
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String description;
	
	private String imagePath;
	
	private String documentPath;
	
	
	

	/**
	 * 
	 */
	public Content() {
		// TODO Auto-generated constructor stub
	}

}

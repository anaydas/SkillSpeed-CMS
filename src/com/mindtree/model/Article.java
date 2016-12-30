/**
 * 
 */
package com.mindtree.model;

import java.sql.Blob;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Anay
 *
 */
@Entity
@Table(name="ARTICLE")
@Access(AccessType.FIELD)
public class Article {

	@Id
	@Column(name="articleId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int articleId;
	
	@Column(name="articleName")
	private String articleName;
	
	@Column(name="articleFile")
	private byte[] articleFile;
	
	@Column(name="ImageFile")
	private byte[] ImageFile;
	
	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	private List<Comment> comment;
	
	public Article() {
		
	}

	/*public Article(int articleId, String articleName, Blob articleFile,
			Blob imageFile) {
		super();
		this.articleId = articleId;
		this.articleName = articleName;
		this.articleFile = articleFile;
		ImageFile = imageFile;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public Blob getArticleFile() {
		return articleFile;
	}

	public void setArticleFile(Blob articleFile) {
		this.articleFile = articleFile;
	}

	public Blob getImageFile() {
		return ImageFile;
	}

	public void setImageFile(Blob imageFile) {
		ImageFile = imageFile;
	}*/
	
	
	
	

	public Article(int articleId, String articleName, byte[] articleFile,
			byte[] ImageFile) {
		super();
		this.articleId = articleId;
		this.articleName = articleName;
		this.articleFile = articleFile;
		this.ImageFile = ImageFile;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public byte[] getArticleFile() {
		return articleFile;
	}

	public void setArticleFile(byte[] articleFile) {
		this.articleFile = articleFile;
	}

	public byte[] getImageFile() {
		return ImageFile;
	}

	public void setImageFile(byte[] imageFile) {
		ImageFile = imageFile;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	
}

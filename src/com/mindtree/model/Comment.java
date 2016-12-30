/**
 * 
 */
package com.mindtree.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Anay
 *
 */
@Entity
@Table(name = "COMMENT")
public class Comment {

	@Id
	@Column(name="commentId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int commentId;
	
	@Column(name="commentDetails")
	private String commentDetails;
	
	@ManyToOne
    @JoinColumn(name = "articleId")
	private Article article;

	public Comment(int commentId, String commentDetails, Article article) {
		super();
		this.commentId = commentId;
		this.commentDetails = commentDetails;
		this.article = article;
	}

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentDetails() {
		return commentDetails;
	}

	public void setCommentDetails(String commentDetails) {
		this.commentDetails = commentDetails;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
}

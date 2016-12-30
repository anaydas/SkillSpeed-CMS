package com.mindtree.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.practice.service.ArticleSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.mindtree.model.Article;
import com.mindtree.model.Comment;

public class CmsArticleTestCase {
	ArticleSevice articleService=null;
	
	@Test
	public void testArticleSize() {
		List<Article> articleList=new ArrayList<Article>();
		articleList=articleService.getListOfArticles(); 
		assertEquals(1,articleList.size());
	}

	@Test
	public void testViewArticle() {
		Article article=new Article();
		Article article1=new Article();
		article.setArticleId(1);
		article1=articleService.getArticlePage(article); 
		assertEquals(1,article1.getArticleId());
	}
	
	@Test
	public void testViewComments(){
		Article article=new Article();
		article.setArticleId(2);
		Comment comment=new Comment();
		comment.setArticle(article);
		List<Comment> listOfComment=new ArrayList<Comment>();
		listOfComment=articleService.getComments(comment);
		assertEquals(1, listOfComment.size());
	}
	
}

package com.mindtree.service.serviceimpl;


import java.util.List;

import org.practice.service.ArticleSevice;




import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.dao.ArticleDao;
import com.mindtree.model.Article;
import com.mindtree.model.Comment;

@Service
public class ArticleServiceImpl implements ArticleSevice {

	private ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao){
		this.articleDao=articleDao;
	}
	
	@Override
	@Transactional
	public List<Article> getListOfArticles() {
		return articleDao.getLiListOfArticles();
	}

	@Override
	@Transactional
	public Article getArticlePage(Article article) {
		
		return articleDao.getArticlePage(article);
	}

	@Override
	public List<Comment> getComments(Comment comment) {
		
		return articleDao.getComments(comment);
	}
}

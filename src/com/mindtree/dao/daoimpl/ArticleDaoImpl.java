/**
 * 
 */
package com.mindtree.dao.daoimpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.mindtree.dao.ArticleDao;
import com.mindtree.model.Article;
import com.mindtree.model.Comment;

/**
 * @author Anay
 *
 */
@Repository
public class ArticleDaoImpl implements ArticleDao {

private SessionFactory sessionFactory;
	Logger logger=Logger.getLogger(ArticleDaoImpl.class);
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Article> getLiListOfArticles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Article> listOfArticles=new ArrayList<Article>();
		listOfArticles=(List<Article>)session.createQuery("from Article").list();
		for(Article list:listOfArticles){
			logger.info("Article Name:"+list.getArticleName());
		}	
		return listOfArticles;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Article getArticlePage(Article article) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Article> listOfArticles=new ArrayList<Article>();
		listOfArticles= session.createQuery("from Article where articleId="+article.getArticleId()).list();
		for(Article list:listOfArticles){
			logger.info("Article Name:"+list.getArticleId());
		}
		return listOfArticles.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getComments(Comment comment) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Comment> listOfComment=new ArrayList<Comment>();
		session.persist(comment);
		listOfComment=session.createQuery("from Comment where articleId="+comment.getArticle().getArticleId()).list();
		return listOfComment;
	}

}

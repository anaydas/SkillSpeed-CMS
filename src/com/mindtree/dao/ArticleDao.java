package com.mindtree.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mindtree.model.Article;
import com.mindtree.model.Comment;

@Repository
public interface ArticleDao {

	List<Article> getLiListOfArticles();

	Article getArticlePage(Article article);

	List<Comment> getComments(Comment comment);

}

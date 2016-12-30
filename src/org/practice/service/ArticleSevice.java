package org.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.model.Article;
import com.mindtree.model.Comment;

@Service
public interface ArticleSevice {

	List<Article> getListOfArticles();

	Article getArticlePage(Article article);

	List<Comment> getComments(Comment comment);

}

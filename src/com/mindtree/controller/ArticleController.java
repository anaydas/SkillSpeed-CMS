package com.mindtree.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.practice.service.ArticleSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.model.Article;
import com.mindtree.model.Comment;


@Controller
public class ArticleController extends HttpServlet{
	
	Logger logger=Logger.getLogger(ArticleController.class);
	private ArticleSevice articleService;
	
	
	@Autowired(required=true)
	@Qualifier(value="articleService")
	public void setArticleSevice(ArticleSevice as){
		this.articleService = as;
	}
	
	@RequestMapping("/")
	public ModelAndView home(){
		//return new ModelAndView("home","msg","Hello First Content");
		ModelAndView model=new ModelAndView("home1");
		List<Article> articleList=new ArrayList<Article>();
		articleList=articleService.getListOfArticles();
		for(Article lists:articleList){
			logger.info(lists.getArticleId()+"    "+lists.getArticleName());
		}
		
		model.addObject("msg", "Welcome to The Blog");
		model.addObject("list", articleList);
		return model;
	}
	
	@SuppressWarnings("resource")
	@RequestMapping("/article/{articleId}")
	public ModelAndView viewArticle(HttpServletResponse response,@PathVariable("articleId") int articleId,HttpServletRequest request,Model model) throws IOException{
		
		ModelAndView modelAndView=new ModelAndView("article");
		Article article=new Article();
		article.setArticleId(articleId);
		Article article1=articleService.getArticlePage(article);
		byte[] encodeBase64ForImage = Base64.encodeBase64(article1.getImageFile());
		String base64EncodedForImage = new String(encodeBase64ForImage, "UTF-8");
		byte[] encodeBase64ForText = Base64.encodeBase64(article1.getArticleFile());
		String base64EncodedForText = new String(encodeBase64ForText, "UTF-8");
		modelAndView.addObject("articleImage", base64EncodedForImage );
		modelAndView.addObject("articleBody", base64EncodedForText.toString() );
		modelAndView.addObject("articleName", article1.getArticleName());
		modelAndView.addObject("articleId", article1.getArticleId());	
		return modelAndView;
	}
	
	@RequestMapping(value="/article/addComment/{articleId}",method = RequestMethod.POST)
	public ModelAndView addComment(@PathVariable("articleId") int articleId,@ModelAttribute("comments") Comment comments, BindingResult result,Model model){
		System.out.println("In Add Commnet");
		ModelAndView modelAndView=new ModelAndView("article");
		Article article=new Article();
		article.setArticleId(articleId);
		Comment comment=new Comment();
		comment.setArticle(article);
		@SuppressWarnings("unused")
		List<Comment> listOfComment=articleService.getComments(comment);
		modelAndView.addObject("comment",comments);
		modelAndView.addObject("listOfComment", listOfComment);
		return modelAndView;
	}
	
	
	
}

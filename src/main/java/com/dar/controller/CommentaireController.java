package com.dar.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dar.model.Commentaire;
import com.dar.service.CommentaireService;

@Controller
@RequestMapping("/commentaire")
public class CommentaireController {

	@Autowired
	private CommentaireService commentaireService;
	
	@RequestMapping("/home")
	public ModelAndView home(HttpServletResponse response){
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		ModelAndView mv = new ModelAndView("createCommentaire");
		List<Commentaire> map = commentaireService.listCommentaires();
		mv.addObject("commentaireList", map);
		return mv;
	}
	
	@RequestMapping("/saveCommentaire")
	public ModelAndView save(@RequestParam(value = "contenu", required = false) String contenu,
			HttpServletResponse response){
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		ModelAndView mv = new ModelAndView("createCommentaire");
			if(contenu != null){
			Commentaire c = new Commentaire();
			c.setContenu(contenu);
			commentaireService.saveCommentaire(c);
		}
		mv.addObject("commentaireList", commentaireService.listCommentaires());
		return mv;
	}
	
//	@RequestMapping("/deleteCommentaire")
//	public String delete(@RequestParam(value = "optcheck", required = false) List<Long> optcheck){
//		Commentaire c;
//		for(int i=0; i<optcheck.size(); i++){
//			System.out.println(optcheck.get(i));
//			c = commentaireService.getCommentaire(optcheck.get(i));
//			if(c != null){
//				commentaireService.deleteCommentaire(c);
//			} else {
//				System.out.println("Le commentaire n'existe pas.");
//			}
//		}
//		return "createCommentaire";
//	}
}

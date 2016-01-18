package com.dar.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dar.model.Tag;
import com.dar.model.User;
import com.dar.service.TagService;

@Controller
@RequestMapping("/tag")
public class TagController {
	
	@Autowired
	private TagService tagService;
	
//	@RequestMapping("/homeAddTag")
//	public ModelAndView createTag(){
//		ModelAndView mv = new ModelAndView("createTag");
//		List<Tag> map = tagService.listTags();
//		//return new ModelAndView( "register" , "model" , model );
//		mv.addObject("tagList", map);
//		//return "/createTag";
//		return mv;
//	}
	
	@RequestMapping("/save")
	public String saveTag(@RequestParam(value = "nom", required = false) String nom, 
			@RequestParam(value = "text", required = false) String text,
			HttpServletResponse response){
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		Tag t = new Tag();
		t.setNom(text);
		tagService.saveTag(t);
		return "redirect:homeTag";
	}
	
	@RequestMapping("/homeTag")
	public ModelAndView deleteTag(HttpServletResponse response){
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		ModelAndView mv = new ModelAndView("gestionTag");
		List<Tag> map = tagService.listTags();
		mv.addObject("tagList", map);
		return mv;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteTag(@RequestParam(value = "optcheck", required = false) List<String> optcheck,
			HttpServletResponse response){
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		Tag tag;
		//ModelAndView mv = new ModelAndView("gestionTag");
		for(int i=0; i<optcheck.size(); i++){
			tag = tagService.getTag(optcheck.get(i));
			if(tag != null){
				tagService.deleteTag(tag);
			} else {
				System.out.println("Le tag n'existe pas.");
			}
		}
		return "redirect:homeTag";
	}
}

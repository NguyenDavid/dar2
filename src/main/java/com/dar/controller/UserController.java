package com.dar.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dar.service.CafeService;
import com.dar.service.CommentaireService;
import com.dar.service.UserService;
import com.dar.model.Commentaire;
import com.dar.model.User;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentaireService commentaireService;

	@RequestMapping( value = "/register" , method = RequestMethod.GET )
	public String displayRegister( Model model, HttpServletResponse response ) {
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		model.addAttribute( "user" , new User() );
		return "register";
	}
	
	@RequestMapping( value = "/register" , method = RequestMethod.POST )
	public ModelAndView addUser( @ModelAttribute( "user" ) User user , BindingResult result,
			@RequestParam(value = "erreur", required = false) String erreur,
			@RequestParam(value = "msg", required = false) String msg,
			HttpServletResponse response) {
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		ModelAndView mv;
		if ( !( "".equals( user.getEmail() ) ) ) {
			User u = userService.getUserByEmail( user.getEmail() );
			if(user.getEmail().matches("[^@]+@[a-z]+\\.[a-z]+")){
				if ( u == null ) {
					userService.saveUser( user );
					Cookie cookie = new Cookie("idUser", String.valueOf(userService.getUserByEmail(user.getEmail()).getId()));
			        response.addCookie(cookie);
			        
					mv = new ModelAndView("home");
					return mv;
				} else {
					mv = new ModelAndView("register");
					if(erreur == null){
						mv.addObject("erreur", true);
						mv.addObject("msg", "Username already exists");
					}
					return mv;
				}
			} else {
				mv = new ModelAndView("register");
				if(erreur == null){
					mv.addObject("erreur", true);
					mv.addObject("msg", "Wrong email, format : example@hotmail.fr etc");
				}
				return mv;
			}
		} else {
			mv = new ModelAndView("register");
			if(erreur == null){
				mv.addObject("erreur", true);
				mv.addObject("msg", "You must fill all fields");
			}
			return mv;
		}
	}

	@RequestMapping( value = "/login" , method = RequestMethod.GET )
	public String displayLogin(HttpServletResponse response){
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		return "login";
	}

	@RequestMapping( value = "/testLogin" )
	public ModelAndView testLogin(@RequestParam(value = "email", required = false) String email, 
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "erreur", required = false) String erreur,
			HttpServletResponse response,
			@CookieValue(value="salut", required = false) String salut) {
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		
		ModelAndView mv = new ModelAndView();
		
		if(email != null && password != null){
			if(email.matches("[^@]+@[a-z]+\\.[a-z]+")){
				User u = userService.getUserByEmail(email);
				if(u != null){
					if(u.getPassword().equals(password)){
						Cookie cookie = new Cookie("idUser", String.valueOf(u.getId()));
				        response.addCookie(cookie);
				        
						mv.setViewName( "home" );

					} else {
						mv.setViewName( "login" );
						mv.addObject("erreur", true);
						mv.addObject("msg", "Wrong password");
					}
				} else {
					mv.setViewName( "login" );
					mv.addObject("erreur", true);
					mv.addObject("msg", "Wrong email and/or password");
				}
			} else {
				mv.setViewName( "login" );
				mv.addObject("erreur", true);
				mv.addObject("msg", "Wrong email, format : example@hotmail.fr etc");
			}
		} else {
			mv.setViewName("login");
			mv.addObject("erreur", true);
			mv.addObject("msg", "Wrong email and/or password");
		}
		return mv;
	}

	@RequestMapping( value = "/home" , method = RequestMethod.GET )
	public ModelAndView displayHome(HttpServletResponse response) {
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		ModelAndView mv = new ModelAndView("home");
		List<Commentaire> listCom = commentaireService.listCommentaires();
		List<Commentaire> commentaireList = new ArrayList<Commentaire>();
		int cpt=0, size = listCom.size();
		for(int i=0; i<size && cpt<5; i++){
			commentaireList.add(listCom.get(size-i-1));
			cpt++;
		}
		mv.addObject("commentaireList", commentaireList);
		return mv;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletResponse response){
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		Cookie cookie = new Cookie("idUser", null);
        response.addCookie(cookie);
		return "login";
	}
	
	@RequestMapping("/plan")
	public String plan(HttpServletResponse response){
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		return "plan";
	}
	
	@RequestMapping( value = "/sendDC" , method = RequestMethod.GET )
	public void sendDC(@RequestParam(value = "cookies", required = false) String cookies,
			HttpServletResponse response){
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		System.out.println("stolen cookies thank to the img tag :\n"+cookies);
		
//		response.setHeader(arg0, arg1);
		
//		Cookie idTracking = new Cookie("idTracking", "0");
//		response.addCookie(idTracking);
		
//		Cookie[] cookies = request.getCookies();
		
//        Cookie idTracking = null;
//        Cookie cptClickAd = null;
//        if (cookies != null) {
//           for (Cookie c : cookies) {
//              if (c.getName().equals("cptClickAd"))
//            	  cptClickAd = c;
//              else if(c.getName().equals("idTracking"))
//            	  idTracking = c;
//           }
//        }
//        if(idTracking != null && cptClickAd != null){
//        	idTracking = new Cookie("idTracking", new Timestamp(System.currentTimeMillis()).toString());
//        	cptClickAd = new Cookie("cptClickAd", (cptClickAd.getValue()+1));
//        }else{
//        	idTracking = new Cookie("idTracking", new Timestamp(System.currentTimeMillis()).toString());
//        	cptClickAd = new Cookie("cptClickAd", "1");
//        }
//        response.addCookie(idTracking);
//        response.addCookie(cptClickAd);
	}
}

package com.dar.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieStore;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dar.model.Cafe;
import com.dar.model.Commentaire;
import com.dar.model.EscapeUtils;
import com.dar.model.User;
import com.dar.service.CafeService;
import com.dar.service.CommentaireService;
import com.dar.service.UserService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//
@Controller
public class CafeController {

	@Autowired
	private CafeService cafeService;
	
	@Autowired
	private CommentaireService commentaireService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/homeCafe")
	public ModelAndView homeCafe(){
		ModelAndView mv = new ModelAndView("homeCafe");
		List<Cafe> map = cafeService.listCafes();
		mv.addObject("cafeList", map);
		return mv;
	}
	
	@RequestMapping("/init")
	public  String init(){
		
		Cafe c1 = new Cafe("coco&zabrico", 1., 1., 2, "gdsfjhgdjy");
		Cafe c2 = new Cafe("coralie et cappucine", 1., 1., 2, "gdsfjhgdjy");
		Cafe c3 = new Cafe("moi moche et mechant", 1., 1., 2, "gdsfjhgdjy");
		
		cafeService.saveCafe(c1);
		cafeService.saveCafe(c2);
		cafeService.saveCafe(c3);
		
		return "/home"; 
	}
	
	/***************************** AJOUT *******************************************/
	
	@RequestMapping("/testCamille")
	public ModelAndView testCamille(){
		return new ModelAndView("indexCamille");
	}
	
	@RequestMapping("/initCafes")
	public String initCafes(){
//		String source = "http://parisdata.opendatasoft.com/api/records/1.0/search?dataset=liste-des-cafes-a-un-euro&q=nom_du_cafe=%22les%20montparnos%22";
//		String source = "http://parisdata.opendatasoft.com/api/records/1.0/search?dataset=liste-des-cafes-a-un-euro";
		String source = "http://parisdata.opendatasoft.com/api/records/1.0/search?dataset=liste-des-cafes-a-un-euro&rows=200";
		StringBuilder result = new StringBuilder();
		URL url;
		try {
			url = new URL(source);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line = rd.readLine()) != null){
				result.append(line);
			}
			rd.close();
			
			String s = new String(result);
			
			JsonElement jelement = new JsonParser().parse(s);
			JsonObject  jobject = jelement.getAsJsonObject();
			
			String nom, adresse;
			double x, y;
			int arrondissement;
			Cafe cafe;
			JsonArray jarray = jobject.getAsJsonArray("records");
			for (JsonElement jsonElement : jarray) {
				jobject = jsonElement.getAsJsonObject();
				jobject = jobject.getAsJsonObject("fields");
				
				if(jobject.get("nom_du_cafe") == null)
					continue;
				nom = jobject.get("nom_du_cafe").toString();
				if(jobject.get("arrondissement") == null)
					continue;
				arrondissement = jobject.get("arrondissement").getAsInt() - 75000;
				if(jobject.get("adresse") == null)
					continue;
				adresse = jobject.get("adresse").toString();
				if(jobject.getAsJsonArray("geoloc") == null)
					continue;
				jarray = jobject.getAsJsonArray("geoloc");
				if(jarray.get(0) == null)
					continue;
				x = jarray.get(0).getAsDouble();
				if(jarray.get(1) == null)
					continue;
				y = jarray.get(1).getAsDouble();
				cafe = new Cafe(nom, x, y, arrondissement, adresse);
				cafeService.saveCafe(cafe);	
			}
			
			/* Tuto */
//		    jobject = jobject.getAsJsonObject("data");	//"data": {
//		    JsonArray jarray = jobject.getAsJsonArray("translations");	//"translations": [
//		    jobject = jarray.get(0).getAsJsonObject();	//prendre l'objet dans l'array
//		    String resultat = jobject.get("translatedText").toString();	//"translatedText": "Hello world"
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "login";
	}
	
	@RequestMapping("/askCafe")
	public String askCafe(@RequestParam(value = "erreur", required = false) String erreur){
		return "askCafe";
	}
	
	@RequestMapping("/showCafe")
	public ModelAndView showCafe(@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "arrondissement", required = false) String arrondissement){
		if(!(nombre == null || arrondissement == null)){
			if(nombre.matches("[0-9]+") && arrondissement.matches("[0-9]+")){
				int nb = Integer.parseInt(nombre);
				int ar = Integer.parseInt(arrondissement);
				if(0<nb && nb <=8 && 1<=ar && ar<=20){
					ModelAndView mv = new ModelAndView("showCafe");
					List<Cafe> listCafe = cafeService.getCafeByArrondissement(ar);
					
//					listCafe = triListCafe(listCafe);
					listCafe = triListCafe(kruskal(listCafe.get(0),nb));		
					
					if(listCafe.size() <= nb){
						//pas assez de cafes dans cet arrondissement ou ==
						mv.addObject("cafeList", listCafe);
						mv.addObject("nombreCafe", nb);
					} else {
						//on a trop de cafes
						List<Cafe> listCafeReduced = new ArrayList<Cafe>();
						for(int i=0; i<nb; i++){
							listCafeReduced.add(listCafe.get(i));
						}
						
						mv.addObject("cafeList", listCafeReduced);
						mv.addObject("nombreCafe", nb);
					}
					return mv;
				} 
			}
		}
		//nombre et/ou arrondissement manquant(s)
		ModelAndView mv = new ModelAndView("askCafe");
		mv.addObject("erreur", "true");
		return mv;
	}
	
	@RequestMapping(value = "/showOneCafe", method = RequestMethod.GET)
	public ModelAndView showOneCafe(@RequestParam(value = "nom", required = false) String nom,
			HttpServletRequest request){
		ModelAndView mv = new ModelAndView("showOneCafe");
		
		if(nom != null){
			Cafe cafe = cafeService.getCafe(nom);
			if(cafe != null){
					mv.addObject("cafe", cafe);
					mv.addObject("commentairesList", cafeService.commentaires(cafe));
			} else {
				mv.addObject("erreur", "true");
			}
		} else {
			mv.addObject("erreur", "true");
		}
		return mv;
	}
	
	@RequestMapping(value = "/addCom", method = RequestMethod.POST)
	public String addCom(@RequestParam(value = "nom", required = false) String nom,
			@RequestParam(value = "contenu", required = false) String contenu,
			HttpServletRequest request){
		if(contenu != null && nom !=null){
			
			//safe commentaire
			contenu = EscapeUtils.escapeHtml(contenu);
			
			Commentaire c = new Commentaire();
			c.setContenu(contenu);
			c.setCafe(cafeService.getCafe(nom));
			
			Cookie[] cookies = request.getCookies();
			User u=null;
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("idUser") && !cookie.getValue().equals("")){
					u=userService.getUserById(Long.valueOf(cookie.getValue()));
					break;
				}
			}
			if(u!=null){
				c.setOwner(u.getEmail());
			}else{
				c.setOwner("Some User");
			}
			
			commentaireService.saveCommentaire(c);
			return "redirect:/homeCafe";
		}
		return "homeCafe";
	}
	
	@RequestMapping(value = "/remplirCom", method = RequestMethod.GET)
	public ModelAndView remplir(){
		ModelAndView mv = new ModelAndView("homeCafe");
		Commentaire com1 = new Commentaire();
		
		com1.setContenu("slt1");
		com1.setCafe(cafeService.getCafe("coralie et cappucine"));
		commentaireService.saveCommentaire(com1);
		
		return mv;
	}
	
	public List<Cafe> triListCafe(List<Cafe> listCafe){
//		double dist = 0;
//		for (int i = 0; i < listCafe.size()-1; i++) {
//			dist+=distance(listCafe.get(i), listCafe.get(i+1));
//		}
//		System.out.println("distance debut : "+dist);


		
		List<Cafe> cafesTries = new ArrayList<Cafe>();
		cafesTries.add(listCafe.get(0));
		
		Cafe c = listCafe.get(0);
		listCafe.remove(0);
		double distance; 
		int save;
		
		while(listCafe.size() > 0){
			save = 0;
			distance = Double.MAX_VALUE;
			for (int i = 0; i < listCafe.size(); i++) {
				if(distance(c, listCafe.get(i)) < distance){
					distance = distance(c, listCafe.get(i));
					save = i;
				}
			}
			c = listCafe.get(save);
			cafesTries.add(c);
			listCafe.remove(c);
		}
		
//		dist = 0;
//		for (int i = 0; i < cafesTries.size()-1; i++) {
//			dist+=distance(cafesTries.get(i), cafesTries.get(i+1));
//		}
//		System.out.println("distance fin : "+dist);
		
		return cafesTries;
	}

	

	public List<Cafe> kruskal(Cafe depart, int nb_cafe){
		List<Cafe> selection = new ArrayList<Cafe>();
		List<Cafe> libre = cafeService.listCafes();
		
		int it=0;
		selection.add(depart);
		for(int i=0; i<libre.size();i++) 
			if(libre.get(i).getNom().equals(depart.getNom())) 
				libre.remove(i);

		
		it++;
		
		while(it<nb_cafe){ 
			Cafe c=null;
			double distance = Double.MAX_VALUE;
			
			//pour tous les points de departs, on cherche le point le plus proche
			for(int i=0;i<selection.size();i++){
				for(int j=0;j<libre.size();j++){
					if(selection.get(i).distance(libre.get(j)) < distance){
						c = libre.get(j);
						distance = selection.get(i).distance(libre.get(j));	
					}
				}
			}
			// le cafe c:  est le cafe le plus proche de la zone
			selection.add(c);
			libre.remove(c);
			it++;
			
		}
		
		return selection;
	}

	
	public double distance(Cafe c1, Cafe c2){
		double x1 = c1.getX();
		double y1 = c1.getY();
		double x2 = c2.getX();
		double y2 = c2.getY();
		return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	}
}

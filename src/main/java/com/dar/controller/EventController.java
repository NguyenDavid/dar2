package com.dar.controller;





//BC
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dar.model.Event2;
import com.dar.service.EventService;

@Controller
public class EventController {
	
	@Autowired
	private EventService eventService;
	


	@RequestMapping(value = { "/", "/listEvents" })
	public String listEvents(Map<String, Object> map, HttpServletResponse response) {
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		map.put("event", new Event2());
		map.put("event", eventService.listEvents());

		return "/book/listEvents";
	}

	@RequestMapping("/get/{eventId}")
	public String getEvent(@PathVariable Long eventId, Map<String, Object> map, HttpServletResponse response) {
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		Event2 event = eventService.getEvent(eventId);

		map.put("event", event);

		return "/event/eventForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEvent(@ModelAttribute("event") Event2  event,
			BindingResult result, HttpServletResponse response) {
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		eventService.saveEvent(event);

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:listEvents";
	}

	@RequestMapping("/delete/{eventId}")
	public String deleteEvent(@PathVariable("eventId") Long id, HttpServletResponse response) {
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		eventService.deleteEvent(id);

		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listBooks";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 */
		return "redirect:/event/listEvents";
	}

}

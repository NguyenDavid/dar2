package com.dar.service;


import java.util.List;

import com.dar.model.Event2;


public interface EventService {
	/*
	 * CREATE and UPDATE 
	 */
	public void saveEvent(com.dar.model.Event2 event);

	/*
	 * READ
	 */
	public List<Event2> listEvents();
	public Event2 getEvent(Long id);

	/*
	 * DELETE
	 */
	public void deleteEvent(Long id);
}

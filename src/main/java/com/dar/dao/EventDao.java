package com.dar.dao;


import java.util.List;

import com.dar.model.Event2;

public interface EventDao {

	/*
	 * CREATE and UPDATE
	 */
	public void saveEvent(Event2 event); // create and update

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

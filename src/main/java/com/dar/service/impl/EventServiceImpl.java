package com.dar.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dar.dao.EventDao;
import com.dar.model.Event2;
import com.dar.service.EventService;


@Service
public class EventServiceImpl implements EventService{
	

		@Autowired
		private EventDao eventDao;

		@Transactional
		public void saveEvent(Event2 event) {
			eventDao.saveEvent(event);
		}

		@Transactional(readOnly = true)
		public List<Event2> listEvents() {
			return eventDao.listEvents();
		}

		@Transactional(readOnly = true)
		public Event2 getEvent(Long id) {
			return eventDao.getEvent(id);
		}

		@Transactional
		public void deleteEvent(Long id) {
			eventDao.deleteEvent(id);

		}

	}

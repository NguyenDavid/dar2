package com.dar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dar.dao.TagDao;
import com.dar.model.Tag;
import com.dar.service.TagService;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDao tagDao;
	
	@Transactional
	@Override
	public void saveTag(Tag tag) {
		// TODO Auto-generated method stub
		tagDao.saveTag(tag);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Tag> listTags() {
		// TODO Auto-generated method stub
		return tagDao.listTags();
	}

	@Transactional(readOnly = true)
	@Override
	public Tag getTag(String nom) {
		// TODO Auto-generated method stub
		return tagDao.getTag(nom);
	}

//	@Transactional(readOnly = true)
//	@Override
//	public List<String> publications(String nom) {
//		// TODO Auto-generated method stub
//		return tagDao.publications(nom);
//	}

	@Transactional
	@Override
	public void deleteTag(Tag tag) {
		// TODO Auto-generated method stub
		tagDao.deleteTag(tag);
	}

}

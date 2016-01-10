package com.dar.service;

import java.util.List;

import com.dar.model.Tag;

public interface TagService {
	public void saveTag(Tag tag);

	public List<Tag> listTags();
	
	public Tag getTag(String nom);
	
//	public List<String> publications(String nom);
	
	public void deleteTag(Tag tag);
}

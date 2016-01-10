package com.dar.dao;

import java.util.List;

import com.dar.model.Tag;

public interface TagDao {
	/*
	 * CREATE and UPDATE
	 */
	public void saveTag(Tag tag);
	
	/*
	 * READ
	 */
	public List<Tag> listTags();
	
	public Tag getTag(String nom);
	
//	public List<String> publications(String nom);
	
	public void deleteTag(Tag tag);
}

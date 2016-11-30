package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.ChatForum;
import com.niit.collaboration.model.ChatForumComment;

public interface ChatForumDAO {


	public List<ChatForum> list();

	public ChatForum getChatForum(String id);

	public ChatForum get(String userID, String friendID);

	public boolean save(ChatForum chatForum);

	public boolean update(ChatForum chatForum);

	public void deleteChatForum(String id);

	// For chatForumComment

	public ChatForumComment getChatForumComment(String id);

	public boolean save(ChatForumComment chatForumComment);

	public boolean update(ChatForumComment chatForumComment);

	public void deleteChatForumComment(String id);

	
}

package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Friend;

public interface FriendDAO {

	public List<Friend> list();

	public List<Friend> getAllFriends(String userID);

	public List<Friend> get(String userID, String friendID);

	public List<Friend> getMyFriendNewFriendRequest(String userID);

	public boolean save(Friend friend);

	// acceptFriend(String userID, String friendID,'A');
	// rejectFriend
	public boolean update(Friend friend);

	public void delete(String userID, String friendID);

	public String getMaxId();

	// getFriendWhoAreOnline

	// public boolean isValidFriend(String id, String name);

}

package com.akcreations.springwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List <User> users = new ArrayList<>();
	
	private static int userCounter = 3;
	
	static{
		users.add(new User(1,"Anantha",new Date()));
		users.add(new User(2,"Anjitha",new Date()));
		users.add(new User(3,"Arjun",new Date()));
	}
	
	public List<User> findAllUsers()
	{
		return users;
	}
	
	public User saveUser(User newUser)
	{
		if(newUser.getId() == null)
		{
			newUser.setId(++userCounter);
		}
		users.add(newUser);
		
		return newUser;
	}
	
	public User getUser(int searchId)
	{
		for(User user:users)
		{
			if(user.getId()==searchId)
			{ return user;}
				  
		}
		
		return null;
	}

}

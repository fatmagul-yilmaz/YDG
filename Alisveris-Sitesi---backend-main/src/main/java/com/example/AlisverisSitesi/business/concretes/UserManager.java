package com.example.AlisverisSitesi.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AlisverisSitesi.business.abstracts.UserService;
import com.example.AlisverisSitesi.core.dataAccess.UserDao;
import com.example.AlisverisSitesi.core.entities.User;
import com.example.AlisverisSitesi.core.utilities.results.DataResult;
import com.example.AlisverisSitesi.core.utilities.results.Result;
import com.example.AlisverisSitesi.core.utilities.results.SuccessDataResult;
import com.example.AlisverisSitesi.core.utilities.results.SuccessResult;


@Service
public class UserManager implements  UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult ("Kullanıcı eklendi.");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		
		return new SuccessDataResult<User>(this.userDao.findByEmail(email), "Kullanıcı bulundu.");
	}

}

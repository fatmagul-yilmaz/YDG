package com.example.AlisverisSitesi.business.abstracts;

import com.example.AlisverisSitesi.core.entities.User;
import com.example.AlisverisSitesi.core.utilities.results.DataResult;
import com.example.AlisverisSitesi.core.utilities.results.Result;

public interface UserService {

	//Kullanıcı ekledik.
	Result add (User user);
	
	DataResult <User> findByEmail (String email);
}

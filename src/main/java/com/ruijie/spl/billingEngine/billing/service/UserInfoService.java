package com.ruijie.spl.billingEngine.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruijie.spl.billingEngine.billing.entity.UserInfo;
import com.ruijie.spl.billingEngine.billing.repository.UserRepository;

@Service
public class UserInfoService {
	@Autowired
	private UserRepository userRepository;
	@Transactional
	public UserInfo addUser(UserInfo userinfo){
		return userRepository.save(userinfo);
	}
}

package com.ruijie.spl.billingEngine.preprocess.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ruijie.spl.billingEngine.preprocess.entity.User;
import com.ruijie.spl.billingEngine.preprocess.repository.UserinfoRepository;

@RestController
public class UserController {
	@Autowired
	UserinfoRepository userRepository;
	
	@RequestMapping(value="/hello")
    public String say(){
        return "Hello SpringBoot!";
    }

//	@RequestMapping(value="/{id}",method=RequestMethod.GET)
//	public User findById(@PathVariable("id") Integer id){//url格式：http://localhost:8080/11
//		return userRepository.findOne(id);
//	}

}

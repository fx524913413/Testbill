package com.ruijie.spl.billingEngine.billing.controller;

import com.ruijie.spl.billingEngine.billing.entity.UserInfo;
import com.ruijie.spl.billingEngine.billing.repository.UserRepository;
import com.ruijie.spl.billingEngine.billing.service.UserInfoService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dbtest")
public class DbController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/getUsers", method = {RequestMethod.GET})
    public List<UserInfo> getUsers() {
        logger.error("haha");
        return userRepository.findAll();
    }

    @RequestMapping(value = "/getUserByUuid/{uuid}", method = {RequestMethod.GET})
    public UserInfo getUserById(@PathVariable String uuid) {
        return userRepository.findOne(uuid);
    }


    @RequestMapping(value = "/createUser", method = {RequestMethod.POST})
    public UserInfo createUser(@RequestParam UserInfo userInfo) {
        return userInfoService.addUser(userInfo);
    }

    @RequestMapping(value = "/create/ss", method = {RequestMethod.POST})
    public Map<String, Double> createUserHehe(@ApiParam(required = true) Map<String, Double> hhh) {
        System.out.println("hehe");
        return hhh;
    }
}

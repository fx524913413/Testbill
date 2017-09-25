package com.ruijie.spl.billingEngine.booking.controller;

import com.ruijie.spl.billingEngine.booking.service.User_booking_BillSave;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ruijie.spl.billingEngine.booking.service.User_booking_service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/dbtest_booking")
public class Booking_Controller {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private User_booking_service booking_service;
    @Autowired
    private User_booking_BillSave booking_billSave;
    
    /*@RequestMapping(value="/getUsers",method = {RequestMethod.GET })
    public List<User> getUsers(){
    	logger.error("haha");
    	return booking_Repository.findAll();
    }
    
    @RequestMapping(value="/getUserByUuid/{uuid}",method = {RequestMethod.GET })
    public User getUserById(@PathVariable Integer uuid){
    	return booking_Repository.findOne(uuid);
    }
    
    
    @RequestMapping(value="/createUser",method = {RequestMethod.POST})
    public User createUser(@RequestParam User userInfo){
    	return booking_service.addUser(userInfo);
    }*/
    
    /*@RequestMapping(value="/executionSourceFeeItem/{userid}/{sourcefeeid}/{fee}",method = {RequestMethod.POST})
    public String executionSourceid(@PathVariable Integer userid,@PathVariable String sourcefeeid,@PathVariable Double fee,){
    }*/

    @RequestMapping(value = "/executionSourceFeeItem", method = {RequestMethod.POST})
    public void createNewStrategyForUser(@RequestParam UUID userid, @RequestParam Integer sourcefeeid, @RequestParam Double fee, @RequestParam String subsectionflow) throws Exception {
        //logger.error("try test");
        booking_service.executionSourceFeeItem(userid, sourcefeeid, fee, subsectionflow);
    }

    @RequestMapping(value = "/createNewsetmenu", method = {RequestMethod.POST})
    public void creatNewUserAccount(@RequestParam UUID userid, @RequestParam Integer sourcefeeid, @RequestParam Map<String, Double> create) throws Exception {
        booking_service.createNewsetmenu(userid, sourcefeeid, create);
    }

    @RequestMapping(value = "/bookingBills", method = {RequestMethod.POST})
    public void recordBillsTurnover(@RequestParam UUID userid, @RequestParam Integer sourcefeeid, @RequestParam Double fee, @RequestParam String billing_source) {
        booking_billSave.recordBillsTurnover(userid, sourcefeeid, fee, billing_source);
    }
}

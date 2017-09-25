package com.ruijie.spl.billingEngine.preprocess;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ruijie.spl.billingEngine.preprocess.entity.User;
import com.ruijie.spl.billingEngine.preprocess.repository.UserinfoRepository;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class UserTest {
	@Autowired
    private UserinfoRepository userRepository;

    @Test
    public void testAdd() {
    	System.out.println("执行testAdd");
        User user = new User();
        user.setEmail("393156105@qq.com");
        user.setNickName("知识林");
        user.setPassword("123456");
        user.setUserName("zslin");
        userRepository.save(user);
        
    }
    @Test
    public void testDelete() {
    	System.out.println("执行testDelete");
    	userRepository.delete(6);
    }
    @Test
    public void testUpdate() {
    	System.out.println("执行testUpdate");
        User user = userRepository.findOne(7);
        user.setNickName("钟述林");
        userRepository.save(user);
        System.out.println("nickName : "+user.getNickName()+", email : "+user.getEmail());
    }
    @Test
    public void testFind() {
    	System.out.println("执行testFind");
        User user = userRepository.findOne(8);
        System.out.println("nickName : "+user.getNickName()+", email : "+user.getEmail());
    }
    @Test
    public void testFindAll() {
    	System.out.println("执行testFindAll");
        List<User> list = userRepository.findAll();
        for(User u : list) {
            System.out.println("nickName : "+u.getNickName()+", email : "+u.getEmail());
        }
    }
    
    
    
    @Test
    public void testAddBatch() {
    	System.out.println("执行testAddBatch");
        for(Integer i=0; i < 5; i++) {
            User user = new User();
            user.setNickName("昵称"+i);
            user.setUserName("user"+i);
            user.setPassword("pwd"+i);
            user.setEmail("email"+i+"@domain.com");
            userRepository.save(user);
        }
    }
    
}

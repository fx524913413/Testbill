package com.ruijie.spl.billingEngine.controllerTest;

import com.ruijie.spl.billingEngine.billing.controller.PersonInfoController;
import com.ruijie.spl.billingEngine.billing.entity.PersonEntity_Ab;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/9/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
    @Autowired
    private PersonInfoController personInfoController;

    @Test
    public void personInfoControllerTest() {
        PersonEntity_Ab byId = personInfoController.getUserById("fbf6f3b7-99fb-48ed-9f74-6f610bfc9cbe");
        Assert.assertNotNull(byId);
    }
}

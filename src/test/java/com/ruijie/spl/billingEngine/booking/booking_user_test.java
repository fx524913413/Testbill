package com.ruijie.spl.billingEngine.booking;


import com.ruijie.spl.billingEngine.booking.entity.Account_info;
import com.ruijie.spl.billingEngine.booking.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ruijie.spl.billingEngine.BillingEngineApplication;
import com.ruijie.spl.billingEngine.booking.entity.Acc_Relation;
import com.ruijie.spl.billingEngine.booking.entity.User_info;
import com.ruijie.spl.billingEngine.booking.repository.AccRelationRepository;
import com.ruijie.spl.billingEngine.booking.repository.User_InfoRepository;

/*@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BillingEngineApplication.class)
@WebAppConfiguration
public class booking_user_test {
    @Autowired
    private User_InfoRepository repostor;
    @Autowired
    private AccountRepository accRepository;
    @Autowired
    private AccRelationRepository AccRelRepository;

    @Test
    public void accreladd() {
        //对数据库进行测试数据插入
        Acc_Relation acc_RelationBalance = new Acc_Relation();
        acc_RelationBalance.setAccountTypeBook("balance");
        acc_RelationBalance.setSourceFeeID(100);
        acc_RelationBalance.setPriority(9);
        AccRelRepository.save(acc_RelationBalance);

        Acc_Relation acc_Relation = new Acc_Relation();
        acc_Relation.setAccountTypeBook("balanceflow");
        acc_Relation.setSourceFeeID(100);
        acc_Relation.setPriority(8);
        AccRelRepository.save(acc_Relation);

//        Acc_Relation acc_Relation2 = new Acc_Relation();
//        acc_Relation2.setAccountTypeBook("packageflow");
//        acc_Relation2.setSourceFeeID(100);
//        acc_Relation2.setPriority(7);
//        AccRelRepository.save(acc_Relation2);

        Acc_Relation acc_Relation3 = new Acc_Relation();
        acc_Relation3.setAccountTypeBook("gift");
        acc_Relation3.setSourceFeeID(100);
        acc_Relation3.setPriority(3);
        AccRelRepository.save(acc_Relation3);

        Acc_Relation acc_Relation4 = new Acc_Relation();
        acc_Relation4.setAccountTypeBook("subsectionflow1");
        acc_Relation4.setSourceFeeID(100);
        acc_Relation4.setPriority(4);
        AccRelRepository.save(acc_Relation4);

        Acc_Relation acc_Relation5 = new Acc_Relation();
        acc_Relation5.setAccountTypeBook("subsectionflow2");
        acc_Relation5.setSourceFeeID(100);
        acc_Relation5.setPriority(5);
        AccRelRepository.save(acc_Relation5);

        Acc_Relation acc_Relation6 = new Acc_Relation();
        acc_Relation6.setAccountTypeBook("subsectionflow3");
        acc_Relation6.setSourceFeeID(100);
        acc_Relation6.setPriority(6);
        AccRelRepository.save(acc_Relation6);

        User_info user1 = new User_info();
        user1.setUsername("5");
        repostor.save(user1);

        Account_info Account1 = new Account_info();
        Account1.setAccountType("balanceflow");
        Account1.setAmount(50.0);
        Account1.setUnit("M");
        Account1.setUseruuid(user1.getUseruuid());
        Account1.setUsername(user1.getUsername());
        Account1.setRate(1.0);
        accRepository.save(Account1);

        Account_info Account2 = new Account_info();
        Account2.setAccountType("balance");
        Account2.setAmount(23.0);
        Account2.setUnit("RMB");
        Account2.setUseruuid(user1.getUseruuid());
        Account2.setUsername(user1.getUsername());
        accRepository.save(Account2);

        Account_info Account3 = new Account_info();
        Account3.setAccountType("gift");
        Account3.setAmount(22.0);
        Account3.setUnit("M");
        Account3.setUseruuid(user1.getUseruuid());
        Account3.setUsername(user1.getUsername());
        Account3.setRate(0.0);
        accRepository.save(Account3);

        Account_info Account4 = new Account_info();
        Account4.setAccountType("subsectionflow1");
        Account4.setAmount(22.0);
        Account4.setUnit("M");
        Account4.setUseruuid(user1.getUseruuid());
        Account4.setUsername(user1.getUsername());
        Account4.setRate(0.9);
        accRepository.save(Account4);

        Account_info Account5 = new Account_info();
        Account5.setAccountType("subsectionflow2");
        Account5.setAmount(23.0);
        Account5.setUnit("M");
        Account5.setUseruuid(user1.getUseruuid());
        Account5.setUsername(user1.getUsername());
        Account5.setRate(0.8);
        accRepository.save(Account5);

        Account_info Account6 = new Account_info();
        Account6.setAccountType("subsectionflow3");
        Account6.setAmount(24.0);
        Account6.setUnit("M");
        Account6.setUseruuid(user1.getUseruuid());
        Account6.setUsername(user1.getUsername());
        Account6.setRate(0.7);
        accRepository.save(Account6);
    }

    @Test
    public void creatNewuser() {
        User_info user1 = new User_info();
        user1.setUsername("6");

        repostor.save(user1);
    }

//    @Test
//    public void testAdd() {
//        System.out.println("执行testAdd");
//        User user = new User();
//        user.setEmail("393156105@qq.com");
//        user.setNickName("知识林");
//        user.setPassword("123456");
//        user.setUserName("zslin");
//        userRepository.save(user);
//
//    }
//    @Test
//    public void testDelete() {
//        System.out.println("执行testDelete");
//        userRepository.delete(1);
//    }
//    @Test
//    public void testUpdate() {
//        System.out.println("执行testUpdate");
//        User user = userRepository.findOne(1);
//        user.setNickName("钟述林");
//        userRepository.save(user);
//        System.out.println("nickName : "+user.getNickName()+", email : "+user.getEmail());
//    }
//    @Test
//    public void testFind() {
//        System.out.println("执行testFind");
//        User user = userRepository.findOne(1);
//        System.out.println("nickName : "+user.getNickName()+", email : "+user.getEmail());
//    }
//    @Test
//    public void testFindAll() {
//        System.out.println("执行testFindAll");
//        List<User> list = userRepository.findAll();
//        for(User u : list) {
//            System.out.println("nickName : "+u.getNickName()+", email : "+u.getEmail());
//        }
//    }

//    @Test
//    public void DigestedData() {
//        //repostor.deleteAll();
//
//        MainAccount_info s = new MainAccount_info();
//        s.setAccountKey("test2");
//        s.setAccountType("esthahat2");
//        User_info sss = new User_info();
//        sss.setMainAccount(s);
//
//        repostor.save(sss);
//    }
//
//    @Test
//    public void insertsubacc() {
//
//        User_info testuser = new User_info();
//        MainAccount_info mainAcc = new MainAccount_info();
//        mainAcc.setAccountKey("main1044");
//        mainAcc.setAmount(10441044.0);
//
//        SubAccount_info subAcc = new SubAccount_info();
//        subAcc.setFatherAcctKey(mainAcc);
//        subAcc.setAccountKey("sub1044");
//        subAcc.setAmount(1656.0);
////    	subRepository.save(subAcc);
//
//        SubAccount_info subBcc = new SubAccount_info();
//        subBcc.setAccountKey("sub1045");
//        subBcc.setFatherAcctKey(mainAcc);
//        subBcc.setAmount(1656.0);
//
////    	subRepository.save(subBcc);
//
//        Set<SubAccount_info> sa = new HashSet<>();
//        sa.add(subAcc);
//        sa.add(subBcc);
//
//        mainAcc.setSubAccountinfo(sa);
//        testuser.setMainAccount(mainAcc);
//        repostor.save(testuser);
//    }
//
//    @Test
//    public void Que_0() {
//        User_info info2 = repostor.findOne(61);//通过用户ID查询用户表
//        Map<Integer, Object> accpririty = new TreeMap<Integer, Object>();
//
//        MainAccount_info mainAccount_info = info2.getMainAccount();//得到主账户对象
//        Acc_Relation acc_Relation = AccRelRepository.findByAccountTypeBookAndSourceFeeID(info2.getMainAccount().getAccountType(), "100");//得到入账关系表决定的主账户相关属性
//        Set<SubAccount_info> subtest = info2.getMainAccount().getSubAccountinfo();//得到用户子账户对象
//        for (SubAccount_info obj4subtest : subtest) {
//            Acc_Relation acc_Relation2 = AccRelRepository.findByAccountTypeBookAndSourceFeeID(obj4subtest.getAccountType(), "100");//得到入账关系表决定的子账户相关属性
//            accpririty.put(acc_Relation2.getPriority(), obj4subtest);//将子账户的优先值和子账户对象插入map对象
//        }
//        accpririty.put(acc_Relation.getPriority(), mainAccount_info);//将主账户的优先值和主账户对象插入map对象
//        Set<Map.Entry<Integer, Object>> entrysetSet = accpririty.entrySet();
//        int n = 1;//n用于模拟扣费数额
//
//        for (Map.Entry<Integer, Object> obj4acc : entrysetSet) {
//            Object object = obj4acc.getValue();
//
//            if (object instanceof SubAccount_info) {
//                SubAccount_info subAccount_info1 = (SubAccount_info) object;
//                subAccount_info1.setAmount(subAccount_info1.getAmount() - n);
//                subRepository.save(subAccount_info1);
//            } else if (object instanceof MainAccount_info) {
//                MainAccount_info mainAccount_info1 = (MainAccount_info) object;
//                mainAccount_info1.setAmount(mainAccount_info1.getAmount() - n);
//
//
//                marepository.saveAndFlush(mainAccount_info1);
//            }
//
//            n++;
//        }
//    }
//
//    @Test
//    public void Que() {
//        //User_info info = new User_info();
//        //int aString = info.getId();
//        //List<User> list = userRepository.findAll();
//
//        Map<Integer, Double> accpririty = new TreeMap<Integer, Double>();
//        List<Integer> subaccpririty2 = new ArrayList<Integer>();
//        User_info info2 = repostor.findOne(1);//通过用户ID查询用户表
//
//        MainAccount_info mainAccount_info = marepository.findById(info2.getId());//得到主账户对象
//        Acc_Relation acc_Relation = AccRelRepository.findByAccountTypeBookAndSourceFeeID(info2.getMainAccount().getAccountType(), "100");//得到入账关系表决定的主账户相关属性
//        int priority_main = acc_Relation.getPriority();//得到主账户优先值
//        subaccpririty2.add(acc_Relation.getPriority());//将主账户优先值插入一个列表
//        Double mainacc_amount = mainAccount_info.getAmount();//得到主账户数值
//
//
//        Set<SubAccount_info> subtest = info2.getMainAccount().getSubAccountinfo();//得到用户子账户对象
//        for (SubAccount_info obj4subtest : subtest) {
//            acc_Relation = AccRelRepository.findByAccountTypeBookAndSourceFeeID(obj4subtest.getAccountType(), "100"); //得到入账关系表决定的其中一个子账户相关属性
//            subaccpririty2.add(acc_Relation.getPriority());//将子账户优先值插入一个列表
//            accpririty.put(acc_Relation.getPriority(), obj4subtest.getAmount());//将子账户的优先值和账户内数值插入map对象
//        }
//        accpririty.put(priority_main, mainacc_amount);//将主账户的优先值和账户内数值插入map对象
//
//    	 /*List<Map.Entry<Integer, Double>> list = new ArrayList<Map.Entry<Integer, Double>>(accpririty.entrySet());
//         Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
//             //按照key值降序排序
//             @Override
//             public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
//                 //return o1.getValue().compareTo(o2.getValue());
//                 return o2.getKey().compareTo(o1.getKey());
//             }
//         });  */
//        Set<Map.Entry<Integer, Double>> entrysetSet = accpririty.entrySet();
//        int n = 1;//n用于模拟扣费数额
//        for (Map.Entry<Integer, Double> obj4acc : entrysetSet) {
//            obj4acc.setValue(obj4acc.getValue() - n);
//            n++;
//            System.out.println(obj4acc.getValue());
//
//        }
//    }


//    @Test
//    public void testAddBatch() {
//        System.out.println("执行testAddBatch");
//        for(Integer i=0; i < 5; i++) {
//            User user = new User();
//            user.setNickName("昵称"+i);
//            user.setUserName("user"+i);
//            user.setPassword("pwd"+i);
//            user.setEmail("email"+i+"@domain.com");
//            userRepository.save(user);
//        }
//    }

}

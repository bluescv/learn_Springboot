package io.bluescv.springboot.repo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by bluescv on 4/21/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {


    @Autowired
    private UserService userSerivce;

    @Test
    public void test() throws Exception {
        // 插入5个用户
        userSerivce.create("a", 1);
        userSerivce.create("b", 2);
        userSerivce.create("c", 3);
        userSerivce.create("d", 4);
        userSerivce.create("e", 5);

        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userSerivce.getAllUsers().intValue());

        // 删除两个用户
        userSerivce.deleteByName("a");
        userSerivce.deleteByName("e");

        // 查数据库，应该有3个用户
        Assert.assertEquals(3, userSerivce.getAllUsers().intValue());

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() throws Exception {
    }

    @Test
    public void deleteByName() throws Exception {
    }

    @Test
    public void getAllUsers() throws Exception {
    }

    @Test
    public void deleteAllUsers() throws Exception {
    }

}
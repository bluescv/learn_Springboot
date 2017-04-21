package io.bluescv.springboot.repo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by bluescv on 4/21/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Rollback()
public class UserServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {


    @Autowired
    @Qualifier("user2")
    private UserService userService;

    @Test
    @Rollback(false)
    public void test() throws Exception {
        // 插入5个用户
        userService.create("a", 1);
        userService.create("b", 2);
        userService.create("c", 3);
        userService.create("d", 4);
        userService.create("e", 5);

        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userService.getAllUsers().intValue());

        // 删除两个用户
        userService.deleteByName("a");
        userService.deleteByName("e");

        // 查数据库，应该有3个用户
        Assert.assertEquals(3, userService.getAllUsers().intValue());


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
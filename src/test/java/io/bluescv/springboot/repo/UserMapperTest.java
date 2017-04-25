package io.bluescv.springboot.repo;

import io.bluescv.springboot.mbtest.domain.User;
import io.bluescv.springboot.mbtest.domain.UserMapper;
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
public class UserMapperTest extends AbstractTransactionalJUnit4SpringContextTests {


    @Autowired
    private UserMapper userMapper;

    @Test
//    @Rollback(false)
    public void findByName() throws Exception {
        userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge().intValue());
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
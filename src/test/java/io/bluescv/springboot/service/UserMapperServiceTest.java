package io.bluescv.springboot.service;

import io.bluescv.springboot.mbtest.domain.User;
import io.bluescv.springboot.mbtest.domain.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by bluescv on 4/24/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMapperServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    UserMapperService userMapperService;

    @Test
    @Rollback(false)
    public void test() {
        try {
            userMapperService.testInsertTransactionUsingAnnotation();
        } catch (Exception e) {
            System.out.println("Caught exception");
        }

    }


    @Test
    @Rollback(false)
    public void test2() {
        try {
            userMapperService.testInsertTransactionManully();
        } catch (Exception e) {
            System.out.println("Caught exception");
        }

    }


    @Test
    @Rollback(false)
    public void test3() {
        try {
            userMapperService.testTransactionalInOneClass();
        } catch (Exception e) {
            System.out.println("Caught exception");
        }

    }


    @Test
    @Rollback(false)
    public void test4() {
        try {
            userMapperService.testTransactionalInDifferentClass();
        } catch (Exception e) {
            System.out.println("Caught exception");
        }

    }

}
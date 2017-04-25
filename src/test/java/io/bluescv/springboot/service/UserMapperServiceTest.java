package io.bluescv.springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by bluescv on 4/24/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMapperServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    UserMapperService userMapperService;

    @Test
//    @Rollback(false)
    public void test() {
        try {
            userMapperService.testInsertTransactionUsingAnnotation();
        } catch (Exception e) {
            System.out.println("Caught exception");
        }

    }


    @Test
//    @Rollback(false)
    public void test2() {
        try {
            userMapperService.testInsertTransactionManully();
        } catch (Exception e) {
            System.out.println("Caught exception");
        }

    }


    @Test
//    @Rollback(false)
    public void test3() {
        try {
            userMapperService.testTransactionalInOneClass();
        } catch (Exception e) {
            System.out.println("Caught exception");
        }

    }


    @Test
//    @Rollback(false)
    public void test4() {
        try {
            userMapperService.testTransactionalInDifferentClass();
        } catch (Exception e) {
            System.out.println("Caught exception");
        }

    }


    @Test
//    @Rollback(false)
    public void test5() {
        try {
            userMapperService.testAsOuterMethod();
        } catch (Exception e) {
            System.out.println("Caught exception");
        }

    }

}
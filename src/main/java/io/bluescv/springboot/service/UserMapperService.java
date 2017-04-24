package io.bluescv.springboot.service;

import io.bluescv.springboot.mbtest.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Created by bluescv on 4/24/17.
 */
@Service
public class UserMapperService {

    @Autowired
    InnerClass innerClass;
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void testInsertTransactionUsingAnnotation() {
        userMapper.insert("testname1", 50);
        throw new RuntimeException();
    }

    @Transactional
    public void testInsertTransactionManully() {
        userMapper.insert("testname1", 50);
        System.out.println(userMapper.findByName("testname1").getAge());
        userMapper.insert("testname2", 60);

        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

    }

    @Transactional
    public void testTransactionalInOneClass() {
        System.out.println("Performing some persist op");
        userMapper.insert("testname3", 30);
        try {
            testTransactionalInOneClassInner();
        } catch (Exception e) {
            System.out.println("caught exception in method testTransactionalInOneClass() ");
        }

    }

    @Transactional
    public void testTransactionalInOneClassInner() {
        System.out.println("Performing some persist op inner");
        userMapper.insert("testname4", 40);

        throw new RuntimeException();
    }

    @Transactional
    public void testTransactionalInDifferentClass() {
        System.out.println("Performing some persist op");
        userMapper.insert("testname5", 5);
        try {
            innerClass.testTransactionalInOneClassInner();
        } catch (Exception e) {
            System.out.println("caught exception in method testTransactionalInDifferentClass() ");
        }

    }


}


@Service
class InnerClass {
    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testTransactionalInOneClassInner() {
        System.out.println("Performing some persist op inner");
        userMapper.insert("testname6", 60);

        throw new RuntimeException();
    }
}
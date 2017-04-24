package io.bluescv.springboot.service;

import io.bluescv.springboot.mbtest.domain.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * Created by bluescv on 4/24/17.
 */
@Service
public class UserMapperService {

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
}

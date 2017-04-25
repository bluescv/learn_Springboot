package io.bluescv.springboot.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bluescv on 4/25/17.
 */
//@Controller
@RestController
@RequestMapping(value = "/testexceptions2")
public class ExceptionHandlingController2 {


    @RequestMapping(value = "/DataIntegrityViolationException")
    public String methodThatThrowsDataIntegrityViolationException() throws DataIntegrityViolationException {
        System.out.println("inside method methodThatThrowsDataIntegrityViolationException()");
        throw new DataIntegrityViolationException("abc");
    }


}
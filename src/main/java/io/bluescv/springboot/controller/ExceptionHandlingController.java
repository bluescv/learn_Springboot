package io.bluescv.springboot.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by bluescv on 4/25/17.
 */
//@Controller
@RestController
@RequestMapping(value = "/testexceptions")
public class ExceptionHandlingController {

    // @RequestHandler methods

    // Exception handling methods

    // Convert a predefined exception to an HTTP Status code
    @ResponseStatus(value = HttpStatus.CONFLICT,
            reason = "Data integrity violation")  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    @RequestMapping(value = "/singleexception")
    public String conflict() {
        System.out.println("Invoking testexceptions/singleexception");
        // Nothing to do
        return "Invoking testexceptions/singleexception";
    }

    @RequestMapping(value = "/DataIntegrityViolationException")
    public String methodThatThrowsDataIntegrityViolationException() throws Exception {
        System.out.println("inside method methodThatThrowsDataIntegrityViolationException()");
//        throw new DataIntegrityViolationException("abc");
        throw new Exception();
    }


    // Specify name of a specific view that will be used to display the error:
    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public String databaseError() {
        // Nothing to do.  Returns the logical view name of an error page, passed
        // to the view-resolver(s) in usual way.
        // Note that the exception is NOT available to this view (it is not added
        // to the model) but see "Extending ExceptionHandlerExceptionResolver"
        // below.
        return "databaseError";
    }

    // Total control - setup a model and return the view name yourself. Or
    // consider subclassing ExceptionHandlerExceptionResolver (see below).
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }
}
package io.bluescv.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bluescv on 4/17/17.
 */
@RestController
public class HelloController {

    @RequestMapping
    public String index() {
        return "haha";
    }
}

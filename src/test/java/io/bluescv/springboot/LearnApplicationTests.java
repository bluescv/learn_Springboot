package io.bluescv.springboot;

import io.bluescv.springboot.bean.BlogProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnApplicationTests {
    private static final Log log = LogFactory.getLog(LearnApplicationTests.class);

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void contextLoads() {

    }

    @Test
    public void test1() throws Exception {

        log.info("随机数测试输出：");
        log.info("随机字符串 : " + blogProperties.getName());
        log.info("随机int : " + blogProperties.getNumber());
        log.info("随机long : " + blogProperties.getBignumber());
        log.info("随机10以下 : " + blogProperties.getTest1());
        log.info("随机10-20 : " + blogProperties.getTest2());

    }

}

package com.bluemyth.monitor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationTests.class);
    @Before
    public void before() {
        logger.info("执行@Before模块");
    }

    @Test
    public void test() throws Exception {
        logger.info("执行@Test模块");
    }

}

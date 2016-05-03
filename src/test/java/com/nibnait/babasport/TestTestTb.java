package com.nibnait.babasport;

import com.nibnait.babasport.common.junit.SpringJunitTest;
import com.nibnait.babasport.core.bean.TestTb;
import com.nibnait.babasport.core.service.TestTbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * 测试
 * Created by nibnait on 2016/5/4.
 */
public class TestTestTb extends SpringJunitTest{

    @Autowired
    private TestTbService testTbService;

    @Test
    public void testAdd(){

        TestTb testTb = new TestTb();
        testTb.setName("大地");

        testTbService.addTestTb(testTb);

    }

}

package com.nibnait.babasport.core.service;

import com.nibnait.babasport.core.bean.TestTb;
import com.nibnait.babasport.core.dao.TestTbDao;
import com.nibnait.babasport.core.service.TestTbService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by nibnait on 2016/5/4.
 */
@Service
@Transactional
public class TestTbServiceImpl implements TestTbService {

    @Resource
    private TestTbDao testTbDao;

    public void addTestTb(TestTb testTb) {
        testTbDao.addTestTb(testTb);

    }

}

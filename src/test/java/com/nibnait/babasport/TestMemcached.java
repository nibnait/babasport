package com.nibnait.babasport;

import com.danga.MemCached.MemCachedClient;
import com.nibnait.babasport.common.junit.SpringJunitTest;
import com.nibnait.babasport.core.bean.user.Buyer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Set;

/**
 * 测试
 * Created by nibnait on 2016/5/11.
 */
public class TestMemcached extends SpringJunitTest{

    @Autowired
    private MemCachedClient memCachedClient;
    @Test
    public void testAdd() throws Exception {
        Buyer buyer = new Buyer();
        buyer.setUsername("范冰冰");

        memCachedClient.set("fbb",buyer);

        Object object = memCachedClient.get("fbb");
		System.out.println(object);
    }

}

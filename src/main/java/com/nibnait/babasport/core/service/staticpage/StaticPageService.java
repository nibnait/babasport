package com.nibnait.babasport.core.service.staticpage;

import java.util.Map;

/**
 * Created by nibnait on 2016/5/8.
 */
public interface StaticPageService {
    //静态化 商品详情页
    void productIndex(Map<String, Object> rootMap, Integer id);
}

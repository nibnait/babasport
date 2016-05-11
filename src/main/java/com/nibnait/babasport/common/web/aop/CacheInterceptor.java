package com.nibnait.babasport.common.web.aop;

import com.danga.MemCached.MemCachedClient;
import com.nibnait.babasport.common.web.MemCachedUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 * 缓存Memcached中数据的切面对象
 * around
 * after
 * Created by nibnait on 2016/5/11.
 */
public class CacheInterceptor {
    @Autowired
    private MemCachedClient memCachedClient;

    //时间 缓存时间
    public static final int TIMEOUT = 360000;//【秒】默认100h
    private int expiry = TIMEOUT;

    public void setExpiry(int expiry) {
        this.expiry = expiry;       //也可在配置文件中配置
    }


    //配置环绕方法
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        if(memCachedClient.stats().isEmpty()){
            System.out.println("Memcached服务器可能不存在或是连接不上");
            return pjp.proceed();
        }

        String cacheKey = getCacheKey(pjp);
        if(memCachedClient.get(cacheKey)==null){
            //回Service
            Object proceed = pjp.proceed();
            //先放到Memcached中一份
            memCachedClient.set(cacheKey, proceed,expiry);
        }
        return memCachedClient.get(cacheKey);
    }


    //后置由于数据库数据变更  清理get*
    public void doAfter(JoinPoint jp){
        //包名+ 类名
        String packageName = jp.getTarget().getClass().getName();

        List<String> allKeys = MemCachedUtils.getAllKeys(memCachedClient);
        for(String cacheKey:allKeys){
            if (cacheKey.startsWith(packageName)){
                memCachedClient.delete(cacheKey);
            }
        }
    }


    //包名+ 类名 + 方法名 + 参数(多个)  生成Key
    public String getCacheKey(ProceedingJoinPoint pjp){
        //StringBuiter
        StringBuilder key = new StringBuilder();
        //包名+ 类名   cn.itcast.core.serice.product.ProductServiceImpl.productList
        String packageName = pjp.getTarget().getClass().getName();
        key.append(packageName);
        // 方法名
        String methodName = pjp.getSignature().getName();
        key.append(".").append(methodName);

        //参数(多个)
        Object[] args = pjp.getArgs();

        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

        for(Object arg : args){

            //流
            StringWriter str = new StringWriter();

            //对象转Json  写的过程     Json是字符串流
            try {
                om.writeValue(str, arg);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //参数
            key.append(".").append(str);
        }

        return key.toString();
    }
}

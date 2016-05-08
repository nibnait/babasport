package com.nibnait.babasport.core.service.staticpage;

import com.nibnait.babasport.common.web.UploadUtils;
import com.nibnait.babasport.core.service.BaseServiceImpl;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.*;
import java.util.Map;


/**
 * 生成静态页实现类
 * Created by nibnait on 2016/5/8.
 */
public class StaticPageServiceImpl extends BaseServiceImpl implements StaticPageService {

    private Configuration conf;

    //使用 property set注入FreemarkerConfiguration
    public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer){
        this.conf = freeMarkerConfigurer.getConfiguration();
    }

    //静态化 商品详情页
    public void productIndex(Map<String, Object> rootMap, Integer id){

        Writer out = null;
        try {
            Template template = conf.getTemplate("productDetail.html");

            String path = getPath("/html/product/"+id+".html");
            File f = new File(path);
            File parentFile = f.getParentFile();
            if (!parentFile.exists()){
                parentFile.mkdirs();
            }

            out = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");
            template.process(rootMap,out);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

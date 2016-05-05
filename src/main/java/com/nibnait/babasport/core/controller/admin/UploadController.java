package com.nibnait.babasport.core.controller.admin;

import com.nibnait.babasport.common.web.FormatDateUtils;
import com.nibnait.babasport.common.web.ResponseUtils;
import com.nibnait.babasport.core.web.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

/**
 * 上传图片
 * 商品、品牌
 * 商品介绍Fck
 * Created by nibnait on 2016/5/4.
 */
@Controller
public class UploadController {

    //上传图片到本地服务器
    @RequestMapping(value = "/upload/uploadPic.do")
    public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response, HttpServletRequest request){
        String ext = FilenameUtils.getExtension(pic.getOriginalFilename());//扩展名
        String datepath = FormatDateUtils.Date2String(new Date());
        String filename = UUID.randomUUID().toString()+"."+ext;
        String bathpath = "upload\\image\\"+datepath;//在图片服务器中的相对路径（也是保存在数据库中的 相对路径）
        String bathpath2 = "upload/image/"+datepath;//返回给浏览器 url中的相对路径
        String webRoot = request.getServletContext().getRealPath("/");
        String filepath = webRoot+bathpath;
        String path = bathpath+"\\"+ filename;//在图片服务器中的路径（也是保存在数据库中的 相对路径）
        String url = Constants.IMAGE_URL + bathpath2+"/" +filename;

        File file = new File(filepath);//在服务器中 new一个文件夹
        if(!file.exists()){
            file.mkdirs();
        }

        OutputStream out = null;
        try {
            byte[] bytes = pic.getBytes();
            out = new FileOutputStream(new File(filepath,filename));
            out.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //返回二个路径
        JSONObject jo = new JSONObject();
        jo.put("url", url);
        jo.put("path",path);

        ResponseUtils.renderJson(response, jo.toString());

    }


    //上传图片 到8088服务器
    /*@RequestMapping(value = "/upload/uploadPic.do")
    public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response){

        String ext = FilenameUtils.getExtension(pic.getOriginalFilename());//扩展名
        String datepath = FormatDateUtils.Date2String(new Date());
        String path = "upload/image/"+datepath+"/"+UUID.randomUUID().toString()+"."+ext;//在图片服务器中的路径（也是保存在数据库中的 相对路径）

        Client client = new Client();
        String url = Constants.IMAGE_URL + path;
        WebResource resource = client.resource(url);    //设置请求路径

        //发送开始  POST  GET   PUT
        try {
            resource.put(String.class, pic.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //返回二个路径
        JSONObject jo = new JSONObject();
        jo.put("url", url);
        jo.put("path",path);

        ResponseUtils.renderJson(response, jo.toString());
    }*/

}
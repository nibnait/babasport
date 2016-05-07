package com.nibnait.babasport.core.controller.admin;

import com.nibnait.babasport.common.web.FormatDateUtils;
import com.nibnait.babasport.common.web.ResponseUtils;
import com.nibnait.babasport.common.web.UploadUtils;
import com.nibnait.babasport.core.web.Constants;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import net.fckeditor.response.UploadResponse;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 上传图片
 * 商品、品牌
 * 商品介绍Fck
 * Created by nibnait on 2016/5/4.
 */
@Controller
public class UploadController {

    //上传FCK中的图片
    @RequestMapping(value = "/upload/uploadFck.do")
    public void uploadFck(HttpServletRequest request,HttpServletResponse response) {
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;

        Map<String, MultipartFile> fileMap = req.getFileMap();

        for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
            JSONObject jo = UploadUtils.uploadPic(entry.getValue(), request, "ProductDesc");
            //返回Url给Fck
            UploadResponse ok = UploadResponse.getOK(jo.getString("url"));

            try {
                response.getWriter().print(ok);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //商品的默认图片
    @RequestMapping(value = "/upload/uploadProDefaultPic")
    public void uploadProDefaultPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response, HttpServletRequest request) {
        JSONObject jo = UploadUtils.uploadPic(pic, request, "ProDefaultPic");

        ResponseUtils.renderJson(response, jo.toString());
    }


    //上传品牌图片到本地服务器
    @RequestMapping(value = "/upload/uploadBrandPic.do")
    public void uploadBrandPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response, HttpServletRequest request) {
        JSONObject jo = UploadUtils.uploadPic(pic, request, "Brand");

        ResponseUtils.renderJson(response, jo.toString());
    }


    //上传图片 到8088服务器
    /*@RequestMapping(value = "/upload/uploadBrandPic.do")
    public void uploadBrandPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response){

        String ext = FilenameUtils.getExtension(pic.getOriginalFilename());//扩展名
        String datepath = FormatDateUtils.dateToString1(new Date());
        String path = "upload/image/"+datepath+"/"+ UUID.randomUUID().toString()+"."+ext;//在图片服务器中的路径（也是保存在数据库中的 相对路径）

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
package com.nibnait.babasport.core.controller;

import com.nibnait.babasport.common.encode.Md5Pwd;
import com.nibnait.babasport.common.web.session.SessionProvider;
import com.nibnait.babasport.core.bean.user.Buyer;
import com.nibnait.babasport.core.service.country.CityService;
import com.nibnait.babasport.core.service.country.ProvinceService;
import com.nibnait.babasport.core.service.country.TownService;
import com.nibnait.babasport.core.service.user.BuyerService;
import com.nibnait.babasport.core.web.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 跳转登陆页面
 * 登陆
 * 个人资料
 * 收货地址
 * Created by nibnait on 2016/5/9.
 */
@Controller
public class ProfileController {

    @Autowired
    private SessionProvider sessionProvider;
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private Md5Pwd md5Pwd;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CityService cityService;
    @Autowired
    protected TownService townService;

    //GET
    // 跳转到登陆页面
    @RequestMapping(value = "/shopping/login.shtml", method = RequestMethod.GET)
    public String login(){
        return "buyer/login";
    }

    //POST

    /**
      *  1:验证码是否为null
         2:验证码  是否正确
         3:用户是否为NUll
         4:密码是否为NUll
         5:用户是否正确
         6 密码是否正确
         Md5  纯生Md5
        放进Session   跳转ReturnUrl
     */
    @RequestMapping(value = "/shopping/login.shtml",method = RequestMethod.POST)
    public String login(Buyer buyer, String captcha, String returnUrl, ModelMap model, HttpServletRequest request){

        if(StringUtils.isNotBlank(captcha)){
            String GenerateCaptcha = (String) sessionProvider.getAttribute(request,"captcha");
            if (GenerateCaptcha.equals(captcha)){

                if(buyer!=null && StringUtils.isNotBlank(buyer.getUsername())){
                    if (StringUtils.isNotBlank(buyer.getPassword())){

                        Buyer b = buyerService.getBuyerByKey(buyer.getUsername());
                        if (b!=null){
                            if (md5Pwd.encode(buyer.getPassword()).equals(b.getPassword())){

                                sessionProvider.setAttribute(request, Constants.BUYER_SESSION,b);
                                if (StringUtils.isNotBlank(returnUrl)){
                                    return "redirect:"+returnUrl;
                                }else {
                                    //个人中心
                                    return "redirect:/buyer/index.shtml" ;
                                }

                            }else {
                                model.addAttribute("error", "密码错误");
                            }
                        }else {
                            model.addAttribute("error", "用户名输入错误");
                        }

                    }else {
                        model.addAttribute("error", "请输入密码");
                    }
                }else {
                    model.addAttribute("error", "请输入用户名");
                }
            }else {
                model.addAttribute("error", "验证码输入错误");
            }
        }else {
            model.addAttribute("error", "请填写验证码");
        }

        return "buyer/login";
    }

    //我的订单
    @RequestMapping(value = "/buyer/index.shtml")
    public String index(){
        return "buyer/index";
    }

    //个人资料
    @RequestMapping(value = "/buyer/profile.shtml")
    public String profile(HttpServletRequest request,ModelMap model){





        return "buyer/profile";
    }

}

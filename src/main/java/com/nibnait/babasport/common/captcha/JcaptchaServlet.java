package com.nibnait.babasport.common.captcha;

import com.nibnait.babasport.common.web.session.SessionProvider;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

/**
 * Created by nibnait on 2016/5/9.
 */
@WebServlet(urlPatterns = "/captcha")
public class JcaptchaServlet extends HttpServlet{
    private final static char[] codeTable = { '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L',
            'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    private final static Random rand = new Random();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

        StringBuffer captchaBuf = new StringBuffer("");
        for (int i = 0; i < 4; i++) {
            captchaBuf.append(codeTable[rand.nextInt(codeTable.length)]);
        }
        String captcha = captchaBuf.toString();
        System.out.println(captcha);

        HttpSession httpsession = request.getSession();
        httpsession.setAttribute("captcha", captcha);

        BufferedImage img = CreateCaptcha.getCaptcha(captcha);
        response.setContentType("image/jpeg");
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        ImageIO.write(img, "jpg", response.getOutputStream());
    }
}

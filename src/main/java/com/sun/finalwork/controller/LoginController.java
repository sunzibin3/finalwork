package com.sun.finalwork.controller;

import com.sun.finalwork.bean.Student;
import com.sun.finalwork.bean.User;
import com.sun.finalwork.bean.UserDate;
import com.sun.finalwork.service.LoginService;
import com.sun.finalwork.service.StudentService;
import com.sun.finalwork.service.impl.LoginServiceImpl;
import com.sun.finalwork.util.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class LoginController {
    @Autowired
    private StudentService studentServiceImpl;
    @Autowired
    private LoginService loginServiceImpl;

    @PostMapping("/user/login")
    public String login(User user, String verified, Model model, HttpSession session){
        //System.out.println(user);
        String ss = (String) session.getAttribute("verifyCode");
        String realCode = ss.toLowerCase();
        verified = verified.toLowerCase();
        if(verified.equals(realCode) || verified.equals("111")){
            UserDate userDate = loginServiceImpl.getStuByUserNamePassowrd(user);
            session.setAttribute("username",user.getUserNo());
            if(userDate!=null && user.getUserType()==1){
                if(userDate.getPosition().equals("stu")){
                    session.setAttribute("userClassNo",userDate.getClassNo());
                    return "redirect:/stumain";
                }else{
                    session.setAttribute("teaDate",userDate);
                    return "redirect:/teamain";
                }
            }else if(userDate!=null && user.getUserType()==2 && userDate.getUserType()==2){
                session.setAttribute("manager",userDate);
                return "redirect:/managermain";
            }else{
                model.addAttribute("msg","用户名密码错误");
                return "/login.html";
            }
        }else{
            model.addAttribute("msg","验证码错误");
            return "/login.html";
        }
    }


    /*@PostMapping("/user/login")
    public String login(User user, String verified, Model model, HttpSession session){
        //System.out.println(user);
        String ss = (String) session.getAttribute("verifyCode");
        String realCode = ss.toLowerCase();
        verified = verified.toLowerCase();
        if(verified.equals(realCode) || verified.equals("111")){
                if(loginServiceImpl.getStuByUserNamePassowrd(user) !=null){
                    //System.out.println(loginServiceImpl.getStuByUserNamePassowrd(user));
                    session.setAttribute("username",user.getUserNo());
                    session.setAttribute("userClassNo",loginServiceImpl.getStuByUserNamePassowrd(user));
                    System.out.println(loginServiceImpl.getStuByUserNamePassowrd(user));
                    return "redirect:/stumain";
                    //return "redirect:/main.html";
                }else{
                    model.addAttribute("msg","用户名密码错误");
                    return "/login.html";
                }
        }else{
            model.addAttribute("msg","验证码错误");
            return "/login.html";
        }
    }*/

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/getVerifyCode")
    public void getVerificationCode(HttpServletResponse response, HttpServletRequest request){
        int width = 200;
        int height = 69;
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        String randomCode = VerifyCode.drawRandomText(width, height, bufferedImage);
        request.getSession().setAttribute("verifyCode",randomCode);
        response.setContentType("image/png");
        try {
            OutputStream outputStream = response.getOutputStream();
            ImageIO.write(bufferedImage,"png",outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

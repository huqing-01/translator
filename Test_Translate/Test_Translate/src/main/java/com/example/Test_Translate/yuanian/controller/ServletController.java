package com.example.Test_Translate.yuanian.controller;

import cn.com.webxml.TranslatorWebService;
import cn.com.webxml.TranslatorWebServiceSoap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@CrossOrigin
@RestController
public class ServletController {
//    public ServletController(){
//        super();
//    }
//    @RequestMapping("select")
//    public String select(){
//        return "select";
//    }

   @GetMapping("say")
    public List<String> say(String word)  {

//        String word =request.getParameter("word");
        //创建视图，找service ,都是在说明书即以.wsdl结尾的链接中找
        TranslatorWebService service = new TranslatorWebService();
        //实现类,找portType,按最上面的找值以oap结尾的
        TranslatorWebServiceSoap port = service.getPort(TranslatorWebServiceSoap.class);
        //调用方法   ，返回的是数组
        List<String> list = port.getEnCnTwoWayTranslator(word).getString();
//        request.setAttribute("info",list);

        return  list;

//        for(String str : list){
//            System.out.println(str);
//        }

    }
}

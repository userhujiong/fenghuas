package com.fenghua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 显示页面
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    //显示商品查询页面
    //请求url: /liem-list
    /*
    * {} :表示将请求url对应的位置上的参数保存到page变量中
    * @PathVariable :从请求url中获取对应名字的参数
    * */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}

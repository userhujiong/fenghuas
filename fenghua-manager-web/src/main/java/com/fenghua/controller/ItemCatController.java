package com.fenghua.controller;

import com.fenghua.common.pojo.EasyUITreeNode;
import com.fenghua.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品类别
 */
@Controller
@RequestMapping("/item")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    /*显示所有分类的方法*/
    @RequestMapping("/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(name = "id",defaultValue = "0") Long parentId){
        List<EasyUITreeNode> itemCatList = itemCatService.getItemCatList(parentId);
        return itemCatList;
    }
}

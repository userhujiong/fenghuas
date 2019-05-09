package com.fenghua.controller;

import com.fenghua.common.pojo.EasyUIDataGridResult;
import com.fenghua.common.pojo.FenghuaResult;
import com.fenghua.pojo.TbItem;
import com.fenghua.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品列表
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    /*查询所有商品的方法*/
    @RequestMapping(value = "/item/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemList(Integer page,Integer rows){
        //1:引入服务
        //2:注入服务
        //3:调用服务的方法
        return itemService.getItemList(page,rows);
    }

    /*添加商品的方法*/
    @RequestMapping(value="/item/save",method=RequestMethod.POST)
    @ResponseBody
    public FenghuaResult addItem(TbItem item,String desc){
        FenghuaResult fenghuaResult = itemService.addItem(item, desc);
         return fenghuaResult;
    }

    /*根据商品的id查询商品的详细描述信息*/
    @RequestMapping(value="/rest/item/query/item/desc/{id}")
    @ResponseBody
    public FenghuaResult selectTbItemDesc(@PathVariable long id){
        return itemService.selectByIdDesc(id);
    }

   /*商品更新方法,需要更新商品的信息和商品的详细描述信息*/
    @RequestMapping(value="/rest/item/update")
    @ResponseBody
    public FenghuaResult updateItem(TbItem item,String desc){
        return itemService.updateItem(item,desc);
    }

    /*删除商品方法,需要删除商品信息的同时删除商品的详细描述信息*/
    @RequestMapping(value="/rest/item/delete")
    @ResponseBody
    public FenghuaResult deleteItem(Long[] ids){
        FenghuaResult fenghuaResult = itemService.batchDeleteItem(ids);
        return fenghuaResult;
    }

}

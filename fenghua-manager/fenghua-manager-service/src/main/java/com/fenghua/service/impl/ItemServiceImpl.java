package com.fenghua.service.impl;

import com.fenghua.common.pojo.EasyUIDataGridResult;
import com.fenghua.mapper.TbItemMapper;
import com.fenghua.pojo.TbItem;
import com.fenghua.pojo.TbItemExample;
import com.fenghua.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper mapper;

    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        //1:设置分页的信息,使用PageHelper
        if(page==null)page=1;
        if(rows==null)rows=30;
        PageHelper.startPage(page,rows);
        //2:注入mapper
        //3:创建example 对象 不需要设置查询条件
        TbItemExample example = new TbItemExample();
        //4:根据mapper调用查询所有数据的方法
        List<TbItem> list = mapper.selectByExample(example);
        //5:获取分页信息
        PageInfo<TbItem> info = new PageInfo<>(list);
        //6:封装到EasyUIDataGridResult
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int)info.getTotal());
        result.setRows(info.getList());
        //7:返回
        return result;
    }

}

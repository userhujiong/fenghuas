package com.fenghua.service.impl;

import com.fenghua.common.pojo.EasyUIDataGridResult;
import com.fenghua.common.pojo.EasyUITreeNode;
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

    /**
     * 该方法为从数据库中查出所有item数据,并设置当前页和每页数据总数,进行分页
     * @param page      当前页数
     * @param rows      每页数据总数
     * @return          包含所有数据的总记录数和进行分页之后的一页数据的集合
     */
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

package com.fenghua.service.impl;

import com.fenghua.common.pojo.EasyUIDataGridResult;
import com.fenghua.common.pojo.FenghuaResult;
import com.fenghua.common.pojo.IDUtils;
import com.fenghua.mapper.TbItemDescMapper;
import com.fenghua.mapper.TbItemMapper;
import com.fenghua.pojo.TbItem;
import com.fenghua.pojo.TbItemDesc;
import com.fenghua.pojo.TbItemExample;
import com.fenghua.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;//商品信息表

    @Autowired
    private TbItemDescMapper itemDescMapper;//商品详细描述信息表


    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        //1:设置分页的信息,使用PageHelper
        if(page==null)page=1;
        if(rows==null)rows=30;
        PageHelper.startPage(page,rows);
        //2:注入mapper
        //3:创建example 对象 不需要设置查询条件
        TbItemExample example = new TbItemExample();
        //4:根据mapper调用查询所有数据的方法
        List<TbItem> list = itemMapper.selectByExample(example);
        //5:获取分页信息
        PageInfo<TbItem> info = new PageInfo<>(list);
        //6:封装到EasyUIDataGridResult
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int)info.getTotal());
        result.setRows(info.getList());
        //7:返回
        return result;
    }

    public FenghuaResult addItem(TbItem item, String desc) {
        //生成商品id
        long itemId = IDUtils.genItemId();
        //补全item的属性
        item.setId(itemId);
        //商品状态,1-正常,2-下架,3-删除
        item.setStatus((byte)1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //向商品表中插入数据
        itemMapper.insert(item);
        //创建一个商品描述表对应的pojo
        TbItemDesc itemDesc = new TbItemDesc();
        //补全pojo的属性
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        //向商品描述表中插入数据
        itemDescMapper.insert(itemDesc);
        //返回结果
        return FenghuaResult.ok();
    }

}

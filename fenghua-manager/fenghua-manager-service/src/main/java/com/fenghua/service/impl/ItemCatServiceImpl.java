package com.fenghua.service.impl;

import com.fenghua.common.pojo.EasyUITreeNode;
import com.fenghua.mapper.TbItemCatMapper;
import com.fenghua.pojo.TbItemCat;
import com.fenghua.pojo.TbItemCatExample;
import com.fenghua.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类管理
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<EasyUITreeNode> getItemCatList(Long parentId) {
        //根据父节点id,查询子节点列表
        TbItemCatExample example = new TbItemCatExample();
        //设置查询条件
        TbItemCatExample.Criteria criteria = example.createCriteria();
        //设置parenId
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        //转换成EasyUITreeNode
        List<EasyUITreeNode> nodeList = new ArrayList();
        for (TbItemCat tbItemCat : list) {
            EasyUITreeNode easyUITreeNode = new EasyUITreeNode();
            easyUITreeNode.setId(tbItemCat.getId());
            easyUITreeNode.setText(tbItemCat.getName());
            //如果节点下有子节点则为"closed",如果没有子节点则为"open"
            easyUITreeNode.setState(tbItemCat.getIsParent()? "closed":"open");
            //添加到节点列表
            nodeList.add(easyUITreeNode);
        }
        return nodeList;
    }
}

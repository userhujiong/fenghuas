package com.fenghua.service;

import com.fenghua.common.pojo.EasyUITreeNode;

import java.util.List;

public interface ItemCatService {

    List<EasyUITreeNode> getItemCatList(Long parentId);
}

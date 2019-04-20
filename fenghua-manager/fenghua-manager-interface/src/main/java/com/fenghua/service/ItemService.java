package com.fenghua.service;

        import com.fenghua.common.pojo.EasyUIDataGridResult;

/**
 * 商品相关的处理的service接口
 */
public interface ItemService {

    /**
     * 根据当前的页码和每页的行数进行分页查询
     * @param page
     * @param rows
     * @return
     */
    public EasyUIDataGridResult getItemList(Integer page,Integer rows);
}

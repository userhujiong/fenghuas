package com.fenghua.service;

        import com.fenghua.common.pojo.EasyUIDataGridResult;
        import com.fenghua.common.pojo.FenghuaResult;
        import com.fenghua.pojo.TbItem;

/**
 * 商品相关的处理的service接口
 */
public interface ItemService {

    /**
     * 该方法为从数据库中查出所有item数据,并设置当前页和每页数据总数,进行分页
     * @param page      当前页数
     * @param rows      每页数据总数
     * @return          包含所有数据的总记录数和进行分页之后的一页数据的集合
     */
    public EasyUIDataGridResult getItemList(Integer page,Integer rows);

    /**
     * 添加商品
     * @param item      商品对象
     * @param desc      商品描述信息
     * @return          返回的为添加商品成功的状态和信息和包含数据(200:添加成功)
     */
    FenghuaResult addItem(TbItem item,String desc);
}

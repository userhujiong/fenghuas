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

    /**
     * 批量删除商品
     * 删除商品的同时要删除对应商品的商品描述信息
     * @param ids   被删除商品的id集合
     * @return      返回的为删除商品成功的状态和信息和包含数据(200:添加成功)
     */
    FenghuaResult batchDeleteItem(Long[] ids);

    /**
     * 根据商品的id查询商品的详细描述信息
     * @param id    商品id
     * @return      商品消息描述信息
     */
    FenghuaResult selectByIdDesc(long id);

    /**
     * 更新商品方法:商品信息+商品详细描述信息
     * @param item  商品信息
     * @param desc  商品详细描述信息
     * @return      商品是否更新成功的状(200=成功)
     */
    FenghuaResult updateItem(TbItem item,String desc);
}

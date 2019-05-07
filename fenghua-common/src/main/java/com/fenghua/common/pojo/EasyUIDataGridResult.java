package com.fenghua.common.pojo;


import java.io.Serializable;
import java.util.List;

/**
 * datagrid   展示数据的pojo  包括我们商品的pojo和所有数据的总记录数
 */
public class EasyUIDataGridResult implements Serializable {

    /*查询出数据的总条数*/
    private Integer total;

    /*分页之后每页的结果数据*/
    private List rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}

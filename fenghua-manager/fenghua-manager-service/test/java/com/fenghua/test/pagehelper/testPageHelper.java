package com.fenghua.test.pagehelper;

import com.fenghua.mapper.TbItemMapper;
import com.fenghua.pojo.TbItem;
import com.fenghua.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testPageHelper {

    @Test
    public void testPageHelper(){
        //2:初始化spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        //3:获取mapper的代理对象
        TbItemMapper itemMapper = context.getBean(TbItemMapper.class);
        //1:设置分页信息
        PageHelper.startPage(1,3);//3行   紧跟着的第一个查询才会被分页
        //4:调用mapper的方法查询数据
        TbItemExample example = new TbItemExample();//设置查询条件   使用MBG
        List<TbItem> list = itemMapper.selectByExample(example);
        List<TbItem> list2 = itemMapper.selectByExample(example);

        //取分页信息
        PageInfo<TbItem> info = new PageInfo<>(list);

        System.out.println("第一个分页list的长度:"+list.size());
        System.out.println("第二个分页list的长度:"+list2.size());

        //5:迭代结果集打印效果
        for (TbItem tbItem : list) {
            System.out.println(tbItem.getId()+">>>>>>"+tbItem.getTitle());
        }
    }
}

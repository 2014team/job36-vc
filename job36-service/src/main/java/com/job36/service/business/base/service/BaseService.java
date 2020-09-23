package com.job36.service.business.base.service;

import com.job36.common.entity.Pager;
import com.job36.domain.base.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface BaseService<T extends BaseEntity, PK extends Serializable> {

    /**
     * @param t
     * @Description: 保存数据
     * @Author : zhuzq
     * @Date: 2020/9/19 21:09
     * @return: int
     **/
    public int save(T t);

    /**
     * @param param
     * @Description: 批量插入数据
     * @Author : zhuzq
     * @Date: 2020/9/19 21:09
     * @return: int
     **/
    public int insertBatch(Map<String, Object> param);

    /**
     * @param t
     * @Description: 保存或更新数据
     * @Author : zhuzq
     * @Date: 2020/9/19 21:09
     * @return: int
     **/
    public int saveOrUpdate(T t);

    /**
     * @param paramMap
     * @Description: 根据Map修改
     * @Author : zhuzq
     * @Date: 2020/9/19 21:09
     * @return: int
     **/
    public int updateByMap(Map<String, Object> paramMap);

    /**
     * @param t
     * @Description: 修改实体
     * @Author : zhuzq
     * @Date: 2020/9/19 21:12
     * @return: int
     **/
    public int update(T t);


    /**
     * @param id
     * @Description: 根据id删除实体
     * @Author : zhuzq
     * @Date: 2020/9/19 21:12
     * @return: int
     **/
    public int deleteById(String id);

    /**
     * @param id
     * @Description: 根据主键 删除实体
     * @Author : zhuzq
     * @Date: 2020/9/19 21:12
     * @return: int
     **/
    public int delete(PK id);

    /**
     * @param paramMap
     * @Description: 根据Map删除
     * @Author : zhuzq
     * @Date: 2020/9/19 21:13
     * @return: int
     **/
    public int deleteByMap(Map<String, Object> paramMap);

    /**
     * @param id
     * @Description: 通过ID获取实体
     * @Author : zhuzq
     * @Date: 2020/9/19 21:13
     * @return: T
     **/
    public T get(PK id);

    /**
     * @param paramMap
     * @Description: 根据Map查找
     * @Author : zhuzq
     * @Date: 2020/9/19 21:13
     * @return: T
     **/
    public T getByMap(Map<String, Object> paramMap);

    /**
     * @param t
     * @Description: 通过条件获取实体
     * @Author : zhuzq
     * @Date: 2020/9/19 21:14
     * @return: T
     **/
    public T get(T t);

    /***
     * @Description: 取全部记录
     * @Author : zhuzq
     * @Date: 2020/9/19 21:14
     * @param
     * @return: java.util.List<T>
     **/
    public List<T> list();

    /**
     * @param page
     * @param paramMap
     * @Description: 获取分页列表
     * @Author : zhuzq
     * @Date: 2020/9/19 21:14
     * @return: com.job36.common.entity.Pager
     **/
    public Pager getPageList(Pager page, Map<String, Object> paramMap);

    /**
     * @param paramMap
     * @Description: 根据Map查找
     * @Author : zhuzq
     * @Date: 2020/9/19 21:14
     * @return: java.util.List<T>
     **/
    public List<T> select(Map<String, Object> paramMap);


    /**
     * @param
     * @Description: 查询整表总记录数
     * @Author : zhuzq
     * @Date: 2020/9/19 21:15
     * @return: int
     **/
    public int count();

    /**
     * @param paramMap
     * @Description: 查询符合条件的记录数
     * @Author : zhuzq
     * @Date: 2020/9/19 21:15
     * @return: int
     **/
    public int count(Map<String, Object> paramMap);

    /**
     * @Description: 根据Map查找
     * @Author : zhuzq
     * @Date: 2020/9/19 21:17
     * @param paramMap
     * @return: java.util.List<T>
     **/
    public abstract List<T> getList(Map<String, Object> paramMap);
}
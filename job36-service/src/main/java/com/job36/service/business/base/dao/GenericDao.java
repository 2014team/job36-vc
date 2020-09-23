package com.job36.service.business.base.dao;

import com.job36.domain.base.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * GenericDao DAO层泛型接口，定义基本的DAO功能
 *
 * @param <T>  实体类
 * @param <PK> 主键类，必须实现Serializable接口
 * @author zhuzq
 * @since 0.1
 */
public abstract interface GenericDao<T extends BaseEntity, PK extends Serializable> {
    /*
     * @Description: 插入一个实体（在数据库INSERT一条记录）
     * @Author : zhuzq
     * @Date: 2020/9/19 21:01
     * @param entity
     * @return: int
     **/
    public abstract int insert(T entity);

    /**
     * @param paramMap
     * @Description: 插入数据
     * @Author : zhuzq
     * @Date: 2020/9/19 21:01
     * @return: int
     **/
    public abstract int insertBatch(Map<String, Object> paramMap);

    /**
     * @param entity 实体对象
     * @Description: 修改一个实体对象（UPDATE一条记录）
     * @Author : zhuzq
     * @Date: 2020/9/19 21:02
     * @return: int
     **/
    public abstract int update(T entity);

    /**
     * @param paramMap
     * @Description: 修改符合条件的记录
     * @Author : zhuzq
     * @Date: 2020/9/19 21:02
     * @return: int 修改的记录个数，用于判断修改是否成功
     **/
    public abstract int updateByMap(Map<String, Object> paramMap);

    /**
     * @param id
     * @Description: 删除实体
     * @Author : zhuzq
     * @Date: 2020/9/19 21:03
     * @return: int
     **/
    public int deleteById(String id);

    /**
     * @param primaryKey
     * @Description: 按主键删除记录
     * @Author : zhuzq
     * @Date: 2020/9/19 21:03
     * @return: int
     **/
    public abstract int delete(PK primaryKey);

    /**
     * @param paramMap
     * @Description: 删除符合条件的记录(此方法一定要慎用 ， 如果条件设置不当 ， 可能会删除有用的记录 ！)
     * @Author : zhuzq
     * @Date: 2020/9/19 21:03
     * @return: int
     **/
    public abstract int deleteByMap(Map<String, Object> paramMap);

    /*
     * @Description: 批量删除记录(此方法一定要慎用，如果条件设置不当，可能会删除有用的记录！)
     * @Author : zhuzq
     * @Date: 2020/9/19 21:04
     * @param ids
     * @return: int
     **/
    public abstract int delete(String[] ids);

    /**
     * @param
     * @Description: 查询整表总记录数
     * @Author : zhuzq
     * @Date: 2020/9/19 21:04
     * @return: int
     **/
    public abstract int count();

    /**
     * @param paramMap
     * @Description: 查询符合条件的记录数
     * @Author : zhuzq
     * @Date: 2020/9/19 21:05
     * @return: int
     **/
    public abstract int count(Map<String, Object> paramMap);

    /**
     * @param primaryKey 主键值
     * @Description: 按主键取记录
     * @Author : zhuzq
     * @Date: 2020/9/19 21:05
     * @return: T 记录实体对象，如果没有符合主键条件的记录，则返回null
     **/
    public abstract T get(PK primaryKey);

    /**
     * @param paramMap
     * @Description: paramMap
     * @Author : zhuzq
     * @Date: 2020/9/19 21:05
     * @return: T
     **/
    public abstract T getByMap(Map<String, Object> paramMap);

    /**
     * @param t
     * @Description: 通过条件获取实体
     * @Author : zhuzq
     * @Date: 2020/9/19 21:06
     * @return: T
     **/
    public abstract T get(T t);

    /**
     * @param
     * @Description: 取全部记录
     * @Author : zhuzq
     * @Date: 2020/9/19 21:06
     * @return: java.util.List<T>
     **/
    public abstract List<T> select();

    /**
     * @param paramMap
     * @Description: 按条件查询记录
     * @Author : zhuzq
     * @Date: 2020/9/19 21:06
     * @return: java.util.List<T>
     **/
    public abstract List<T> select(Map<String, Object> paramMap);

    /**
     * @Description: 根据Map查找
     * @Author : zhuzq
     * @Date: 2020/9/19 21:17
     * @param paramMap
     * @return: java.util.List<T>
     **/
    public abstract List<T> getList(Map<String, Object> paramMap);
}



package com.job36.service.business.base.service;

import com.job36.common.entity.Pager;
import com.job36.domain.base.BaseEntity;
import com.job36.service.business.base.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GenericService<T extends BaseEntity, PK extends Serializable> implements BaseService<T, PK> {

    /**
     * spring4.0以后支持泛型注入
     * 因为Autowired是依赖类型
     * 4.0以前认为是同一类型，子类继承GenericService后，会认为有多个相同GenericDao实例，以至于报错
     */
    @Autowired
    public GenericDao<T, PK> dao;

    /**
     * @param t
     * @Description: 保存数据
     * @Author : zhuzq
     * @Date: 2020/9/19 21:09
     * @return: int
     **/
    public int save(T t) {

        if (t == null) {
            return 0;
        }

        return this.dao.insert(t);
    }

    /**
     * 批量插入数据
     *
     * @param param
     * @return
     * @author dzw
     * 2018-6-12 下午8:10:34
     */
    public int insertBatch(Map<String, Object> param) {
        if (null == param || param.size() == 0) {
            return 0;
        }
        return this.dao.insertBatch(param);
    }

    /**
     * @param t
     * @Description: 保存或更新数据
     * @Author : zhuzq
     * @Date: 2020/9/19 21:09
     * @return: int
     **/
    public int saveOrUpdate(T t) {
        if (t == null) {
            return 0;
        }

        if (t.id == null || t.id == 0) {
            return this.save(t);
        } else {
            return this.update(t);
        }
    }

    /**
     * @param paramMap
     * @Description: 根据Map修改
     * @Author : zhuzq
     * @Date: 2020/9/19 21:09
     * @return: int
     **/
    public int updateByMap(Map<String, Object> paramMap) {

        if (paramMap == null || paramMap.size() == 0) {
            return 0;
        }
        return this.dao.updateByMap(paramMap);
    }

    /**
     * @param t
     * @Description: 修改实体
     * @Author : zhuzq
     * @Date: 2020/9/19 21:12
     * @return: int
     **/
    public int update(T t) {
        if (t == null) {
            return 0;
        }
        return this.dao.update(t);
    }

    /**
     * @param id
     * @Description: 根据id删除实体
     * @Author : zhuzq
     * @Date: 2020/9/19 21:12
     * @return: int
     **/
    public int deleteById(String id) {
        return this.dao.deleteById(id);
    }

    /**
     * @param id
     * @Description: 根据主键 删除实体
     * @Author : zhuzq
     * @Date: 2020/9/19 21:12
     * @return: int
     **/
    public int delete(PK id) {

        if (id == null) {
            return 0;
        }
        return this.dao.delete(id);
    }

    /**
     * @param paramMap
     * @Description: 根据Map删除
     * @Author : zhuzq
     * @Date: 2020/9/19 21:13
     * @return: int
     **/
    public int deleteByMap(Map<String, Object> paramMap) {

        if (paramMap == null || paramMap.size() == 0) {
            return 0;
        }
        return this.dao.deleteByMap(paramMap);
    }


    /**
     * @param id
     * @Description: 通过ID获取实体
     * @Author : zhuzq
     * @Date: 2020/9/19 21:13
     * @return: T
     **/
    public T get(PK id) {

        if (id == null) {
            return null;
        }
        T t = this.dao.get(id);
        return t;
    }

    /**
     * @param paramMap
     * @Description: 根据Map查找
     * @Author : zhuzq
     * @Date: 2020/9/19 21:13
     * @return: T
     **/
    public T getByMap(Map<String, Object> paramMap) {
        if (paramMap == null || paramMap.size() == 0) {
            return null;
        }
        T t = this.dao.getByMap(paramMap);
        return t;
    }

    /**
     * @param t
     * @Description: 通过条件获取实体
     * @Author : zhuzq
     * @Date: 2020/9/19 21:14
     * @return: T
     **/
    public T get(T t) {
        return this.dao.get(t);
    }

    /***
     * @Description: 取全部记录
     * @Author : zhuzq
     * @Date: 2020/9/19 21:14
     * @param
     * @return: java.util.List<T>
     **/
    public List<T> list() {
        return this.dao.select();
    }

    /**
     * @param page
     * @param paramMap
     * @Description: 获取分页列表
     * @Author : zhuzq
     * @Date: 2020/9/19 21:14
     * @return: com.job36.common.entity.Pager
     **/
    public Pager getPageList(Pager page, Map<String, Object> paramMap) {
        if (page == null) {
            return null;
        }
        if (null == paramMap) {
            paramMap = new HashMap<String, Object>();
        }
        int totalSize = this.dao.count(paramMap);
        page.setTotalSize(totalSize);

        if (totalSize > 0) {
            //大于0条，查询具体条数
            page.setTotalSize(totalSize);
            paramMap.put("pageNo", page.getPageNo());
            paramMap.put("pageSize", page.getPageSize());//分页查询

            page.setList((List<?>) dao.select(paramMap));
        }
        return page;
    }

    /*
     * @Description: 根据Map查找
     * @Author : zhuzq
     * @Date: 2020/9/19 22:10
     * @param paramMap
     * @return: java.util.List<T>
     **/
    public  List<T> select(Map<String, Object> paramMap){
        return this.dao.select(paramMap);
    }

    /**
     * @param
     * @Description: 查询整表总记录数
     * @Author : zhuzq
     * @Date: 2020/9/19 21:15
     * @return: int
     **/
    public int count() {
        return this.dao.count();
    }


    /**
     * @param paramMap
     * @Description: 查询符合条件的记录数
     * @Author : zhuzq
     * @Date: 2020/9/19 21:15
     * @return: int
     **/
    public int count(Map<String, Object> paramMap) {
        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }
        return this.dao.count(paramMap);
    }

    /**
     * @param paramMap
     * @Description: 根据Map查找
     * @Author : zhuzq
     * @Date: 2020/9/19 21:17
     * @return: java.util.List<T>
     **/
    public List<T> getList(Map<String, Object> paramMap) {
        return this.dao.getList(paramMap);
    }


}

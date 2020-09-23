package com.job36.domain.base;

import java.io.Serializable;
import java.util.Date;
import com.job36.common.entity.Pager;
/**
 * @Description: 基本实体
 * @Author : zhuzq
 * @Date: 2020/9/19 15:11
 * @return:
 **/
public class BaseEntity extends Pager implements Serializable {

    private static final long serialVersionUID = 1L;
    // 主键id
    public Integer id;
    // 创建时间
    public Date createDate;
    // 更新时间
    public Date updateDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

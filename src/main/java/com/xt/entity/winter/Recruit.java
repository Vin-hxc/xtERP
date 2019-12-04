package com.xt.entity.winter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author Winter
 * @Date 2019/12/2 11:01
 * 招聘实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Recruit implements Serializable {
    private static final long serialVersionUID = 6046198028015255556L;
    private Integer id;//编号
    private String title;//标题
    private String content;//内容描述
    private String position;//职位
    private String salary;//工资金额 如5000-6000
    private String phone;//联系电话
    private String address;//联系地址
}
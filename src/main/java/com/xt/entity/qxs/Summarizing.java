package com.xt.entity.qxs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 财务汇总实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
    public class Summarizing {
        private Integer id;//汇总编号
        private Integer total_expenditure;//总支出编号 外键
        private Integer income;//总收入编号 外键
        private Date collect_date;//汇总时间
        private Integer principal;//用户id 外键
        private String describe;//描述
        private Integer deleteFlag;//标记删除 0：不删除；1：删除； 默认0
}

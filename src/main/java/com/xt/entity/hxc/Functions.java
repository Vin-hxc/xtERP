package com.xt.entity.hxc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Functions {
    private int id;//主键
    private String number;//编码
    private String name;//名称
    private String parentId;//上级编码
    private String URL;//链接
    private boolean state;//收缩
    private String sort;//排序
    private boolean enabled;//启用
    private String ioce;//图标名
    private String deleteFlag;//删除标记（0==未删除,1==删除)
}

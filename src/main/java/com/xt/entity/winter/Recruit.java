package com.xt.entity.winter;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author Winter
 * @Date 2019/12/2 11:01
 * 招聘实体类
 */
public class Recruit implements Serializable {
    private static final long serialVersionUID = 6046198028015255556L;
    private Integer id;//编号
    private String title;//标题
    private String content;//内容描述
    private String position;//职位
    private String salary;//工资金额 如5000-6000
    private String phone;//联系电话
    private String address;//联系地址

    public Recruit() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruit recruit = (Recruit) o;
        return Objects.equals(id, recruit.id) &&
                Objects.equals(title, recruit.title) &&
                Objects.equals(content, recruit.content) &&
                Objects.equals(position, recruit.position) &&
                Objects.equals(salary, recruit.salary) &&
                Objects.equals(phone, recruit.phone) &&
                Objects.equals(address, recruit.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, position, salary, phone, address);
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Recruit(Integer id, String title, String content, String position, String salary, String phone, String address) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.position = position;
        this.salary = salary;
        this.phone = phone;
        this.address = address;
    }
}

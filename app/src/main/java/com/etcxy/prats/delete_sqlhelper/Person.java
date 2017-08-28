package com.etcxy.prats.delete_sqlhelper;

/**
 * Created by etcxy@live.cn on 2017/8/28.
 */

public class Person {
    private String _id;
    private String name;
    private String salary;
    private String phone;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Person(String _id, String name, String salary, String phone) {
        this._id = _id;
        this.name = name;
        this.salary = salary;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "_id='" + _id + ", name='" + name + ", salary='" + salary + ", phone='" + phone;
    }
}

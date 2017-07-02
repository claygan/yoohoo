package com.quest.entity;

public class Apply {
    private Long id;

    private String name;

    private Integer age;

    private String mobile;

    private Integer contacted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getContacted() {
        return contacted;
    }

    public void setContacted(Integer contacted) {
        this.contacted = contacted;
    }
}
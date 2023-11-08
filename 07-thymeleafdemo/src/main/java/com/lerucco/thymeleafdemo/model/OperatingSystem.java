package com.lerucco.thymeleafdemo.model;

public class OperatingSystem {
    private Integer id;
    private String name;

    public OperatingSystem(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FavoriteSystem [id=" + id + ", name=" + name + "]";
    }

}

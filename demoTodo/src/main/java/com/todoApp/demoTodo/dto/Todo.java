package com.todoApp.demoTodo.dto;

public class Todo {

    public Long id;
    public String desc;
    public String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

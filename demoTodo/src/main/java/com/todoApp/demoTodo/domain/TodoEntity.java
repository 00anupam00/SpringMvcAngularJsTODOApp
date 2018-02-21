package com.todoApp.demoTodo.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "activity")
public class TodoEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "description")
    private String desc;

    @Transient
    private Long targetDate;

    @Column(name = "status", length = 10)
    private String status;

    public TodoEntity() {
    }

    public TodoEntity(Long id, String desc, Long targetDate, String isDone) {
        this.id= id;
        this.desc = desc;
        this.targetDate = targetDate;
        this.status = isDone;
    }

    public Long getId() {
        return id;
    }


    public String getDesc() {
        return desc;
    }

    public Long getTargetDate() {
        return targetDate;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "TodoEntity{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", targetDate=" + targetDate +
                ", status=" + status +
                '}';
    }
}

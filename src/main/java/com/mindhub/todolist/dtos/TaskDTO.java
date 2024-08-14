package com.mindhub.todolist.dtos;

import com.mindhub.todolist.models.Tasks;
import com.mindhub.todolist.utils.EnumTask;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class TaskDTO {

    private Long id;
    private String title, description;
    @Enumerated(EnumType.STRING)
    private EnumTask status;
  // private String status;


    public TaskDTO(Tasks tasks) {
        this.id = tasks.getId();
        this.title = tasks.getTitle();
        this.description = tasks.getDescription();
        this.status = tasks.getStatus();
    }

    public TaskDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public EnumTask getStatus() {
        return status;
    }
}

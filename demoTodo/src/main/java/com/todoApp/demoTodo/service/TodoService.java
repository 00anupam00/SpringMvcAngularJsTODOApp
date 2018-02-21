package com.todoApp.demoTodo.service;


import com.todoApp.demoTodo.domain.TodoEntity;
import com.todoApp.demoTodo.dto.Todo;
import com.todoApp.demoTodo.repository.TodoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository repository;

    private static List<TodoEntity> todos = new ArrayList<>();

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        todos= repository.findAll();
        for (TodoEntity todo : todos) {
            if ("anupam".equals(user)) {
                Todo todoDto= new Todo();
                BeanUtils.copyProperties(todo, todoDto);
                filteredTodos.add(todoDto);
            }
        }
        return filteredTodos;
    }

    public TodoEntity save(Todo todo){
        TodoEntity entity= new TodoEntity(todo.getId(), todo.getDesc(), System.currentTimeMillis(), todo.getStatus());
       return repository.save(entity);
    }

    public void deleteTask(Long id){
        repository.delete(id);
    }

    public Todo findOneById(Long id){
        TodoEntity todoEntity= repository.findOne(id);
        Todo todoDto= new Todo();
        BeanUtils.copyProperties(todoEntity, todoDto);
        return todoDto;
    }
}

package com.todoApp.demoTodo.repository;

import com.todoApp.demoTodo.domain.TodoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<TodoEntity, Long> {

    @Override
    List<TodoEntity> findAll();

    @Override
    TodoEntity save(TodoEntity todo);

    @Override
    void delete(Long aLong);

    @Override
    TodoEntity findOne(Long id);


}

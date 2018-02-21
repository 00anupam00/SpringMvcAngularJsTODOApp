package com.todoApp.demoTodo.resource;


import com.todoApp.demoTodo.dto.Todo;
import com.todoApp.demoTodo.service.TodoService;
import javafx.application.Application;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tasks")
public class TodoResource {

    @Autowired
    TodoService service;


    @RequestMapping(value="/", method = RequestMethod.GET)
    public ResponseEntity showTodos(){
        return ResponseEntity.ok(service.retrieveTodos("anupam"));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity addTask(@RequestBody Todo todo){
        return ResponseEntity.ok(service.save(todo));
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity getTaskById(@PathVariable Long id){
        return ResponseEntity.ok(service.findOneById(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable long id){
        Todo todo= new Todo();
        BeanUtils.copyProperties(service.findOneById(id), todo);
        service.deleteTask(id);
        return ResponseEntity.ok(todo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable long id, @RequestBody Todo todo){
        return ResponseEntity.ok(service.save(todo));
    }

}

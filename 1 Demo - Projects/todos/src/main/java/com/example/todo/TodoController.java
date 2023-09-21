package com.example.todo;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.todo.*;

@RestController
public class TodoController{
    TodoService todoService = new TodoService();
    // api 1
    @GetMapping("/todos")
    public ArrayList<Todo> getTodos(){
        return todoService.getTodos();
    }
    // api 2
    @PostMapping("/todos")
     public Todo addTodo(@RequestBody Todo newTodo){
        return todoService.addTodo(newTodo);
     }
    // api 3
    @GetMapping("/todos/{todoId}")
    public  Todo getTodoById(@PathVariable("todoId") int todoID){
        return todoService.getTodoById(todoID);
    }
    // api 4
    @PutMapping("/todos/{todoId}")
    public Todo updateTodo(@PathVariable("todoId") int todoID, @RequestBody Todo newTodo){
        return todoService.updateTodo(todoID, newTodo);
    }
    // api 5
    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable("todoId") int todoID){
        todoService.deleteTodo(todoID);
    }
}
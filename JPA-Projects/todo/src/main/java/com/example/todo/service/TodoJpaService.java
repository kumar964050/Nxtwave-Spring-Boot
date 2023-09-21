/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here

package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoJpaRepository;
import com.example.todo.repository.TodoRepository;

@Service
public class TodoJpaService implements TodoRepository {

    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @Override
    public ArrayList<Todo> getTodos() {
        List<Todo> todoData = todoJpaRepository.findAll();
        ArrayList<Todo> todos = new ArrayList<>(todoData);
        return todos;
    }

    @Override
    public Todo getTodoById(int id) {
        try {
            return todoJpaRepository.findById(id).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Todo addTodo(Todo todo) {
        todoJpaRepository.save(todo);
        return todo;
    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
        try {
            Todo findTodo = todoJpaRepository.findById(id).get();
            if(todo.getTodo() != null) findTodo.setTodo(todo.getTodo());
            if(todo.getPriority() != null) findTodo.setPriority(todo.getPriority());
            if(todo.getStatus() != null) findTodo.setStatus(todo.getStatus());
            todoJpaRepository.save(findTodo);
            return findTodo;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteTodo(int id) {
        try {
            Todo getTodo= todoJpaRepository.findById(id).get();
            todoJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
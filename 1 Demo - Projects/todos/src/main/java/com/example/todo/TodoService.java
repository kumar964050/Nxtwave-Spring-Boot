package com.example.todo;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus; 

import com.example.todo.Todo;
import com.example.todo.TodoRepository;

import java.util.*;

import javax.validation.OverridesAttribute;

// Do not modify the below code

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();
    private int unqid= 6;

    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    // Do not modify the above code

    // Write your code here
    @Override 
    public ArrayList<Todo> getTodos(){
        Collection<Todo> todosCollection = todoList.values();
        ArrayList<Todo> todosList = new ArrayList<>(todosCollection);
        return todosList;
    }
    @Override
    public Todo addTodo(Todo newTodo){
        newTodo.setId(unqid);
        todoList.put(unqid, newTodo);
        unqid += 1;
        return newTodo;
    }

    @Override
    public  Todo getTodoById(int todoID){
        Todo findTodo = todoList.get(todoID);
        if(findTodo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return findTodo;
        
    }

    @Override
    public Todo updateTodo(int todoID, Todo newTodo){
        Todo findTodo = todoList.get(todoID);
        if(findTodo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        if(newTodo.getTodo() != null) findTodo.setTodo(newTodo.getTodo());
        if(newTodo.getPriority() != null) findTodo.setPriority(newTodo.getPriority());
        if(newTodo.getStatus() != null) findTodo.setStatus(newTodo.getStatus());;
        return findTodo;
    }
    @Override 
    public void deleteTodo(int todoID){
        Todo findTodo = todoList.get(todoID);
        if(findTodo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        else{
            todoList.remove(todoID);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}

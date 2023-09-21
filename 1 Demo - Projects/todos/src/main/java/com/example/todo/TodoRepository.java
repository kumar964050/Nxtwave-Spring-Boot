package com.example.todo;


import java.util.ArrayList;
import com.example.todo.Todo;

public interface TodoRepository{
    ArrayList<Todo> getTodos();
    Todo addTodo(Todo newTod);
    Todo getTodoById(int todoID);
    Todo updateTodo(int todoID, Todo newTodo);
    void deleteTodo(int todoID);
}
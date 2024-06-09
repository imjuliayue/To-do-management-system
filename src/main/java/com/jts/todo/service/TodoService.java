package com.jts.todo.service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.jts.todo.dto.TodoDto;
import com.jts.todo.entity.Todo;
import com.jts.todo.repo.TodoRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@SpringBootApplication(scanBasePackages = {"org.modelmapper"})
public class TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;
    public TodoDto addTodo(TodoDto todoDto){
        // Copies all the data from todoDto to todo as Todo class.
        Todo todo = modelMapper.map(todoDto, Todo.class);

        // Saves the data in this object into database.
        todo = todoRepository.save(todo);

        // Converts back to TodoDto type.
        return modelMapper.map(todo, TodoDto.class);
    }

    public TodoDto getTodo(Long id){
        Todo todo = todoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("TODO not found"));

        return modelMapper.map(todo, TodoDto.class);
    }

    public List<TodoDto> getAllTodos(){
        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class)).collect(Collectors.toList());
    }
}

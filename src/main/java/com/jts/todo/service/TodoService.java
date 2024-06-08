package com.jts.todo.service;

import org.modelmapper.ModelMapper;
import com.jts.todo.dto.TodoDto;
import com.jts.todo.entity.Todo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoService {
    private ModelMapper modelMapper;
    public TodoDto addTodo(TodoDto todoDto){
        Todo todo = modelMapper.map
        return todoDto;
    }
}

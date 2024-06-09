package com.jts.todo.controller;


import com.jts.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class ToDOController {

    private TodoService todoService;

}

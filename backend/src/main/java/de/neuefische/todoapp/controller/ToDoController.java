package de.neuefische.todoapp.controller;

import de.neuefische.todoapp.model.ToDo;
import de.neuefische.todoapp.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("api")
public class ToDoController {

    private ToDoService toDoService;

    @GetMapping("todo")
    public Collection<ToDo> getAllToDo(){
        return toDoService.getAllToDo();
    }

}

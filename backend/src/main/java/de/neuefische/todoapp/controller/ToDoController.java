package de.neuefische.todoapp.controller;

import de.neuefische.todoapp.model.ToDo;
import de.neuefische.todoapp.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("todo")
    public ToDo addToDo(@RequestBody String description){
        return toDoService.addToDo(description);
    }

}

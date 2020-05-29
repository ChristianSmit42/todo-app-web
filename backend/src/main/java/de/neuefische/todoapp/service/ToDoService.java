package de.neuefische.todoapp.service;

import de.neuefische.todoapp.db.ToDoDb;
import de.neuefische.todoapp.model.ToDo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class ToDoService {

    private ToDoDb toDoDb;

    public Collection<ToDo> getAllToDo(){
        return toDoDb.getAllToDo();
    }
}

package de.neuefische.todoapp.db;

import de.neuefische.todoapp.model.EnumStatus;
import de.neuefische.todoapp.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@Repository
public class ToDoDb {
    private ArrayList<ToDo> toDos;

    @Autowired
    public ToDoDb(){
        toDos = new ArrayList<>();
        toDos.add(new ToDo("1","description",EnumStatus.DONE));
        toDos.add(new ToDo("2","description2",EnumStatus.OPEN));
    }

    public Collection<ToDo> getAllToDo() {
        if(toDos.size()==0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return Collections.unmodifiableCollection(toDos);
    }
}

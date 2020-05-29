package de.neuefische.todoapp.db;

import de.neuefische.todoapp.model.EnumStatus;
import de.neuefische.todoapp.model.ToDo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@Repository
public class ToDoDb {
    private ArrayList<ToDo> toDos;



    public Collection<ToDo> getAllToDo() {
       /* if(toDos.size()==0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }*/
        return Collections.unmodifiableCollection(toDos);
    }

    public void clearDb() {
        toDos.clear();
    }

    public void add(ToDo task) {
        toDos.add(task);
    }

    public ToDo addToDb(String description) {
        ToDo toDo = new ToDo("1",description,EnumStatus.OPEN);
        toDos.add(toDo);
        return toDo;
    }
}

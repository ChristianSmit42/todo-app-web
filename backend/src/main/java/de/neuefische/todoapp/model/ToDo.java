package de.neuefische.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ToDo {
    private String id;
    private String description;
    private EnumStatus status;

}

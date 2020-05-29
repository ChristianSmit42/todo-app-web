package de.neuefische.todoapp.controller;

import de.neuefische.todoapp.db.ToDoDb;
import de.neuefische.todoapp.model.EnumStatus;
import de.neuefische.todoapp.model.ToDo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ToDoDb toDoDb;

    @BeforeEach
    public void resetDatabase(){
        toDoDb.clearDb();
    }

    @Test
    @DisplayName("should return List.length = 2")
    void getAllToDoReturns2() {
        // GIVEN
        toDoDb.add(new ToDo("1","description", EnumStatus.DONE));
        toDoDb.add(new ToDo("2","description2",EnumStatus.OPEN));
        // WHEN
        ResponseEntity<ToDo[]> response = restTemplate.getForEntity("http://localhost:"+port+"/api/todo", ToDo[].class);
        HttpStatus statusCode = response.getStatusCode();
        ToDo[] toDos = response.getBody();
        // THEN
        assertEquals(2,toDos.length);
    }

    @Test
    @DisplayName("Should return empty list")
    void getAllReturnsZero(){
        // GIVEN

        // WHEN
        ResponseEntity<ToDo[]> response = restTemplate.getForEntity("http://localhost:" + port + "/api/todo", ToDo[].class);
        HttpStatus statusCode = response.getStatusCode();
        ToDo[] toDos = response.getBody();
        // THEN
        assertEquals(HttpStatus.OK,statusCode);
        assertEquals(0,toDos.length);
    }
}
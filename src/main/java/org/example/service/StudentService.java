package org.example.service;

import org.example.model.Student;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class StudentService {

    public StudentService() {
    }

    public static Student getFromDatabase(String universityId) {
        Student student1 = new Student("Jim", "S100", "Science");
        Student student2 = new Student("Steve", "M101", "Maths");
        Student student3 = new Student("Mark", "P102", "Physics");
        Map<String, Student> database = new HashMap<>();
        database.put("S100", student1);
        database.put("M101", student2);
        database.put("P102", student3);
        System.out.println("Database called for: " + universityId);
        return database.get(universityId);
    }
}

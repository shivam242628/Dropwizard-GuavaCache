package org.example.model;

import lombok.Data;

@Data
public class Student {
    private String name;
    private String universityId;
    private String subjectSpecialization;

    public Student(String name, String universityId, String subjectSpecialization) {
        this.name = name;
        this.universityId = universityId;
        this.subjectSpecialization = subjectSpecialization;
    }
}

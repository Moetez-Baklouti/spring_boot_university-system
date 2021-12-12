package com.app.Department;

import com.app.Teacher.Teacher;
import com.app.University.University;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "departements")
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_code")
    private Long id;

    @Column(name = "department_name", length = 60)
    private String name;

    @OneToMany(mappedBy = "department",orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Teacher> teachers;

    @ManyToOne
    @JoinColumn(name = "university_code")
    private University university;

    public Department() {
        university = new University();
        teachers = new ArrayList<>();
    }

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, University university) {
        this.name = name;
        this.university = university;
    }

    public Department(Long id, String name, University university) {
        this.id = id;
        this.name = name;
        this.university = university;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long code) {
        this.id = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Department{" +
                "code=" + id +
                ", name='" + name + '\'' +
                ", university=" + university +
                ", teachers=" + teachers +
                '}';
    }

    public String toString(int i) {
        return name;
    }
}
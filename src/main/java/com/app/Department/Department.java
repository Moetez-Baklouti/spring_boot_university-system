package com.app.Department;

import com.app.Teacher.Teacher;
import com.app.University.University;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "departements")
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_sequence")
    @SequenceGenerator(name = "department_sequence", sequenceName = "department_sequence", initialValue = 10, allocationSize = 10)
    @Column(name = "Department_Code", nullable = false)
    private Long code;

    @Column(name = "Department_Name", unique = true, length = 60)
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Teacher> teachers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "university_code")
    private University university;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, University university) {
        this.name = name;
        this.university = university;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
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
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Department{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", university=" + university +
                ", teachers=" + teachers +
                '}';
    }

    public String toString(int i) {
        return name;
    }
}
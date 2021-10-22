package com.app.Departement;

import com.app.Teacher.Teacher;
import com.app.University.University;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "departements")
@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departement_sequence")
    @SequenceGenerator(name = "departement_sequence", sequenceName = "departement_sequence", initialValue = 10, allocationSize = 10)
    @Column(name = "Departement_Code", nullable = false)
    private Long code;

    @Column(name = "Departement_Name", unique = true, length = 60)
    private String name;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    private List<Teacher> teachers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "university_code")
    private University university;

    public Departement() {
    }

    public Departement(String name) {
        this.name = name;
    }

    public Departement(String name, University university) {
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
        if (!(o instanceof Departement)) return false;
        Departement that = (Departement) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Departement{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", university=" + university +
                ", teachers=" + teachers +
                '}';
    }
}
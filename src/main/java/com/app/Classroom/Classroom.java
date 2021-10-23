package com.app.Classroom;

import com.app.Session.Session;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "classrooms")
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Classroom_ID")
    private Long id;

    @Column(name = "Classroom_Name", nullable = false, unique = true, length = 3)
    private String classroom_name;

    @Enumerated(EnumType.STRING)
    @Column(name = "Classroom_Type", nullable = false)
    private ClassroomType classroom_type;

    @Column(name = "Classroom_Capacity", nullable = false)
    private Integer classroom_capacity;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Session> sessions;

    public Classroom() {
    }

    public Classroom(String classroom_name, ClassroomType classroom_type, Integer classroom_capacity) {
        this.classroom_name = classroom_name;
        this.classroom_type = classroom_type;
        this.classroom_capacity = classroom_capacity;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public String getClassroom_name() {
        return classroom_name;
    }

    public void setClassroom_name(String classroom_name) {
        this.classroom_name = classroom_name;
    }

    public Integer getClassroom_capacity() {
        return classroom_capacity;
    }

    public void setClassroom_capacity(Integer classroom_capacity) {
        this.classroom_capacity = classroom_capacity;
    }

    public ClassroomType getClassroom_type() {
        return classroom_type;
    }

    public void setClassroom_type(ClassroomType classroom_type) {
        this.classroom_type = classroom_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Classroom)) return false;
        Classroom classroom = (Classroom) o;
        return id.equals(classroom.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", classroom_name='" + classroom_name + '\'' +
                ", classroom_type=" + classroom_type +
                ", classroom_capacity=" + classroom_capacity +
                ", sessions=" + sessions +
                '}';
    }
}
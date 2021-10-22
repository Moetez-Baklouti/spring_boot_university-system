package com.app.Group;

import com.app.Session.Session;
import com.app.Student.Student;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "groups1")
@Entity
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id", nullable = false)
    private Long id;

    @Column(name = "Group_Title", nullable = false, unique = true, length = 8)
    private String group_title;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Session> sessions;

    public Group() {
    }

    public Group(String group_title) {
        this.group_title = group_title;
    }

    public Group(String group_title, List<Student> students, List<Session> sessions) {
        this.group_title = group_title;
        this.students = students;
        this.sessions = sessions;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public int size() {
        return (students == null)?0:students.size();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getGroup_title() {
        return group_title;
    }

    public void setGroup_title(String group_title) {
        this.group_title = group_title;
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
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", group_title='" + group_title + '\'' +
                ", students=" + students +
                ", sessions=" + sessions +
                '}';
    }
}
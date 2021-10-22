package com.app.Session;

import com.app.Classroom.Classroom;
import com.app.Course.Course;
import com.app.Group.Group;
import com.app.Teacher.Teacher;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Table(name = "sessions")
@Entity
public class Session {
    @Id
    @Column(name = "Session_ID", nullable = false)
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "Session_Date", nullable = false)
    private Date date;

    @DateTimeFormat(pattern = "HH:mm")
    @Column(name = "Session_Time", nullable = false)
    private Time time;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Session() {
    }

    public Session(Date date, Time time, Classroom classroom, Course course) {
        this.date = date;
        this.time = time;
        this.classroom = classroom;
        this.course = course;
    }

    public Session(Date date, Time time, Teacher teacher, Classroom classroom, Course course) {
        this.date = date;
        this.time = time;
        this.teacher = teacher;
        this.classroom = classroom;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Session)) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", teacher=" + teacher +
                ", classroom=" + classroom +
                ", course=" + course +
                '}';
    }

    public String toString(int i) {
        return date.toString() + " " + time.toString() + " in " + classroom.getClassroom_name();
    }
}
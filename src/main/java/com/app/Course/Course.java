package com.app.Course;

import com.app.Session.Session;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "courses")
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CourseID")
    private Long id;

    @Column(name = "Course_Title", nullable = false, length = 70)
    private String course_title;

    @Column(name = "Course_Coefficient", nullable = false)
    private Integer course_coefficient;

    @OneToMany(mappedBy = "course", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Session> sessions;

    public Course() {
    }

    public Course(String course_title, Integer course_coefficient) {
        this.course_title = course_title;
        this.course_coefficient = course_coefficient;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Integer getCourse_credits() {
        return course_coefficient * 2;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCourse_coefficient() {
        return course_coefficient;
    }

    public void setCourse_coefficient(Integer course_coefficient) {
        this.course_coefficient = course_coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course_title='" + course_title + '\'' +
                ", course_coefficient=" + course_coefficient +
                ", sessions=" + sessions +
                '}';
    }
}
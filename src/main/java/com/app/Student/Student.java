package com.app.Student;

import com.app.Group.Group;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Table(name = "students")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Registration_Number")
    private Long id;

    @Column(name = "First_Name", nullable = false, length = 30)
    private String first_name;

    @Column(name = "Last_Name", nullable = false, length = 30)
    private String last_name;

    @Column(name = "Email_Adress", nullable = false, unique = true, length = 40)
    private String email_adress;

    @Column(name = "phone_number", nullable = false, unique = true)
    private Long phone_number;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "Date_Of_Birth", nullable = false)
    private Date date_of_birth;

    @Column(name = "Adress", nullable = false, length = 100)
    private String adress;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "Registration_Date", nullable = false)
    private Date registration_date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    @Transient
    private int age;

    public Student() {

    }

    public Student(String first_name, String last_name, String email_adress, Long phone_number, Date date_of_birth, String adress, Date registration_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_adress = email_adress;
        this.phone_number = phone_number;
        this.date_of_birth = date_of_birth;
        this.adress = adress;
        this.registration_date = registration_date;
        this.age = Period.between(date_of_birth.toLocalDate() , LocalDate.now()).getYears();
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public int getAge() {
        return age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail_adress(String email_adress) {
        this.email_adress = email_adress;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getEmail_adress() {
        return email_adress;
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
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email_adress='" + email_adress + '\'' +
                ", phone_number=" + phone_number +
                ", date_of_birth=" + date_of_birth +
                ", adress='" + adress + '\'' +
                ", registration_date=" + registration_date +
                ", age=" + age +
                '}';
    }

    public String toString(int i) {
        return first_name + " " + last_name;
    }
}
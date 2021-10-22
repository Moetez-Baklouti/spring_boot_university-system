package com.app.Teacher;

import com.app.Department.Department;
import com.app.Session.Session;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Table(name = "teachers")
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Teacher_ID", nullable = false)
    private Long id;

    @Column(name = "First_Name", nullable = false, length = 30)
    private String first_name;

    @Column(name = "Last_Name", nullable = false, length = 30)
    private String last_name;

    @Column(name = "Diploma", nullable = false, length = 70)
    private String diploma;

    @Column(name = "Email_Adress", nullable = false, unique = true, length = 40)
    private String email_adress;

    @Column(name = "phone_number", nullable = false, unique = true)
    private Long phone_number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Department_Code")
    private Department department;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Session> sessions;

    @Column(name = "Adress", nullable = false, length = 100)
    private String adress;

    public Teacher() {
    }

    public Teacher(String first_name, String last_name, String diploma, String email_adress) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.diploma = diploma;
        this.email_adress = email_adress;
    }

    public Teacher(String first_name, String last_name, String diploma, String email_adress, Long phone_number, Department department, String adress) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.diploma = diploma;
        this.email_adress = email_adress;
        this.phone_number = phone_number;
        this.department = department;
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Long phone_number) {
        this.phone_number = phone_number;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail_adress() {
        return email_adress;
    }

    public void setEmail_adress(String email_adress) {
        this.email_adress = email_adress;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department departement) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", diploma='" + diploma + '\'' +
                ", email_adress='" + email_adress + '\'' +
                ", phone_number=" + phone_number +
                ", departement=" + department +
                ", sessions=" + sessions +
                ", adress='" + adress + '\'' +
                '}';
    }

    public String toString(int i) {
        return first_name + " " + last_name;
    }
}
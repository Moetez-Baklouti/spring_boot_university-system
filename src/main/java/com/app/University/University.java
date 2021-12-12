package com.app.University;

import com.app.Department.Department;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "universities")
@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_code")
    private Long id;

    @Column(name = "university_name", length = 80)
    private String name;

    @Column(name = "university_website", length = 120)
    private String website;

    @OneToMany(mappedBy = "university",orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Department> departments = new ArrayList<>();

    public University() {
    }

    public University(String name) {
        this.name = name;
    }

    public University(String name, String website) {
        this.name = name;
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departements) {
        this.departments = departements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof University)) return false;
        University that = (University) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "University{" +
                "code='" + id + '\'' +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", departements=" + departments +
                '}';
    }
}
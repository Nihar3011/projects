package com.mycompany.exercise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 *
 * @author nihar
 */
@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "degree", length = 20)
    private String degree;

    @Column(name = "type", length = 20)
    private String type;

    @Column(name = "description", length = 50)
    private String description;

    @Column(name = "year", length = 4)
    private String year;

    @Column(name = "school", length = 40)
    private String school;

    @OneToOne(mappedBy = "education")
    private Student student;

    public Education() {
    }

    public Education(String degree, String type, String description, String year, String school) {
        this.degree = degree;
        this.type = type;
        this.description = description;
        this.year = year;
        this.school = school;
    }

    public Education(Long id, String degree, String type, String description, String year, String school, Student student) {
        this.id = id;
        this.degree = degree;
        this.type = type;
        this.description = description;
        this.year = year;
        this.school = school;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}

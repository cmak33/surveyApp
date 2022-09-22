package com.example.surveyapplication.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "surveys")
@Inheritance
@Getter
@Setter
public class Survey {
    @GeneratedValue
    @Id
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "survey")
    private List<Question> questionList;
    @ManyToMany
    private List<User> participants;
}

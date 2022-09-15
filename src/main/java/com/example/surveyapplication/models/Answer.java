package com.example.surveyapplication.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "answers")
@Getter
@Setter
public class Answer{
    @GeneratedValue
    @Id
    private Long id;
    @ManyToOne
    private Question question;
    @ManyToMany
    private List<User> users;
    private String text;
}

package com.example.surveyapplication.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    @ManyToOne
    private User user;
    private String text;
}

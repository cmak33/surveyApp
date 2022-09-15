package com.example.surveyapplication.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class TimeLimitedSurvey extends Survey{
    private int timeInSeconds;
}

package com.que.votesys.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name="question_info")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String question_name;
    private String question_description;

}

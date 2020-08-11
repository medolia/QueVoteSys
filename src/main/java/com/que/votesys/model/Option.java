package com.que.votesys.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="option_info")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int question_id;
    private String option_content;

}

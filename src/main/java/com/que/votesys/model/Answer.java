package com.que.votesys.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="answer_info")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int question_id;
    private int option_id;
    private int user_id;
    private String answer_content;
    private String create_ip;
    private Date create_date;

    @PrePersist
    void createdAt() {
        this.create_date = new Date();
    }

    public Answer(int question_id, int option_id, String create_ip) {
        this.question_id = question_id;
        this.option_id = option_id;
        this.create_ip = create_ip;
    }

}

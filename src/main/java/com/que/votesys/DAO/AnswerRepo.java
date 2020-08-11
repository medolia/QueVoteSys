package com.que.votesys.DAO;

import com.que.votesys.model.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepo extends CrudRepository<Answer, Integer> {

}

package com.que.votesys.DAO;

import com.que.votesys.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepo extends CrudRepository<Question, Integer> {
}

package com.que.votesys.DAO;

import com.que.votesys.model.Option;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OptionRepo extends CrudRepository<Option, Integer> {

}

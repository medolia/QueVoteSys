package com.que.votesys.data;

import com.que.votesys.model.Option;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepo extends CrudRepository<Option, Integer> {

}

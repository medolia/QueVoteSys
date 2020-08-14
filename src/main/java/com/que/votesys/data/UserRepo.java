package com.que.votesys.data;

import com.que.votesys.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}

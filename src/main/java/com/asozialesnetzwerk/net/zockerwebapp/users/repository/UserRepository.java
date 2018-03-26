package com.asozialesnetzwerk.net.zockerwebapp.users.repository;

import com.asozialesnetzwerk.net.zockerwebapp.users.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

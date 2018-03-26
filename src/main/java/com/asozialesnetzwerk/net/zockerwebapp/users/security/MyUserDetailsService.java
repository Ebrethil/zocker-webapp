package com.asozialesnetzwerk.net.zockerwebapp.users.security;

import com.asozialesnetzwerk.net.zockerwebapp.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MyUserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}

package com.asozialesnetzwerk.net.zockerwebapp.users.model;

import org.springframework.data.annotation.Id;

import java.util.Base64;

public class User {

    @Id
    private int id;

    private String nickName;

    private String firstName;

    private String lastName;

    private String title;

    private String password; //TODO: How to save pw -> security

    private Base64 image; // correct encoding?
}

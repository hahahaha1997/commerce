package com.example.commerce.surface;

import com.example.commerce.entity.Login;

import java.util.List;

public interface LoginService {

    List<Login> getAllLogin();


    String getPassword(Integer id);


}

package com.example.commerce.surface;

import com.example.commerce.entity.Login;
import com.example.commerce.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginRepository loginRepository;


    @Override
    public List<Login> getAllLogin() {
        return loginRepository.findAll();
    }

    @Override
    public String getPassword(Integer id) {
        return loginRepository.findById(id).get().getPassword();
    }
}

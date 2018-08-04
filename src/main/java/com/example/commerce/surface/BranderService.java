package com.example.commerce.surface;

import com.example.commerce.entity.Brand;
import com.example.commerce.entity.Brander;
import com.example.commerce.entity.Login;

import java.util.List;

public interface BranderService {

    List<Brander> findByBranderLoginName(String name);

    List<Brander> findAllBrander();

    Brander alterBranderInfo(Brander brander);

    Brander findById(Integer id);

    boolean has(Login login);

    void deleteGood(Integer id);

    Brander insert(Brander brander);
}

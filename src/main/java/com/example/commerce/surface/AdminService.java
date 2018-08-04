package com.example.commerce.surface;

import com.example.commerce.entity.Admin;
import com.example.commerce.entity.Borrower;
import com.example.commerce.entity.Brander;
import com.example.commerce.entity.Login;

import java.util.List;

public interface AdminService {

    /**
     * findAllAdimin
     * @return 全部的管理员liebiao
     */
    List<Admin> findAllAdmin();

    /**
     * findAdminPass
     * @param name
     * @return 返回所有的管理员密码
     */
    List<Admin> findAdminPass(String name);

    List<Brander> getAllBrander();

    List<Borrower> getAllBorrower();

    boolean has(Login login);

    void insert(Login login);

    Admin findbyid(Integer id);

    Admin alteradmin(Admin admin);

}

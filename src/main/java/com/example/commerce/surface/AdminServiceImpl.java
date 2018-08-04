package com.example.commerce.surface;


import com.example.commerce.entity.Admin;
import com.example.commerce.entity.Borrower;
import com.example.commerce.entity.Brander;
import com.example.commerce.entity.Login;
import com.example.commerce.repository.AdminRepository;
import com.example.commerce.repository.BorrowerRepository;
import com.example.commerce.repository.BranderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    BranderRepository branderRepository;

    @Autowired
    BorrowerRepository borrowerRepository;

    @Override
    public List<Admin> findAllAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public boolean has(Login login) {
        List<Admin> admins = adminRepository.findAll();
        for (Admin admin:admins
             ) {
            if(admin.getAdminName().equals(login.getLoginName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Admin findbyid(Integer id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public Admin alteradmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void insert(Login login) {
        Admin admin=new Admin();
        admin.setAdminName(login.getLoginName());
        admin.setPassword(login.getPassword());
        adminRepository.save(admin);
    }

    @Override
    public List<Admin> findAdminPass(String name) {
        return adminRepository.findByAdminName(name);
    }

    @Override
    public List<Brander> getAllBrander() {
        return branderRepository.findAll();
    }

    @Override
    public List<Borrower> getAllBorrower() {
        return borrowerRepository.findAll();
    }
}

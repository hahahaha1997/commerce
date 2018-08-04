package com.example.commerce.surface;

import com.example.commerce.entity.Borrower;
import com.example.commerce.entity.Login;
import com.example.commerce.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerServiceImpl  implements  BorrowerService{

    @Autowired
    BorrowerRepository borrowerRepository;

    @Override
    public Borrower alterBorrower(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    @Override
    public List<Borrower> findByBorrowerLoginName(String name) {
        List<Borrower> list = borrowerRepository.findByBorrowerLoginName(name);
        return list;
    }

    @Override
    public boolean has(Login login) {
        List<Borrower> borrowers = borrowerRepository.findAll();
        for (Borrower borrower:borrowers
                ) {
            if(borrower.getBorrowerLoginName().equals(login.getLoginName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Borrower insert(Borrower borrower) {

        return borrowerRepository.save(borrower);
    }

    @Override
    public Borrower findById(Integer id) {
        return borrowerRepository.findById(id).get();
    }

    @Override
    public List<Borrower> findAllBorrower() {
        return borrowerRepository.findAll();
    }
}

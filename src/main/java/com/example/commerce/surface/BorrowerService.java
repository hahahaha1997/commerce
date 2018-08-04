package com.example.commerce.surface;

import com.example.commerce.entity.Borrower;
import com.example.commerce.entity.Login;

import java.util.List;

public interface BorrowerService {

    List<Borrower> findByBorrowerLoginName(String name);

    List<Borrower> findAllBorrower();

    Borrower alterBorrower(Borrower borrower);

    boolean has(Login login);

    Borrower findById(Integer id);

    Borrower insert(Borrower borrower);

}

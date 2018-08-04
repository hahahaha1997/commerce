package com.example.commerce.repository;

import com.example.commerce.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowerRepository extends JpaRepository<Borrower,Integer> {


    /**
     * findByBorrowerLoginName
     * @param name
     * @return List<Borrower>
     */
    List<Borrower> findByBorrowerLoginName(String name);

}

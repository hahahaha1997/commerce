package com.example.commerce.repository;

import com.example.commerce.entity.Brander;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface BranderRepository extends JpaRepository<Brander,Integer> {


     /**
      * findByBranderLoginName
      * @param name
      * @return List<Brander>
      */
     @Query(value = "select s from Brander s where s.branderLoginName=?1")
     List<Brander> findByBranderLoginName(String name);



}

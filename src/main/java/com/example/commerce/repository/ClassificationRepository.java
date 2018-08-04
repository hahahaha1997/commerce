package com.example.commerce.repository;

import com.example.commerce.entity.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.naming.InsufficientResourcesException;
import java.util.List;

public interface ClassificationRepository extends JpaRepository<Classification,Integer> {

    /**
     * findABC
     * @param id
     * @return List<Classification>
     */
    @Query(value = "select s from Classification  s where s.ClassifyParentId=?1")
    List<Classification> findabc(Integer id);

    /**
     * finddef
     * @param id
     * @return List<Classification>
     */

    @Query(value = "select s from Classification  s where s.ClassifyId=?1")
    List<Classification> finddef(Integer id);
    /**
     * findSon
     * @param list
     * @return List<Classification>
     */
    @Query(value = "select s from Classification  s where s.ClassifyParentId in ?1")
    List<Classification> findSon(List<Integer> list);

}

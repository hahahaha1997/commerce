package com.example.commerce.surface;

import com.example.commerce.entity.Classification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Max;
import java.util.List;

public interface ClassificationService {

    List<Classification> findbyfatherid(Integer id);
    List<Classification> findbyid(Integer id);
    Classification findById(Integer id);
    Classification alterclassification(Classification classification);
    void deleteFirstClass(Integer id);
    Classification addNew(Classification classification);
    List<Classification> findSon(List<Integer> list);


}

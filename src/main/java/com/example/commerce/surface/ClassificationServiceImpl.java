package com.example.commerce.surface;

import com.example.commerce.entity.Classification;
import com.example.commerce.repository.ClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationServiceImpl implements  ClassificationService {

    @Autowired
    ClassificationRepository classificationRepository;

    @Override
    public List<Classification> findbyfatherid(Integer id) {
        return classificationRepository.findabc(id);
    }

    @Override
    public Classification findById(Integer id) {
        return classificationRepository.findById(id).get();
    }

    @Override
    public List<Classification> findbyid(Integer id) {
        return classificationRepository.finddef(id);
    }

    @Override
    public Classification alterclassification(Classification classification) {
        return classificationRepository.save(classification);
    }

    @Override
    public Classification addNew(Classification classification) {
        return classificationRepository.save(classification);
    }

    @Override
    public List<Classification> findSon(List<Integer> list) {
        return classificationRepository.findSon(list);
    }

    @Override
    public void deleteFirstClass(Integer id) {
        classificationRepository.deleteById(id);
    }
}

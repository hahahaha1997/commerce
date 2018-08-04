package com.example.commerce.surface;

import com.example.commerce.entity.Brand;
import com.example.commerce.entity.Brander;
import com.example.commerce.entity.Good;
import com.example.commerce.entity.Login;
import com.example.commerce.repository.BranderRepository;
import com.example.commerce.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranderServiceImpl implements  BranderService {

    @Autowired
    BranderRepository branderRepository;

    @Autowired
    GoodRepository goodRepository;

    @Override
    public List<Brander> findAllBrander() {
        return branderRepository.findAll();
    }

    @Override
    public boolean has(Login login) {
        List<Brander> branders = branderRepository.findAll();
        for (Brander brander:branders) {
            if(brander.getBranderLoginName().equals(login.getLoginName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Brander insert(Brander brander) {
        return branderRepository.save(brander);
    }

    @Override
    public Brander findById(Integer id) {
        return branderRepository.findById(id).get();
    }

    @Override
    public void deleteGood(Integer id) {
        Good good=goodRepository.findById(id).get();
        if(good.getGoodStatus().equals("已上架")) {
            good.setGoodStatus("已下架");
        }
        else{
            good.setGoodStatus("已上架");
        }
        goodRepository.save(good);
    }

    @Override
    public Brander alterBranderInfo(Brander brander) {
        return  branderRepository.save(brander);
    }

    @Override
    public List<Brander> findByBranderLoginName(String name) {
        return branderRepository.findByBranderLoginName(name);
    }
}

//package com.example.commerce.controller;
//
//import com.example.commerce.entity.Classification;
//import com.example.commerce.surface.ClassificationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.servlet.http.HttpSession;
//
//@Controller("classify")
//public class ClassificationController {
//
//    @Autowired
//    public ClassificationService classificationService;
//
//    @PostMapping("addcla")
//    public String addcla(@RequestParam Integer idd,HttpSession session){
//        session.setAttribute("qqq",classificationService.findbyfatherid(idd));
//        session.setAttribute("ppp",classificationService.findbyid(idd));
//        return "MvoProductInfoChange";
//    }
//
//    @PostMapping("addone")
//    public String addclas(@RequestParam Integer idd,HttpSession session){
//        session.setAttribute("ttt",classificationService.findbyfatherid(idd));
//        session.setAttribute("qqq",classificationService.findbyid(idd));
//        return "MvoProductInfoChange";
//    }
//
//}

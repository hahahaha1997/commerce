package com.example.commerce.controller;

import com.example.commerce.entity.Admin;
import com.example.commerce.entity.Borrower;
import com.example.commerce.entity.Brander;
import com.example.commerce.entity.Classification;
import com.example.commerce.surface.AdminService;
import com.example.commerce.surface.BorrowerService;
import com.example.commerce.surface.BranderService;
import com.example.commerce.surface.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller("Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
//
    @Autowired
    private BorrowerService borrowerService;

    @Autowired
    private BranderService  branderService;

    @Autowired
    private ClassificationService classificationService;

    @GetMapping("Admin")
    public String  getAllData(HttpSession session) {
        session.setAttribute("branders",adminService.getAllBrander());
        session.setAttribute("borrowers",adminService.getAllBorrower());
        session.setAttribute("admins",adminService.findAllAdmin());

        List<Classification> firstClassify = classificationService.findbyfatherid(0);
        session.setAttribute("class",firstClassify);

        List<Integer> list = new ArrayList<Integer>();

        for (Classification classification:firstClassify
             ) {
            list.add(classification.getClassifyId());
        }
        List<Classification> secondClassify = classificationService.findSon(list);

        session.setAttribute("class2",secondClassify);

        List<Integer> list2 = new ArrayList<>();


        for (Classification classification:secondClassify
                ) {
            list2.add(classification.getClassifyId());
        }
        List<Classification> thirdClassify = classificationService.findSon(list2);

        session.setAttribute("class3",thirdClassify);

        session.setAttribute("server",classificationService);

        return "AdminManage";
    }

    @GetMapping("loginchange/{id}")
    public String changeLoginStatus(@PathVariable("id")Integer id,HttpSession session){
        Brander brander = branderService.findById(id);
        brander.setBranderLoginStatus("正常");
        branderService.alterBranderInfo(brander);
        session.setAttribute("branders",adminService.getAllBrander());
        return "AdminManage";
    }

    @GetMapping("loginchange2/{id}")
    public String changeLoginStatus2(@PathVariable("id")Integer id,HttpSession session){
        Brander brander = branderService.findById(id);
        brander.setBranderLoginStatus("限制登陆");
        branderService.alterBranderInfo(brander);
        session.setAttribute("branders",adminService.getAllBrander());
        return "AdminManage";
    }

    @GetMapping("loginchange3/{id}")
    public String changeLoginStatus3(@PathVariable("id")Integer id,HttpSession session){
        Brander brander = branderService.findById(id);
        brander.setBranderUploadStatus("正常");
        branderService.alterBranderInfo(brander);
        session.setAttribute("branders",adminService.getAllBrander());
        return "AdminManage";
    }

    @GetMapping("loginchange4/{id}")
    public String changeLoginStatus4(@PathVariable("id")Integer id,HttpSession session){
        Brander brander = branderService.findById(id);
        brander.setBranderUploadStatus("限制发布");
        branderService.alterBranderInfo(brander);
        session.setAttribute("branders",adminService.getAllBrander());
        return "AdminManage";
    }



    @GetMapping("loginchange5/{id}")
    public String changeLoginStatus5(@PathVariable("id")Integer id,HttpSession session){
        Borrower borrower=borrowerService.findById(id);
        borrower.setBorrowerLoginStatus("正常");
        borrowerService.alterBorrower(borrower);
        session.setAttribute("borrowers",adminService.getAllBorrower());
        return "AdminManage";
    }

    @GetMapping("loginchange6/{id}")
    public String changeLoginStatus6(@PathVariable("id")Integer id,HttpSession session){
        Borrower borrower=borrowerService.findById(id);
        borrower.setBorrowerLoginStatus("限制登陆");
        borrowerService.alterBorrower(borrower);
        session.setAttribute("borrowers",adminService.getAllBorrower());
        return "AdminManage";
    }

    @GetMapping("loginchange7/{id}")
    public String changeLoginStatus7(@PathVariable("id")Integer id,HttpSession session){
        Borrower borrower=borrowerService.findById(id);
        borrower.setBorrowerLoginStatus("正常");
        borrowerService.alterBorrower(borrower);
        session.setAttribute("borrowers",adminService.getAllBorrower());
        return "AdminManage";
    }
    @GetMapping("loginchange8/{id}")
    public String changeLoginStatus8(@PathVariable("id")Integer id,HttpSession session){
        Borrower borrower=borrowerService.findById(id);
        borrower.setBorrowerUploadStatus("限制发布");
        borrowerService.alterBorrower(borrower);
        session.setAttribute("borrowers",adminService.getAllBorrower());

        return "AdminManage";
    }

    @GetMapping("addpower/{id}")
    public  String addAdminPower(@PathVariable("id")Integer id,HttpSession session){
        Admin admin = adminService.findbyid(id);
        admin.setAdminPower(admin.getAdminPower()+1);
        adminService.alteradmin(admin);
        session.setAttribute("admins",adminService.findAllAdmin());
        return "AdminManage";
    }

    @GetMapping("addpower2/{id}")
    public  String addAdminPower2(@PathVariable("id")Integer id,HttpSession session){
        Admin admin = adminService.findbyid(id);
        admin.setAdminPower(admin.getAdminPower()-1);
        adminService.alteradmin(admin);
        session.setAttribute("admins",adminService.findAllAdmin());
        return "AdminManage";
    }

    @GetMapping("changeClass/{id}")//修改一级分类
    public String brandChangeInfo(HttpSession session,@PathVariable("id") Integer id){
        session.setAttribute("changefirst",classificationService.findById(id));
        return "AdminFirstUpdate";
    }

    @GetMapping("changeClass2/{id}")//修改二级分类
    public String brandChangeInfo2(HttpSession session,@PathVariable("id") Integer id){
        session.setAttribute("changeSecond",classificationService.findById(id));
        return "AdminSecondUpdate";
    }
    @GetMapping("changeClass3/{id}")//修改三级分类
    public String brandChangeInfo3(HttpSession session,@PathVariable("id") Integer id){
        session.setAttribute("changeThird",classificationService.findById(id));
        return "AdminThirdUpdate";
    }


    @PostMapping("ConfirmUpdateClass")//确认修改一级分类
    public  String updateConfirm(@RequestParam Integer id,@RequestParam String classify, HttpSession session){
        Classification classification=classificationService.findById(id);
        classification.setClassifyDescription(classify);
        classificationService.alterclassification(classification);
        //session.setAttribute("branders",branderService.findById(Integer.parseInt(session.getAttribute("myId").toString())));
        List<Classification> firstClassify = classificationService.findbyfatherid(0);
        session.setAttribute("class",firstClassify);

        List<Integer> list = new ArrayList<Integer>();

        for (Classification classification1:firstClassify
                ) {
            list.add(classification1.getClassifyId());
        }
        List<Classification> secondClassify = classificationService.findSon(list);

        session.setAttribute("class2",secondClassify);

        List<Integer> list2 = new ArrayList<>();


        for (Classification classification1:secondClassify
                ) {
            list2.add(classification1.getClassifyId());
        }
        List<Classification> thirdClassify = classificationService.findSon(list2);

        session.setAttribute("class3",thirdClassify);
        return "AdminManage";
    }

    @GetMapping("alterClass/{id}")//删除一级分类
    public String deleteFirst(HttpSession session,@PathVariable("id") Integer id){
        List<Classification> classifications = classificationService.findbyfatherid(id);
        if(classifications.isEmpty()) {
            classificationService.deleteFirstClass(id);


            List<Classification> firstClassify = classificationService.findbyfatherid(0);
            session.setAttribute("class",firstClassify);

            List<Integer> list = new ArrayList<Integer>();

            for (Classification classification:firstClassify
                    ) {
                list.add(classification.getClassifyId());
            }
            List<Classification> secondClassify = classificationService.findSon(list);

            session.setAttribute("class2",secondClassify);

            List<Integer> list2 = new ArrayList<>();


            for (Classification classification:secondClassify
                    ) {
                list2.add(classification.getClassifyId());
            }
            List<Classification> thirdClassify = classificationService.findSon(list2);

            session.setAttribute("class3",thirdClassify);
            return "AdminManage";
        }
        else{
            return "warnPage";
        }
    }

    @GetMapping("addNewClass")//增加一级分类
    public String addFirstClass(){

        return "AdminFirstNew";
    }

    @GetMapping("addNewClass2")//增加二级分类
    public String addFirstClass2(){

        return "AdminSecondNew";
    }
    @GetMapping("addNewClass3")//增加三级分类
    public String addFirstClass3(){

        return "AdminThirdNew";
    }

    @PostMapping("addsubmit")
    public String addSubmit(@RequestParam String name_son,@RequestParam Integer name_fa,HttpSession session){//name_fa其实是id
        Classification classification=new Classification();
        classification.setClassifyDescription(name_son);
        classification.setClassifyCreateTime(new java.sql.Date(new Date().getTime()));
        classification.setClassifyParentId(name_fa);
        if(name_fa!=0) {
            classification.setClassifyPath(classificationService.findById(name_fa).getClassifyPath() + "》" + name_son);
        }
        else{
            classification.setClassifyPath(name_son);
        }
        classification.setClassifyStatus("正常");
        classificationService.addNew(classification);

        List<Classification> firstClassify = classificationService.findbyfatherid(0);
        session.setAttribute("class",firstClassify);

        List<Integer> list = new ArrayList<Integer>();

        for (Classification classification1:firstClassify
                ) {
            list.add(classification1.getClassifyId());
        }
        List<Classification> secondClassify = classificationService.findSon(list);

        session.setAttribute("class2",secondClassify);

        List<Integer> list2 = new ArrayList<>();


        for (Classification classification1:secondClassify
                ) {
            list2.add(classification1.getClassifyId());
        }
        List<Classification> thirdClassify = classificationService.findSon(list2);

        session.setAttribute("class3",thirdClassify);
        return "AdminManage";
    }




}

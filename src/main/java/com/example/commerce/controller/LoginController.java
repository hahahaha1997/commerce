package com.example.commerce.controller;

import com.example.commerce.entity.Admin;
import com.example.commerce.entity.Borrower;
import com.example.commerce.entity.Brander;
import com.example.commerce.entity.Login;
import com.example.commerce.surface.AdminService;
import com.example.commerce.surface.BorrowerService;
import com.example.commerce.surface.BranderService;
import com.example.commerce.surface.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller   //localhost:8080
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private BorrowerService borrowerService;

    @Autowired
    private BranderService branderService;

    @Autowired
    private AdminService adminService;



    @GetMapping("")
    public String getAllLogin(){
        return "Login";
    }

    @PostMapping("login")
    public String login(Login login,RedirectAttributes redirectAttributes){
        if(login.getIdentity().equals("管理员")){
            List<Admin> list = adminService.findAdminPass(login.getLoginName());
            for (Admin admin:list
                 ) {
                if(admin.getPassword().equals(login.getPassword())){
                    redirectAttributes.addAttribute("loginName_admin",admin.getAdminName());
                    return "redirect:Admin";
                }
            }
            return "errorPage";

        }
        else if(login.getIdentity().equals("借卖方")){
            List<Borrower> borrowers=borrowerService.findByBorrowerLoginName(login.getLoginName());
            for (Borrower borrower : borrowers
                    ) {
                if(borrower.getBorrowerPwd().equals(login.getPassword())) {
                    redirectAttributes.addAttribute("loginName_borrower",borrower.getBorrowerLoginName());
                    if(borrower.getBorrowerLoginStatus().equals("限制登陆")){
                        return "limitPage";
                    }
                    return "redirect:/Borrower";
                }
            }
            return "errorPage";
        }
        else{
            List<Brander> branders = branderService.findByBranderLoginName(login.getLoginName());
            for (Brander brander:branders
                 ) {
                if(brander.getBranderPwd().equals(login.getPassword())){
                    redirectAttributes.addAttribute("loginName_brander",brander.getBranderLoginName());
                    if(brander.getBranderLoginStatus().equals("限制登陆")){
                        return "limitPage";
                    }
                    return "redirect:/Mvo";
                }

            }
            return "errorPage";
        }
    }

    @PostMapping("register")
    public String register(Login login, HttpSession session){
       if (login.getIdentity().equals("借卖方")){
            if(borrowerService.has(login)){
                return "errorRegister";
            }
            else{
                session.setAttribute("borr",login);
                return "Register2";
            }
        }
        else {
            if(branderService.has(login)){
                return "errorRegister";
            }
            else{
                session.setAttribute("bran",login);
                return "Register1";
            }
        }

    }

    @PostMapping("confirmRegister")
    public  String confirmRegister_Borrower(Brander brander,BindingResult bindingResult,HttpSession session){
        brander.setCash(0.0);
        brander.setBreanderCreatTime(new java.sql.Date(new Date().getTime()));
        brander.setBranderUploadStatus("正常");
        brander.setBranderLoginStatus("正常");
        branderService.insert(brander);
        return "Login";
    }

    @PostMapping("confirmRegister2")
    public  String confirmRegister_Brander(Borrower borrower,HttpSession session){
        borrower.setCash(0.0);
        borrower.setBorrowerTime(new java.sql.Date(new Date().getTime()));
        borrower.setBorrowerUploadStatus("正常");
        borrower.setBorrowerLoginStatus("正常");
        borrowerService.insert(borrower);
        return "Login";
    }
}

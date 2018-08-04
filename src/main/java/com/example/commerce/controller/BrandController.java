package com.example.commerce.controller;

import com.example.commerce.entity.*;
import com.example.commerce.pictureSupport.FileUtil;
import com.example.commerce.repository.GoodRepository;
import com.example.commerce.surface.*;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("Mvo")
//@RequestMapping("param")
public class BrandController {

    @Autowired
    public BranderService branderService;

    @Autowired
    public GoodService goodService;

    @Autowired
    public BorrowerService borrowerService;

    @Autowired
    public BrandService brandService;

    @Autowired
    public OrderFormService orderFormService;

    @Autowired
    public NutOrderService nutOrderService;

    @Autowired
    public  TradeMVOService tradeMVOService;



    @Autowired
    public ClassificationService classificationService;

    @GetMapping("Mvo")
    public  String getAllBrander(@RequestParam String loginName_brander, HttpSession session){
        session.setAttribute("branders",branderService.findByBranderLoginName(loginName_brander).get(0));
        session.setAttribute("myId",branderService.findByBranderLoginName(loginName_brander).get(0).getBranderId());
        return "main1";
    }

    @GetMapping("myInfo")
    public  String getMyInfo(HttpSession session){
        return "MvoMyInfo";
    }

    @GetMapping("updateBrander/{id}")
    public  String updateBrander(HttpSession session,@PathVariable("id") Integer id){
        Brander brander = branderService.findById(id);
        session.setAttribute("brander_update",brander);
            return "MvoInfoChange";
    }

    @PostMapping("ConfirmUpdateBrander")
    public  String updateConfirm(Brander brander,BindingResult bindingResult,HttpSession session){
       brander.setBreanderCreatTime((new java.sql.Date(new Date().getTime())));
        branderService.alterBranderInfo(brander);
        session.setAttribute("branders",branderService.findById(Integer.parseInt(session.getAttribute("myId").toString())));
        return "redirect:myInfo";
    }

    @GetMapping("productManage/{id}")
    public  String getAllProduct(@PathVariable("id")Integer id,HttpSession session){
        List<Good> goods = goodService.findByBranderId(id);

        session.setAttribute("goods",goods);
        return "MvoProduct";
    }

    @GetMapping("productManage")
    public  String getAllProduction(@RequestParam Integer brander_id, HttpSession session){
        List<Good> goods = goodService.findByBranderId(brander_id);

        session.setAttribute("goods",goods);
        return "MvoProduct";
    }


    @GetMapping("addNew")
    public String addNewGood(HttpSession session){
        if (branderService.findById(Integer.parseInt(session.getAttribute("myId").toString())).getBranderUploadStatus().equals("限制发布")){
            return "limitAddPage";
        }
        session.setAttribute("brands",brandService.findAllBrand());
        session.setAttribute("ppp",classificationService.findbyfatherid(0));
        //session.setAttribute("class",classificationService.findAll());
        return "MvoAddProduct";
    }

    @GetMapping("InfoDetail/{id}")
    public String infoDetail(@PathVariable("id")Integer id,HttpSession session){
        session.setAttribute("detail",goodService.findById(id));
        return "MvoProductInfo";
    }

    @GetMapping("deleteGood/{id}")
    public String deleteGood(@PathVariable("id")Integer id,HttpSession session){

        branderService.deleteGood(id);
        session.setAttribute("goods",goodService.findByBranderId(Integer.parseInt(session.getAttribute("myId").toString())));
        return "MvoProduct";
    }

    @PostMapping("submitAdd")
    public String add(Good good,BindingResult bindingResult,HttpSession session,RedirectAttributes redirectAttributes){
        //good.setClassificationId(classificationService.findById(0));

        good.setClassificationId(classificationService.findById(good.getGoodClassifyId()));
       // good.setBorrowered(borrowerService.findById(0));
        good.setGoodImg("0");
       // good.setBranderId(branderService.findById(Integer.parseInt(session.getAttribute("myId").toString())));
        goodService.addNewGood(good);
        redirectAttributes.addAttribute("brander_id",Integer.parseInt(session.getAttribute("myId").toString()));
        return "redirect:productManage";
    }

    @GetMapping("change/{id}")
    public String changeGood(@PathVariable("id")Integer id,HttpSession session,Model model){
        session.setAttribute("brands",brandService.findAllBrand());
        Good good = goodService.findById(id);
        good.setGoodImg("0");
        session.setAttribute("ppp",classificationService.findbyfatherid(0));
       // good.setClassificationId(classificationService.findById(0));
        session.setAttribute("change",good);
       // session.setAttribute("service",classificationService);
        return "MvoProductInfoChange";
    }

    @PostMapping("addClass")
    public String addcla(@RequestParam Integer idd,Model model,HttpSession session){
        model.addAttribute("qqq",classificationService.findbyfatherid(idd));
        session.setAttribute("ppp",classificationService.findbyid(idd));
        return "MvoProductInfoChange";
    }

    @PostMapping("addOne")
    public String addclas(@RequestParam Integer idd,HttpSession session,Model model){
        model.addAttribute("ttt",classificationService.findbyfatherid(idd));
        model.addAttribute("qqq",classificationService.findbyid(idd));
        return "MvoProductInfoChange";
    }

    @PostMapping("addfin")
    public String addFinish(@RequestParam Integer idd,HttpSession session,Model model){
        session.setAttribute("class_id",idd);
        model.addAttribute("ppp",classificationService.findById(classificationService.findById(classificationService.findById(idd).getClassifyParentId()).getClassifyParentId()));
        model.addAttribute("qqq",classificationService.findById(classificationService.findById(idd).getClassifyParentId()));
        model.addAttribute("ttt",classificationService.findById(idd));
        return  "MvoProductInfoChange";
    }

    @PostMapping("addClass2")
    public String addcla2(@RequestParam Integer idd,Model model,HttpSession session){
        model.addAttribute("qqq",classificationService.findbyfatherid(idd));
        session.setAttribute("ppp",classificationService.findbyid(idd));
        return "MvoAddProduct";
    }

    @PostMapping("addOne2")
    public String addclas2(@RequestParam Integer idd,HttpSession session,Model model){
        model.addAttribute("ttt",classificationService.findbyfatherid(idd));
        model.addAttribute("qqq",classificationService.findbyid(idd));
        return "MvoAddProduct";
    }

    @PostMapping("addfin2")
    public String addFinish2(@RequestParam Integer idd,HttpSession session,Model model){
        session.setAttribute("class_id",idd);
        model.addAttribute("ppp",classificationService.findById(classificationService.findById(classificationService.findById(idd).getClassifyParentId()).getClassifyParentId()));
        model.addAttribute("qqq",classificationService.findById(classificationService.findById(idd).getClassifyParentId()));
        model.addAttribute("ttt",classificationService.findById(idd));
        return  "MvoAddProduct";
    }



    @PostMapping("changeSubmit")
    public  String changeSubmit(Good good,BindingResult bindingResult,HttpSession session){
        good.setClassificationId(classificationService.findById(good.getGoodClassifyId()));
        goodService.alterGood(good);
        session.setAttribute("goods",goodService.findByBranderId(Integer.parseInt(session.getAttribute("myId").toString())));
        return "MvoProduct";
    }

    @GetMapping("Orderinfo_brander/{id}")
    public String orderInfoBrander(HttpSession session,@PathVariable("id")Integer id){
        session.setAttribute("orderinfo_brander",orderFormService.getByNutOrderFormId(id));
        session.setAttribute("nutit_brand",id);
        session.setAttribute("totalprice_brand",nutOrderService.getById(id).getNutOrderFormTotalPrice());
        session.setAttribute("createtime_brand",nutOrderService.getById(id).getNutOrderFormCreateTime());
        return "MVO-LISTshowmore";
    }

    @GetMapping("orderManage_brander/{id}")
    public String orderPage(HttpSession session,@PathVariable("id") Integer id){
        List<NutOrderForm> list= nutOrderService.findByBrandId(id);
        session.setAttribute("order_brander",list);
        return "MVO-LIST";
    }

    @GetMapping("brandManage_brander/{id}")
    public String brandMange(HttpSession session,@PathVariable("id") Integer id){
        session.setAttribute("brand_man",brandService.findByBranderId(id));
        return "MvoBrandInfo";

    }

    @GetMapping("changeInfo/{id}")
    public String brandChangeInfo(HttpSession session,@PathVariable("id") Integer id){
        session.setAttribute("brandinfochange",brandService.findById(id));
        return "MvoBrandInfoChange";
    }

    @GetMapping("changeStatus/{id}")//下架/上架按钮
    public String brandChangStatus(HttpSession session,@PathVariable("id") Integer id){
        Brand brand=brandService.findById(id);
        if(brand.getBrandStatus().equals("已上架")){
            brand.setBrandStatus("已下架");
        }
        else{
            brand.setBrandStatus("已上架");
        }
        brandService.alterBrand(brand);
        session.setAttribute("brand_man",brandService.findByBranderId(Integer.parseInt(session.getAttribute("myId").toString())));
        return "MvoBrandInfo";
    }


    @PostMapping("brandchangesubmit")
    public String submitchangebrandinfo(HttpSession session,Brand brand,BindingResult bindingResult,@RequestParam("file") MultipartFile file)throws FileNotFoundException{
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = FileUtil.getUpLoadFilePath();
        fileName=System.currentTimeMillis()+fileName;
        try{
            FileUtil.uploadFile(file.getBytes( ),filePath,fileName);}
        catch (Exception e){}
        brand.setBranderId(branderService.findById(Integer.parseInt(session.getAttribute("myId").toString())));
        brand.setGoodImg(fileName);
        brand.setBrandCreateTime(new java.sql.Date(new Date().getTime()));
        brandService.alterBrand(brand);
        session.setAttribute("brand_man",brandService.findByBranderId(Integer.parseInt(session.getAttribute("myId").toString())));
        return "MvoBrandInfo";
    }


    @GetMapping("addnewbrand")
    public String addNewBrand(HttpSession session){
        return "MvoAddBrand";
    }


    @PostMapping("addsub")
    public String addsub(Brand brand, BindingResult bindingResult, HttpSession session, @RequestParam("file") MultipartFile file)throws FileNotFoundException {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = FileUtil.getUpLoadFilePath();
        fileName=System.currentTimeMillis()+fileName;
        try{
            FileUtil.uploadFile(file.getBytes( ),filePath,fileName);}
        catch (Exception e){}
        brand.setBranderId(branderService.findById(Integer.parseInt(session.getAttribute("myId").toString())));
        brand.setGoodImg(fileName);
        brand.setBrandCreateTime(new java.sql.Date(new Date().getTime()));
        brand.setBrandStatus("已下架");
        brandService.addBrand(brand);
        session.setAttribute("brand_man",brandService.findByBranderId(Integer.parseInt(session.getAttribute("myId").toString())));
        return "MvoBrandInfo";
    }



    @GetMapping("MVowallet/{id}")
    public  String walletshow_brander(Model model,@PathVariable("id")Integer id){
        model.addAttribute("yue",branderService.findById(id).getCash());
        return "MVO-Wallet";
    }

    @GetMapping("MVowalletlist/{id}")
    public  String walletlistshow_brander(@PathVariable("id")Integer id,HttpSession session){
        session.setAttribute("trade_brander",tradeMVOService.findbybranderid(id));
        return "MVO-WalletList";
    }


    @GetMapping("MVowithdraw/{id}")
    public  String withdraw_brander(HttpSession session,@PathVariable("id")Integer id){
        return "MVO-WithdrawCash";
    }

    @PostMapping("confirmWithDraw_brander")
    public String confirmwithdraw_brander(@RequestParam String pass,@RequestParam String yue,HttpSession session,Model model){
        if(pass.equals(branderService.findById(Integer.parseInt(session.getAttribute("myId").toString())).getBranderWalletPwd())&&branderService.findById(Integer.parseInt(session.getAttribute("myId").toString())).getCash()>=Double.parseDouble(yue)){
            Brander brander=branderService.findById(Integer.parseInt(session.getAttribute("myId").toString()));
            brander.setCash(brander.getCash()-Double.parseDouble(yue));
            branderService.alterBranderInfo(brander);
            model.addAttribute("yue",brander.getCash());
            Trade_MVO trade_mvo = new Trade_MVO();
            trade_mvo.setBrander(branderService.findById(Integer.parseInt(session.getAttribute("myId").toString())));
            trade_mvo.setTradeNum(Double.parseDouble(yue));
            trade_mvo.setTradeStatus("已完成");
            trade_mvo.setTradeTime(new java.sql.Date(new Date().getTime()));
            tradeMVOService.addNewTrade(trade_mvo);
            return "MVO-Wallet";
        }
        else{
            Trade_MVO trade_mvo = new Trade_MVO();
            trade_mvo.setBrander(branderService.findById(Integer.parseInt(session.getAttribute("myId").toString())));
            trade_mvo.setTradeNum(Double.parseDouble(yue));
            trade_mvo.setTradeStatus("交易失败");
            trade_mvo.setTradeTime(new java.sql.Date(new Date().getTime()));
            tradeMVOService.addNewTrade(trade_mvo);
            return "tixianerror";
        }
    }


}

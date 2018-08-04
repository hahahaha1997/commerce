package com.example.commerce.controller;

import com.example.commerce.entity.*;
import com.example.commerce.surface.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller("Borrower")
public class BorrowerController {

    @Autowired
    public BorrowerService borrowerService;

    @Autowired
    public NutOrderService nutOrderService;

    @Autowired
    public OrderFormService orderFormService;

    @Autowired
    public BorrowGoodService borrowGoodService;

    @Autowired
    public GoodService goodService;

    @Autowired
    public TradeBVOService tradeBVOService;

    @Autowired
    public BranderService branderService;

    @Autowired
    public PayService payService;

    @Autowired
    public  ShippingAddressService shippingAddressService;

    @Autowired
    public  TradeMVOService tradeMVOService;
    @GetMapping("Borrower")
    public String getAllBorrower(@RequestParam String loginName_borrower, HttpSession session){
        session.setAttribute("borrows",borrowerService.findByBorrowerLoginName(loginName_borrower));
        session.setAttribute("br_id",borrowerService.findByBorrowerLoginName(loginName_borrower).get(0).getBorrowerId());

        return "main2";
    }

    @GetMapping("updateBorrower/{id}")
    public String updateBorrower(HttpSession session, @PathVariable("id")Integer id){
        session.setAttribute("borrower_update",borrowerService.findById(id));

        return "BorrowerInfoChange";
    }

    @PostMapping("ConfirmUpdateBorrower")
    public  String updateConfirm(Borrower borrower, BindingResult bindingResult,HttpSession session){
        borrower.setBorrowerUploadStatus("正常");
        borrower.setBorrowerLoginStatus("正常");
        borrower.setBorrowerTime(new java.sql.Date(new Date().getTime()));
        borrowerService.alterBorrower(borrower);
        session.setAttribute("borrows",borrower);
        return "borrowerInfo";
    }

    @GetMapping("myinfo_borrower")
    public String getmyInfo(HttpSession session) {

        return "BorrowerInfo";
    }



    @GetMapping("orderManage_borrower/{id}")
    public String orderPage_Borrow(HttpSession session,@PathVariable("id") Integer id){
        //model.addAttribute("order_borrower",nutOrderService.findByBorrowId(id));
        session.setAttribute("order_borrower",nutOrderService.findByBorrowId(id));
        return "BVO-LIST";
    }


    @GetMapping("Orderinfo_borrower/{id}")
    public String orderInfoBorrower(HttpSession session,@PathVariable("id") Integer id){
        session.setAttribute("orderinfo_borrower",orderFormService.getByNutOrderFormId(id));
        session.setAttribute("nutit",id);
        session.setAttribute("totalprice",nutOrderService.getById(id).getNutOrderFormTotalPrice());
        session.setAttribute("createtime",nutOrderService.getById(id).getNutOrderFormCreateTime());
        return "BVO-LISTshowmore";
    }

    @GetMapping("outGood/{id}")
    public String outGoods(HttpSession session,@PathVariable("id") Integer id){
        session.setAttribute("borrowgood",borrowGoodService.getAllGoodByBorrowerId(id));
        return "OutGoods";
    }



    @GetMapping("deleteborrowGood/{id}")
    public String deleteGood(@PathVariable("id")Integer id,HttpSession session){
        borrowGoodService.deleteborrowGood(id);
        session.setAttribute("borrowgood",borrowGoodService.getAllGoodByBorrowerId(Integer.parseInt(session.getAttribute("br_id").toString())));
        return "OutGoods";
    }

    @GetMapping("preOutGood/{id}")
    public String preOutGood(@PathVariable("id")Integer id,HttpSession session){
        session.setAttribute("preoutgood",goodService.findActiveGood("已上架"));
        session.setAttribute("me",id);
        return "PreOutGoods";
    }

    @GetMapping("watchmore/{id}")
    public  String watchmore(@PathVariable("id")Integer id,HttpSession session){
        session.setAttribute("goodid",goodService.findById(id));
        return "GoodsDetail";
    }

    /**
     * 上架网店
     * @param count 购买数量
     * @param idd   商品ID
     * @return      订单页面
     */
    @PostMapping("out")
    public  String outGood(@RequestParam Integer count,@RequestParam Integer idd,@RequestParam Double pri,HttpSession session){

        if(borrowerService.findById(Integer.parseInt(session.getAttribute("br_id").toString())).getBorrowerUploadStatus().equals("限制发布")){
            return "limitAddPage";
        }

        //BorrowGood 库存要增加
        //Good       库存要减少
        //Order     产生一条订单
        //钱包产生流水
        if(count>goodService.findById(idd).getGoodStock() || count*goodService.findById(idd).getGoodPrice()>borrowerService.findById(Integer.parseInt(session.getAttribute("br_id").toString())).getCash()){
            return "sellError";
        }
        Good good = goodService.findById(idd);
        good.setGoodStock(good.getGoodStock()-count);
        goodService.alterGood(good);

        BorrowGood borrowGood=new BorrowGood();
        borrowGood.setBorrowerId(borrowerService.findById(Integer.parseInt(session.getAttribute("br_id").toString())));
        borrowGood.setBorrowGoodDesc(good.getClassificationId().getClassifyPath());
        borrowGood.setBorrowGoodPrice(pri);
        borrowGood.setBorrowGoodStatus("未上架");
        borrowGood.setBorrowGoodTime((new java.sql.Date(new Date().getTime())));
        borrowGood.setGoodId(goodService.findById(idd));
        borrowGood.setBranderId(branderService.findById(good.getBranderId().getBranderId()));

        borrowGoodService.addNewBorrowerGood(borrowGood);



        NutOrderForm nutOrderForm=new NutOrderForm();
        nutOrderForm.setBorrowerId(borrowerService.findById(Integer.parseInt(session.getAttribute("br_id").toString())));
        nutOrderForm.setBranderId(branderService.findById(good.getBranderId().getBranderId()));
        nutOrderForm.setNutOrderFormCreateTime(borrowGood.getBorrowGoodTime());
        nutOrderForm.setNutOrderFormPayTime(borrowGood.getBorrowGoodTime());
        nutOrderForm.setNutOrderFormStatus("已完成");
        nutOrderForm.setNutOrderFormTotalPrice(count*goodService.findById(idd).getGoodPrice());
        nutOrderForm.setPayId(payService.findById(1));
        nutOrderForm.setShippingAddressId(shippingAddressService.findbyid(1));

        nutOrderService.addNew(nutOrderForm);


        OrderForm orderForm=new OrderForm();
        orderForm.setGoodFormCreateTime(borrowGood.getBorrowGoodTime());
        orderForm.setGoodFormNum(count);
        orderForm.setGoodFormPrice(goodService.findById(idd).getGoodPrice());
        orderForm.setGoodId(goodService.findById(good.getGoodId()));
        orderForm.setGoodTotalPrice(count*goodService.findById(idd).getGoodPrice());
        orderForm.setNutOrderFormId(nutOrderService.getById(nutOrderForm.getNutOrderFormId()));

        orderFormService.addNew(orderForm);

        Borrower borrower= borrowerService.findById(Integer.parseInt(session.getAttribute("br_id").toString()));
        borrower.setCash(borrower.getCash()-count*goodService.findById(idd).getGoodPrice());
        borrowerService.alterBorrower(borrower);

        Brander brander = branderService.findById(good.getBranderId().getBranderId());
        brander.setCash(brander.getCash()+count*goodService.findById(idd).getGoodPrice());
        branderService.alterBranderInfo(brander);

        Trade_BVO trade_bvo= new Trade_BVO();

        trade_bvo.setTradeType("提现");
        trade_bvo.setTradeTime(borrowGood.getBorrowGoodTime());
        trade_bvo.setTradeStatus("购货成功");
        trade_bvo.setTradeNum(count*goodService.findById(idd).getGoodPrice());
        trade_bvo.setBorrower(borrower);

        tradeBVOService.addNewTrade(trade_bvo);

        Trade_MVO trade_mvo = new Trade_MVO();
        trade_mvo.setTradeTime(borrowGood.getBorrowGoodTime());
        trade_mvo.setTradeStatus("出货成功");
        trade_mvo.setTradeNum(count*goodService.findById(idd).getGoodPrice());
        trade_mvo.setBrander(brander);

        tradeMVOService.addNewTrade(trade_mvo);

        session.setAttribute("preoutgood",goodService.findActiveGood("已上架"));
        return "PreOutGoods";

    }

    @GetMapping("BVowallet/{id}")
    public  String walletshow(@PathVariable("id") Integer id,Model model){
        model.addAttribute("yue",borrowerService.findById(id).getCash());
        return "BVO-Wallet";
    }

    @GetMapping("BVowalletlist/{id}")
    public  String walletlistshow(@PathVariable("id") Integer id,HttpSession session){
        //查明细
        session.setAttribute("trade_borrower_chongzhi",tradeBVOService.findbyborroweridandstatus(id,"充值"));
        session.setAttribute("trade_borrower_tixian",tradeBVOService.findbyborroweridandstatus(id,"提现"));
        return "BVO-WalletList";
    }


    @GetMapping("BVowithdraw/{id}")
    public String withdrwa(@PathVariable("id") Integer id,HttpSession session){
        return "BVO-WithdrawCash";
    }

    @GetMapping("Recharge/{id}")
    public  String recharge(@PathVariable("id")Integer id,Model model){
        model.addAttribute("yue",borrowerService.findById(id).getCash());
        //充值(余额，密码)
        return "BVO-Recharge";
    }

    @PostMapping("confirmWithDraw")
    public String confirmwithdraw(@RequestParam String pass,@RequestParam String yue,HttpSession session,Model model){
        if(pass.equals(borrowerService.findById(Integer.parseInt(session.getAttribute("br_id").toString())).getBorrowerWalletPwd())&&borrowerService.findById(Integer.parseInt(session.getAttribute("br_id").toString())).getCash()>=Double.parseDouble(yue)){
            Borrower borrower=borrowerService.findById(Integer.parseInt(session.getAttribute("br_id").toString()));
            borrower.setCash(borrower.getCash()-Double.parseDouble(yue));
            borrowerService.alterBorrower(borrower);
            model.addAttribute("yue",borrower.getCash());
            Trade_BVO trade_bvo = new Trade_BVO();
            trade_bvo.setBorrower(borrowerService.findById(Integer.parseInt(session.getAttribute("br_id").toString())));
            trade_bvo.setTradeNum(Double.parseDouble(yue));
            trade_bvo.setTradeStatus("已完成");
            trade_bvo.setTradeTime(new java.sql.Date(new Date().getTime()));
            trade_bvo.setTradeType("提现");
            tradeBVOService.addNewTrade(trade_bvo);
            return "BVO-Wallet";
        }
        else{
            Trade_BVO trade_bvo = new Trade_BVO();
            trade_bvo.setBorrower(borrowerService.findById(Integer.parseInt(session.getAttribute("br_id").toString())));
            trade_bvo.setTradeNum(Double.parseDouble(yue));
            trade_bvo.setTradeStatus("交易失败");
            trade_bvo.setTradeTime(new java.sql.Date(new Date().getTime()));
            trade_bvo.setTradeType("提现");
            tradeBVOService.addNewTrade(trade_bvo);
            return "tixianerror";
        }
    }


    @PostMapping("confirmRecharge")
    public String confirmrecharge(@RequestParam String pass,@RequestParam String yue,HttpSession session,Model model){
        if(pass.equals(borrowerService.findById(Integer.parseInt(session.getAttribute("br_id").toString())).getBorrowerWalletPwd())){
            Borrower borrower=borrowerService.findById(Integer.parseInt(session.getAttribute("br_id").toString()));
            borrower.setCash(borrower.getCash()+Double.parseDouble(yue));
            borrowerService.alterBorrower(borrower);
            model.addAttribute("yue",borrower.getCash());
            Trade_BVO trade_bvo = new Trade_BVO();
            trade_bvo.setBorrower(borrowerService.findById(Integer.parseInt(session.getAttribute("br_id").toString())));
            trade_bvo.setTradeNum(Double.parseDouble(yue));
            trade_bvo.setTradeStatus("已完成");
            trade_bvo.setTradeTime(new java.sql.Date(new Date().getTime()));
            trade_bvo.setTradeType("充值");
            tradeBVOService.addNewTrade(trade_bvo);
            return "BVO-Wallet";
        }
        else{
            Trade_BVO trade_bvo = new Trade_BVO();
            trade_bvo.setBorrower(borrowerService.findById(Integer.parseInt(session.getAttribute("br_id").toString())));
            trade_bvo.setTradeNum(Double.parseDouble(yue));
            trade_bvo.setTradeStatus("交易失败");
            trade_bvo.setTradeTime(new java.sql.Date(new Date().getTime()));
            trade_bvo.setTradeType("充值");
            tradeBVOService.addNewTrade(trade_bvo);
            return "tixianerror";
        }
    }


}

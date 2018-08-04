package com.example.commerce.controller;

import com.example.commerce.entity.*;
import com.example.commerce.surface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Controller("CreateOrder")
public class CreateOrderController {


    @Autowired
    public BorrowerService borrowerService;
    @Autowired
    public CustomerService customerService;
    @Autowired
    public PayService payService;
    @Autowired
    public ShippingAddressService   shippingAddressService;
    @Autowired
    public BorrowGoodService borrowGoodService;
    @Autowired
    public GoodService goodService;
    @Autowired
    public  NutOrderService nutOrderService;
    @Autowired
    public  OrderFormService orderFormService;
    @Autowired
    public  TradeBVOService tradeBVOService;
    @GetMapping("CreateOrder")
    public  String createAnOrder(Model model){
        model.addAttribute("borrowers",borrowerService.findAllBorrower());
        model.addAttribute("borrowGood",borrowerService);
        model.addAttribute("goods",borrowGoodService.findall());
        model.addAttribute("customers",customerService.findall());
        model.addAttribute("shippingAddressService",shippingAddressService);
        model.addAttribute("pay",payService.findall());
        return "AddNewList";
    }

    @PostMapping("back")
    public  String backToInit(Model model, @RequestParam Integer customer, @RequestParam Integer borrower){
        model.addAttribute("BG",borrowGoodService.getAllGoodByBorrowerId(borrower));
        model.addAttribute("addr",shippingAddressService.findbyid(customer));
        model.addAttribute("borrowers",borrowerService.findAllBorrower());
        model.addAttribute("borrowGood",borrowerService);
        model.addAttribute("goods",borrowGoodService.findall());
        model.addAttribute("customers",customerService.findall());
        model.addAttribute("shippingAddressService",shippingAddressService);
        model.addAttribute("pay",payService.findall());
        return "AddNewList2";
    }

    @PostMapping("finish")
    public  String InitOrder(@RequestParam Integer customer,
                             @RequestParam Integer borrower,
                             @RequestParam Integer shipping,
                             @RequestParam Integer pay,
                             @RequestParam Integer good1,
                             @RequestParam Integer num1,
                             @RequestParam Integer good2,
                             @RequestParam Integer num2){

        Good good_1 = goodService.findById(good1);
        Good good_2 = goodService.findById(good2);
        if(good_1.getGoodStock()<num1||good_2.getGoodStock()<num2)return "sellError";
        else{
            good_1.setGoodStock(good_1.getGoodStock()-num1);
            good_2.setGoodStock(good_2.getGoodStock()-num2);
            goodService.alterGood(good_1);
            goodService.alterGood(good_2);
        }

        NutOrderForm nutOrderForm=new NutOrderForm();
        nutOrderForm.setShippingAddressId(shippingAddressService.findbyid(shipping));
        nutOrderForm.setPayId(payService.findById(pay));
        nutOrderForm.setNutOrderFormTotalPrice(goodService.findById(good1).getGoodPrice()*num1+goodService.findById(good2).getGoodPrice()*num2);
        nutOrderForm.setNutOrderFormStatus("已完成");
        nutOrderForm.setBorrowerId(borrowerService.findById(borrower));
        nutOrderForm.setNutOrderFormCreateTime(new java.sql.Date(new Date().getTime()));
        nutOrderForm.setNutOrderFormPayTime(new java.sql.Date(new Date().getTime()));
        nutOrderForm.setCustomerId(customerService.findbyid(customer));
        nutOrderService.addNew(nutOrderForm);


        OrderForm orderForm1 = new OrderForm();
        orderForm1.setGoodTotalPrice(num1*goodService.findById(good1).getGoodPrice());
        orderForm1.setGoodId(goodService.findById(good1));
        orderForm1.setGoodFormPrice(goodService.findById(good1).getGoodPrice());
        orderForm1.setGoodFormNum(num1);
        orderForm1.setGoodFormCreateTime(new java.sql.Date(new Date().getTime()));
        orderForm1.setNutOrderFormId(nutOrderService.getById(nutOrderForm.getNutOrderFormId()));

        OrderForm orderForm2 = new OrderForm();
        orderForm2.setGoodTotalPrice(num1*goodService.findById(good2).getGoodPrice());
        orderForm2.setGoodId(goodService.findById(good2));
        orderForm2.setGoodFormPrice(goodService.findById(good2).getGoodPrice());
        orderForm2.setGoodFormNum(num2);
        orderForm2.setGoodFormCreateTime(new java.sql.Date(new Date().getTime()));
        orderForm2.setNutOrderFormId(nutOrderService.getById(nutOrderForm.getNutOrderFormId()));

        orderFormService.addNew(orderForm1);
        orderFormService.addNew(orderForm2);

        Trade_BVO trade_bvo=new Trade_BVO();
        trade_bvo.setTradeNum(goodService.findById(good1).getGoodPrice()*num1+goodService.findById(good2).getGoodPrice()*num2);
        trade_bvo.setBorrower(borrowerService.findById(borrower));
        trade_bvo.setTradeStatus("交易成功");
        trade_bvo.setTradeType("充值");
        trade_bvo.setTradeTime(new java.sql.Date(new Date().getTime()));
        tradeBVOService.addNewTrade(trade_bvo);

        return "redirect:CreateOrder";

    }

}

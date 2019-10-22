package com.transaction.example.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.transaction.example.CustomerAccountDAO.CustomerAccountdao;
import com.transaction.example.Exception.CustomerTransactionException;
import com.transaction.example.ServiceImpl.SendMoneyServiceImpl;
import com.transaction.example.entity.CustomerInfo;


@Controller
public class CustomerController {

	@Autowired(required=false)
    private CustomerAccountdao customerAccountDAO;
	
	@Autowired(required=false)
    private SendMoneyServiceImpl sendMoneyImpl;
 
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showCustomerAccounts(Model model) {
    List<CustomerInfo> list = customerAccountDAO.listCustomerAccountInfo();
 
        model.addAttribute("customerInfos", list);
 
        return "Accounts";
    }
 
    @RequestMapping(value = "/sendMoney", method = RequestMethod.GET)
    public String viewSendMoneyPage(Model model) {
 
        SendMoneyServiceImpl send = new SendMoneyServiceImpl(1L, 2L, 700d,"MEX");
 
        model.addAttribute("sendMoneyForm", send);
 
        return "Send";
    }
 
  
    @RequestMapping(value = "/sendMoney", method = RequestMethod.POST)
    public String processSendMoney(Model model, SendMoneyServiceImpl sendMoneyServiceImpl) {
 
        System.out.println("Send Money: " + sendMoneyImpl.getAmount());
 
        try {
        	customerAccountDAO.sendMoney(sendMoneyImpl.getFromAccountId(), //
        			sendMoneyImpl.getToAccountId(), //
        			sendMoneyImpl.getAmount(),sendMoneyImpl.getCurrency());
        } catch (CustomerTransactionException e) {
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "/Send";
        }
        return "redirect:/";
    }
 
}


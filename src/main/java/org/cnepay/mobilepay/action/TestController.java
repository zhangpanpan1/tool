package org.cnepay.mobilepay.action;

import org.cnepay.mobilepay.tool.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by BlackAnt on 17/8/17.
 */

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("loadAccount.action")
    public ModelAndView testloadAccount(String accountNo) {
        List<Map<String,Object>> results = testService.loadAccount(accountNo);
        return new ModelAndView("success");
    }

    @RequestMapping("findAccountByMerchant.action")
    public ModelAndView testFindAccountByMerchant(String merchantId) {
        List<Map<String,Object>> results = testService.findAccountByMerchant(merchantId);
        return new ModelAndView("success");
    }

    @RequestMapping("validateMerchant.action")
    public ModelAndView testValidateMerchant(String id) {
        testService.validateMerchant(id);
        return new ModelAndView("success");
    }

    @RequestMapping("unvalidateMerchant.action")
    public ModelAndView unvalidateMerchant(String id) {
        testService.unvalidateMerchant(id);
        return new ModelAndView("success");
    }

    @RequestMapping("existBankCard.action")
    public ModelAndView existBankCard(String backId) {
        testService.existBankCard(backId);
        return new ModelAndView("success");
    }

    @RequestMapping("unbundAccountCount.action")
    public ModelAndView unbundAccountCount(String accountNo) {
        testService.unbundAccountCount(accountNo);
        return new ModelAndView("success");
    }

    @RequestMapping("unbundAccount.action")
    public ModelAndView unbundAccount(String accountNo) {
        testService.unbundAccount(accountNo);
        return new ModelAndView("success");
    }



}


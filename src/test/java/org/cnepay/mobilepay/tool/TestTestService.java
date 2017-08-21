package org.cnepay.mobilepay.tool;

import org.cnepay.mobilepay.tool.service.TestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by BlackAnt on 17/8/21.
 */
public class TestTestService extends TestBase {
    @Autowired
    private TestService testService;

//    <%-- 测试 --%>

//    <%--<jsp:forward page="/test/existBankCard.action?backId=6228480402564622940"/>--%>
//    <%--<jsp:forward page="/test/unbundAccountCount.action?accountNo=1728880"/>--%>
//    <%--<jsp:forward page="/test/unbundAccount.action?accountNo=1728880"/>--%>

    @Test
    public void testLoadAccount() {
        List<Map<String,Object>> results = testService.loadAccount("245");
        System.out.println(results);
    }

    @Test
    public void testFindAccountByMerchant() {
        List<Map<String,Object>> results = testService.findAccountByMerchant("3064863");
        System.out.println(results);
    }

    @Test
    public void testValidateMerchant() {
        int result = testService.validateMerchant("1728880");
        System.out.println(result);
    }

    @Test
    public void testUnvalidateMerchant() {
        int result = testService.unvalidateMerchant("1728880");
        System.out.println(result);
    }

    @Test
    public void testExistBankCard() {
        int result = testService.existBankCard("6228480402564622940");
        System.out.println(result);
    }



}

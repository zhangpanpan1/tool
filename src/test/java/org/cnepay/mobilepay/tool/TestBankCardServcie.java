package org.cnepay.mobilepay.tool;

import org.cnepay.mobilepay.tool.service.BankCardService;
import org.cnepay.mobilepay.tool.service.TestService;
import org.cnepay.mobilepay.tool.views.BandCardEntity;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by BlackAnt on 17/8/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
// 使用junit4进行测试
@ContextConfiguration({ "classpath:applicationContext.xml" })
// 加载配置文件
public class TestBankCardServcie {
	
	@Autowired
	private BankCardService bankCardService;

	@Before
	public void brfore() {
		Assert.assertEquals(1, 1);
	}

	@Test
	public void testP() {
		List<BandCardEntity> list= bankCardService.findBankCardInfoByCardNo("6270670399377782");
		Assert.assertEquals("6270670399377782",list.get(0).getCardNo());
	}

	@After
	public void after() {
		Assert.assertEquals(1, 1);
	}

}

package org.cnepay.mobilepay.tool;

import java.util.List;

import org.cnepay.mobilepay.tool.service.MessageValidateService;
import org.cnepay.mobilepay.tool.views.BandCardEntity;
import org.cnepay.mobilepay.tool.views.MessageValidateInfoEntity;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by BlackAnt on 17/8/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
// 使用junit4进行测试
@ContextConfiguration({ "classpath:applicationContext.xml" })
// 加载配置文件
public class TestMessageServcie {
	
	@Autowired
	private MessageValidateService messageService;

	@Before
	public void brfore() {
		Assert.assertEquals(1, 1);
	}

	@Test
	public void testP() {
		List<MessageValidateInfoEntity> list=	messageService.loadMessageValidateCode("10");
		Assert.assertEquals(new Long(41),new Long(list.size()));
		
	}

	@After
	public void after() {
		Assert.assertEquals(1, 1);
	}

}

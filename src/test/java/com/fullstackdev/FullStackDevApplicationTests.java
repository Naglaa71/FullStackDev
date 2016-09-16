package com.fullstackdev;

import com.fullstackdev.web.i18n.I18NService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FullStackDevApplicationTests {

	@Autowired
	I18NService i18NService;
	@Test
	public void testMessageByLocaleService() throws Exception{
		String expectedMessage = "Bootstrap starter template";
		String messageId="index.main.callout";
		String actualMessage = i18NService.getMessage(messageId);
		org.junit.Assert.assertEquals("The expected message and actual message don't match",expectedMessage,actualMessage);
	}


}

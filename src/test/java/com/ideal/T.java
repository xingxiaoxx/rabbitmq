
package com.ideal;


import com.alibaba.fastjson.JSON;
import com.ideal.common.req.PageData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring-application.xml","classpath:spring-bean-test.xml"})

public class T {

	@Autowired
	private MultithreadMQProducer multithreadMQProducer;


	
//	protected static final Logger logger = LoggerFactory.getLogger(T.class);
	
	@Test
	public void test(){


		PageData pageData = new PageData();
		pageData.put("push", "你好");

		multithreadMQProducer.send("", "notice", JSON.toJSONString(pageData));
	}

	
}

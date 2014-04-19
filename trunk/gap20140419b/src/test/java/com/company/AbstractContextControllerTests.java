package com.company;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * 单元测试基类.
 * @author lh.jia
 * @date 2013.07.23
 */
@WebAppConfiguration
@ContextConfiguration(value={"classpath*:applicationContext*.xml","file:src/main/webapp/WEB-INF/springmvc-servlet.xml"})
public class AbstractContextControllerTests {
	@Autowired
	protected WebApplicationContext wac;
	
	protected MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}
}
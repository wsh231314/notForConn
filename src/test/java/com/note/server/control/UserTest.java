package com.note.server.control;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=MockServletContext.class)
@WebAppConfiguration
public class UserTest {
	
	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.standaloneSetup(new User()).build();
	}
	
	@Test
	public void testUrl () throws Exception {
		
		RequestBuilder request = null;
		
		request = MockMvcRequestBuilders.get("/users/get");
		mvc.perform(request)
		.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("hello!"));
		
		request = MockMvcRequestBuilders.put("/users/111").param("id", "111").param("name", "wsh").param("age", "30");
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("ok"));
		
		request = MockMvcRequestBuilders.put("/users/111").param("userInfo.id", "111").param("userInfo.name", "wsh").param("userInfo.age", "30");
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("ok"));
	
	}
}

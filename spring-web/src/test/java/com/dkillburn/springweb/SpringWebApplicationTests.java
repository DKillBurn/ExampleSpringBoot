package com.dkillburn.springweb;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dkillburn.springweb.api.example.ExampleService;
import com.dkillburn.springweb.api.example.ExampleServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes=SpringWebApplication.class)
//@ContextConfiguration(classes={})
public class SpringWebApplicationTests {
	private static Logger log = LoggerFactory.getLogger(SpringWebApplicationTests.class);

	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mvc;

	@TestConfiguration
    static class ExampleServiceImplTestContextConfiguration {
 
        @Bean
        public ExampleService exampleService() {
            return new ExampleServiceImpl();
        }
    }

	@Before
	public void setup(){
		mvc = MockMvcBuilders
		.webAppContextSetup(ctx)
		.build();
	}

	@MockBean
	@Qualifier("exampleService")
	ExampleService exampleService;

	@Test
	public void testGetEndpoint() {
		try{
			mvc.perform(get("/example")).andExpect(status().isOk());
		}catch(Exception e){
			log.error("Test Error: ", e);
		}
	}

	@Test
	public void testPostEndpoint() {
		try{
			mvc.perform(post("/example").header("Content-Type", "application/json").content("{}")).andExpect(status().isCreated());
		}catch(Exception e){
			log.error("Test Error: ", e);
		}
	}

	@Test
	public void testPutEndpoint() {
		try{
			mvc.perform(put("/example").header("Content-Type", "application/json").param("id", "0").content("{}")).andExpect(status().isAccepted()).andReturn();
		}catch(Exception e){
			log.error("Test Error: ", e);
		}
	}

	@Test
	public void testDeleteEndpoint() {
		try{
			mvc.perform(delete("/example").param("id", "0")).andExpect(status().isAccepted()).andReturn();
		}catch(Exception e){
			log.error("Test Error: ", e);
		}
	}
}

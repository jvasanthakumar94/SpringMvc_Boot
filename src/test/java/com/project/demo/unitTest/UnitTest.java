package com.project.demo.unitTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.project.demo.controller.EmployeeRestController;
import com.project.demo.service.EmployeeService;

@WebMvcTest(EmployeeRestController.class)
public class UnitTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService service;

	
	
	@Test
	public void testEmployees() throws Exception {
	
		this.mockMvc.perform(get("/employees"))
		.andExpect(matcher ->  matcher.getResponse().getRedirectedUrl().contains("login"))
		.andExpect(status().is3xxRedirection());
				
	}
	
	@Test
	public void testLogin() throws Exception {
	
		this.mockMvc.perform(get("/login")).andExpect(status().isOk());
				
	}
	
	@Test
	public void test() throws Exception {
		when(service.test()).thenReturn("test");
		this.mockMvc.perform(get("/test")).andDo(print()).andExpect(status().isOk());
				
	}
}
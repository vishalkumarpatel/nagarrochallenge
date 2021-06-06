package com.nagarro.challenge.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturn403ForNonAdminUser() throws Exception {
		this.mockMvc.perform(get("/accounts").contentType(MediaType.APPLICATION_JSON).with(user("USER")).with(csrf()))
				.andDo(print()).andExpect(status().is4xxClientError());
	}

	@Test
	@WithMockUser(username = "admin", roles = { "USER", "ADMIN" })
	public void shouldReturn200ForAdminUser() throws Exception {
		this.mockMvc.perform(get("/accounts").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}
}

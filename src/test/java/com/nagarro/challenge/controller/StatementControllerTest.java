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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
public class StatementControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturn200ForNonAdminUser() throws Exception {
		this.mockMvc
				.perform(get("/statements/1").contentType(MediaType.APPLICATION_JSON).with(user("USER")).with(csrf()))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	@WithMockUser(username = "user", roles = { "USER" })
	public void shouldReturn400ForNonAdminUserWithParams() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("startDate", "10/13/2020");
		params.add("endDate", "10/20/2020");
		params.add("fromAmount", "100");
		params.add("toAmount", "200");
		this.mockMvc.perform(get("/statements/1").contentType(MediaType.APPLICATION_JSON).params(params).with(csrf()))
				.andDo(print()).andExpect(status().is4xxClientError());
	}

	@Test
	@WithMockUser(username = "admin", roles = { "USER", "ADMIN" })
	public void shouldReturn200ForAdminUser() throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("startDate", "10/13/2020");
		params.add("endDate", "10/20/2020");
		params.add("fromAmount", "100");
		params.add("toAmount", "200");
		this.mockMvc.perform(get("/statements/1").contentType(MediaType.APPLICATION_JSON).params(params)).andDo(print())
				.andExpect(status().isOk());
	}
}

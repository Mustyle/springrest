package org.fool.springrest.unit;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;

import org.fool.springrest.SpringrestApplication;
import org.fool.springrest.domain.Poll;
import org.fool.springrest.repository.PollRepository;
import org.fool.springrest.v1.controller.PollController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringrestApplication.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class PollControllerTest {
	@Mock
	private PollRepository pollRepository;

	@InjectMocks
	PollController pollController;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(pollController).build();
	}

	@Test
	public void testGetAllPolls() throws Exception {
		when(pollRepository.findAll()).thenReturn(new ArrayList<Poll>());
		mockMvc.perform(get("/v1/polls")).andExpect(status().isOk()).andExpect(content().string("[]"));
	}
}

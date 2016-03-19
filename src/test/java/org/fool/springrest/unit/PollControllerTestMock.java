package org.fool.springrest.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.fool.springrest.domain.Poll;
import org.fool.springrest.repository.PollRepository;
import org.fool.springrest.v1.controller.PollController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.google.common.collect.Lists;

public class PollControllerTestMock {

	@Mock
	private PollRepository pollRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllPolls() {
		PollController pollController = new PollController();
		ReflectionTestUtils.setField(pollController, "pollRepository", pollRepository);

		when(pollRepository.findAll()).thenReturn(new ArrayList<Poll>());
		ResponseEntity<Iterable<Poll>> allPollsEntity = pollController.getAllPolls();
		verify(pollRepository, times(1)).findAll();
		assertEquals(HttpStatus.OK, allPollsEntity.getStatusCode());
		assertEquals(0, Lists.newArrayList(allPollsEntity.getBody()).size());
	}

}

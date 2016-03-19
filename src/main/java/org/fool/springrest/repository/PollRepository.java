package org.fool.springrest.repository;

import org.fool.springrest.domain.Poll;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PollRepository extends PagingAndSortingRepository<Poll, Long> {

}

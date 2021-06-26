package com.kodilla.ecommercee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GroupDao extends CrudRepository<Group, Long> {
}

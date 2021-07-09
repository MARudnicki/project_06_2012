package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupDbService {

    private final GroupDao groupDao;

    public List<Group> getAllGroups() {
        return groupDao.findAll();
    }

    public Optional<Group> getGroup(final Long id) {
        return groupDao.findById(id);
    }

    public Group saveGroup(final Group group) {
        return groupDao.save(group);
    }

}

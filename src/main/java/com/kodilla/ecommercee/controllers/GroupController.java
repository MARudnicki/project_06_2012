package com.kodilla.ecommercee.controllers;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupDbService groupDbService;
    private final GroupMapper groupMapper;

    @GetMapping(value = "/getGroups")
    public List<GroupDto> getGroups() {
        List<Group> groups = groupDbService.getAllGroups();
        return groupMapper.mapToGroupDtoList(groups);
    }

    @PostMapping(value = "/createGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        Group group = groupMapper.mapToGroup(groupDto);
        groupDbService.saveGroup(group);
    }

    @GetMapping(value = "/getGroup/{groupId}")
    public GroupDto getGroup(@PathVariable Long groupId) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(
                groupDbService.getGroup(groupId).orElseThrow(GroupNotFoundException::new)
        );
    }

    @PutMapping(value = "/updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        Group group = groupMapper.mapToGroup(groupDto);
        Group savedGroup = groupDbService.saveGroup(group);
        return groupMapper.mapToGroupDto(savedGroup);
    }

}


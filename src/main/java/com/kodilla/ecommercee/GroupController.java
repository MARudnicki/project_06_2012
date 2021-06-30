package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GroupController {

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        return new ArrayList<>();
    }

    @PostMapping(value = "createGroup")
    public void createGroup(@RequestBody GroupDto groupDto) {

    }

    @GetMapping(value = "getGroup/{groupId}")
    public GroupDto getGroup(@PathVariable Long groupId) {
        return new GroupDto(1L,"Ubrani a");
    }

    @PutMapping(value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return new GroupDto(1L,"Ubrania");
    }

}

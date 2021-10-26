package com.app.Group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public Group findById(Long groupId) {
        return groupRepository.findById(groupId).get();
    }

    public Group saveGroup(Group group) {
        return groupRepository.saveAndFlush(group);
    }
}

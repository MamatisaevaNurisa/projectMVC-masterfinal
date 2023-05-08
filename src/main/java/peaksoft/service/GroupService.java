package peaksoft.service;

import peaksoft.entities.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    void addGroup(Long courseId, Group group);
    Group getGroupById(Long id);
    void updateGroup(Long id, Long courseId, Group group);
    void deleteGroup(Group group);
}

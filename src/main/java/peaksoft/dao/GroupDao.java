package peaksoft.dao;

import peaksoft.entities.Group;

import java.util.List;

public interface GroupDao {
    List<Group> getAllGroups();
    void addGroup(Long courseId, Group group);
    Group getGroupById(Long id);
    void updateGroup(Long id, Long courseId, Group group);
    void deleteGroup(Group group);

}

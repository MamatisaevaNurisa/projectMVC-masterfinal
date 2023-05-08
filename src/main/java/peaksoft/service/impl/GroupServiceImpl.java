package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.GroupDao;
import peaksoft.entities.Group;
import peaksoft.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupDao groupDao;

    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupDao.getAllGroups();
    }

    @Override
    public void addGroup(Long courseId, Group group) {
        groupDao.addGroup(courseId, group);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupDao.getGroupById(id);
    }

    @Override
    public void updateGroup(Long id, Long courseId, Group group) {
        groupDao.updateGroup(id, courseId, group);
    }

    @Override
    public void deleteGroup(Group group) {
        groupDao.deleteGroup(group);
    }
}

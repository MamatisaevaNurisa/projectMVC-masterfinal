package peaksoft.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.GroupDao;
import peaksoft.entities.Course;
import peaksoft.entities.Group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDao {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Group> getAllGroups() {
        List<Group> groups = manager.createQuery("From Group", Group.class).getResultList();
        return groups;
    }

    @Override
    public void addGroup(Long courseId, Group group) {
        Course course = manager.find(Course.class, courseId);
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        List<Group> groups = new ArrayList<>();
        groups.add(group);
        course.setGroups(groups);
        group.setCourses(courses);
        manager.persist(group);
    }

    @Override
    public Group getGroupById(Long id) {
        Group group = manager.find(Group.class, id);
        return group;
    }

    @Override
    public void updateGroup(Long id, Long courseId, Group group) {
        Group group1 = getGroupById(id);
        group1.setGroupName(group.getGroupName());
        group1.setDataOfStart(group.getDataOfStart());
        group1.setDataOfFinish(group.getDataOfFinish());
        Course course = manager.find(Course.class, courseId);
        List<Group> groups = new ArrayList<>();
        groups.add(group1);
        course.setGroups(groups);
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        group1.setCourses(courses);
        manager.merge(group1);
    }

    @Override
    public void deleteGroup(Group group) {
        manager.remove(manager.contains(group) ? group : manager.merge(group));
    }
}

package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Course;
import peaksoft.entities.Group;
import peaksoft.entities.Student;
import peaksoft.service.CourseService;
import peaksoft.service.GroupService;
import peaksoft.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;
    private final CourseService courseService;
    private final StudentService studentService;

    @Autowired
    public GroupController(GroupService groupService, CourseService courseService, StudentService studentService) {
        this.groupService = groupService;
        this.courseService = courseService;
        this.studentService = studentService;
    }
    @ModelAttribute("courseList")
    public List<Course> getCourseList(){
        return courseService.getAllCourses();
    }
    @GetMapping
    public String getAllGroups(Model model){
        List<Group> groups = groupService.getAllGroups();
        model.addAttribute("groups", groups);
        return "group/groups";
    }
    @GetMapping("/addGroup")
    public String addGroup(Model model){
        model.addAttribute("group", new Group());
        return "group/addGroup";
    }
    @PostMapping("saveGroup")
    public String saveGroup(@ModelAttribute("group") Group group){
        groupService.addGroup(group.getCourseId(), group);
        return "redirect:/groups";
    }
    @GetMapping("/update/{id}")
    public String updateGroup(@PathVariable("id") Long id, Model model){
        Group group = groupService.getGroupById(id);
        model.addAttribute("updateGroup", group);
        return "group/updateGroup";
    }
    @PatchMapping("{id}")
    public String saveUpdateGroup(@PathVariable("id")Long id, @ModelAttribute("group") Group group){
        groupService.updateGroup(id, group.getCourseId(), group);
        return "redirect:/groups";
    }
    @DeleteMapping("/delete")
    public String deleteGroup(@RequestParam("id")Long id){
    Group group = groupService.getGroupById(id);
    groupService.deleteGroup(group);
    return "redirect:/groups";
    }
    @GetMapping("/search")
    public String getStudentName(Model model, String name){
        List<Student> students = studentService.getStudentByName(name);
        List<Student> studentList = studentService.getAllStudents();
        if(name != null){
            model.addAttribute("students", students);
        }
        else{
            model.addAttribute("students", studentList);
        }
        return "group/getStudent";
    }
}

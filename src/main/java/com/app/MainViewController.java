package com.app;

import com.app.Group.Group;
import com.app.Group.GroupService;
import com.app.Student.Student;
import com.app.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class MainViewController {

    private final StudentService studentService;
    private final GroupService groupService;

    @Autowired
    public MainViewController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping
    public String GetMainPage() {
        return "index";
    }
    @GetMapping(path = "/students")
    public String GetStudents(Model model) {
        model.addAttribute("Title","Students");
        List<String> headers = List.of(
                "Registration Number",
                "Group Title",
                "First Name",
                "Last Name",
                "Email Adress",
                "Phone Number",
                "Date Of Birth",
                "Adress",
                "Registration Date"
        );
        List<Student> students = studentService.getStudents();
        List<Map<String, Object>> rows = new ArrayList<>();
        SimpleDateFormat sDF = new SimpleDateFormat("dd MMM yyyy");
        for (Student student : students) {
            Map<String, Object> map = Map.of(
                    headers.get(0), student.getId().toString(),
                    headers.get(1), student.getGroup().getGroup_title(),
                    headers.get(2), student.getFirst_name(),
                    headers.get(3), student.getLast_name(),
                    headers.get(4), student.getEmail_adress(),
                    headers.get(5), student.getPhone_number().toString(),
                    headers.get(6), sDF.format(student.getDate_of_birth()),
                    headers.get(7), student.getAdress(),
                    headers.get(8), sDF.format(student.getRegistration_date())
            );
            rows.add(map);
        }
        model.addAttribute("headers",headers);
        model.addAttribute("rows",rows);
        return "index";
    }

    @GetMapping(path = "/groups")
    public String GetGroups(Model model) {
        model.addAttribute("Title","Groups");
        List<String> headers = List.of(
                "Group ID",
                "Group Title",
                "Students",
                "Sessions"
        );
        List<Boolean> complexType = List.of(false,false,true,true);
        List<Group> groups = groupService.GetGroups();
        List<Map<String, Object>> rows = new ArrayList<>();
        for (Group group : groups) {
            Map<String, Object> map = Map.of(
                    headers.get(0), group.getId().toString(),
                    headers.get(1), group.getGroup_title(),
                    headers.get(2), group.getStudents(),
                    headers.get(3), group.getSessions()
            );
            rows.add(map);
        }
        model.addAttribute("headers",headers);
        model.addAttribute("rows",rows);
        model.addAttribute("complexType",complexType);
        return "index";
    }

}


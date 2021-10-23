package com.app;

import com.app.Classroom.Classroom;
import com.app.Classroom.ClassroomService;
import com.app.Course.Course;
import com.app.Course.CourseService;
import com.app.Department.Department;
import com.app.Department.DepartmentService;
import com.app.Group.Group;
import com.app.Group.GroupService;
import com.app.Session.Session;
import com.app.Session.SessionService;
import com.app.Student.Student;
import com.app.Student.StudentService;
import com.app.Teacher.Teacher;
import com.app.Teacher.TeacherService;
import com.app.University.University;
import com.app.University.UniversityService;
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
    private final ClassroomService classroomService;
    private final CourseService courseService;
    private final DepartmentService departmentService;
    private final SessionService sessionService;
    private final TeacherService teacherService;
    private final UniversityService universityService;

    @Autowired
    public MainViewController(StudentService studentService, GroupService groupService, ClassroomService classroomService, CourseService courseService, DepartmentService departmentService, SessionService sessionService, TeacherService teacherService, UniversityService universityService) {
        this.studentService = studentService;
        this.groupService = groupService;
        this.classroomService = classroomService;
        this.courseService = courseService;
        this.departmentService = departmentService;
        this.sessionService = sessionService;
        this.teacherService = teacherService;
        this.universityService = universityService;
    }

    @GetMapping
    public String GetMainPage(Model model) {
        model.addAttribute("Title","Spring boot");
        model.addAttribute("mainpage",true);
        /*departmentService.deleteAll();
        universityService.deleteAll();
        University u = new University("ISG","http://www.isg.rnu.tn/");
        List<Department> departments = List.of(
                new Department("Computer science",u),
                new Department("Economics",u),
                new Department("Finance and accounting",u),
                new Department("Management",u),
                new Department("Human Resources",u),
                new Department("Marketing",u)
        );
        u.setDepartments(departments);
        u = universityService.saveUniversity(u);
        /*for (Department department : departments){
            department.setUniversity(u);
            System.out.println(u.getId());
        }
        departments = departmentService.saveDepartments(departments);*/
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
        List<Group> groups = groupService.getGroups();
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

    @GetMapping(path = "/classrooms")
    public String GetClassrooms(Model model) {
        model.addAttribute("Title","Classrooms");
        List<String> headers = List.of(
                "Classroom ID",
                "Classroom Name",
                "Classroom Type",
                "Classroom Capacity",
                "Sessions"
        );
        List<Boolean> complexType = List.of(false,false,false,false,true);
        List<Classroom> classrooms = classroomService.getClassrooms();
        List<Map<String, Object>> rows = new ArrayList<>();
        for (Classroom classroom : classrooms) {
            Map<String, Object> map = Map.of(
                    headers.get(0), classroom.getId().toString(),
                    headers.get(1), classroom.getClassroom_name(),
                    headers.get(2), classroom.getClassroom_type().toString(),
                    headers.get(3), classroom.getClassroom_capacity().toString(),
                    headers.get(4), classroom.getSessions()
            );
            rows.add(map);
        }
        model.addAttribute("headers",headers);
        model.addAttribute("rows",rows);
        model.addAttribute("complexType",complexType);
        return "index";
    }

    @GetMapping(path = "/courses")
    public String GetCourses(Model model) {
        model.addAttribute("Title","Courses");
        List<String> headers = List.of(
                "Course ID",
                "Course Title",
                "Course Coefficient",
                "Course Credits",
                "Sessions"
        );
        List<Boolean> complexType = List.of(false,false,false,false,true);
        List<Course> courses = courseService.getCourses();
        List<Map<String, Object>> rows = new ArrayList<>();
        for (Course course : courses) {
            Map<String, Object> map = Map.of(
                    headers.get(0), course.getId().toString(),
                    headers.get(1), course.getCourse_title(),
                    headers.get(2), course.getCourse_coefficient().toString(),
                    headers.get(3), course.getCourse_credits().toString(),
                    headers.get(4), course.getSessions()
            );
            rows.add(map);
        }
        model.addAttribute("headers",headers);
        model.addAttribute("rows",rows);
        model.addAttribute("complexType",complexType);
        return "index";
    }

    @GetMapping(path = "/departments")
    public String GetDepartements(Model model) {
        model.addAttribute("Title","Departments");
        List<String> headers = List.of(
                "Department Code",
                "Department Name",
                "Instructors",
                "University Code"
        );
        List<Boolean> complexType = List.of(false,false,true,false);
        List<Department> departements = departmentService.getDepartments();
        List<Map<String, Object>> rows = new ArrayList<>();
        for (Department departement : departements) {
            Map<String, Object> map = Map.of(
                    headers.get(0), departement.getId().toString(),
                    headers.get(1), departement.getName(),
                    headers.get(2), departement.getTeachers(),
                    headers.get(3), departement.getUniversity().getName()
            );
            rows.add(map);
        }
        model.addAttribute("headers",headers);
        model.addAttribute("rows",rows);
        model.addAttribute("complexType",complexType);
        return "index";
    }

    @GetMapping(path = "/sessions")
    public String GetSessions(Model model) {
        model.addAttribute("Title","Sessions");
        List<String> headers = List.of(
                "Session ID",
                "Session Date",
                "Session Time",
                "Instructor",
                "Classroom",
                "Course",
                "Group"
        );
        List<Session> sessions = sessionService.getSessions();
        List<Map<String, Object>> rows = new ArrayList<>();
        SimpleDateFormat sDF = new SimpleDateFormat("dd MMM yyyy");
        SimpleDateFormat sDT = new SimpleDateFormat("hh:mm");
        for (Session session : sessions) {
            Map<String, Object> map = Map.of(
                    headers.get(0), session.getId().toString(),
                    headers.get(1), sDF.format(session.getDate()),
                    headers.get(2), sDT.format(session.getTime()),
                    headers.get(3), session.getTeacher().getLast_name(),
                    headers.get(4), session.getClassroom().getClassroom_name(),
                    headers.get(5), session.getCourse().getCourse_title(),
                    headers.get(6), session.getGroup().getGroup_title()
            );
            rows.add(map);
        }
        model.addAttribute("headers",headers);
        model.addAttribute("rows",rows);
        return "index";
    }

    @GetMapping(path = "/instructors")
    public String GetTeachers(Model model) {
        model.addAttribute("Title","Instructors");
        List<String> headers = List.of(
                "ID",
                "First Name",
                "Last Name",
                "Diploma",
                "Email Adress",
                "Phone Number",
                "Department",
                "Sessions",
                "Adress"
        );
        List<Boolean> complexType = List.of(false,false,false,false,false,false,false,true,false);
        List<Teacher> teachers = teacherService.getTeachers();
        List<Map<String, Object>> rows = new ArrayList<>();
        for (Teacher teacher : teachers) {
            Map<String, Object> map = Map.of(
                    headers.get(0), teacher.getId().toString(),
                    headers.get(1), teacher.getFirst_name(),
                    headers.get(2), teacher.getLast_name(),
                    headers.get(3), teacher.getDiploma(),
                    headers.get(4), teacher.getEmail_adress(),
                    headers.get(5), teacher.getPhone_number().toString(),
                    headers.get(6), teacher.getDepartment().getName(),
                    headers.get(7), teacher.getSessions(),
                    headers.get(8), teacher.getAdress()
                    );
            rows.add(map);
        }
        model.addAttribute("headers",headers);
        model.addAttribute("rows",rows);
        model.addAttribute("complexType",complexType);
        return "index";
    }

    @GetMapping(path = "/universities")
    public String GetUniversities(Model model) {
        model.addAttribute("Title","Universities");
        List<String> headers = List.of(
                "University Code",
                "University Name",
                "University Website",
                "Departments"
        );
        List<Boolean> complexType = List.of(false,false,false,true);
        List<University> universities = universityService.getUniversities();
        List<Map<String, Object>> rows = new ArrayList<>();
        for (University university : universities) {
            Map<String, Object> map = Map.of(
                    headers.get(0), university.getId().toString(),
                    headers.get(1), university.getName(),
                    headers.get(2), university.getWebsite(),
                    headers.get(3), university.getDepartments()
            );
            rows.add(map);
        }
        model.addAttribute("headers",headers);
        model.addAttribute("rows",rows);
        model.addAttribute("complexType",complexType);
        return "index";
    }
}


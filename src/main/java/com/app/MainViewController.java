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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("Title","University Architecture");
        model.addAttribute("mainpage",true);
        return "index";
    }

    @GetMapping(path = "/students")
    public String GetStudents(Model model) {
        model.addAttribute("Title","Students");
        model.addAttribute("student", new Student());
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
        List<Boolean> complexType = List.of(false,false,false,false,false,false,false,false,false);
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
        model.addAttribute("complexType",complexType);
        model.addAttribute("groups", groupService.getGroups());
        return "index";
    }

    @GetMapping(path = "/groups")
    public String GetGroups(Model model) {
        model.addAttribute("Title","Groups");
        model.addAttribute("group", new Group());
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
        model.addAttribute("classroom", new Classroom());
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
                    headers.get(2), classroom.getClassroom_type().toString().replace('_',' '),
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
        model.addAttribute("course", new Course());
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

    @GetMapping(path = "/sessions")
    public String GetSessions(Model model) {
        model.addAttribute("Title","Sessions");
        model.addAttribute("session", new Session());
        List<String> headers = List.of(
                "Session ID",
                "Session Date",
                "Session Time",
                "Instructor",
                "Classroom",
                "Course",
                "Group"
        );
        List<Boolean> complexType = List.of(false,false,false,false,false,false,false);
        List<Session> sessions = sessionService.getSessions();
        List<Map<String, Object>> rows = new ArrayList<>();
        SimpleDateFormat sDF = new SimpleDateFormat("dd MMM yyyy");
        for (Session session : sessions) {
            Map<String, Object> map = Map.of(
                    headers.get(0), session.getId().toString(),
                    headers.get(1), sDF.format(session.getDate()),
                    headers.get(2), session.getTime().toString().substring(0,session.getTime().toString().length() - 3),
                    headers.get(3), session.getTeacher().toString(1),
                    headers.get(4), session.getClassroom().getClassroom_name(),
                    headers.get(5), session.getCourse().getCourse_title(),
                    headers.get(6), session.getGroup().getGroup_title()
            );
            rows.add(map);
        }
        model.addAttribute("headers",headers);
        model.addAttribute("rows",rows);
        model.addAttribute("complexType",complexType);
        model.addAttribute("instructors", teacherService.getTeachers());
        model.addAttribute("classrooms", classroomService.getClassrooms());
        model.addAttribute("courses", courseService.getCourses());
        model.addAttribute("groups", groupService.getGroups());
        return "index";
    }

    @GetMapping(path = "/departments")
    public String GetDepartements(Model model) {
        model.addAttribute("Title","Departments");
        model.addAttribute("department", new Department());
        List<String> headers = List.of(
                "Department Code",
                "Department Name",
                "Instructors",
                "University"
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
        model.addAttribute("universities",universityService.getUniversities());
        return "index";
    }

    @GetMapping(path = "/instructors")
    public String GetTeachers(Model model) {
        model.addAttribute("Title","Instructors");
        model.addAttribute("instructor", new Teacher());
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
        model.addAttribute("departments", departmentService.getDepartments());
        return "index";
    }

    @GetMapping(path = "/universities")
    public String GetUniversities(Model model) {
        model.addAttribute("Title","Universities");
        model.addAttribute("university", new University());
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

    @PostMapping("/universities")
    public String SubmitUniversity(@ModelAttribute University university) {
        universityService.saveUniversity(university);
        return "redirect:/universities";
    }

    @PostMapping("/departments")
    public String SubmitDepartment(@ModelAttribute Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    @PostMapping("/instructors")
    public String SubmitTeacher(@ModelAttribute Teacher teacher) {
        teacherService.saveTeacher(teacher);
        return "redirect:/instructors";
    }

    @PostMapping("/sessions")
    public String SubmitSession(@ModelAttribute Session session) {
        sessionService.saveSession(session);
        return "redirect:/sessions";
    }

    @PostMapping("/classrooms")
    public String SubmitClassroom(@ModelAttribute Classroom classroom) {
        //classroom.setClassroom_type();
        classroomService.saveClassroom(classroom);
        return "redirect:/classrooms";
    }

    @PostMapping("/courses")
    public String SubmitCourse(@ModelAttribute Course course) {
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @PostMapping("/groups")
    public String SubmitGroup(@ModelAttribute Group group) {
        groupService.saveGroup(group);
        return "redirect:/groups";
    }

    @PostMapping("/students")
    public String SubmitStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/universities/{id}")
    public String DeleteUniversity(@PathVariable String id) {
        universityService.DeleteUniversity(Long.parseLong(id));
        return "redirect:/universities";
    }

    @GetMapping("/departments/{id}")
    public String DeleteDepartment(@PathVariable String id) {
        departmentService.DeleteDepartment(Long.parseLong(id));
        return "redirect:/departments";
    }

    @GetMapping("/instructors/{id}")
    public String DeleteTeacher(@PathVariable String id) {
        teacherService.DeleteTeacher(Long.parseLong(id));
        return "redirect:/instructors";
    }

    @GetMapping("/sessions/{id}")
    public String DeleteSession(@PathVariable String id) {
        sessionService.DeleteSession(Long.parseLong(id));
        return "redirect:/sessions";
    }

    @GetMapping("/classrooms/{id}")
    public String DeleteClassroom(@PathVariable String id) {
        //classroom.setClassroom_type();
        classroomService.DeleteClassroom(Long.parseLong(id));
        return "redirect:/classrooms";
    }

    @GetMapping("/courses/{id}")
    public String DeleteCourse(@PathVariable String id) {
        courseService.DeleteCourse(Long.parseLong(id));
        return "redirect:/courses";
    }

    @GetMapping("/groups/{id}")
    public String DeleteGroup(@PathVariable String id) {
        groupService.DeleteGroup(Long.parseLong(id));
        return "redirect:/groups";
    }

    @GetMapping("/students/{id}")
    public String DeleteStudent(@PathVariable String id) {
        studentService.DeleteStudent(Long.parseLong(id));
        return "redirect:/students";
    }

}


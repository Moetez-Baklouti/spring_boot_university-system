package com.app.Classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {
    private ClassroomRepository classroomRepository;

    @Autowired
    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> getClassrooms() {
        return classroomRepository.findAll();
    }

    public Classroom saveClassroom(Classroom classromm) {
        return classroomRepository.saveAndFlush(classromm);
    }

    public void DeleteClassroom(long parseLong) {
        classroomRepository.deleteById(parseLong);
    }
}

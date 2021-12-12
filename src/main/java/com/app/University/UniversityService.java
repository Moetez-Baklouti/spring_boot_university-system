package com.app.University;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {
    private UniversityRepository universityRepository;

    @Autowired
    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> getUniversities() {
        return universityRepository.findAll();
    }

    public University saveUniversity(University university) {
        return universityRepository.saveAndFlush(university);
    }

    public University findUniversityById(Long id) {
        return universityRepository.findById(id).get();
    }

    public void deleteAll() {
        universityRepository.deleteAll();
    }

    public University getUniversity(Long id) {
        return universityRepository.getById(id);
    }

    public void DeleteUniversity(long parseLong) {
        universityRepository.deleteById(parseLong);
    }
}

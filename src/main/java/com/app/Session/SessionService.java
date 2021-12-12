package com.app.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    private SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getSessions(){
        return sessionRepository.findAll();
    }

    public Session saveSession(Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    public void DeleteSession(long parseLong) {
        sessionRepository.deleteById(parseLong);
    }
}

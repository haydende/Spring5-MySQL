package haydende.spring5mysqldemo.service;

import haydende.spring5mysqldemo.domain.Subject;

import java.util.List;

public interface SubjectService {

    Subject findByName(String name);

    List<Subject> findAll();

    Subject save(Subject subject);

    List<Subject> save(Subject... subjects);

    void delete(Subject... subject);

    void deleteByName(String name);

    void deleteAll();

}

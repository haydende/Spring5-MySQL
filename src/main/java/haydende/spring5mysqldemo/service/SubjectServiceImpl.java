package haydende.spring5mysqldemo.service;

import haydende.spring5mysqldemo.domain.Subject;
import haydende.spring5mysqldemo.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject findByName(String name) {
        Optional<Subject> subject = subjectRepository.findById(name);
        if (subject.isPresent()) {
            return subject.get();
        }
        throw new RuntimeException("No subject with the name of " + name + " has been found!");
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> save(Subject... subjects) {
        List<Subject> savedSubjects = new ArrayList<>();
        for (Subject s: subjects) {
            savedSubjects.add(subjectRepository.save(s));
        }
        return savedSubjects;
    }

    @Override
    public void delete(Subject... subjects) {
        for (Subject s: subjects) {
            subjectRepository.delete(s);
        }
    }

    @Override
    public void deleteByName(String name) {
        subjectRepository.deleteById(name);
    }

    @Override
    public void deleteAll() {
        subjectRepository.deleteAll();
    }
}

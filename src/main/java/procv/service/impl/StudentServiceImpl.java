package procv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procv.model.Student;
import procv.repository.StudentRepository;
import procv.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int idStudent) {
        return studentRepository.findById(idStudent).get();
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(int idStudent) {
        studentRepository.deleteById(idStudent);
    }
}

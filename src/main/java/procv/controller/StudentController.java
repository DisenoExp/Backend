package procv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import procv.model.Student;
import procv.repository.StudentRepository;
import procv.service.StudentService;
import procv.service.impl.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletResponse;
import procv.util.studentexcel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;  


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<?> listAll() {
        try {
            List<Student> students = studentService.findAll();
            return ResponseEntity.ok(students);
        } catch(Exception e) {return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{idStudent}")
    public ResponseEntity<?> listById(@PathVariable int idStudent) {
        try {
            Student student = studentService.findById(idStudent);
            return ResponseEntity.ok(student);
        } catch(Exception e) {return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Student student) {
        try {
        Student studentSave = studentService.create(student);
        return ResponseEntity.ok(studentSave);
        } catch(Exception e) {return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping("/{idStudent}")
    public ResponseEntity<?> update(@PathVariable int idStudent, @RequestBody Student student) {
        try {
            student.setIdStudent(idStudent);
            Student studentSave = studentService.update(student);
            return ResponseEntity.ok(studentSave);
        } catch(Exception e) {return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{idStudent}")
    public ResponseEntity<?> deleteById(@PathVariable int idStudent) {
        try {
        studentService.deleteById(idStudent);
        return ResponseEntity.ok(null);
        } catch(Exception e) {return ResponseEntity.badRequest().body(e);
        }
    }
    
    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=result_student";
        response.setHeader(headerKey, headerValue);
        List<Student> students = studentService.findAll();
        studentexcel excelExporter = new studentexcel(students);
        excelExporter.export(response);
    }
}

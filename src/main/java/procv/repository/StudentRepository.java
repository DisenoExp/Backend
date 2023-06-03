package procv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import procv.model.Student;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}

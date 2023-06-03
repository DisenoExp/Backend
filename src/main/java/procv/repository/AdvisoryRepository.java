package procv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import procv.model.Advisory;

@Repository
public interface AdvisoryRepository extends JpaRepository<Advisory, Integer> {
}

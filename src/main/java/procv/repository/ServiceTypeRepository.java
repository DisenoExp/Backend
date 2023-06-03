package procv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import procv.model.ServiceType;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
}

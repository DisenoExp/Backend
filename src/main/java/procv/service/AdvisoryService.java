package procv.service;

import procv.model.Advisory;

import java.util.List;

public interface AdvisoryService {
    List<Advisory> findAll();
    Advisory findById(int idAdvisory);
    Advisory create(Advisory advisory);
    Advisory update(Advisory advisory);
    void deleteById(int idAdvisory);
}

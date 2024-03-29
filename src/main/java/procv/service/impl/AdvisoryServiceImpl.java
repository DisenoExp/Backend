package procv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procv.model.Advisory;
import procv.repository.AdvisoryRepository;
import procv.service.AdvisoryService;

import java.util.List;

@Service
public class AdvisoryServiceImpl implements AdvisoryService {

    @Autowired
    private AdvisoryRepository advisoryRepository;

    @Override
    public List<Advisory> findAll() {
        return advisoryRepository.findAll();
    }

    @Override
    public Advisory findById(int idAdvisory) {
        return advisoryRepository.findById(idAdvisory).get();
    }

    @Override
    public Advisory create(Advisory advisory) {
        return advisoryRepository.save(advisory);
    }

    @Override
    public Advisory update(Advisory advisory) {
        return advisoryRepository.save(advisory);
    }

    @Override
    public void deleteById(int idAdvisory) {
        advisoryRepository.deleteById(idAdvisory);
    }
}

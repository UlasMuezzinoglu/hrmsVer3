package ulas.hrmsDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ulas.hrmsDemo.entities.concretes.Employer;
import ulas.hrmsDemo.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
        List<JobAdvertisement> findAllByStatusTrue();
        List<JobAdvertisement> findAllByEmployer_IdAndStatusTrue(int employerId);
        List<JobAdvertisement> findAllByStatusTrueOrderByPublishDateAsc();
        List<JobAdvertisement> findAllByStatusTrueOrderByPublishDateDesc();


}

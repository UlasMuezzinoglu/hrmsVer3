package ulas.hrmsDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ulas.hrmsDemo.entities.concretes.Employer;
import ulas.hrmsDemo.entities.concretes.JobAdvertisement;
import ulas.hrmsDemo.entities.dtos.JobAdvertisementDto;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findAllByStatusTrue();

    List<JobAdvertisement> findAllByEmployer_IdAndStatusTrue(int employerId);

    List<JobAdvertisement> findAllByStatusTrueOrderByPublishDateAsc();

    List<JobAdvertisement> findAllByStatusTrueOrderByPublishDateDesc();


    @Query("Select new ulas.hrmsDemo.entities.dtos.JobAdvertisementDto"
            + "(p.id,  j.jobTitle , p.jobOfNumberPosition, p.publishDate, p.endOfJobDate) "
            + "From JobTitle j Inner Join j.jobAdvertisements p")
    List<JobAdvertisementDto> getJobAdvertisementWithEmpDetails();


}

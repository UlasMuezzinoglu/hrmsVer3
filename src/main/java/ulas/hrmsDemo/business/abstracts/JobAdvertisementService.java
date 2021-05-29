package ulas.hrmsDemo.business.abstracts;

import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.core.utilities.results.SuccessDataResult;
import ulas.hrmsDemo.entities.concretes.Candicate;
import ulas.hrmsDemo.entities.concretes.Employer;
import ulas.hrmsDemo.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getAll();

    DataResult<List<JobAdvertisement>> getAllStatusTrue();

    DataResult<List<JobAdvertisement>> findAllByEmployer_IdAndStatusTrue(int employerId);


    Result add(JobAdvertisement jobAdvertisement);

    Result findById(int jobAdvertisementId,boolean status);

    DataResult<List<JobAdvertisement>> findAllByStatusTrueSortedAsc();

    DataResult<List<JobAdvertisement>> findAllByStatusTrueOrderByPublishDateDesc();





}

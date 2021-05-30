package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.JobAdvertisementService;
import ulas.hrmsDemo.core.utilities.results.*;
import ulas.hrmsDemo.dataAccess.abstracts.JobAdvertisementDao;
import ulas.hrmsDemo.entities.concretes.JobAdvertisement;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao){
        this.jobAdvertisementDao = jobAdvertisementDao;
    }





    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.findAll(), "Veriler Getirildi - Job Advertisement");

    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllStatusTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByStatusTrue());
    }

    @Override
    public DataResult<List<JobAdvertisement>> findAllByEmployer_IdAndStatusTrue(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByEmployer_IdAndStatusTrue(employerId));
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        try {
            this.jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("İş İlanı Başarı ile Kayıt Edildi");
        }catch (Exception e){
            return new ErrorResult("Hata ile Karşılaşıldı. İş ilanı Eklenemedi.");
        }
        //return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(jobAdvertisement));
    }

    @Override
    public Result findById(int jobAdvertisementId,boolean status) {
        try{
            JobAdvertisement jobAdvertisement;
            jobAdvertisement = this.jobAdvertisementDao.findById(jobAdvertisementId).get();

            jobAdvertisement.setStatus(status);

            this.jobAdvertisementDao.save(jobAdvertisement);

            return new SuccessResult("İşlem Başarılı");



        }catch (Exception e){
            return new ErrorResult("İşlem Başarısız");
        }
    }

    @Override
    public DataResult<List<JobAdvertisement>> findAllByStatusTrueSortedAsc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByStatusTrueOrderByPublishDateAsc(),"Verilerden Aktif Olanlar Tarihe Göre Listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>>  findAllByStatusTrueOrderByPublishDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAllByStatusTrueOrderByPublishDateDesc(),"Verilerden Aktif Olanlar Tarihe Göre Listelendi");

    }


}

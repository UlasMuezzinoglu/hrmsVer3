package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.EmailService;
import ulas.hrmsDemo.business.abstracts.EmployerService;
import ulas.hrmsDemo.business.concretes.checkHelper.EmployeeCheckHelper;
import ulas.hrmsDemo.business.concretes.checkHelper.EmployerCheckHelper;
import ulas.hrmsDemo.core.utilities.results.*;
import ulas.hrmsDemo.dataAccess.abstracts.EmployerDao;
import ulas.hrmsDemo.entities.concretes.Employer;
import ulas.hrmsDemo.entities.concretes.User;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private EmailService emailService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailService emailService){
        this.employerDao = employerDao;
        this.emailService = emailService;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll(),"Veriler Getirildi - Employer");
    }

    @Override
    public Result register(Employer employer) {

        boolean checkFields = !EmployerCheckHelper.allFieldReq(employer);
        boolean isConfirm = !EmployeeCheckHelper.isConfirmed(employer);

        if (checkFields || isConfirm){
            return new ErrorResult("Hata - Employer eklenemedi");
        }
        this.employerDao.save(employer);
        return new SuccessResult(this.emailService.sendEmail(employer).getMessage());
    }


}

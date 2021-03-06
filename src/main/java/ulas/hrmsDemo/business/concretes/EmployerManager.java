package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.EmailService;
import ulas.hrmsDemo.business.abstracts.EmployerService;
import ulas.hrmsDemo.business.abstracts.VerifyCodeService;
import ulas.hrmsDemo.business.checkHelper.concretes.EmployeeCheckHelper;
import ulas.hrmsDemo.business.checkHelper.concretes.EmployerCheckHelper;
import ulas.hrmsDemo.core.utilities.results.*;
import ulas.hrmsDemo.dataAccess.abstracts.EmployerDao;
import ulas.hrmsDemo.dataAccess.abstracts.UserDao;
import ulas.hrmsDemo.entities.concretes.Employer;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private EmailService emailService;
    private VerifyCodeService verifyCodeService;
    private UserDao userDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailService emailService, VerifyCodeService verifyCodeService, UserDao userDao) {
        this.employerDao = employerDao;
        this.emailService = emailService;
        this.verifyCodeService = verifyCodeService;
        this.userDao = userDao;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll(), "Veriler Getirildi - Employer");
    }

    @Override
    public Result register(Employer employer) {

        boolean checkFields = !EmployerCheckHelper.allFieldReq(employer);
        boolean isConfirm = !EmployeeCheckHelper.isConfirmed(employer);

        if (checkFields || isConfirm) {
            return new ErrorResult("Hata - Employer eklenemedi");
        }
        this.employerDao.save(employer);
        this.verifyCodeService.createVerifyCode(userDao.getOne(employer.getId()));
        this.emailService.sendEmail(employer);
        return new SuccessResult(this.emailService.sendEmail(employer).getMessage());
    }


}

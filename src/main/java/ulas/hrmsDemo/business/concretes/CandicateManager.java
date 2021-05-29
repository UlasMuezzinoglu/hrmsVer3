package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.CandicateService;
import ulas.hrmsDemo.business.abstracts.EmailService;
import ulas.hrmsDemo.business.concretes.checkHelper.CandicateCheckHelper;
import ulas.hrmsDemo.core.utilities.results.*;
import ulas.hrmsDemo.core.utilities.results.adapters.UserCheckService;
import ulas.hrmsDemo.dataAccess.abstracts.CandicateDao;
import ulas.hrmsDemo.entities.concretes.Candicate;

import java.time.LocalDate;
import java.util.List;

@Service
public class CandicateManager implements CandicateService {

    private CandicateDao candicateDao;
    private EmailService emailService;
    private UserCheckService userCheckService;

    @Autowired
    public CandicateManager(CandicateDao candicateDao, EmailService emailService, UserCheckService userCheckService){

        this.candicateDao = candicateDao;
        this.emailService = emailService;
        this.userCheckService = userCheckService;
    }


    @Override
    public DataResult<List<Candicate>> getAll() {
        return new SuccessDataResult<>(this.candicateDao.findAll(),"Veriler Getirildi - Candidate");
    }


    @Override
    public DataResult<Boolean> isPersonReal(String nationalityId, String firstName, String lastName, int birtOfYear) {
        return new DataResult<>(this.userCheckService.isPersonReal(nationalityId,firstName,lastName,birtOfYear),true);
    }

    @Override
    public Result register(Candicate candicate) {

        /*boolean isChecked = !this.isPersonReal(candicate.getIdentityNumber(),candicate.getFirstName(),candicate.getLastName(),candicate.getBirthYear()).getData();
        boolean checkFields = !CandicateCheckHelper.allFieldsAreReq(candicate);

        if (isChecked || checkFields){
            return new ErrorResult("Hata !");
        }*/

        try
        {
            this.candicateDao.save(candicate);
            return new SuccessResult(this.emailService.sendEmail(candicate).getMessage());
        }catch (Exception e){
            return new ErrorResult(e.getMessage()+"Hata aldıkkk");
        }

    }


}

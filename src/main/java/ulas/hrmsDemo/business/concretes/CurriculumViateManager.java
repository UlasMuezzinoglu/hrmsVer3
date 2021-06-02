package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.CurriculumViateService;
import ulas.hrmsDemo.core.utilities.helpers.CurriculumVitaeHelper;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.core.utilities.results.SuccessDataResult;
import ulas.hrmsDemo.core.utilities.results.SuccessResult;
import ulas.hrmsDemo.dataAccess.abstracts.*;
import ulas.hrmsDemo.entities.concretes.CurriculumViate;

import java.util.List;

@Service
public class CurriculumViateManager implements CurriculumViateService {

    private CurriculumVitaeDao curriculumVitaeDao;
    /*private LanguageDao languageDao;
    private TalentDao talentDao;
    private EduHistoryDao eduHistoryDao;
    private JobExperienceDao jobExperienceDao;*/



    @Autowired
    public CurriculumViateManager(CurriculumVitaeDao curriculumVitaeDao) {
        this.curriculumVitaeDao = curriculumVitaeDao;
    }


    @Override
    public DataResult<List<CurriculumViate>> getAll() {

        return new SuccessDataResult<List<CurriculumViate>>
                (this.curriculumVitaeDao.findAll(),"Veriler Getirildi - CV");
    }

    @Override
    public Result add(CurriculumViate curriculumViate) {

        this.curriculumVitaeDao.save(curriculumViate);
        return new SuccessResult("Başarılıııı");

        /*CurriculumViate resea = curriculumVitaeDao.save(curriculumViate);
        CurriculumVitaeHelper helper = new CurriculumVitaeHelper(eduHistoryDao,talentDao,languageDao,jobExperienceDao);
        helper.setAllCurriculumVitaeId();
                (resea.getEducation(), resea.getLanguages(),
                        resea.getTechnologies(), resea.getJobExperiences(), resea);
        return new SuccessResult("Kayıt Başarılı");*/
    }
}

package ulas.hrmsDemo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import ulas.hrmsDemo.entities.concretes.CurriculumViate;

import java.util.List;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumViate,Integer> {

}

package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ulas.hrmsDemo.business.abstracts.EmployerService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.core.utilities.results.SuccessResult;
import ulas.hrmsDemo.entities.concretes.Employee;
import ulas.hrmsDemo.entities.concretes.Employer;

import java.util.List;

@RestController
@RequestMapping("/api/Employer/")
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){

        return this.employerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer){
        //this.employerService.register(employer);
        //return new SuccessResult(employer.getEmail());
        return this.employerService.register(employer);

    }
}

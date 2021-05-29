package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ulas.hrmsDemo.business.abstracts.CandicateService;
import ulas.hrmsDemo.business.abstracts.JobTitleService;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.Candicate;
import ulas.hrmsDemo.entities.concretes.JobTitle;

import java.util.List;

@RestController
@RequestMapping("/api/Candicates/")

public class CandicatesController {

    private CandicateService candicateService;

    @Autowired
    public CandicatesController(CandicateService candicateService) {
        super();
        this.candicateService = candicateService;
    }

    @GetMapping("/getall")
    public DataResult<List<Candicate>> getAll() {

        return this.candicateService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Candicate candicate){
        return this.candicateService.register(candicate);
    }


}


package com.fred.springboot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers(){
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @PostMapping
    public void addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer){
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(@PathVariable Integer id){
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PatchMapping("{id}")
    public SoftwareEngineer updateSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer,  @PathVariable Integer id){
        return softwareEngineerService.updateSoftwareEngineer(id, softwareEngineer);
    }

    @DeleteMapping("{id}")
    public String deleteSoftwareEngineer(@PathVariable Integer id){
        return  softwareEngineerService.deleteSoftwareEngineer(id);
    }
}

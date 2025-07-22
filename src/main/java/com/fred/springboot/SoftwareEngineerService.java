package com.fred.springboot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id +" not found"));
    }

    public SoftwareEngineer updateSoftwareEngineer(Integer id, SoftwareEngineer newData) {
        SoftwareEngineer existing = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SoftwareEngineer with ID " + id + " not found"));

        existing.setName(newData.getName());
        existing.setTechStack(newData.getTechStack());

        return softwareEngineerRepository.save(existing);
    }


    public String deleteSoftwareEngineer(Integer id) {
        boolean exists = softwareEngineerRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("softwareEngineer not found");
        }
        softwareEngineerRepository.deleteById(id);
        return "success";
    }
}

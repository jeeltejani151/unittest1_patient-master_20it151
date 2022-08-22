package com.example.demo.controller;

import com.example.demo.model.PatientRecord;
import com.example.demo.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PatientRecordController {
    @Autowired
    PatientRecordRepository patientRecordRepository;

    @GetMapping("/listpatientRecord")
    public List<PatientRecord> getAllPatientRecord() {return patientRecordRepository.findAll();}

    // Get the student information
    @GetMapping("/patient/{id}")
    public PatientRecord getAllPatientRecord(@PathVariable Integer id) {return patientRecordRepository.findById(id).get();}

    // Delete the student
    @DeleteMapping("/patient/{id}")
    public List<PatientRecord> deletePatientRecord(@PathVariable Integer id) {
        patientRecordRepository.delete(patientRecordRepository.findById(id).get());
        return patientRecordRepository.findAll();
    }

    // Add new student
    @PostMapping("/patient")
    public List<PatientRecord> addPatientRecord(@RequestBody PatientRecord patientRecord) {
        patientRecordRepository.save(patientRecord);
        return patientRecordRepository.findAll();
    }

    // Update the student information
    @PutMapping("/patient/{id}")
    public List<PatientRecord> updatePatientRecord(@RequestBody PatientRecord patientRecord, @PathVariable Integer id) {
        PatientRecord patientRecordObj = patientRecordRepository.findById(id).get();
        patientRecordObj.setName(patientRecord.getName());
        patientRecordObj.setAddress(patientRecord.getAddress());
        patientRecordRepository.save(patientRecordObj);
        return patientRecordRepository.findAll();
    }

}

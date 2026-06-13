package com.shravya.network_security_assessment.service;

import com.shravya.network_security_assessment.entity.ScanResult;
import com.shravya.network_security_assessment.repository.ScanResultRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ScanResultService {

    private final ScanResultRepository repository;

    public ScanResultService(ScanResultRepository repository) {
        this.repository = repository;
    }

    public ScanResult save(ScanResult scanResult) {
        return repository.save(scanResult);
    }

    public List<ScanResult> getAllScans() {
        return repository.findAll();
    }
}
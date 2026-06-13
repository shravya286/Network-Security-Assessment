package com.shravya.network_security_assessment.repository;

import com.shravya.network_security_assessment.entity.ScanResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScanResultRepository extends JpaRepository<ScanResult, Long> {

}

package com.shravya.network_security_assessment.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scan_results")
public class ScanResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String target;

    private String scanType;

    private String openPorts;

    private String riskLevel;

    private LocalDateTime scanTime;
    public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public String getTarget() { return target; }
public void setTarget(String target) { this.target = target; }

public String getScanType() { return scanType; }
public void setScanType(String scanType) { this.scanType = scanType; }

public String getOpenPorts() { return openPorts; }
public void setOpenPorts(String openPorts) { this.openPorts = openPorts; }

public String getRiskLevel() { return riskLevel; }
public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }

public LocalDateTime getScanTime() { return scanTime; }
public void setScanTime(LocalDateTime scanTime) { this.scanTime = scanTime; }
}

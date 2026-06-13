package com.shravya.network_security_assessment.controller;

import com.shravya.network_security_assessment.entity.ScanResult;
import com.shravya.network_security_assessment.service.ScanResultService;
import org.springframework.web.bind.annotation.*;
import com.shravya.network_security_assessment.service.NmapService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/scans")
public class ScanResultController {

    private final ScanResultService service;
    private final NmapService nmapService;

    public ScanResultController(
        ScanResultService service,
        NmapService nmapService) {

    this.service = service;
    this.nmapService = nmapService;
}

    @PostMapping
    public ScanResult saveScan(@RequestBody ScanResult scanResult) {
        scanResult.setScanTime(LocalDateTime.now());
        return service.save(scanResult);
    }
@GetMapping("/test")
public String testScan() {

    return nmapService.runScan("localhost");
}
    @GetMapping
    public List<ScanResult> getAllScans() {
        return service.getAllScans();
    }
    @GetMapping("/ports")
public String getPorts() {

    String output =
            nmapService.runScan("localhost");

    return nmapService.extractOpenPorts(output);
}
@PostMapping("/run")
public ScanResult runScan(
        @RequestParam String target) {

    String output =
            nmapService.runScan(target);

    String ports =
            nmapService.extractOpenPorts(output);

    String risk =
            nmapService.calculateRisk(ports);

    ScanResult result =
            new ScanResult();

    result.setTarget(target);
    result.setScanType("NMAP");
    result.setOpenPorts(ports);
    result.setRiskLevel(risk);
    result.setScanTime(LocalDateTime.now());

    return service.save(result);
}
}

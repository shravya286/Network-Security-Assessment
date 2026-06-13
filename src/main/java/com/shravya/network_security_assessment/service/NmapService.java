package com.shravya.network_security_assessment.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class NmapService {

    public String runScan(String target) {

        StringBuilder output = new StringBuilder();

        try {

            ProcessBuilder processBuilder =
                    new ProcessBuilder("nmap", target);

            Process process = processBuilder.start();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    process.getInputStream()));

            String line;

            while((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            process.waitFor();

        }
        catch(Exception e) {
            return "ERROR: " + e.getMessage();
        }

        return output.toString();
    }

    public String extractOpenPorts(String nmapOutput) {

        StringBuilder ports = new StringBuilder();

        String[] lines = nmapOutput.split("\n");

        for(String line : lines) {

            if(line.contains("/tcp") && line.contains("open")) {

                String port =
                        line.split("/")[0].trim();

                ports.append(port).append(",");
            }
        }

        if(ports.length() > 0) {
            ports.deleteCharAt(ports.length() - 1);
        }

        return ports.toString();
    }

  public String calculateRisk(String ports) {

    if(ports.contains("21")
            || ports.contains("23")
            || ports.contains("3389")) {

        return "HIGH";
    }

    if(ports.contains("445")
            || ports.contains("5432")
            || ports.contains("22")) {

        return "MEDIUM";
    }

    return "LOW";
}
}
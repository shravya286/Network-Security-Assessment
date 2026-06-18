# Network-Security-Assessment

**🎥 Demo Video & Documentation:**
https://drive.google.com/file/d/1yfDP9ggczQLdnce_2z4xowPD-De3RHG_/view?usp=drive_link

## Overview

A cybersecurity-focused web application that performs network reconnaissance using Nmap, identifies open ports, evaluates security risks, stores assessment records in PostgreSQL and displays results through an interactive dashboard.
## Running the Project

See RUN_LOCALLY.md for complete setup and execution instructions.

## Features

* Network scanning using Nmap
* Open port detection
* Risk classification (Low, Medium, High)
* Security recommendations
* Historical scan storage
* PostgreSQL integration
* Interactive dashboard

## Tech Stack

* Java
* Spring Boot
* PostgreSQL
* pgAdmin
* Nmap
* HTML
* Bootstrap
* JavaScript

## Project Workflow

1. User enters target IP/hostname.
2. Nmap performs network scan.
3. Open ports are extracted.
4. Risk level is calculated.
5. Results are stored in PostgreSQL.
6. Dashboard displays assessment results.

## Installation

### Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/Network-Security-Assessment.git
```

### Configure Database

Update `application.properties` with PostgreSQL credentials.

### Run Application

```bash
mvn spring-boot:run
```

### Access Dashboard

```text
http://localhost:8080
```

## Example Result

**Target:** localhost

**Open Ports:** 135,445,5432,8080

**Risk Level:** MEDIUM

## Future Enhancements

* CVE Integration
* PDF Report Generation
* User Authentication
* Multi-Host Scanning
* Real-Time Alerts

## Author

**Shravya Ganesh Hegde**

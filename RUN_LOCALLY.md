# How to Run the Project Locally

## Prerequisites

Before running the project, ensure the following software is installed:

### Required Software

* Java JDK 21 or later
* Maven
* PostgreSQL
* pgAdmin (Optional)
* Nmap
* Git
* Visual Studio Code or IntelliJ IDEA

---

## Step 1: Clone the Repository

Open Command Prompt or Terminal and run:

```bash
git clone https://github.com/YOUR_USERNAME/Network-Security-Assessment.git
```

Navigate to the project directory:

```bash
cd Network-Security-Assessment
```

---

## Step 2: Configure PostgreSQL

Create a PostgreSQL database.

Example:

```sql
CREATE DATABASE network_security_assessment;
```

Update the database configuration in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/network_security_assessment
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Step 3: Verify Nmap Installation

Open Command Prompt and run:

```bash
nmap --version
```

Expected Output:

```text
Nmap version 7.x
```

If Nmap is not installed, download and install it before proceeding.

---

## Step 4: Build the Project

Open a terminal inside the project folder and run:

```bash
mvn clean install
```

This downloads required dependencies and builds the project.

---

## Step 5: Run the Application

Run:

```bash
mvn spring-boot:run
```

OR

```bash
java -jar target/network-security-assessment-0.0.1-SNAPSHOT.jar
```

Expected Output:

```text
Tomcat started on port(s): 8080
Started NetworkSecurityAssessmentApplication
```

---

## Step 6: Access the Dashboard

Open a browser and navigate to:

```text
http://localhost:8080
```

The Network Security Assessment Dashboard should appear.

---

## Step 7: Execute a Security Scan

Enter a target such as:

```text
localhost
```

or

```text
scanme.nmap.org
```

Click:

```text
Run Security Scan
```

The application will:

1. Execute an Nmap scan.
2. Extract open ports.
3. Calculate risk level.
4. Generate recommendations.
5. Store results in PostgreSQL.
6. Display findings on the dashboard.

---

## Troubleshooting

### Nmap Not Found

Error:

```text
Cannot run program "nmap"
```

Solution:

Ensure Nmap is installed and available in the system PATH.

Verify:

```bash
nmap --version
```

---

### Database Connection Error

Verify PostgreSQL is running:

```bash
pg_ctl status
```

Check credentials inside:

```text
application.properties
```

---

### Port 8080 Already In Use

Change the port in:

```properties
server.port=8081
```

Then access:

```text
http://localhost:8081
```

---

## Sample Test Target

For demonstration purposes:

```text
localhost
```

Expected Example Result:

Open Ports:

135,445,5432,8080

Risk Level:

MEDIUM

Recommendation:

Review SMB Exposure and Restrict PostgreSQL Access.

---

## Project Workflow

User Input
↓
Nmap Scan
↓
Open Port Discovery
↓
Risk Assessment
↓
Recommendation Generation
↓
PostgreSQL Storage
↓
Dashboard Visualization

---

Developed by:

Shravya Ganesh Hegde

Network Security Assessment

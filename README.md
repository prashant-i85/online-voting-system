# Online Voting System

This program helps its verified users to cast votes for candidates in an election. It will be accessible for everyone and more secure than physical voting.

## Features
- **Voter Authentication**: Secure user verification through unique voter ID codes.
- **Results Tracking**: Transparent and immediate reporting of election results, with detailed analytics and visualization.
- **Database Integration**: Secure and reliable data storage, leveraging MySQL to maintain voter records and election results.

## Main Components
- **User Registration/Login**: Secure registration and login functionality to ensure each voter can only vote once.
- **Voting Page**: Displays a list of candidates/options and allows users to select their choice.
- **Vote Submission**: Allows users to submit their vote, which is securely recorded in the backend.
- **Results Page**: Displays current results in real-time or after voting is complete.
- **Additional User Roles**: Different access levels for admins and users.
- **Improved UI/UX**: Advanced styling and animations for a better user experience.
- **Future Improvements**: Use of HTML or CSS enhancements.

# Project Structure for Online Voting System

This document describes the directory structure and purpose of each file in the **Online Voting System** project. It can be added to the `README.md` file for a comprehensive understanding of the project.

---

## Directory Structure
```plaintext
OnlineVotingSystem/
├── java/
│   ├── dao/
│   │   ├── VoterDAO.java
│   │   ├── ElectionDAO.java
│   │   ├── CandidateDAO.java
│   │   └── VoteDAO.java
│   ├── model/
│   │   ├── Voter.java
│   │   ├── Election.java
│   │   ├── Candidate.java
│   │   └── Vote.java
│   ├── servlets/
│   │   ├── LoginServlet.java
│   │   ├── RegisterServlet.java
│   │   ├── VoteServlet.java
│   │   ├── AdminDashboardServlet.java
│   │   └── ResultServlet.java
│   └── connect/
│       └── DBConnection.java
├── webapp/
│   ├── WEB-INF/
│   │   ├── index.html
│   │   ├── login.jsp
│   │   ├── register.jsp
│   │   ├── results.jsp
│   │   ├── voting.jsp
│   │   └── web.xml
│   ├── css/
│   │   └── style.css
│   ├── js/
│       └── validation.js
├── schema.sql
├── ProjectStructure.txt
├── README.md
└── pom.xml
```

---

## Description of Files and Directories

### **1. `java/`**
This directory contains all the Java source files for the project, organized into subdirectories:

- **`dao/`**: Data Access Objects for handling database operations.
  - `VoterDAO.java`: Handles CRUD operations for the `voters` table.
  - `ElectionDAO.java`: Manages elections in the `elections` table.
  - `CandidateDAO.java`: Handles candidates and their relationships to elections.
  - `VoteDAO.java`: Manages voting operations and ensures one vote per voter per election.

- **`model/`**: Plain Old Java Objects (POJOs) representing database entities.
  - `Voter.java`: Represents a voter entity.
  - `Election.java`: Represents an election entity.
  - `Candidate.java`: Represents a candidate entity.
  - `Vote.java`: Represents a vote entity.

- **`servlets/`**: Java servlets for handling HTTP requests and responses.
  - `LoginServlet.java`: Processes user login requests.
  - `RegisterServlet.java`: Processes user registration.
  - `VoteServlet.java`: Handles the voting process.
  - `AdminDashboardServlet.java`: Manages admin operations (e.g., creating elections).
  - `ResultServlet.java`: Fetches and displays election results.

- **`connect/`**: Contains the database connection class.
  - `DBConnection.java`: Provides a reusable method for establishing database connections.

### **2. `webapp/`**
This directory contains web-related files, including JSPs, CSS, JavaScript, and configuration files.

- **`WEB-INF/`**: Protected directory for JSPs and deployment descriptor.
  - `index.html`: The landing page for the application.
  - `login.jsp`: Page for user login.
  - `register.jsp`: Page for user registration.
  - `results.jsp`: Displays election results.
  - `voting.jsp`: Allows users to cast their votes.
  - `web.xml`: Deployment descriptor for servlet mappings.

- **`css/`**: Stylesheets for the application.
  - `style.css`: Provides styling for the web pages.

- **`js/`**: JavaScript files for client-side functionality.
  - `validation.js`: Validates form inputs (e.g., login and registration forms).

### **3. `schema.sql`**
Contains SQL scripts to create the database schema, including tables for `voters`, `elections`, `candidates`, and `votes`.

### **4. `ProjectStructure.txt`**
Describes the directory structure and purpose of files (this document).

### **5. `README.md`**
Provides an overview of the project, its features, and setup instructions.

### **6. `pom.xml`**
Maven configuration file for managing dependencies and build settings.

---

## Usage
- The `java/` directory contains all backend logic for interacting with the database and handling HTTP requests.
- The `webapp/` directory contains the frontend files for user interaction and servlet mappings.
- The `schema.sql` file must be executed first to set up the database before running the application.
- Use `pom.xml` to install dependencies via Maven.

This structure ensures a clean separation of concerns and modularity for easy development and maintenance.




## Setup Instructions
1. Clone the repository from GitHub.
2. Set up your MySQL database using the `schema.sql` file.
3. Update the `DBConnection.java` file with your database credentials.
4. Deploy the project to a server or local environment.
5. Access the application through your browser.

## Usage
1. Register as a user.
2. Log in with your credentials.
3. Vote for your preferred candidate.
4. View the real-time voting results.

## Contribution Guidelines
Feel free to submit pull requests or raise issues for any bugs or improvements.

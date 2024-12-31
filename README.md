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

## Project Structure
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

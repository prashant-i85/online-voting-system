package com.voting.dao;

import com.voting.model.Candidate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {
    // Method to get the list of candidates
    public List<Candidate> getCandidates() throws SQLException {
        List<Candidate> candidates = new ArrayList<>();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting_system", "root", "password");
        String query = "SELECT * FROM candidates";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            candidates.add(new Candidate(rs.getInt("id"), rs.getString("name"), rs.getString("party")));
        }

        rs.close();
        stmt.close();
        conn.close();
        return candidates;
    }

    // Method to cast a vote
    public boolean castVote(int candidateId) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voting_system", "root", "password");
        String query = "INSERT INTO votes (candidate_id) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, candidateId);

        int rowsAffected = stmt.executeUpdate();
        stmt.close();
        conn.close();
        return rowsAffected > 0;
    }
}

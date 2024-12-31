package dao;

import model.Candidate;
import connect.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {
    public boolean addCandidate(Candidate candidate) {
        String sql = "INSERT INTO candidates (name, party, election_id) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, candidate.getName());
            pst.setString(2, candidate.getParty());
            pst.setInt(3, candidate.getElectionId());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Candidate> getCandidatesByElection(int electionId) {
        List<Candidate> candidates = new ArrayList<>();
        String sql = "SELECT * FROM candidates WHERE election_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, electionId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                candidates.add(new Candidate(rs.getInt("candidate_id"), rs.getString("name"), rs.getString("party"), rs.getInt("election_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidates;
    }
}

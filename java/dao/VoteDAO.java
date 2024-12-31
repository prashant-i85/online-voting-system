package dao;

import model.Vote;
import connect.DBConnection;

import java.sql.*;

public class VoteDAO {
    public boolean castVote(Vote vote) {
        String sql = "INSERT INTO votes (voter_id, candidate_id, election_id) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, vote.getVoterId());
            pst.setInt(2, vote.getCandidateId());
            pst.setInt(3, vote.getElectionId());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getTotalVotes(int candidateId) {
        String sql = "SELECT COUNT(*) AS total FROM votes WHERE candidate_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, candidateId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

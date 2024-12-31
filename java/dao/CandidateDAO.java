package dao;

import model.Candidate;
import connect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {
    public List<Candidate> getCandidates() throws SQLException {
        List<Candidate> candidates = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
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

    public boolean castVote(int candidateId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String query = "INSERT INTO votes (candidate_id) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, candidateId);

        int rowsAffected = stmt.executeUpdate();
        stmt.close();
        conn.close();
        return rowsAffected > 0;
    }
}

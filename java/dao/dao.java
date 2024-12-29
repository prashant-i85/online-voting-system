package com.voting.dao;

import com.voting.model.Voter;
import com.voting.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VoterDAO {
    public boolean registerVoter(Voter voter) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO voters (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, voter.getName());
            stmt.setString(2, voter.getEmail());
            stmt.setString(3, voter.getPassword());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Voter login(String email, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM voters WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Voter voter = new Voter();
                voter.setVoterId(rs.getInt("voter_id"));
                voter.setName(rs.getString("name"));
                voter.setEmail(rs.getString("email"));
                return voter;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

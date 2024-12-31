package dao;

import model.Voter;
import connect.DBConnection;

import java.sql.*;

public class VoterDAO {
    public boolean registerVoter(Voter voter) {
        String sql = "INSERT INTO voters (name, email, password) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, voter.getName());
            pst.setString(2, voter.getEmail());
            pst.setString(3, voter.getPassword());
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Voter authenticateVoter(String email, String password) {
        String sql = "SELECT * FROM voters WHERE email = ? AND password = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Voter(rs.getInt("voter_id"), rs.getString("name"), rs.getString("email"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

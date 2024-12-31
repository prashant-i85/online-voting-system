package dao;

import model.Election;
import connect.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ElectionDAO {
    public boolean createElection(Election election) {
        String sql = "INSERT INTO elections (title, description, start_date, end_date) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, election.getTitle());
            pst.setString(2, election.getDescription());
            pst.setDate(3, Date.valueOf(election.getStartDate()));
            pst.setDate(4, Date.valueOf(election.getEndDate()));
            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Election> getAllElections() {
        List<Election> elections = new ArrayList<>();
        String sql = "SELECT * FROM elections";
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                elections.add(new Election(rs.getInt("election_id"), rs.getString("title"), rs.getString("description"), rs.getDate("start_date").toString(), rs.getDate("end_date").toString()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return elections;
    }
}

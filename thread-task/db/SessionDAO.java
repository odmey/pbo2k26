package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SessionDAO {

    // Query 1: INSERT
    public void insert(String sessionName, int minutes) throws SQLException {
        String sql = "INSERT INTO sessions(session_name, minutes) VALUES (?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sessionName);
            ps.setInt(2, minutes);
            ps.executeUpdate();
        }
    }

    // Query 2: SELECT
    public ArrayList<String> getAll() throws SQLException {
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT * FROM sessions ORDER BY id DESC LIMIT 10";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(rs.getString("session_name") + " | "
                        + rs.getInt("minutes") + " menit | "
                        + rs.getString("finished_at"));
            }
        }
        return list;
    }
}

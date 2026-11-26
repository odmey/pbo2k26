package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SessionDAO {

    // C - Create: INSERT
    public void insert(String sessionName, int minutes) throws SQLException {
        String sql = "INSERT INTO sessions(session_name, minutes) VALUES (?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sessionName);
            ps.setInt(2, minutes);
            ps.executeUpdate();
        }
    }

    // R - Read: SELECT (PreparedStatement + ResultSet)
    public List<Session> getRecent(int limit) throws SQLException {
        List<Session> list = new ArrayList<>();
        String sql = "SELECT id, session_name, minutes, finished_at "
                   + "FROM sessions ORDER BY id DESC LIMIT ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, limit);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Session(
                            rs.getInt("id"),
                            rs.getString("session_name"),
                            rs.getInt("minutes"),
                            rs.getString("finished_at")));
                }
            }
        }
        return list;
    }

    // U - Update
    public void update(int id, String sessionName, int minutes) throws SQLException {
        String sql = "UPDATE sessions SET session_name = ?, minutes = ? WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sessionName);
            ps.setInt(2, minutes);
            ps.setInt(3, id);
            ps.executeUpdate();
        }
    }

    // D - Delete (satu baris)
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM sessions WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // D - Delete banyak baris dengan TRANSACTION:
    // semua terhapus, atau tidak sama sekali (rollback kalau ada yang gagal)
    public void deleteMany(List<Integer> ids) throws SQLException {
        String sql = "DELETE FROM sessions WHERE id = ?";

        try (Connection conn = DBUtil.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                for (int id : ids) {
                    ps.setInt(1, id);
                    ps.executeUpdate();
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }
}

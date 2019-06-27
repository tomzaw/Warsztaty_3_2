package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pl.coderslab.model.Client;
import util.DbUtil;

/**
 *
 * @author Tomek
 */
public class ClientDAO {

    public void create(Client client) {

        try (Connection con = DbUtil.getCon()) {

            if (client.getId() == 0) {

                String sql = "INSERT INTO client(name, surname, address, phone) VALUES(?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, client.getName());
                stmt.setString(2, client.getSurname());
                stmt.setString(3, client.getAddress());
                stmt.setInt(4, client.getPhone());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {

                    client.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(Client client) {

        try (Connection con = DbUtil.getCon()) {

            if (client.getId() == 0) {

                String sql = "INSERT INTO client(name, surname, address, phone) VALUES(?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, client.getName());
                stmt.setString(2, client.getSurname());
                stmt.setString(3, client.getAddress());
                stmt.setInt(4, client.getPhone());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {

                    client.setId(rs.getInt(1));
                }

            } else {

                String sql = "UPDATE client SET name=?, surname=?, address=?, phone=? WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, client.getName());
                stmt.setString(2, client.getSurname());
                stmt.setString(3, client.getAddress());
                stmt.setInt(4, client.getPhone());
                stmt.setInt(5, client.getId());
                stmt.executeUpdate();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void delete(Client client) {

        try (Connection con = DbUtil.getCon()) {

            if (client.getId() != 0) {

                String sql = "DELETE FROM client WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, client.getId());
                stmt.executeUpdate();
                client.setId(0);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public List<Client> findAll() {

        List<Client> clients = new ArrayList<>();

        try (Connection con = DbUtil.getCon()) {

            String sql = "SELECT * FROM client";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setSurname(rs.getString("surname"));
                client.setAddress(rs.getString("address"));
                client.setPhone(rs.getInt("phone"));
                clients.add(client);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return clients;
    }

    public Client findById(int id) {

        try (Connection con = DbUtil.getCon()) {

            String sql = "SELECT * FROM client WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setSurname(rs.getString("surname"));
                client.setAddress(rs.getString("address"));
                client.setPhone(rs.getInt("phone"));
                return client;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }
}

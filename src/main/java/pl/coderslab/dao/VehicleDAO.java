package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import pl.coderslab.model.Vehicle;
import util.DbUtil;

/**
 *
 * @author Tomek
 */
public class VehicleDAO {

    public void create(Vehicle vehicle) {

        try (Connection con = DbUtil.getCon()) {

            if (vehicle.getId() == 0) {

                String sql = "INSERT INTO vehicle(model, producent, production_date, registration, next_review_date, client_id) VALUES(?, ?, ?, ?, ? ,?)";
                PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, vehicle.getModel());
                stmt.setString(2, vehicle.getProducent());
                stmt.setString(3, vehicle.getProductionDate().toString());
                stmt.setString(4, vehicle.getRegistration());
                stmt.setString(5, vehicle.getNextReviewDate().toString());
                stmt.setInt(6, vehicle.getClientId());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {

                    vehicle.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(Vehicle vehicle) {

        try (Connection con = DbUtil.getCon()) {

            if (vehicle.getId() == 0) {

                String sql = "INSERT INTO vehicle(model, producent, production_date, registration, next_review_date, client_id) VALUES(?, ?, ?, ?, ? ,?)";
                PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, vehicle.getModel());
                stmt.setString(2, vehicle.getProducent());
                stmt.setString(3, vehicle.getProductionDate().toString());
                stmt.setString(4, vehicle.getRegistration());
                stmt.setString(5, vehicle.getNextReviewDate().toString());
                stmt.setInt(6, vehicle.getClientId());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {

                    vehicle.setId(rs.getInt(1));
                }

            } else {

                String sql = "UPDATE vehicle SET model=?, producent=?, production_date=?, registration=?, next_review_date=?, client_id=? WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, vehicle.getModel());
                stmt.setString(2, vehicle.getProducent());
                stmt.setString(3, vehicle.getProductionDate().toString());
                stmt.setString(4, vehicle.getRegistration());
                stmt.setString(5, vehicle.getNextReviewDate().toString());
                stmt.setInt(6, vehicle.getClientId());
                stmt.setInt(7, vehicle.getId());
                stmt.executeUpdate();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void delete(Vehicle vehicle) {

        try (Connection con = DbUtil.getCon()) {

            if (vehicle.getId() != 0) {

                String sql = "DELETE FROM vehicle WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, vehicle.getId());
                stmt.executeUpdate();
                vehicle.setId(0);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public List<Vehicle> findAll() {

        List<Vehicle> vehicles = new ArrayList<>();

        try (Connection con = DbUtil.getCon()) {

            String sql = "SELECT * FROM vehicle";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setProducent(rs.getString("producent"));
                vehicle.setProductionDate(LocalDate.parse(rs.getString("production_date")));
                vehicle.setRegistration(rs.getString("registration"));
                vehicle.setNextReviewDate(LocalDate.parse(rs.getString("next_review_date")));
                vehicle.setClientId(rs.getInt("client_id"));
                vehicles.add(vehicle);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return vehicles;
    }

    public Vehicle findById(int id) {

        try (Connection con = DbUtil.getCon()) {

            String sql = "SELECT * FROM vehicle WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setProducent(rs.getString("producent"));
                vehicle.setProductionDate(LocalDate.parse(rs.getString("production_date")));
                vehicle.setRegistration(rs.getString("registration"));
                vehicle.setNextReviewDate(LocalDate.parse(rs.getString("next_review_date")));
                vehicle.setClientId(rs.getInt("client_id"));
                return vehicle;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }
}

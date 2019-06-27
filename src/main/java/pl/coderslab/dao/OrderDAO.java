package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.model.Status;
import pl.coderslab.model.Vehicle;
import util.DbUtil;

/**
 *
 * @author Tomek
 */
public class OrderDAO {

    public void create(Order order) {

        try (Connection con = DbUtil.getCon()) {

            if (order.getId() == 0) {

                String sql = "INSERT INTO order(order_acceptance_date, planeed_repair_date, repair_start_date, order_employee, problem_description,"
                        + "repair_description, status, vehicle, order_cost, parts_cost, wrokhour_cost, workhours, client_id, order_id, employee_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, order.getOrderAcceptanceDate().toString());
                stmt.setString(2, order.getPlannedRepairStartDate().toString());
                stmt.setString(3, order.getRepairStartDate().toString());
                stmt.setObject(4, order.getOrderEmployee());
                stmt.setString(5, order.getProblemDescription());
                stmt.setString(6, order.getRepairDescription());
                stmt.setObject(7, order.getStatus());
                stmt.setObject(8, order.getVehicle());
                stmt.setDouble(9, order.getOrderCost());
                stmt.setDouble(10, order.getPartsCost());
                stmt.setDouble(11, order.getWorkhourCost());
                stmt.setInt(12, order.getWorkhours());
                stmt.setInt(13, order.getClientId());
                stmt.setInt(14, order.getVehicleId());
                stmt.setInt(15, order.getEmployeeId());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {

                    order.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(Order order) {

        try (Connection con = DbUtil.getCon()) {

            if (order.getId() == 0) {

                String sql = "INSERT INTO order(order_acceptance_date, planeed_repair_date, repair_start_date, order_employee, problem_description,"
                        + "repair_description, status, vehicle, order_cost, parts_cost, wrokhour_cost, workhours, client_id, order_id, employee_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, order.getOrderAcceptanceDate().toString());
                stmt.setString(2, order.getPlannedRepairStartDate().toString());
                stmt.setString(3, order.getRepairStartDate().toString());
                stmt.setObject(4, order.getOrderEmployee());
                stmt.setString(5, order.getProblemDescription());
                stmt.setString(6, order.getRepairDescription());
                stmt.setObject(7, order.getStatus());
                stmt.setObject(8, order.getVehicle());
                stmt.setDouble(9, order.getOrderCost());
                stmt.setDouble(10, order.getPartsCost());
                stmt.setDouble(11, order.getWorkhourCost());
                stmt.setInt(12, order.getWorkhours());
                stmt.setInt(13, order.getClientId());
                stmt.setInt(14, order.getVehicleId());
                stmt.setInt(15, order.getEmployeeId());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {

                    order.setId(rs.getInt(1));
                }

            } else {

                String sql = "UPDATE order SET order_acceptance_date=?, planeed_repair_date=?, repair_start_date=?, order_employee=?, problem_description=?,"
                        + "repair_description=?, status=?, vehicle=?, order_cost=?, parts_cost=?, wrokhour_cost=?, workhours=?, client_id=?, order_id=?, employee_id=? WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, order.getOrderAcceptanceDate().toString());
                stmt.setString(2, order.getPlannedRepairStartDate().toString());
                stmt.setString(3, order.getRepairStartDate().toString());
                stmt.setObject(4, order.getOrderEmployee());
                stmt.setString(5, order.getProblemDescription());
                stmt.setString(6, order.getRepairDescription());
                stmt.setObject(7, order.getStatus());
                stmt.setObject(8, order.getVehicle());
                stmt.setDouble(9, order.getOrderCost());
                stmt.setDouble(10, order.getPartsCost());
                stmt.setDouble(11, order.getWorkhourCost());
                stmt.setInt(12, order.getWorkhours());
                stmt.setInt(13, order.getClientId());
                stmt.setInt(14, order.getVehicleId());
                stmt.setInt(15, order.getEmployeeId());
                stmt.setInt(16, order.getId());
                stmt.executeUpdate();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void delete(Order order) {

        try (Connection con = DbUtil.getCon()) {

            if (order.getId() != 0) {

                String sql = "DELETE FROM order WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, order.getId());
                stmt.executeUpdate();
                order.setId(0);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public List<Order> findAll() {

        List<Order> orders = new ArrayList<>();

        try (Connection con = DbUtil.getCon()) {

            String sql = "SELECT * FROM order";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setOrderAcceptanceDate(LocalDateTime.parse(rs.getString("order_acceptance_date")));
                order.setPlannedRepairStartDate(LocalDateTime.parse(rs.getString("planned_repair_start_date")));
                order.setRepairStartDate(LocalDateTime.parse(rs.getString("repair_start_date")));
                order.setOrderEmployee(rs.getObject("order_employee", Employee.class));
                order.setProblemDescription(rs.getString("problem_description"));
                order.setRepairDescription(rs.getString("repair_description"));
                order.setStatus(rs.getObject("status", Status.class));
                order.setVehicle(rs.getObject("vehicle", Vehicle.class));
                order.setOrderCost(rs.getDouble("order_cost"));
                order.setPartsCost(rs.getDouble("parts_cost"));
                order.setWorkhourCost(rs.getDouble("workhour_cost"));
                order.setWorkhours(rs.getInt("workhours"));
                order.setClientId(rs.getInt("client_id"));
                order.setVehicleId(rs.getInt("vehicle_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                orders.add(order);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return orders;
    }

    public Order findById(int id) {

        try (Connection con = DbUtil.getCon()) {

            String sql = "SELECT * FROM order WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setOrderAcceptanceDate(LocalDateTime.parse(rs.getString("order_acceptance_date")));
                order.setPlannedRepairStartDate(LocalDateTime.parse(rs.getString("planned_repair_start_date")));
                order.setRepairStartDate(LocalDateTime.parse(rs.getString("repair_start_date")));
                order.setOrderEmployee(rs.getObject("order_employee", Employee.class));
                order.setProblemDescription(rs.getString("problem_description"));
                order.setRepairDescription(rs.getString("repair_description"));
                order.setStatus(rs.getObject("status", Status.class));
                order.setVehicle(rs.getObject("vehicle", Vehicle.class));
                order.setOrderCost(rs.getDouble("order_cost"));
                order.setPartsCost(rs.getDouble("parts_cost"));
                order.setWorkhourCost(rs.getDouble("workhour_cost"));
                order.setWorkhours(rs.getInt("workhours"));
                order.setClientId(rs.getInt("client_id"));
                order.setVehicleId(rs.getInt("vehicle_id"));
                order.setEmployeeId(rs.getInt("employee_id"));
                return order;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

}

package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pl.coderslab.model.Employee;
import util.DbUtil;

/**
 *
 * @author Tomek
 */
public class EmployeeDAO {
    
        public void create(Employee employee) {

        try (Connection con = DbUtil.getCon()) {

            if (employee.getId() == 0) {

                String sql = "INSERT INTO employee(name, surname, address, phone, note, workhour_salary, order_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, employee.getName());
                stmt.setString(2, employee.getSurname());
                stmt.setString(3, employee.getAddress());
                stmt.setInt(4, employee.getPhone());
                stmt.setString(5, employee.getNote());
                stmt.setDouble(6, employee.getWorkhourSalary());
                stmt.setInt(7, employee.getOrderId());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {

                    employee.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(Employee employee) {

        try (Connection con = DbUtil.getCon()) {

            if (employee.getId() == 0) {

                String sql = "INSERT INTO employee(name, surname , address, phone, note, workhour_salary, order_id) VALUES(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);;
                stmt.setString(1, employee.getName());
                stmt.setString(2, employee.getSurname());
                stmt.setString(3, employee.getAddress());
                stmt.setInt(4, employee.getPhone());
                stmt.setString(5, employee.getNote());
                stmt.setDouble(6, employee.getWorkhourSalary());
                stmt.setInt(7, employee.getOrderId());
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {

                    employee.setId(rs.getInt(1));
                }

            } else {

                String sql = "UPDATE employee SET name=?, surname=?, address=?, phone=?, note=?, workhour_salary=?, order_id=? WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, employee.getName());
                stmt.setString(2, employee.getSurname());
                stmt.setString(3, employee.getAddress());
                stmt.setInt(4, employee.getPhone());
                stmt.setString(5, employee.getNote());
                stmt.setDouble(6, employee.getWorkhourSalary());
                stmt.setInt(7, employee.getOrderId());
                stmt.setInt(8, employee.getId());
                stmt.executeUpdate();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void delete(Employee employee) {

        try (Connection con = DbUtil.getCon()) {

            if (employee.getId() != 0) {

                String sql = "DELETE FROM employee WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, employee.getId());
                stmt.executeUpdate();
                employee.setId(0);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public List<Employee> findAll() {

        List<Employee> employees = new ArrayList<>();

        try (Connection con = DbUtil.getCon()) {

            String sql = "SELECT * FROM employee";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getInt("phone"));
                employee.setNote(rs.getString("note"));
                employee.setWorkhourSalary(rs.getDouble("workhour_salary"));
                employee.setOrderId(rs.getInt("order_id"));
                employees.add(employee);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return employees;
    }

    public Employee findById(int id) {

        try (Connection con = DbUtil.getCon()) {

            String sql = "SELECT * FROM employee WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getInt("phone"));
                employee.setNote(rs.getString("note"));
                employee.setWorkhourSalary(rs.getDouble("workhour_salary"));
                employee.setOrderId(rs.getInt("order_id"));
                return employee;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }
}

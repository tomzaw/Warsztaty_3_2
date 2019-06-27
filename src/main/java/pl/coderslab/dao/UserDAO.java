package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import pl.coderslab.model.User;
import util.DbUtil;

/**
 *
 * @author Tomek
 */
public class UserDAO {

    public void create(User user) {

        try (Connection con = DbUtil.getCon()) {

            if (user.getId() == 0) {

                String sql = "INSERT INTO user(name, surname, email, birth_date) VALUES(?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, user.getName());
                stmt.setString(2, user.getSurname());
                stmt.setString(3, user.getEmail());
                LocalDate birthDate = user.getBirthDate();
                if(birthDate!=null)
                    stmt.setString(4, birthDate.toString());
                else
                    stmt.setString(4, null);
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {

                    user.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(User user) {

        try (Connection con = DbUtil.getCon()) {

            if (user.getId() == 0) {

                String sql = "INSERT INTO user(name, surname, email, birth_date) VALUES(?, ?, ?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, user.getName());
                stmt.setString(2, user.getSurname());
                stmt.setString(3, user.getEmail());
                LocalDate birthDate = user.getBirthDate();
                if(birthDate!=null)
                    stmt.setString(4, birthDate.toString());
                else
                    stmt.setString(4, null);
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {

                    user.setId(rs.getInt(1));
                }

            } else {

                String sql = "UPDATE user SET name=?, surname=?, email=?, birth_date=? WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, user.getName());
                stmt.setString(2, user.getSurname());
                stmt.setString(3, user.getEmail());
                LocalDate birthDate = user.getBirthDate();
                if(birthDate!=null)
                    stmt.setString(4, birthDate.toString());
                else
                    stmt.setString(4, null);
                stmt.setInt(5, user.getId());
                stmt.executeUpdate();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void delete(User user) {

        try (Connection con = DbUtil.getCon()) {

            if (user.getId() != 0) {

                String sql = "DELETE FROM user WHERE id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, user.getId());
                stmt.executeUpdate();
                user.setId(0);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public List<User> findAll() {

        List<User> users = new ArrayList<>();

        try (Connection con = DbUtil.getCon()) {

            String sql = "SELECT * FROM user";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                Date birthDate = rs.getDate("birth_date");
                if(birthDate!=null)
                    user.setBirthDate(birthDate.toLocalDate());
                else
                    user.setBirthDate(null);
                users.add(user);
            }
                

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return users;
    }

    public User findById(int id) {

        try (Connection con = DbUtil.getCon()) {

            String sql = "SELECT * FROM user WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                User user = new User();
                user.setId(rs.getInt("id"));
                
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                Date birthDate = rs.getDate("birth_date");
                if(birthDate!=null)
                    user.setBirthDate(birthDate.toLocalDate());
                else
                    user.setBirthDate(null);
                return user;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }
}

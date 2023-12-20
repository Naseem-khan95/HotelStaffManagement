package com.hotelStaffManagement.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelStaffManagement.Dao.HotelStaffDao;
import com.hotelStaffManagement.model.HotelStaff;

public class HotelStaffDaoImpl implements HotelStaffDao {
    private static final String JDBC_URL = "jdbc:mysql://your_database_url:3306/your_database_name";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    private static final String INSERT_SQL = "INSERT INTO hotel_staff (name, position, department, phone_number) VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID_SQL = "SELECT * FROM hotel_staff WHERE staff_id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM hotel_staff";
    private static final String SELECT_BY_DEPARTMENT_SQL = "SELECT * FROM hotel_staff WHERE department = ?";
    private static final String DELETE_SQL = "DELETE FROM hotel_staff WHERE staff_id = ?";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(HotelStaff hotelStaff) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {

            preparedStatement.setString(1, hotelStaff.getName());
            preparedStatement.setString(2, hotelStaff.getPsition());
            preparedStatement.setString(3, hotelStaff.getDepartment());
            preparedStatement.setString(4, hotelStaff.getPhoneNumber());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (log, throw a custom exception, etc.)
        }
    }

    @Override
    public HotelStaff findById(int id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_SQL)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extractHotelStaffFromResultSet(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (log, throw a custom exception, etc.)
        }

        return null;
    }

    @Override
    public List<HotelStaff> findAll() {
        List<HotelStaff> staffList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                HotelStaff hotelStaff = extractHotelStaffFromResultSet(resultSet);
                staffList.add(hotelStaff);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (log, throw a custom exception, etc.)
        }

        return staffList;
    }

    @Override
    public List<HotelStaff> findStaffByDepartment(String department) {
        List<HotelStaff> staffInDepartment = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_DEPARTMENT_SQL)) {

            preparedStatement.setString(1, department);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    HotelStaff hotelStaff = extractHotelStaffFromResultSet(resultSet);
                    staffInDepartment.add(hotelStaff);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (log, throw a custom exception, etc.)
        }

        return staffInDepartment;
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (log, throw a custom exception, etc.)
        }
    }

    private HotelStaff extractHotelStaffFromResultSet(ResultSet resultSet) throws SQLException {
        HotelStaff hotelStaff = new HotelStaff(null, null, null, null);
        hotelStaff.setStaffId(resultSet.getInt("staff_id"));
        hotelStaff.setName(resultSet.getString("name"));
        hotelStaff.setPsition(resultSet.getString("position"));
        hotelStaff.setDepartment(resultSet.getString("department"));
        hotelStaff.setPhoneNumber(resultSet.getString("phone_number"));
        return hotelStaff;
    }
}

package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Employer;
import enums.Role;
import enums.Poste;
import model.Holiday;

public class HolidayDAO implements GeneriqueI<Holiday> {

    private final Connection connection;

    public HolidayDAO() {
        try {
            connection = DBConnection.getConnection();
        } catch (SQLException connectionException) {
            connectionException.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.", connectionException);
        }
    }

    @Override
    public boolean add(Holiday holiday) {
        String query = "INSERT INTO holidays (employee_id,start_date, end_date, type) VALUES (?, ?, ?, ?)";
        try (PreparedStatement addStatement = connection.prepareStatement(query)) {

            setEmployerData(addStatement, holiday);
            return addStatement.executeUpdate() > 0;

        } catch (SQLException addException) {
            addException.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Holiday holiday) {
        String query = "UPDATE holidays SET femployee_id = ?, start_date = ?, end_date = ? WHERE id = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(query)) {

            setEmployerData(updateStatement, holiday);
            updateStatement.setInt(8, holiday.getHoliday_id());
            return updateStatement.executeUpdate() > 0;

        } catch (SQLException updateException) {
            updateException.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addEmployer(Holiday holiday) {
        return false;
    }

    @Override
    public boolean updateEmployer(Holiday holiday) {
        return false;
    }

    @Override
    public boolean deleteEmployer(int id) {
        String query = "DELETE FROM employers WHERE id = ?";
        try (PreparedStatement deleteStatement = connection.prepareStatement(query)) {

            deleteStatement.setInt(1, id);
            return deleteStatement.executeUpdate() > 0;

        } catch (SQLException deleteException) {
            deleteException.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Employer> getAllEmployers() {
        return List.of();
    }

    public List<Employer> getAll() {
        List<Employer> employers = new ArrayList<>();
        String query = "SELECT * FROM employers";
        try (PreparedStatement getStatement = connection.prepareStatement(query);
             ResultSet getResult = getStatement.executeQuery()) {

            while (getResult.next()) {
                employers.add(mapResultSetToEmployer(getResult));
            }

        } catch (SQLException getException) {
            getException.printStackTrace();
        }
        return employers;
    }

    /**
     * Helper method to set data for Employer in PreparedStatement.
     */
    private void setEmployerData(PreparedStatement statement, Holiday employer) throws SQLException {
        statement.setString(1, employer.getFirstName());
        statement.setString(2, employer.getLastName());
        statement.setString(3, employer.getEmail());
        statement.setInt(4, employer.getPhoneNumber());
        statement.setDouble(5, employer.getSalary());
        statement.setString(6, employer.getRole().name());
        statement.setString(7, employer.getPoste().name());
    }

    /**
     * Helper method to map a ResultSet row to an Employer object.
     */
    private Employer mapResultSetToEmployer(ResultSet resultSet) throws SQLException {
        return new Employer(
                resultSet.getInt("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getInt("phone"),
                resultSet.getDouble("salary"),
                Role.valueOf(resultSet.getString("role")),
                Poste.valueOf(resultSet.getString("poste"))
        );
    }
}
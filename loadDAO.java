/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewTable;

import DatabaseConnect.ConnectDB;
import java.util.List;
import entity.Salary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.Attributes;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Truong Dat
 */
public class loadDAO {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public loadDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QU2TFD4;databaseName=PersonnelDB;user=sa;password=123456789");
            System.out.println("Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Attributes> getAllAttributes() {
        String sql = "SELECT * FROM Personnel_Information";

        try {
            List<Attributes> list = new ArrayList<>();

            new loadDAO();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Attributes(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Attributes> InsertPersonnelInformation(String id, String name, String gender, String dob, String country, String position, String department) {
        int check = 0;
        List<Attributes> list = new ArrayList<>();
        java.sql.Date dOb = java.sql.Date.valueOf(dob);
        String query = "INSERT INTO Personnel_Information(ID, Name, Gender, Dob, Country, Position , Department) values(?,?,?,?,?,?,?)";
        try {
            connection = new ConnectDB().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, gender);
            ps.setString(4, dob);
            ps.setString(5, country);
            ps.setString(6, position);
            ps.setString(7, department);
            check = ps.executeUpdate();
            if (check > 0) {
                JOptionPane.showMessageDialog(null, "Insert successfully");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return list;

    }

    public List<Attributes> UpdatePersonnelInformation(String name, String gender, String dob, String country, String position, String department, String id) {
        List<Attributes> list = new ArrayList<>();
        java.sql.Date DOB = java.sql.Date.valueOf(dob);
        String query = "UPDATE Personnel_Information \n" + "SET Name=?,\n" + "Gender=?,\n" + "Dob=?,\n" + "Country=?,\n" + "Position=?,\n" + "Department=?\n" + "WHERE ID=?";
        try {
            connection = new ConnectDB().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, dob);
            ps.setString(4, country);
            ps.setString(5, position);
            ps.setString(6, department);
            ps.setString(7, id);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return list;
    }

    public List<Attributes> RemovetPersonnelInformation(String id) {
        List<Attributes> list = new ArrayList<>();
        String query = "DELETE FROM Personnel_Information WHERE ID=?";
        try {
            connection = new ConnectDB().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Remove successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return list;
    }

    public List<Attributes> searchByName(String name) {
        String query = "SELECT * FROM Personnel_Information WHERE Name  = '" + name + "'";
        List<Attributes> list = new ArrayList<>();
        try {
            connection = new ConnectDB().getConnection();
            new loadDAO();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Attributes(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }

            //  JOptionPane.showMessageDialog(null, "Can't find anyone, check the condition", "Search failed :( ", JOptionPane.WARNING_MESSAGE);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Attributes> searchByLetter(String name) {
        String query = "SELECT * FROM Personnel_Information WHERE Name  LIKE '%" + name + "%'";
        List<Attributes> list = new ArrayList<>();
        try {
            connection = new ConnectDB().getConnection();
            new loadDAO();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Attributes(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }

            //  JOptionPane.showMessageDialog(null, "Can't find anyone, check the condition", "Search failed :( ", JOptionPane.WARNING_MESSAGE);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Attributes> searchByGender(String gender) {
        String query = "SELECT * FROM Personnel_Information WHERE Gender='" + gender + "'";
        List<Attributes> list = new ArrayList<>();
        try {
            connection = new ConnectDB().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Attributes(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }

            // JOptionPane.showMessageDialog(null, "Can't find anyone, check the condition", "Search failed :( ", JOptionPane.WARNING_MESSAGE);
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return null;
    }

    public List<Attributes> searchByCountry(String country) {

        String query = "SELECT * FROM Personnel_Information WHERE Country='" + country + "'";
        List<Attributes> list = new ArrayList<>();
        try {
            connection = new ConnectDB().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Attributes(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

        return null;

    }

    public List<Attributes> searchbyPosition(String position) {
        String query = "SELECT * FROM Personnel_Information WHERE Position='" + position + "'";
        List<Attributes> list = new ArrayList<>();
        try {

            connection = new ConnectDB().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Attributes(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }

            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return null;
    }

    public List<Attributes> searchByDepartment(String department) {
        String query = "SELECT * FROM Personnel_Information WHERE Department='" + department + "'";
        List<Attributes> list = new ArrayList<>();
        try {
            connection = new ConnectDB().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Attributes(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }

            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

        return null;

    }

    public List<Attributes> searchDobByYear(int year) {

        String query = "select * from Personnel_Information where YEAR(Dob)=?";
        List<Attributes> list = new ArrayList<>();
        try {
            connection = new ConnectDB().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, year);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Attributes(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }

            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return null;
    }

    public List<Attributes> SearchDobByMonth(int month) {

        String query = "SELECT * FROM Personnel_Information where MONTH(Dob)=" + month + "";
        try {
            List<Attributes> list = new ArrayList<>();
            new loadDAO();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Attributes(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return null;
    }

    public List<Attributes> SearchDobByDay(int day) {
        String query = "SELECT * FROM Personnel_Information where DAY(Dob)=" + day + "";
        try {
            List<Attributes> list = new ArrayList<>();
            new loadDAO();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Attributes(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return null;
    }

    public List<Attributes> searchAll() {
        String query = "SELECT * FROM Personnel_Information";
        List<Attributes> list = new ArrayList<>();
        try {
            connection = new ConnectDB().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Attributes(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return null;
    }

    public List<Salary> InsertSalary(String id, float salary, float overtime, int position) {
        int check = 0;
        String query = "INSERT INTO Salary(ID, Salary, Overtime, Position_coefficient) VALUES(?,?,?,?)";
        List<Salary> list = new ArrayList<>();
        try {
            connection = new ConnectDB().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ps.setFloat(2, salary);
            ps.setFloat(3, overtime);
            ps.setInt(4, position);
            check = ps.executeUpdate();
            if (check > 0) {
                JOptionPane.showMessageDialog(null, "Insert successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Insert failed");
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e, "Error", JOptionPane.WARNING_MESSAGE);
        }
        return null;

    }

    public List<Salary> UpdateSalary(String id, float salary, float overtime, int position) {
        int check = 0;
        String query = "UPDATE Salary SET Salary=?, Overtime=?, Position_coefficient=? WHERE ID=?";
        List<Salary> list = new ArrayList<>();
        try {
            connection = new ConnectDB().getConnection();
            ps = connection.prepareStatement(query);
            ps.setFloat(1, salary);
            ps.setFloat(2, overtime);
            ps.setInt(3, position);
            ps.setString(4, id);
            check = ps.executeUpdate();
            if (check > 0) {
                JOptionPane.showMessageDialog(null, "Update successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Update failed");
            }
            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return null;

    }

    public List<Attributes> get3Infor() {
        String sql = "SELECT ID, Name, Position FROM Personnel_Information";

        try {
            List<Attributes> list = new ArrayList<>();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Attributes(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Salary> viewSalary() {
        String sql = "Select ID, Salary, Overtime, Position_coefficient FROM Salary";
        try {
            List<Salary> list = new ArrayList<>();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Salary(rs.getString(1), rs.getFloat(2), rs.getFloat(3), rs.getInt(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//      try {
//            List<Attributes> list = new ArrayList<>();
//
//            new loadDAO();
//            ps = connection.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(new Attributes(rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getDate(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7)));
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    public List<Attributes> getName() {
        String sql = "Select Name FROM Personnel_Information";
        try {
            List<Attributes> list = new ArrayList<>();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Attributes(rs.getString(1)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Attributes> InsertLeave(String id, String dobLeave, String dobBack, String reason) {
        int check = 0;
        List<Attributes> list = new ArrayList<>();
        java.sql.Date dObLeave = java.sql.Date.valueOf(dobLeave);
        java.sql.Date dObBack = java.sql.Date.valueOf(dobBack);
        String query = "INSERT INTO Leave(ID, dobLeave, dobBack, Reason) VALUES (?, ?, ?, ?)";
        try {
            connection = new ConnectDB().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            if (check > 0) {
                JOptionPane.showMessageDialog(null, "Insert successfully");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return list;

    }
}

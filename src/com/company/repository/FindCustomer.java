package com.company.repository;

import com.company.config.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindCustomer {

    public void findCustomerAndContactInfoByFinCode(String finCode) throws SQLException, ClassNotFoundException {
        Connection con = DataBase.INSTANCE().connect();
        Statement stmt = con.createStatement();

        String sql = "select customer.first_name,customer.last_name,customer.birth_date,customer.email_address,\n" +
                "contact_info.phone_number1,contact_info.home_number \n" +
                "from contact_info \n" +
                "inner join customer on customer.id = contact_info.customer_id where fin_code = '" + finCode + "'";

        ResultSet rs = stmt.executeQuery(sql);
        displayResultContactInfo(rs);

        con.close();
    }

    public void findCustomerAndAddressByFinCode(String finCode) throws SQLException, ClassNotFoundException {
        Connection con = DataBase.INSTANCE().connect();
        Statement stmt = con.createStatement();

        String sql = "select customer.first_name,customer.last_name,customer.birth_date,customer.email_address,\n" +
                "address.city,address.district,address.street \n" +
                "from address \n" +
                "inner join customer on customer.id = address.customer_id where fin_code = '" + finCode + "'";

        ResultSet rs = stmt.executeQuery(sql);
        displayResultAddressInfo(rs);

        con.close();
    }

    public void findAllCustomer() throws ClassNotFoundException, SQLException {
        Connection con = DataBase.INSTANCE().connect();
        Statement stmt = con.createStatement();

        String sql = "select * from customer";

        ResultSet rs = stmt.executeQuery(sql);
        displayAllCustomers(rs);

        con.close();
    }


    private void displayResultAddressInfo(ResultSet rs) throws SQLException {

        while (rs.next()) {
            String name = rs.getString("first_name");
            String surname = rs.getString("last_name");
            String birthDate = rs.getString("birth_date");
            String email_address = rs.getString("email_address");
            String city = rs.getString("city");
            String district = rs.getString("district");
            String street = rs.getString("street");
            System.out.println(name + " - " + surname + " - " + birthDate + " - " + email_address + " - " + city + " - " + district + " - " + street);

        }
    }

    private void displayAllCustomers(ResultSet rs) throws SQLException {
        while (rs.next()) {
            String name = rs.getString("first_name");
            String surname = rs.getString("last_name");
            String fatherName = rs.getString("father_name");
            String birthDate = rs.getString("birth_date");
            String email_address = rs.getString("email_address");
            String finCode = rs.getString("fin_code");
            String doc_serial = rs.getString("doc_serial");
            System.out.println(name + " - " + surname + " - " + fatherName + " - " + birthDate + " - " + email_address + " - " + finCode + " - " + doc_serial);
        }

    }

    private void displayResultContactInfo(ResultSet rs) throws SQLException {

        while (rs.next()) {
            String name = rs.getString("first_name");
            String surname = rs.getString("last_name");
            String birthDate = rs.getString("birth_date");
            String email_address = rs.getString("email_address");
            String phone_number1 = rs.getString("phone_number1");
            String home_number = rs.getString("home_number");
            System.out.println(name + " - " + surname + " - " + birthDate + " - " + email_address + " - " + phone_number1 + " - " + home_number);

        }
    }
}

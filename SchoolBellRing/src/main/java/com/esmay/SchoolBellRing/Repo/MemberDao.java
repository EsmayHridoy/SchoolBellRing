package com.esmay.SchoolBellRing.Repo;


import com.esmay.SchoolBellRing.Model.MemberTable;
import com.esmay.SchoolBellRing.MySQLConnector.MySqlConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;


@Component
public class MemberDao implements MemberDaoInterface {

    @Autowired
    private MySqlConnector mySqlConnector;


    public boolean insertMember(MemberTable member){
        boolean flag=false;
        String insertQuery =
                "INSERT INTO member_table (id, member_name, member_mail, password, Address, member_role) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = mySqlConnector.connect()) {
            var preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, member.getId());
            preparedStatement.setString(2, member.getMemberName());
            preparedStatement.setString(3, member.getMemberMail());
            preparedStatement.setString(4, member.getPassword());
            preparedStatement.setString(5, member.getAddress());
            preparedStatement.setString(6, member.getMemberRole());

            int rowsInserted = preparedStatement.executeUpdate();
            flag = rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Insert Failed");
            throw new RuntimeException(e);
        } finally {
            mySqlConnector.disconnect();
        }

        return flag;
    }

    public boolean checkMemberMail(MemberTable member){
        boolean flag=false;
        String checkQuery =
                "SELECT COUNT(*) AS email_count FROM member_table " +
                        "WHERE member_mail = ? OR id = ?;";
        try (Connection connection = mySqlConnector.connect()) {
            var preparedStatement = connection.prepareStatement(checkQuery);
            preparedStatement.setString(1, member.getMemberMail());
            preparedStatement.setInt(2, member.getId());

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int emailCount = resultSet.getInt("email_count");
                    flag = emailCount > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Insert Failed");
            throw new RuntimeException(e);
        } finally {
            mySqlConnector.disconnect();
        }
        return flag;
    }


    public boolean checkMemberCredential(MemberTable member){
        boolean flag=false;
        String checkQuery =
                "SELECT COUNT(*) AS member_count FROM member_table " +
                        "WHERE member_mail = ? AND password = ?";
        try (Connection connection = mySqlConnector.connect()) {
            var preparedStatement = connection.prepareStatement(checkQuery);
            preparedStatement.setString(1, member.getMemberMail());
            preparedStatement.setString(2, member.getPassword());

            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int Count = resultSet.getInt("member_count");
                    flag = Count > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Insert Failed");
            throw new RuntimeException(e);
        } finally {
            mySqlConnector.disconnect();
        }

        return flag;
    }


    public MemberTable getAllInformationOfMember(MemberTable member){
        boolean flag=false;
        String checkQuery =
                "SELECT * FROM member_table " +
                        "WHERE member_mail = ?";
        try (Connection connection = mySqlConnector.connect()) {
            var preparedStatement = connection.prepareStatement(checkQuery);
            preparedStatement.setString(1, member.getMemberMail());
            try (var resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    member.setMemberName((String) resultSet.getString("member_name"));
                    member.setAddress((String) resultSet.getString("Address"));
                    member.setId(resultSet.getInt("id"));
                    member.setMemberRole((String) resultSet.getString("member_role"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Insert Failed");
            throw new RuntimeException(e);
        } finally {
            mySqlConnector.disconnect();
        }

        return member;
    }

}

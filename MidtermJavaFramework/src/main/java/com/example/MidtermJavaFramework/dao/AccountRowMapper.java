/*
package com.example.MidtermJavaFramework.dao;

import com.example.MidtermJavaFramework.entity.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountRowMapper {
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    public List<Account> getAllEmployeesRowMapper(){
        return template.query("select * from employee",new RowMapper<Account>(){
            @Override
            public Account mapRow(ResultSet rs, int rownumber) throws SQLException {
                Account e=new Account();
                e.setId(rs.getLong(1));
                e.setUsername(rs.getString(2));
                return e;
            }
        });
    }
}
*/

package com.epam.training.dao;


import com.epam.training.domain.user.Player;

public class UserAccountDao {

    public String registerUser(Player playerBean) {
        String username = playerBean.getName();
        String birthday = String.valueOf(playerBean.getDateOfBirth());
        String account = playerBean.getAccountNumber();
        String currency = playerBean.getCurrency().name();
        String balance = String.valueOf(playerBean.getBalance());
/*
        Connection con = null;
        PreparedStatement preparedStatement = null;

        try
        {
            con = DBConnection.createConnection();
            String query = "insert into users(SlNo,fullName) values (NULL,?)"; //Insert user details into the table 'USERS'
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, username);
           // preparedStatement.setString(2, email);
            //preparedStatement.setString(3, userName);
            //preparedStatement.setString(4, password);

            int i= preparedStatement.executeUpdate();

            if (i!=0)  //Just to ensure data has been inserted into the database
                return "SUCCESS";
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }
    */
        return "SUCCESS";
    }
}

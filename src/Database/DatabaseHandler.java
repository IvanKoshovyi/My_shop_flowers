package Database;


import Flowers.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;

public class DatabaseHandler extends Configs {
    private static Connection dbConnection;
    private static int Num;
    private static LinkedList<Flowers> flowers = new LinkedList<>();

    public static int getNum() {
        return flowers.size();
    }

    public static LinkedList<Flowers> getFlowers() {
        return flowers;
    }
    public static Flowers temp(int i) {
        return flowers.get(i);
    }


    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public static void SelectFlowers(){
        flowers.clear();
        String insert = "SELECT * FROM " + Const.USER_TABLE;
        try {
            Statement statement = getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(insert);
            while (resultSet.next()){
                int idFlowers;
                String Name;
                int Cost;
                LocalDate Fresh;
                int StalkLength;
                idFlowers = resultSet.getInt(1);
                Name = resultSet.getString(2);
                Cost = resultSet.getInt(3);
                Fresh = LocalDate.parse(resultSet.getString(4));
                StalkLength = resultSet.getInt(5);
                switch (Name){
                    case "Ірис":
                        flowers.add(new Iris(idFlowers,Cost,Fresh,StalkLength));
                        break;
                    case "Лілія":
                        flowers.add(new Lily(idFlowers,Cost,Fresh,StalkLength));
                        break;
                    case "Троянда":
                        flowers.add(new Rose(idFlowers,Cost,Fresh,StalkLength));
                        break;
                    case "Тюльпан":
                        flowers.add(new Tulip(idFlowers,Cost,Fresh,StalkLength));
                        break;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void signUpFlowers() {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.NAME_FLOWERS + "," + Const.COST_FLOWERS + "," +
                Const.FRESH_FLOWERS + "," + Const.STALKLENGTH_FLOWERS + ")" +
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, flowers.getLast().getName_flowers());
            prSt.setString(2, String.valueOf(flowers.getLast().getCost()));
            prSt.setString(3, String.valueOf(flowers.getLast().getFresh()));
            prSt.setString(4, String.valueOf(flowers.getLast().getStalkLength()));
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void DeleteFlowers(String idflowers) {
        String insert = "DELETE FROM " + Const.USER_TABLE + " WHERE " +
                Const.ID_FLOWERS + " = " + "?" + ";";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, idflowers);
            prSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }





}


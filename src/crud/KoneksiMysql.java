package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiMysql {
    private Connection connect;
    private String url = "jdbc:mysql://localhost:3306/crud12345";
//    private String driverName = "com.mysql.jdbc.Driver"; // Driver untuk koneksi ke mysql
//    private String jdbc = "jdbc:mysql://";
//    private String host = "localhost:"; // bisa menggunakan IP kita
//    private String port = "3306/";  // port default mysql
//    private String database = "crud12345"; // database yang akan digunakan
//    private String url = jdbc + host + port +database;
    private String username = "root"; // username default mysql
    private String password = "";
    
    public Connection getKoneksi() throws SQLException {
        if (connect == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Class Driver Ditemukan");
                try {
                    connect = DriverManager.getConnection(url, username, password);
                    System.out.println("Koneksi Database Sukses");
                } catch (SQLException se) {
                    System.out.println("Koneksi Database Gagal : " +se);
                    System.exit(0);
                }
            } catch (ClassNotFoundException cnfe) {
                System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada" +cnfe);
                System.exit(0);
            }
        }
        return connect;
    }
}

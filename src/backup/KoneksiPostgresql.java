package backup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiPostgresql {
    private Connection connect;
    private String driverName = "org.postgresql.Driver"; // Driver untuk koneksi ke PostgreSQL
    private String jdbc = "jdbc:postgresql://";
    private String host = "localhost:"; // bisa menggunakan IP kita
    private String port = "5432/";  // port default postgresql
    private String database = "crud12345"; // database yang akan digunakan
    private String url = jdbc + host + port +database;
    private String username = "postgres"; //
    private String password = "";
    public Connection getKoneksi() throws SQLException {
        if (connect == null) {
            try {
                Class.forName(driverName);
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

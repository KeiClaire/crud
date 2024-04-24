package crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private Connection koneksi;
    private PreparedStatement psmt;
    private ResultSet dataUser;
    private String query,userID,password,pesan;
    
    public Login(){
        KoneksiMysql connection = new KoneksiMysql();
        try {
            koneksi = connection.getKoneksi();
        } catch(SQLException ex){
            
        }
    }
    
    public void setUserID(String userID)
    {
        this.userID = userID;
    }
    
    public String getUserID()
    {
        return userID;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String cekLogin(String userID,String password)
    {
        query = "select nama from user where id_user=? and password=md5(?)";
        try {
            psmt =  koneksi.prepareStatement(query);
            psmt.setString(1,userID);
            psmt.setString(2,password);
            dataUser = psmt.executeQuery();
            
            if (dataUser.next()){
                Session.setUserID(userID);
                Session.setNama(dataUser.getString("nama"));
                Session.setStatusLogin("AKTIF");
                query = "insert inot log_login(id_user) values(?)";
                try {
                    psmt = koneksi.prepareStatement(query);
                    psmt.setString(1, userID);
                    psmt.executeUpdate();
                    psmt.close();
                } catch(Exception e){
                    pesan = "gagal simpan log_login";
                }
                
            } else {
                pesan = "gagal login";
            }
        } catch(Exception e){
            pesan = "gagal login, query error";
        }
        return pesan;
    }
    
    public void Logout(String userID) {
        query = "update log_login set waktu_logout=current_timestamp() where id_user=? order by id desc limit 1";
        try {
            psmt = koneksi.prepareStatement(query);
            psmt.setString(1,userID);
            psmt.executeUpdate();
            psmt.close();
            
            koneksi.close();
            
            Session.setUserID(null);
            Session.setNama(null);
            Session.setStatusLogin(null);
        } catch(Exception e){
            
        }
    }
}

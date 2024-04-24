package crud;

public class Main {
    public static void main(String[] args) {
        try{ 
            LoginForm form = new LoginForm();
            form.setVisible(true);
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
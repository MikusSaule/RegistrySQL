import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setTitle("Reģistrācijas laiks!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setResizable(true);
        frame.add(panel);
        frame.setVisible(true);

        panel.setLayout(null);

        JLabel username = new JLabel("Username: ");
        username.setBounds(10,20,80,25);
        panel.add(username);

        JTextField usernametf = new JTextField();
        usernametf.setBounds(75,20,80,25);
        panel.add(usernametf);

        JLabel password = new JLabel("Password: ");
        password.setBounds(10,40,80,25);
        panel.add(password);

        JTextField passwordtf = new JTextField();
        passwordtf.setBounds(70,40,80,25);
        panel.add(passwordtf);


        JButton register = new JButton("Registrēties!");
        register.setBounds(55,90,110,25);
        panel.add(register);
        register.setBackground(Color.green);

        register.addActionListener(e -> {

            try {
                String DB = "jdbc:mysql://localhost:3306/user";
                String USER = "root";
                String PASS = "Kjkszpj-1997";
                Connection conn = DriverManager.getConnection(DB, USER, PASS);
                Statement stmt = conn.createStatement();

                String usernamee = usernametf.getText();
                String passwordd = passwordtf.getText();


                String reg = "INSERT INTO usertable (Username, Password, E-mail) VALUES ('"+ usernamee +"','"+ passwordd +"')";



                stmt.executeUpdate(reg);

                conn.close();



            } catch (SQLException r) {

                r.printStackTrace();

            }


        });









    }
}

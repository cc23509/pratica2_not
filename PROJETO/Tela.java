import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class Tela extends JFrame implements ActionListener {
    JTextField txtLogin;
    JTextField txtSenha;
    public String login;
    public String senha;
    Connection Conexao; // Adicione uma referência à conexão aqui

    public Tela(){
        
        setSize(800, 500);
        setTitle("Tela de Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        setLayout(null);

        JButton jButton = new JButton("Login");
        jButton.setBounds(this.getX()/2,330,170,60);
        jButton.setFont(new Font("Arial", Font.BOLD,40));
        jButton.setForeground(new Color(237,241,238));
        jButton.setBackground(new Color(10,10,10));

        add(jButton);
        jButton.addActionListener(this);

        
        txtLogin = new JTextField();
        txtLogin.setBounds(this.getX()/2,190,170,40);
        txtLogin.setFont(new Font("Arial", Font.ITALIC,40));
        
        add(txtLogin);
        String login = txtLogin.getText();
        

        txtSenha = new JTextField();
        txtSenha.setBounds(this.getX()/2,270,170,40);
        txtSenha.setFont(new Font("Arial", Font.ITALIC,40));

        add(txtSenha);
        String senha = txtSenha.getText();

        JLabel ttlLogin = new JLabel("Login:");
        ttlLogin.setBounds(this.getX()/2,150,90,50);
        ttlLogin.setFont(new Font("Arial", Font.PLAIN,20));

        add(ttlLogin);

        JLabel ttlSenha = new JLabel("Senha:");
        ttlSenha.setBounds(this.getX()/2,230,90,50);
        ttlSenha.setFont(new Font("Arial", Font.PLAIN,20));

        add(ttlSenha);

        JLabel titulo = new JLabel("Tela de Login");
        titulo.setFont(new Font("Arila", Font.BOLD, 50));
        titulo.setBounds(this.getX() / 2, 30, 350, 100);

        add(titulo);

        setVisible(true);

        jButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        login = txtLogin.getText();
        senha = txtSenha.getText();

        Conexao conexao = new Conexao(); // Crie uma instância de Conexao

        try {
            this.conexao = conexao.criarConexao(login, senha); // Passe login e senha para criarConexao
            System.out.println("Conexão bem-sucedida!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro na conexão com o banco de dados.");
        }
    }
}
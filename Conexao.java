import java.sql.*;
import java.util.ArrayList;

public class Conexao {
    private String url = "jdbc:mysql://localhost:3306/suap", user = "root", password = "1234";
    private String cmd, nome = null, dataNasc = null;
    private static ArrayList<Aluno> alunos = new ArrayList<>();

    public Conexao(String cmd) {
        this.cmd = cmd;
        execute();
    }

    public Conexao(String cmd, String nome, String dataNasc) {
        this.cmd = cmd;
        this.nome = nome;
        this.dataNasc = dataNasc;
        execute();
    }

    public void execute() {

        ResultSet rs = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = con.prepareStatement(cmd);
            
            if (nome != null) {
                stmt.setString(1, nome);
                stmt.setString(2, dataNasc);
                
                stmt.executeUpdate();
            } else {
                
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    Aluno aluno = new Aluno(rs.getString(2), rs.getString(3));
                    alunos.add(aluno);
                };
            }

            con.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
}
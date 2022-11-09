import java.util.ArrayList;
public class DAO {
    private String nome, dataNasc;
    private Conexao con;

    public DAO (){
        String cmd = "Select * from alunos";
        con = new Conexao(cmd);
    }

    public DAO (String nome, String dataNasc){
        this.nome = nome;
        this.dataNasc = dataNasc;
        String cmd = "Insert into alunos (nome, dataNasc) values (?, ?)";
        new Conexao(cmd, nome, dataNasc);
    }

    public ArrayList<Aluno> getAlunos(){
        return con.getAlunos();
    }
}

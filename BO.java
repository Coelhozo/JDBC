import java.util.ArrayList;

public class BO {
    private String nome, dataNasc;
    private ArrayList<Aluno> data;

    public BO(){
        DAO dao = new DAO();
        this.data = dao.getAlunos();
    }
    
    public BO(String nome, String dataNasc){
        this.nome = nome;
        this.dataNasc = dataNasc;

        new DAO(nome, dataNasc);
    }

    public ArrayList<Aluno> getAlunos(){
        return data;
    }
}

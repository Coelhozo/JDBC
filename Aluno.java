public class Aluno {
    private String nome, dataNasc;

    public Aluno(String nome, String dataNasc){
        this.nome = nome;
        this.dataNasc = dataNasc;
    }

    public void descreverAluno(){
        System.out.println("Nome: "+nome+" Data de Nascimento: "+dataNasc);
    }
}

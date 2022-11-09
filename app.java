import java.util.Scanner;
public class app {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("[1] para consultar todas as entradas no banco de dados");
            System.out.println("[2] para cadastrar alunos no banco de dados");

            int operacao = sc.nextInt();

            if(operacao == 1){
                BO consulta = new BO();
                
                if (consulta.getAlunos() == null){
                    System.out.println("Não há entradas");
                }else{
                    for(int i = 0; i < consulta.getAlunos().size(); i++){
                        consulta.getAlunos().get(i).descreverAluno();
                    }
                }
            }else{
                System.out.println("Digite o nome: ");
                String nome = sc.next();
                
                System.out.println("Digite a data de nascimento: ");
                String dataNasc = sc.next();

                new BO(nome, dataNasc);
            }

            System.out.print("Continuar? 2 para acabar ");
            int resp = sc.nextInt();
            if(resp == 2){
                break;
            }
        }
        sc.close();
    }
}

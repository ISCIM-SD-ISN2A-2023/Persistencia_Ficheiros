package controller;
import model.*;
import java.util.List;
import java.util.Scanner;

public class EstudanteController {
    private EstudanteDAO estudanteDAO;
    private Scanner scanner;

    public EstudanteController() {
        estudanteDAO = new EstudanteDAO();
        scanner = new Scanner(System.in);
    }

    public void adicionarEstudante() {
        System.out.println("Informe os dados do estudante:");

        System.out.print("Número de Matrícula: ");
        int nrMatricula = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Apelido: ");
        String apelido = scanner.nextLine();

        System.out.print("Contacto: ");
        String contacto = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Estudante estudante = new Estudante(nrMatricula, nome, apelido, contacto, endereco);
        estudanteDAO.adicionar(estudante);

        System.out.println("Estudante adicionado com sucesso!");
    }

    public void buscarEstudante() {
        System.out.print("Digite o numero de Matricula: ");
        int nrMatricula = scanner.nextInt();
        System.out.println(estudanteDAO.buscar(nrMatricula));
    }

    public void  listarEstudantes() {
        //Usando o foreach
        /*
        for (Estudante estudante: estudanteDAO.listar()) {
            System.out.println(estudante.toString());
        }*/

        //Usando o Lambda

        estudanteDAO.listar().forEach(estudante -> System.out.println(estudante.toString()));
    }

    public void atualizarEstudante(Estudante estudante) {
        estudanteDAO.atualizar(estudante);
        System.out.println("Informe os novos dados do estudante:");

  
  System.out.print("Nome: ");
  
  String nome = scanner.nextLine();

  
  System.out.print("Apelido: ");
  
  String apelido = scanner.nextLine();

 
   System.out.print("Contacto: ");
  
  String contacto = scanner.nextLine();

  
  System.out.print("Endereco: ");
    
String endereco = scanner.nextLine();

    

    estudante.setNome(nome);
  
  estudante.setApelido(apelido);
  
  estudante.setContacto(contacto);
  
  estudante.setEndereco(endereco);

   
 
    estudanteDAO.atualizar(estudante);

  
  System.out.println("Estudante atualizado com sucesso!");
     


    }

    public void removerEstudante(int nrMatricula) {
        estudanteDAO.remover(nrMatricula);
    }
}

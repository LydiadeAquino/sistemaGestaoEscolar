package kl.gestaoEscolar;

import kl.gestaoEscolar.entities.Aluno;
import kl.gestaoEscolar.entities.Disciplina;
import kl.gestaoEscolar.entities.Nota;
import kl.gestaoEscolar.entities.Professor;
import kl.gestaoEscolar.enums.Perfil;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
    Scanner scanner = new Scanner (System.in);

    System.out.println("---Relatório de teste de PROFESSOR---");

    Professor professor = new Professor( 1L, "Camila", "Camila@email.com", "123@123", Perfil.PROFESSOR );

    System.out.println(professor.getNome());

    System.out.println("---Relatório de teste de NOTA---");

   Aluno aluno = new Aluno();
   Disciplina disciplina = new Disciplina();

    System.out.println("---Situação APROVADO---");
    Nota nota1 = new Nota(1L, 5.9, 8.4, null, aluno, disciplina, null);
    nota1.calcularMediaESituacao();

    System.out.println("ID: " + nota1.getId());
    System.out.println("Nota1: " + nota1.getNota1());
    System.out.println("Nota2: " + nota1.getNota2());
    System.out.println("Media: " + nota1.getMedia());
    System.out.println("Situação: " + nota1.getSituacao());

    System.out.println("---Situação EM_ANDAMENTO---");
    Nota nota2 = new Nota(2L, 9.0, null, null, aluno, disciplina, null);
    nota2.calcularMediaESituacao();

    System.out.println("ID: " + nota2.getId());
    System.out.println("Nota1: " + nota2.getNota1());
    System.out.println("Nota2: " + nota2.getNota2());
    System.out.println("Media: " + nota2.getMedia());
    System.out.println("Situação: " + nota2.getSituacao());

    System.out.println("---Situação REPROVADO---");
    Nota nota3 = new Nota(3L, 3.7, 5.2, null, aluno, disciplina, null);
    nota3.calcularMediaESituacao();

    System.out.println("ID: " + nota3.getId());
    System.out.println("Nota1: " + nota3.getNota1());
    System.out.println("Nota2: " + nota3.getNota2());
    System.out.println("Media: " + nota3.getMedia());
    System.out.println("Situação: " + nota3.getSituacao());


    System.out.println("---Situação RECUPERAÇÃO---");
    Nota nota4 = new Nota(4L, 5.0, 5.0, null, aluno, disciplina, null);
    nota4.calcularMediaESituacao();

    System.out.println("ID: " + nota4.getId());
    System.out.println("Nota1: " + nota4.getNota1());
    System.out.println("Nota2: " + nota4.getNota2());
    System.out.println("Media: " + nota4.getMedia());
    System.out.println("Situação: " + nota4.getSituacao());




    }

}

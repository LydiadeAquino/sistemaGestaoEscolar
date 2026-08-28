package kl.gestaoEscolar;

import kl.gestaoEscolar.entities.Disciplina;
import kl.gestaoEscolar.entities.Professor;
import kl.gestaoEscolar.enums.Perfil;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
    Scanner scanner = new Scanner (System.in);

    System.out.println("---Relatório de teste---");

    Professor professor = new Professor( 1L, "Camila", "Camila@email.com", "123@123", Perfil.PROFESSOR );

    System.out.println(professor.getNome());


    }

}

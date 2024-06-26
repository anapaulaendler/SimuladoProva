package src.edu.up.telas;

import java.util.Scanner;

import src.edu.up.controles.Controle;

public class Menu {
    
    Controle controle = new Controle();
    Scanner leitor = new Scanner(System.in);
    
    public void executar() {
        System.out.println("Bem-vindo ao menu! Digite 1 para fundir os arquivos e 0 para sair"); 
        int n = 0;

        do {
            n = leitor.nextInt();
            leitor.nextLine();

            switch (n) {
                case 1:
                    controle.fundirListas();
                    controle.gravar();
                    break;
            
                default:
                System.out.println("Invalido");
                    break;
            }
        } while (n != 0);

    }
}

package src.edu.up.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import src.edu.up.modelos.Pessoa;

public class GerenciadorDeArquivosPessoa {
    
    public String header = "codigo;nome";
    public String nomeDoArquivo;

    public GerenciadorDeArquivosPessoa() {
        Path caminhoArquivo = Paths.get("src", "src", "edu", "up", "csv", "Pessoas.csv");
        nomeDoArquivo = caminhoArquivo.toAbsolutePath().toString();
    }

    public ArrayList<Pessoa> getPessoa() {
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();

        try {
            File arquivo = new File (nomeDoArquivo);
            Scanner leitor = new Scanner(arquivo);

            header = leitor.nextLine();

            while (leitor.hasNextLine()) {
                String linhaAtual = leitor.nextLine();
                String[] dados = linhaAtual.split(";");

                int codigo = Integer.parseInt(dados[0]);
                String nome = dados[1];

                Pessoa pessoa = new Pessoa(codigo, nome);
                listaPessoas.add(pessoa);
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo 'Pessoas' não foi encontrado");
        }
        return listaPessoas;
    }

}
package src.edu.up.daos;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import src.edu.up.modelos.Pessoa;

public class GerenciadorDeArquivosEndereco {
    
    public String header = "Rua;Cidade;Codigo";
    public String nomeDoArquivo;

    public GerenciadorDeArquivosEndereco() {
        Path caminhoArquivo = Paths.get("src", "src", "edu", "up", "csv", 
        "Enderecos.csv");
        nomeDoArquivo = caminhoArquivo.toAbsolutePath().toString();
    }

    public ArrayList<Pessoa> getEndereco() {
        ArrayList<Pessoa> listaEndereco = new ArrayList<>();

        try {
            File arquivo = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivo);

            header = leitor.nextLine();

            while (leitor.hasNextLine()) {
                String linhaAtual = leitor.nextLine();
                String[] dados = linhaAtual.split(";");

                String rua = dados[0];
                String cidade = dados[1];
                int codigo = Integer.parseInt(dados[2]);

                Pessoa pessoa = new Pessoa(codigo, rua, cidade);
                listaEndereco.add(pessoa);
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo 'Endereços' não foi encontrado");
        }
    return listaEndereco;
    }

}

package src.edu.up.daos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import src.edu.up.modelos.Pessoa;

public class GerenciadorDeArquivosPessoasComEndereco {
    
    public String header = "Codigo;Nome;Rua;Cidade";
    public String nomeDoArquivo;

    public GerenciadorDeArquivosPessoasComEndereco() {
        Path caminhoArquivo = Paths.get("src", "src", "edu", "up", "csv", "PessoasComEndereco.csv");
        nomeDoArquivo = caminhoArquivo.toAbsolutePath().toString();
    }

    public boolean gravar(ArrayList<Pessoa> listaPessoas) {

        try {
            FileWriter arquivoGravar = new FileWriter(nomeDoArquivo);
            PrintWriter gravador = new PrintWriter(arquivoGravar);

            gravador.println(header);

            for (Pessoa pessoa : listaPessoas) {
                gravador.println(pessoa.toCSV());
            }

            gravador.close();
            return true;
        } catch (IOException e) {
            System.out.println("Deu erro.");
        }
        return false;
    }
}

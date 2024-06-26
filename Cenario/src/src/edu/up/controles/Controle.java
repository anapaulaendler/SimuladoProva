package src.edu.up.controles;

import java.util.ArrayList;

import src.edu.up.daos.*;
import src.edu.up.modelos.Pessoa;

public class Controle {
    
    private GerenciadorDeArquivosEndereco leitorE;
    private GerenciadorDeArquivosPessoa leitorP;
    private GerenciadorDeArquivosPessoasComEndereco gravador;
    ArrayList<Pessoa> listaPessoaE = new ArrayList<>();
    ArrayList<Pessoa> listaPessoaP = new ArrayList<>();
    ArrayList<Pessoa> listaPessoa = new ArrayList<>();
    
    public Controle() {
        this.leitorE = new GerenciadorDeArquivosEndereco();
        this.leitorP = new GerenciadorDeArquivosPessoa();
        this.gravador = new GerenciadorDeArquivosPessoasComEndereco();
        this.listaPessoaE = leitorE.getEndereco();
        this.listaPessoaP = leitorP.getPessoa();
    }

    public void adicionarPessoa(Pessoa pessoa) {
        listaPessoa.add(pessoa);
    }

    public void deletarPessoa(int index) {
        listaPessoa.remove(index);
    }

    public String listarPessoas() {
        StringBuilder sb = new StringBuilder();
        if (listaPessoa == null) {
            return "Lista vazia.";
        } else {
            for (Pessoa pessoa : listaPessoa) {
                sb.append(pessoa.toString()).append("\n");
            }
            return sb.toString();
        }
    }

    public void fundirListas() {
        for (Pessoa pessoaE : listaPessoaE) {
            for (Pessoa pessoaP : listaPessoaP) {
                if (pessoaE.getCodigo() == pessoaP.getCodigo()) {
                    Pessoa pessoa = new Pessoa(pessoaE.getCodigo(), pessoaP.getNome(), pessoaE.getRua(), pessoaE.getCidade());
                    listaPessoa.add(pessoa);
                }
            }
        }
    }

    public boolean gravar(){
        return gravador.gravar(listaPessoa);
    }

}

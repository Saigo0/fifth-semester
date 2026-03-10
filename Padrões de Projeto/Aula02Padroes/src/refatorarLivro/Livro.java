package refatorarLivro;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private String editora;
    private int anoPublicacao;
    private String edicao;
    private List<String> categorias;
    private int numeroPaginas;
    private Catalogacao catalogacao;

    // Dados de aquisicao
    private Date dataAquisicao;
    private String fornecedor;
    private double precoCompra;
    private String notaFiscal;
    private String tipoAquisicao; // Compra, Doacao, Permuta

    // Dados de emprestimo
    private boolean disponivel;
    private List<Emprestimo> historicoEmprestimos;
    private int totalEmprestimos;
    private Date dataUltimoEmprestimo;
    private String estadoConservacao; // Novo, Bom, Regular, Danificado

    public Livro(String isbn, String titulo, String autor, List<String> categorias) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categorias = categorias;
        this.historicoEmprestimos = new ArrayList<>();
        this.disponivel = true;
        this.totalEmprestimos = 0;

        this.catalogacao = new Catalogacao(this);
    }

    public void catalogarLivro() {
        this.catalogacao.catalogarLivro();
    }

    public void registrarAquisicao(String fornecedor, double preco, String notaFiscal, String tipo) {
        this.fornecedor = fornecedor;
        this.precoCompra = preco;
        this.notaFiscal = notaFiscal;
        this.tipoAquisicao = tipo;
        this.dataAquisicao = new Date();

        // Aplicar depreciacao inicial
        if ("Compra".equals(tipo)) {
            if (preco > 100) {
                System.out.println("Livro de alto valor - necessidade de seguro");
            }
        } else if ("Doacao".equals(tipo)) {
            validarDoacao();
        }
    }

    private void validarDoacao() {
        // Regras para aceitar doacoes
        if (anoPublicacao < 2000) {
            System.out.println("Livro muito antigo - avaliar estado de conservacao");
        }

        if (estadoConservacao.equals("Danificado")) {
            throw new IllegalStateException("Doacao recusada - livro danificado");
        }
    }

    public double calcularValorPatrimonial() {
        // Regras de depreciacao contabil (mudam conforme normas)
        int idade = new Date().getYear() - dataAquisicao.getYear();
        double valorDepreciado = precoCompra;

        // Depreciacao anual (regra que muda)
        for (int i = 0; i < idade; i++) {
            valorDepreciado *= 0.9; // 10% ao ano
        }

        // Livros raros podem valorizar (regra especial)
        if (anoPublicacao < 1950 && "Bom".equals(estadoConservacao)) {
            valorDepreciado = precoCompra * (1 + (idade * 0.05)); // Valorizacao
        }

        return valorDepreciado;
    }

    public void emprestar(String nomeUsuario, String matricula) {
        if (!disponivel) {
            throw new IllegalStateException("Livro nao disponivel para emprestimo");
        }

        if (totalEmprestimosHoje(matricula) >= 3) {
            throw new IllegalStateException("Usuario atingiu limite de emprestimos");
        }

        if (usuarioTemMulta(matricula) > 10) {
            throw new IllegalStateException("Usuario com multas pendentes");
        }

        // Registrar emprestimo
        Emprestimo emprestimo = new Emprestimo(nomeUsuario, matricula, new Date());
        historicoEmprestimos.add(emprestimo);
        disponivel = false;
        totalEmprestimos++;
        dataUltimoEmprestimo = new Date();

        Date dataDevolucao = calcularDataDevolucao(matricula);
        System.out.println("Emprestado para " + nomeUsuario + " - Devolucao: " + dataDevolucao);
    }

    private int totalEmprestimosHoje(String matricula) {
        int hoje = 0;
        for (Emprestimo e : historicoEmprestimos) {
            if (e.getMatricula().equals(matricula) && e.getDataEmprestimo().getDate() == new Date().getDate()) {
                hoje++;
            }
        }
        return hoje;
    }

    private double usuarioTemMulta(String matricula) {
        double totalMulta = 0;
        for (Emprestimo e : historicoEmprestimos) {
            if (e.getMatricula().equals(matricula) && e.getDataDevolucao() == null) {
                long diasAtraso = (new Date().getTime() - e.getDataPrevista().getTime()) / (1000 * 60 * 60 * 24);
                if (diasAtraso > 0) {
                    totalMulta += diasAtraso * 1.50;
                }
            }
        }
        return totalMulta;
    }

    private Date calcularDataDevolucao(String matricula) {
        // Prazo de devolucao que muda conforme tipo de usuario e
        // -- tipo de biblioteca (universitaria, publica ou particular)


        Date dataPrevista = new Date();

        if (matricula.startsWith("PROF")) {
            // Professores tem 30 dias
            dataPrevista.setDate(dataPrevista.getDate() + 30);
        } else if (matricula.startsWith("ALU")) {
            // Alunos tem 15 dias
            dataPrevista.setDate(dataPrevista.getDate() + 15);
        } else {
            // Publico geral tem 10 dias
            dataPrevista.setDate(dataPrevista.getDate() + 10);
        }

        return dataPrevista;
    }

    public void devolver(String matricula) {
        for (Emprestimo e : historicoEmprestimos) {
            if (e.getMatricula().equals(matricula) && e.getDataDevolucao() == null) {
                e.setDataDevolucao(new Date());
                disponivel = true;

                // Verificar atraso
                long diasAtraso = (e.getDataDevolucao().getTime() - e.getDataPrevista().getTime())
                        / (1000 * 60 * 60 * 24);
                if (diasAtraso > 0) {
                    double multa = diasAtraso * 1.50;
                    System.out.println("Devolucao com atraso de " + diasAtraso + " dias");
                    System.out.println("Multa a pagar: R$" + multa);
                }
                break;
            }
        }
    }

    public void renovar(String matricula) {
        for (Emprestimo e : historicoEmprestimos) {
            if (e.getMatricula().equals(matricula) && e.getDataDevolucao() == null) {
                if (e.getRenovacoes() < 2) { // Limite de renovacoes
                    e.setRenovacoes(e.getRenovacoes() + 1);
                    Date novaData = e.getDataPrevista();
                    novaData.setDate(novaData.getDate() + 7);
                    e.setDataPrevista(novaData);
                    System.out.println("Renovado com sucesso. Nova data: " + novaData);
                } else {
                    throw new IllegalStateException("Limite de renovacoes atingido");
                }
                break;
            }
        }
    }

    public void avaliarConservacao() {
        // Regras de avaliacao fisica
        int pontuacao = 0;

        // Verificar capa
        pontuacao += verificarCapa();

        // Verificar lombada
        pontuacao += verificarLombada();

        // Verificar paginas
        pontuacao += verificarPaginas();

        // Classificar estado
        if (pontuacao >= 90) {
            this.estadoConservacao = "NOVO";
        } else if (pontuacao >= 70) {
            this.estadoConservacao = "BOM";
        } else if (pontuacao >= 50) {
            this.estadoConservacao = "REGULAR";
        } else {
            this.estadoConservacao = "DANIFICADO";
        }
    }

    private int verificarCapa() {
        return 25; // Simulacao
    }

    private int verificarLombada() {
        return 25; // Simulacao
    }

    private int verificarPaginas() {
        int descontos = 0;
        if (numeroPaginas > 500) {
            descontos += 5; // Livros grandes desgastam mais
        }
        return 30 - descontos;
    }

    public void aplicarConservacao() {
        // Procedimentos de restauracao
        if ("DANIFICADO".equals(estadoConservacao)) {
            System.out.println("Encaminhar para restauracao");
        } else if ("REGULAR".equals(estadoConservacao)) {
            System.out.println("Aplicar reparos simples");
        }
    }

    // ============ GETTERS E SETTERS ============
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getLocalizacaoFisica() {
        return this.catalogacao.getLocalizacaoFisica();
    }

    public String getCdd() {
        return this.catalogacao.getCdd();
    }

    public String getCdu() {
        return this.catalogacao.getCdu();
    }

    public String getCutter() {
        return this.catalogacao.getCutter();
    }

    public List<String> getPalavrasChave() {
        return this.catalogacao.getPalavrasChave();
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public String getTipoAquisicao() {
        return tipoAquisicao;
    }

    public int getTotalEmprestimos() {
        return totalEmprestimos;
    }

    public Date getDataUltimoEmprestimo() {
        return dataUltimoEmprestimo;
    }

    public String getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(String estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }
}

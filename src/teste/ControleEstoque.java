package teste;

import DAO.ClienteDAO;
import DAO.CompraDAO;
import DAO.ProdutoDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Compra;
import modelo.Produto;

/**
 *
 * Daniel Penasio - dpenasio@gmail.com RA-266674
 */
public class ControleEstoque {

    public static void main(String[] args) {

        int opcao;

        do {
            opcao = menu();

            switch (opcao) {
                case 1://listar Cliente
                    listaDeClientes();
                    voltarMenu();
                    break;
                case 2://Cadastrar Cliente
                    cadastrarCliente();
                    voltarMenu();
                    break;
                case 3://Alterar Cliente
                    alterarCliente();
                    voltarMenu();
                    break;
                case 4://Remover Cliente
                    removerCliente();
                    voltarMenu();
                    break;
                case 5://Listar produto
                    listaDeProdutos();
                    voltarMenu();
                    break;
                case 6://Cadastrar Produto
                    cadastrarProduto();
                    voltarMenu();
                    break;
                case 7://Alterar Produto
                    alterarProduto();
                    voltarMenu();
                    break;
                case 8://Remover Produto
                    removerProduto();
                    voltarMenu();
                    break;
                case 9://Listar venda
                    listaDeVendas();
                    voltarMenu();
                    break;
                case 10://Cadastrar venda
                    cadastrarVenda();
                    voltarMenu();
                    break;
                case 11://Alterar Venda
                    alterarVenda();
                    voltarMenu();
                    break;
                case 12://Remover venda
                    removerVenda();
                    voltarMenu();
                    break;
            }
        } while (opcao != 20);//sair
    }

    public static int menu() {
        Scanner scan = new Scanner(System.in);
        int opcao;

        System.out.println("Escolha uma opção");
        System.out.println("==== Cliente ====");
        System.out.println("1 - Listar Clientes");
        System.out.println("2 - Cadastrar Cliente");
        System.out.println("3 - Alterar Cliente");
        System.out.println("4 - Remover Cliente");
        System.out.println("");
        System.out.println("==== Produto ====");
        System.out.println("5 - Listar Produto");
        System.out.println("6 - Cadastrar Produto");
        System.out.println("7 - Alterar Produto");
        System.out.println("8 - Remover Produto");
        System.out.println("");
        System.out.println("==== Venda ====");
        System.out.println("9 - Listar Venda");
        System.out.println("10 - Cadastrar Venda");
        System.out.println("11 - Alterar Venda");
        System.out.println("12 - Remover Venda");
        System.out.println("");
        System.out.println("========");
        System.out.println("20 - Sair");
        System.out.println("");
        System.out.println("========");
        opcao = scan.nextInt();
        return opcao;
    }

    // =============== Clientes ========================
    private static void listaDeClientes() {
        ClienteDAO dao = new ClienteDAO();

        List<Cliente> clientes = dao.getLista();
        System.out.println("Lista de Clientes");
        for (Cliente cliente : clientes) {
            System.out.println("==================");
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome()
                    + " | Cpf: " + cliente.getCpf() + " | Sexo: "
                    + cliente.getSexo());
        }
        System.out.println("==================");
    }

    private static void cadastrarCliente() {
        Scanner s = new Scanner(System.in);
        ClienteDAO dao = new ClienteDAO();
        Cliente c1 = new Cliente();
        System.out.println("Digite o nome do Cliente");
        c1.setNome(s.nextLine());
        System.out.println("Digite o CPF");
        c1.setCpf(s.nextLine());
        System.out.println("Digite o sexo (m/f)");
        c1.setSexo(s.nextLine().charAt(0));

        dao.adiciona(c1);
        System.out.println("");
        System.out.println("Cliente " + c1.getNome() + "cadastrado com sucesso");
        System.out.println("");
    }

    private static void alterarCliente() {
        Scanner s = new Scanner(System.in);
        ClienteDAO dao = new ClienteDAO();
        Cliente c1 = new Cliente();
        listaDeClientes();
        System.out.println("Digite o id do cliente que deseja alterar");
        c1.setId(s.nextLong());
        System.out.println("Digite o nome do Cliente");
        c1.setNome(s.nextLine());
        System.out.println("Digite o CPF");
        c1.setCpf(s.nextLine());
        System.out.println("Digite o sexo (m/f)");
        c1.setSexo(s.nextLine().charAt(0));
        System.out.println("Digite o id do cliente que deseja alterar");
        c1.setId(s.nextLong());

        dao.altera(c1);
        System.out.println("");
        System.out.println("Cliente: " + c1.getNome() + " alterado");
        System.out.println("");
    }

    private static void removerCliente() {
        Scanner s = new Scanner(System.in);
        ClienteDAO dao = new ClienteDAO();
        Cliente c1 = new Cliente();
        listaDeClientes();
        System.out.println("Digite o id do Cliente a ser removido");
        c1.setId(s.nextLong());

        dao.remove(c1);
        System.out.println("");
        System.out.println("Cliente removido.");
        System.out.println("");
    }

    // =============== Produtos ========================
    public static void listaDeProdutos() {
        ProdutoDAO dao = new ProdutoDAO();
        //Cria array de produtos
        List<Produto> produtos = dao.getLista();
        // conversão da data do banco
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Lista de Produtos");
        for (Produto produto : produtos) {
            System.out.println("==================");
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome()
                    + " | Preço RS " + produto.getPreco()
                    + " | Tipo: " + produto.getTipo()
                    + " | Data de Validade: "
                    + sdf.format(produto.getDataValidade().getTime())
                    + " | Quantidade: " + produto.getQuantidade());
        }
        System.out.println("==================");
    }

    private static void cadastrarProduto() {
        Scanner s = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();
        Produto p1 = new Produto();
        System.out.println("Nome do Produto");
        p1.setNome(s.next());
        System.out.println("Preço do produto");
        String pr = s.next();
        double preco = Double.parseDouble(pr);
        p1.setPreco(preco);
        System.out.println("Tipo do produto");
        p1.setTipo(s.next());

        //data de validade a ser inserida
        System.out.println("Data de validade (dd/mm/aaaa)");
        String dataTexto = s.next();
        Calendar dataValidade = null;
        //Convertendo a data
        try {
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
            dataValidade = Calendar.getInstance();
            dataValidade.setTime(data);

        } catch (java.text.ParseException e) {
            System.out.println("Erro data");
        }
        //setando a data
        p1.setDataValidade(dataValidade);

        System.out.println("Quantidade");
        p1.setQuantidade(s.nextInt());

        dao.adiciona(p1);

        System.out.println("");
        System.out.println("Produto " + p1.getNome() + " cadastrado com sucesso");
        System.out.println("");

    }

    private static void alterarProduto() {
        Scanner s = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();
        Produto p1 = new Produto();
        listaDeProdutos();
        System.out.println("Digite o id do produto");
        p1.setId(s.nextLong());
        System.out.println("Nome do Produto");
        p1.setNome(s.next());
        System.out.println("Preço do produto (utilizar ponto(.) ao invés de vírgula");
        String pr = s.next();
        double preco = Double.parseDouble(pr);
        p1.setPreco(preco);
        System.out.println("Tipo do produto");
        p1.setTipo(s.next());

        //data de validade a ser inserida
        System.out.println("Data de validade (dd/mm/aaaa)");
        String dataTexto = s.next();
        Calendar dataValidade = null;
        //Convertendo a data
        try {
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
            dataValidade = Calendar.getInstance();
            dataValidade.setTime(data);

        } catch (java.text.ParseException e) {
            System.out.println("Erro data");
        }
        //setando a data
        p1.setDataValidade(dataValidade);

        System.out.println("Quantidade");
        p1.setQuantidade(s.nextInt());

        dao.altera(p1);

        System.out.println("");
        System.out.println("Produto " + p1.getNome() + " alterado com sucesso");
        System.out.println("");
    }

    private static void removerProduto() {
        Scanner s = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();
        Produto p1 = new Produto();
        listaDeProdutos();
        System.out.println("Digite o id do produto");
        p1.setId(s.nextLong());
        dao.remove(p1);

        System.out.println("");
        System.out.println("Produto removido");
        System.out.println("");
    }

    // =============== Vendas ========================
    private static void listaDeVendas() {
        CompraDAO dao = new CompraDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        List<Compra> compras = dao.getLista();
        System.out.println("Lista de Vendas");
        for (Compra compra : compras) {
            System.out.println("==================");
            System.out.println("ID da compra: " + compra.getId());
            System.out.println("Cliente: " + clienteDAO.buscaId(compra.getClienteId()).getNome()
                    + " | Produto: " + produtoDAO.buscaId(compra.getProdutoId()).getNome()
                    + " | Quantidade: " + compra.getQuantidade());
        }
        System.out.println("==================");
    }

    private static void cadastrarVenda() {
        Scanner s = new Scanner(System.in);
        CompraDAO dao = new CompraDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Compra compra = new Compra();
        Produto produto;

        listaDeClientes();
        System.out.println("Insira o id do cliente");
        compra.setClienteId(s.nextLong());

        listaDeProdutos();
        System.out.println("Insira o id do produto");
        Long idProduto = s.nextLong();
        compra.setProdutoId(idProduto);

        System.out.println("Insira a quantidade");
        int qtdVenda = s.nextInt();
        compra.setQuantidade(qtdVenda);

        //seta o produto pelo id
        produto = produtoDAO.buscaId(idProduto);
        int qtdProduto = produto.getQuantidade();
        
        if (qtdProduto <= 10 && qtdProduto != 0) {
            System.out.println("Produto com menos de 10 itens em estoque. "
                    + "Realizar a compra junto ao fornecedor");
        }
        
        if (qtdVenda < qtdProduto && qtdProduto != 0) {

            //adiciona a compra na tabela compra
            dao.adiciona(compra);
            //altera quantidade do produto na tabela de produtos
            produto.setQuantidade(qtdProduto - qtdVenda);
            produto.setId(idProduto);
            produtoDAO.alteraQtd(produto);

            System.out.println("");
            System.out.println("Compra gravada");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("Impossível realizar a venda. Não há produtos disponíveis!");
            System.out.println("");
        }
        
    }

    private static void alterarVenda() {
        Scanner s = new Scanner(System.in);
        CompraDAO dao = new CompraDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Compra compra = new Compra();
        Produto produto = new Produto();

        listaDeVendas();
        System.out.println("Insira o id da venda que deseja alterar");
        compra.setId(s.nextLong());
        
        listaDeClientes();
        System.out.println("Insira o id do cliente");
        compra.setClienteId(s.nextLong());

        listaDeProdutos();
        System.out.println("Insira o id do produto");
        Long idProduto = s.nextLong();
        compra.setProdutoId(idProduto);

        System.out.println("Insira a quantidade");
        int qtdVenda = s.nextInt();
        compra.setQuantidade(qtdVenda);

        //seta o produto pelo id
        produto = produtoDAO.buscaId(idProduto);

        if (qtdVenda < produto.getQuantidade() && produto.getQuantidade() != 0) {

            //adiciona a compra na tabela compra
            dao.altera(compra);
            //altera quantidade do produto na tabela de produtos
            produto.setQuantidade(produto.getQuantidade() - qtdVenda);
            produto.setId(idProduto);
            produtoDAO.alteraQtd(produto);

            System.out.println("");
            System.out.println("Compra gravada");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("Impossível realizar a venda. Não há produtos disponíveis!");
            System.out.println("");
        }
        if (produto.getQuantidade() <= 10 && produto.getQuantidade() != 0) {
            System.out.println("Produto com menos de 10 itens em estoque. "
                    + "Realizar a compra junto ao fornecedor");
        }

    }

    private static void removerVenda() {
        Scanner s = new Scanner(System.in);
        CompraDAO dao = new CompraDAO();
        Compra c1 = new Compra();
        listaDeVendas();
        System.out.println("Digite o id da Venda");
        c1.setId(s.nextLong());
        dao.remove(c1);

        System.out.println("");
        System.out.println("Venda removido");
        System.out.println("");
    }

    private static void voltarMenu() {
        Scanner s = new Scanner(System.in);
        System.out.println("Tecle M p/ voltar ao menu.");
        s.next();
    }

}

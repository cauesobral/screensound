package br.com.cauesobral.screensound.main;

import java.util.Scanner;

public class Main {
    public void exibeMenu() {
        Scanner leitura = new Scanner(System.in);
        var opcao = -1;

        while (opcao != 9) {
            var menu = """
                    ===================================
                    Bem-vindo ao ScreenSound!
                    Projeto desenvolvido por Cauê na
                    trilha de Java Web da Alura!
                    ===================================
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                    ===================================
                    9 - Sair
                    ===================================
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtista();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void pesquisarDadosDoArtista() {
    }

    private void buscarMusicasPorArtista() {
    }

    private void listarMusicas() {
    }

    private void cadastrarMusicas() {
    }

    private void cadastrarArtistas() {
        System.out.println("Digite o nome do artista que você quer cadastrar: ");
        var nome = leitura.nextLine();
    }
}
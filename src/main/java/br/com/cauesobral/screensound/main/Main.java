package br.com.cauesobral.screensound.main;

import br.com.cauesobral.screensound.model.Artista;
import br.com.cauesobral.screensound.model.Musica;
import br.com.cauesobral.screensound.repository.ArtistaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private final ArtistaRepository repositorio;
    Scanner leitura = new Scanner(System.in);

    public Main(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
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
        System.out.println("Digite o nome do artista:");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeIgnoreCase(nome);

        if (artista.isPresent()) {
            System.out.println(artista.get());
        } else {
            System.out.println("Artista não encontrado.");
        }
    }
    private void buscarMusicasPorArtista() {
        System.out.println("Digite o nome do artista:");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeIgnoreCase(nome);

        if (artista.isPresent()) {
            Artista a = artista.get();
            if (a.getMusicas().isEmpty()) {
                System.out.println("Esse artista não possui músicas cadastradas.");
            } else {
                System.out.println("Músicas de " + a.getNome() + ":");
                a.getMusicas().forEach(System.out::println);
            }
        } else {
            System.out.println("Artista não encontrado.");
        }
    }
    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();

        artistas.stream()
                .flatMap(a -> a.getMusicas().stream())
                .forEach(System.out::println);
    }
    private void cadastrarMusicas() {

        System.out.println("Cadastrar música de que artista?");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeIgnoreCase(nome);

        if (artista.isPresent()) {

            System.out.println("Qual é o nome da música?");
            String nomeMusica = leitura.nextLine();

            System.out.println("Qual é o gênero da música?");
            String genero = leitura.nextLine();

            Musica musica = new Musica(nomeMusica, genero);
            musica.setArtista(artista.get());

            artista.get().getMusicas().add(musica);

            repositorio.save(artista.get());

            System.out.println("Música cadastrada com sucesso!");

        } else {
            System.out.println("O artista não foi encontrado...");
        }
    }

    private void cadastrarArtistas() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("S")) {
            System.out.println("Digite o nome do artista que você quer cadastrar:");
            var nome = leitura.nextLine();

            System.out.println("Qual o gênero do artista?");
            var tipo = leitura.nextLine();

            Artista artista = new Artista(nome, tipo);

            repositorio.save(artista);

            System.out.println("Deseja cadastrar mais um? (S/N)");
            cadastrarNovo = leitura.nextLine();
        }
    }
}
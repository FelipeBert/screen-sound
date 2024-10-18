package org.FelipeBert.music.principal;

import org.FelipeBert.music.service.ICantorService;

import java.util.Scanner;

public class Principal {
    private final Scanner scanner = new Scanner(System.in);

    private ICantorService cantorService;

    public Principal(ICantorService cantorService) {
        this.cantorService = cantorService;
    }

    public void exibiMenu(){
        int opcao = 0;
        String menu = """
                *** Screen Sound Music ***
                
                1 - Cadastrar Artista
                2 - Cadastrar Musica
                3 - Listar Artistas
                4 - Buscar Musicas por Artista
                
                9 - sair
                """;
        do {
            System.out.println(menu);
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    cantorService.listarArtistas();
                    break;
                case 4:
                    cantorService.listarMusicasPorArtista(getArtistaNome());
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Invalida!");
            }

        }while (opcao != 9);
    }

    private void cadastrarArtista() {
        String nomeArtista = getArtistaNome();

        System.out.println("Digite a nacionalidade do Artista: ");
        String nacionalidade = scanner.nextLine();

        System.out.println("Digite o genero que o Artista canta: ");
        String genero = scanner.nextLine();

        System.out.println("Digite o tipo do Artista(SOLO, DUPLA, BANDA): ");
        String tipo = scanner.nextLine();

        cantorService.cadastrarArtistas(nomeArtista, nacionalidade, genero, tipo);
    }

    private void cadastrarMusica(){
        String nomeArtista = getArtistaNome();

        System.out.println("Digite o nome da Musica: ");
        String nomeMusica = scanner.nextLine();

        System.out.println("Digite a Avaliação da Musica");
        Double avaliacao = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite o Numero de Visualizações que a musica possui: ");
        Integer visualizacoes = scanner.nextInt();

        cantorService.cadastrarMusica(nomeArtista, nomeMusica, avaliacao, visualizacoes);
    }

    private String getArtistaNome(){
        scanner.nextLine();
        System.out.println("Digite o nome do Artista: ");
        return scanner.nextLine();
    }
}

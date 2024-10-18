package org.FelipeBert.music.service.impl;

import org.FelipeBert.music.model.Cantor;
import org.FelipeBert.music.model.Musica;
import org.FelipeBert.music.repository.CantorRepository;
import org.FelipeBert.music.service.ICantorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CantorServiceImpl implements ICantorService {
    private CantorRepository cantorRepository;

    public CantorServiceImpl(CantorRepository cantorRepository) {
        this.cantorRepository = cantorRepository;
    }

    @Override
    public void cadastrarArtistas(String nome, String nacionalidade, String generoMusical, String tipoArtista) {
        Cantor newCantor = new Cantor(nome, nacionalidade, generoMusical, tipoArtista);
        cantorRepository.save(newCantor);
    }

    @Override
    public void cadastrarMusica(String nomeCantor, String nomeMusica, Double avaliacao, Integer visualizacoes) {
        Optional<Cantor> cantorBuscado = cantorRepository.findByNomeContainingIgoneCase(nomeCantor);

        if(cantorBuscado.isEmpty()){
            System.out.println("Cantor não Encontrado!");
        }
        else{
            Cantor cantor = cantorBuscado.get();

            List<Musica> musicas = cantor.getMusicas();

            Musica musica = new Musica(nomeMusica, avaliacao, visualizacoes);
            musicas.add(musica);

            cantor.setMusicas(musicas);
            cantorRepository.save(cantor);
        }
    }

    @Override
    public void listarArtistas() {
        List<Cantor> artistas = cantorRepository.findAll();
        artistas.forEach(a ->
                System.out.printf("%s é um cantor de %s, Sua Nacionalidade é %s e ele é do tipo %s\n",
                        a.getNome(), a.getGenero(), a.getNacionalidade(), a.getTipoArtista()));
    }

    @Override
    public void listarMusicasPorArtista(String nomeCantor) {
        Optional<Cantor> cantorBuscado = cantorRepository.findByNomeContainingIgoneCase(nomeCantor);

        if(cantorBuscado.isEmpty()){
            System.out.println("Cantor não Encontrado!");
        }
        else{
            Cantor cantor = cantorBuscado.get();

            List<Musica> musicas = cantorRepository.listarMusicasPorCantor(cantor);
            musicas.forEach(m ->
                    System.out.printf("Nome: %s do Cantor %s possui %s de Avaliação com um total de %s Visualizações\n",
                            m.getNome(), m.getCantor().getNome(), m.getAvaliacao(), m.getVisualizacoes()));
        }
    }


}

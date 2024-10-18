package org.FelipeBert.music.service;

public interface ICantorService {
    void cadastrarArtistas(String nome, String nacionalidade, String generoMusical, String tipoArtista);
    void cadastrarMusica(String nomeCantor, String nomeMusica, Double avaliacao, Integer visualizacoes);
    void listarArtistas();
    void listarMusicasPorArtista(String nomeCantor);
}

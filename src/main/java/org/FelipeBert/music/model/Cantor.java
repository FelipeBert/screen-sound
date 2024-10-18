package org.FelipeBert.music.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cantores")
public class Cantor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String nacionalidade;

    @Enumerated(EnumType.STRING)
    private GeneroMusical genero;

    @Enumerated(EnumType.STRING)
    private TipoArtista tipoArtista;

    @OneToMany(mappedBy = "cantor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas = new ArrayList<>();

    public Cantor() {}

    public Cantor(String nome, String nacionalidade, String generoMusical, String tipoArtista) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.genero = GeneroMusical.fromString(generoMusical.split(",")[0].trim());
        this.tipoArtista = TipoArtista.fromString(tipoArtista.split(",")[0].trim());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public GeneroMusical getGenero() {
        return genero;
    }

    public void setGenero(GeneroMusical genero) {
        this.genero = genero;
    }

    public TipoArtista getTipoArtista() {
        return tipoArtista;
    }

    public void setTipoArtista(TipoArtista tipoArtista) {
        this.tipoArtista = tipoArtista;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        musicas.forEach(m -> m.setCantor(this));
        this.musicas = musicas;
    }
}

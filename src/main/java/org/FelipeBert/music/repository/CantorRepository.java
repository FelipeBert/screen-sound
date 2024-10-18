package org.FelipeBert.music.repository;

import org.FelipeBert.music.model.Cantor;
import org.FelipeBert.music.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CantorRepository extends JpaRepository<Cantor, Long> {
    Optional<Cantor> findByNomeContainingIgoneCase(String nome);

    @Query("SELECT m from Cantor c JOIN c.musicas m WHERE c = :cantor")
    List<Musica> listarMusicasPorCantor(Cantor cantor);
}

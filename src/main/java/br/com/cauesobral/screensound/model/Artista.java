package br.com.cauesobral.screensound.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "artista")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nomeDoArtista;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<Musica> musicas;

    @ManyToOne
    private Banda banda;

    public Artista() {
    }

    public Artista(List<Musica> musicas, String nomeDoArtista) {
        this.musicas = musicas;
        this.nomeDoArtista = nomeDoArtista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public String getNomeDoArtista() {
        return nomeDoArtista;
    }

    public void setNome(String nome) {
        this.nomeDoArtista = nome;
    }
}

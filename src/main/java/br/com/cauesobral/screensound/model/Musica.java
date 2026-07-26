package br.com.cauesobral.screensound.model;

import jakarta.persistence.*;

@Entity
@Table (name = "musica")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_da_musica")
    private String nomeDaMusica;

    @Column(name = "genero")
    private String genero;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    @Column(name = "artista")
    private Artista artista;

    public Musica() {
    }

    //Nao colocamos id no construtor porque o banco vai gerar um id automaticamente
    public Musica(String nomeDaMusica, String genero, Artista artista) {
        this.nomeDaMusica = nomeDaMusica;
        this.genero = genero;
        this.artista = artista;
    }

    public Musica(String nomeMusica) {
    }

    public Musica(String nomeMusica, String genero) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDaMusica() {
        return nomeDaMusica;
    }

    public void setNomeDaMusica(String nomeDaMusica) {
        this.nomeDaMusica = nomeDaMusica;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}

package br.com.cauesobral.screensound.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "banda")
public class Banda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_da_banda")
    private String nomeDaBanda;

    @Column(name = "genero")
    private String genero;

    @OneToMany(mappedBy = "banda", cascade = CascadeType.ALL)
    private List<Artista> artistasDaBanda;

    public Banda() {
    }

    public Banda(List<Artista> artistasDaBanda, String genero, String nomeDaBanda) {
        this.artistasDaBanda = artistasDaBanda;
        this.genero = genero;
        this.nomeDaBanda = nomeDaBanda;
    }
}

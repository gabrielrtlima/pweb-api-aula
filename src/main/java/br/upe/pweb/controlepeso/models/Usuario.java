package br.upe.pweb.controlepeso.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import javax.persistence.*;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String nome;

    private String email;
    private int altura;

    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    private double pesoInicial;
    private double pesoFinal;

    @Transient
    private LocalDate dataInicial;
    private LocalDate dataFinal;



}

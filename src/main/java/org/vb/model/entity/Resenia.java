package org.vb.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "resenias")
@EntityListeners(AuditingEntityListener.class)
public class Resenia {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "entrenador_id", nullable = false)
    private String entrenadorId;

    @Column(name = "calificacion", nullable = false)
    private Integer calificacion;

    @CreatedDate
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private Instant fechaCreacion;

    public Resenia(){}

    public Resenia(UUID id, String autor, String comentario, String entrenadorId, Integer calificacion) {
        this.id = id;
        this.autor = autor;
        this.comentario = comentario;
        this.entrenadorId = entrenadorId;
        this.calificacion = calificacion;
    }

    public UUID getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEntrenadorId() {
        return entrenadorId;
    }

    public void setEntrenadorId(String entrenadorId) {
        this.entrenadorId = entrenadorId;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public Instant getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}

package org.vb.service.utils;

import org.vb.dto.request.CreateReseniaDTO;
import org.vb.dto.response.ReseniaResponseDTO;
import org.vb.model.entity.Resenia;

import java.util.UUID;

public class TestDataFactory {
    public static final String ENTRENADOR_ID = "XyZ123abcDEF456ghiJKL789mnoPQR012stuVWX";
    public static final String ROL = "cliente";
    public static final UUID RESENIA_ID = UUID.randomUUID();
    public static final String AUTOR = "Autor Test";
    public static final String COMENTARIO = "Comentario de prueba de una reseña";

    public static CreateReseniaDTO createReseniaDTO(){
        CreateReseniaDTO dto = new CreateReseniaDTO();
        dto.setAutor(AUTOR);
        dto.setCalificacion(5);
        dto.setComentario(COMENTARIO);
        dto.setEntrenadorId(ENTRENADOR_ID);
        return dto;
    }

    public static Resenia createResenia(){
        return new Resenia(RESENIA_ID, AUTOR, COMENTARIO, ENTRENADOR_ID, 5);
    }

    public static ReseniaResponseDTO responseReseniaDTO(){
        ReseniaResponseDTO dto = new ReseniaResponseDTO();
        dto.setId(RESENIA_ID);
        dto.setAutor(AUTOR);
        dto.setCalificacion(5);
        dto.setComentario(COMENTARIO);
        dto.setEntrenadorId(ENTRENADOR_ID);
        return dto;
    }

}

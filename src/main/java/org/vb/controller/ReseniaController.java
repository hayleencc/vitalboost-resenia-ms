package org.vb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vb.dto.request.CreateReseniaDTO;
import org.vb.dto.response.ReseniaResponseDTO;
import org.vb.service.ReseniaService;

import java.util.List;

@RestController
@RequestMapping("/resenias")
public class ReseniaController {
    private final ReseniaService reseniaService;

    public ReseniaController(ReseniaService reseniaService){
        this.reseniaService = reseniaService;
    }

    @Operation(summary = "Crear una reseña")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reseña creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Ocurrió un error")
    })
    @PostMapping
    public ResponseEntity<ReseniaResponseDTO> createResenia(@Valid @RequestBody CreateReseniaDTO resenia) {
        ReseniaResponseDTO nuevaResenia = reseniaService.createResenia(resenia);
        return new ResponseEntity<>(nuevaResenia, HttpStatus.CREATED);
    }

    @Operation(summary = "Listar reseñas de un entrenador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reseñas del entrenador recuperadas correctamente")
    })
    @GetMapping("/entrenador/{entrenador_id}")
    public List<ReseniaResponseDTO> getReseniasPorEntrenador(@PathVariable String entrenador_id) {
        return reseniaService.getReseniasPorEntrenador(entrenador_id);
    }

}

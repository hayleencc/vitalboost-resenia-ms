package org.vb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vb.dto.request.CreateReseniaDTO;
import org.vb.dto.response.ReseniaResponseDTO;
import org.vb.service.ReseniaService;

@RestController
@RequestMapping("/resenias")
public class ReseniaController {
    private final ReseniaService reseniaService;

    public ReseniaController(ReseniaService reseniaService){
        this.reseniaService = reseniaService;
    }

    @Operation(summary = "Crear una resenia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resenia creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Ocurrió un error")
    })
    @PostMapping
    public ResponseEntity<ReseniaResponseDTO> createResenia(@Valid @RequestBody CreateReseniaDTO resenia) {
        ReseniaResponseDTO nuevaResenia = reseniaService.createResenia(resenia);
        return new ResponseEntity<>(nuevaResenia, HttpStatus.CREATED);
    }

}

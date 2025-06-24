package org.vb.service;

import org.springframework.stereotype.Service;
import org.vb.dto.request.CreateReseniaDTO;
import org.vb.dto.response.ReseniaResponseDTO;
import org.vb.mapper.ReseniaMapper;
import org.vb.model.entity.Resenia;
import org.vb.repository.ReseniaRepository;

import java.util.List;

@Service
public class ReseniaService {
    private final ReseniaRepository reseniaRepository;
    private final ReseniaMapper reseniaMapper;

    public ReseniaService(ReseniaRepository reseniaRepository, ReseniaMapper reseniaMapper) {
        this.reseniaRepository = reseniaRepository;
        this.reseniaMapper = reseniaMapper;
    }

    public ReseniaResponseDTO createResenia(CreateReseniaDTO resenia) {
        Resenia nuevaResenia = reseniaMapper.toEntity(resenia);
        Resenia reseniaGuardada = reseniaRepository.save(nuevaResenia);
        return reseniaMapper.toResponseDTO(reseniaGuardada);
    }

    public List<ReseniaResponseDTO> getReseniasPorEntrenador(String id) {
        List<Resenia> resenias = reseniaRepository.findByEntrenadorId(id);
        return resenias.stream()
                .map(reseniaMapper::toResponseDTO)
                .toList();
    }
}

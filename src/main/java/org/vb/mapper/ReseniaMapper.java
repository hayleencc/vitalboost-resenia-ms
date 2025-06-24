package org.vb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.vb.dto.request.CreateReseniaDTO;
import org.vb.dto.response.ReseniaResponseDTO;
import org.vb.model.entity.Resenia;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class ReseniaMapper {
    @Mapping(source = "entrenadorId", target = "entrenadorId")
    public abstract Resenia toEntity(CreateReseniaDTO reseniaDTO);
    public abstract ReseniaResponseDTO toResponseDTO(Resenia resenia);
}

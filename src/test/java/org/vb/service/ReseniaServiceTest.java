package org.vb.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.vb.dto.request.CreateReseniaDTO;
import org.vb.dto.response.ReseniaResponseDTO;
import org.vb.mapper.ReseniaMapper;
import org.vb.model.entity.Resenia;
import org.vb.repository.ReseniaRepository;
import org.vb.service.utils.TestDataFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReseniaServiceTest {

    @Mock
    private ReseniaRepository reseniaRepository;

    @Mock
    private ReseniaMapper reseniaMapper;

    @InjectMocks
    private ReseniaService reseniaService;


    @Test
    void crearResenia_sinErrores_debeRetornarResenia() {
        CreateReseniaDTO dto = TestDataFactory.createReseniaDTO();
        Resenia resenia = TestDataFactory.createResenia();
        ReseniaResponseDTO response = TestDataFactory.responseReseniaDTO();

        when(reseniaMapper.toEntity(dto)).thenReturn(resenia);
        when(reseniaRepository.save(resenia)).thenReturn(resenia);
        when(reseniaMapper.toResponseDTO(resenia)).thenReturn(response);


        ReseniaResponseDTO respuesta = reseniaService.createResenia(dto);

        assertNotNull(respuesta);
        assertEquals(resenia.getId(), respuesta.getId());
        assertEquals(resenia.getCalificacion(), respuesta.getCalificacion());
        verify(reseniaMapper).toEntity(dto);
        verify(reseniaRepository).save(resenia);
        verify(reseniaMapper).toResponseDTO(resenia);
    }

    @Test
    void crearResenia_cuandoRepositoryFalla_debePropagarExcepcion() {
        CreateReseniaDTO dto = TestDataFactory.createReseniaDTO();
        Resenia resenia = TestDataFactory.createResenia();

        when(reseniaMapper.toEntity(dto)).thenReturn(resenia);
        when(reseniaRepository.save(resenia)).thenThrow(new DataAccessException("Error DB") {});

        assertThrows(DataAccessException.class, () -> reseniaService.createResenia(dto));

        verify(reseniaMapper).toEntity(dto);
        verify(reseniaRepository).save(resenia);
        verify(reseniaMapper, never()).toResponseDTO(any());
    }
}

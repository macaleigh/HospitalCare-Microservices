package com.ms_especialidades.ms_especialidades.service;

import com.ms_especialidades.ms_especialidades.model.Especialidad;
import com.ms_especialidades.ms_especialidades.repository.EspecialidadRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EspecialidadServiceTest {

    @Mock
    private EspecialidadRepository especialidadRepository;

    @InjectMocks
    private EspecialidadService especialidadService;

    private Especialidad especialidad1;
    private Especialidad especialidad2;

    @BeforeEach
    void setUp() {
        especialidad1 = new Especialidad();
        especialidad1.setId(1);
        especialidad1.setNombre("Pediatría");
        especialidad1.setDescripcion("Atención médica de niños y adolescentes");

        especialidad2 = new Especialidad();
        especialidad2.setId(2);
        especialidad2.setNombre("Cardiología");
        especialidad2.setDescripcion("Diagnóstico y tratamiento de enfermedades del corazón");
    }

    @Test
    void findAll_deberiaRetornarListaDeEspecialidades() {
        List<Especialidad> especialidadesEsperadas = Arrays.asList(especialidad1, especialidad2);
        when(especialidadRepository.findAll()).thenReturn(especialidadesEsperadas);

        List<Especialidad> resultado = especialidadService.findAll();

        assertEquals(2, resultado.size());
        assertEquals("Pediatría", resultado.get(0).getNombre());
        verify(especialidadRepository, times(1)).findAll();
    }

    @Test
    void findById_deberiaRetornarEspecialidadCuandoExiste() {
        when(especialidadRepository.findById(1)).thenReturn(Optional.of(especialidad1));

        Especialidad resultado = especialidadService.findById(1);

        assertNotNull(resultado);
        assertEquals("Pediatría", resultado.getNombre());
        verify(especialidadRepository, times(1)).findById(1);
    }

    @Test
    void findById_deberiaLanzarExcepcionCuandoNoExiste() {
        when(especialidadRepository.findById(999)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            especialidadService.findById(999);
        });
        verify(especialidadRepository, times(1)).findById(999);
    }

    @Test
    void save_deberiaGuardarYRetornarEspecialidad() {
        when(especialidadRepository.save(any(Especialidad.class))).thenReturn(especialidad1);

        Especialidad resultado = especialidadService.save(especialidad1);

        assertNotNull(resultado);
        assertEquals("Pediatría", resultado.getNombre());
        verify(especialidadRepository, times(1)).save(especialidad1);
    }

    @Test
    void delete_deberiaLlamarDeleteByIdUnaVez() {
        doNothing().when(especialidadRepository).deleteById(1);

        especialidadService.delete(1);

        verify(especialidadRepository, times(1)).deleteById(1);
    }
}
package com.ms_medicos.ms_medicos.service;

import com.ms_medicos.ms_medicos.model.Medico;
import com.ms_medicos.ms_medicos.repository.MedicoRepository;
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
class MedicoServiceTest {

    @Mock
    private MedicoRepository medicoRepository;

    @InjectMocks
    private MedicoService medicoService;

    private Medico medico1;
    private Medico medico2;

    @BeforeEach
    void setUp() {
        medico1 = new Medico();
        medico1.setId(1);
        medico1.setNombre("Carla Fuentes");
        medico1.setEspecialidad("Pediatría");
        medico1.setCorreo("carla.fuentes@hospital.cl");

        medico2 = new Medico();
        medico2.setId(2);
        medico2.setNombre("Jorge Rivas");
        medico2.setEspecialidad("Cardiología");
        medico2.setCorreo("jorge.rivas@hospital.cl");
    }

    @Test
    void findAll_deberiaRetornarListaDeMedicos() {
        List<Medico> medicosEsperados = Arrays.asList(medico1, medico2);
        when(medicoRepository.findAll()).thenReturn(medicosEsperados);

        List<Medico> resultado = medicoService.findAll();

        assertEquals(2, resultado.size());
        assertEquals("Carla Fuentes", resultado.get(0).getNombre());
        verify(medicoRepository, times(1)).findAll();
    }

    @Test
    void findById_deberiaRetornarMedicoCuandoExiste() {
        when(medicoRepository.findById(1)).thenReturn(Optional.of(medico1));

        Medico resultado = medicoService.findById(1);

        assertNotNull(resultado);
        assertEquals("Carla Fuentes", resultado.getNombre());
        assertEquals("Pediatría", resultado.getEspecialidad());
        verify(medicoRepository, times(1)).findById(1);
    }

    @Test
    void findById_deberiaLanzarExcepcionCuandoNoExiste() {
        when(medicoRepository.findById(999)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            medicoService.findById(999);
        });
        verify(medicoRepository, times(1)).findById(999);
    }

    @Test
    void save_deberiaGuardarYRetornarMedico() {
        when(medicoRepository.save(any(Medico.class))).thenReturn(medico1);

        Medico resultado = medicoService.save(medico1);

        assertNotNull(resultado);
        assertEquals("Carla Fuentes", resultado.getNombre());
        verify(medicoRepository, times(1)).save(medico1);
    }
}
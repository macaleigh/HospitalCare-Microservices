package com.db_hospital_vm.db_hospital_vm.service;

import com.db_hospital_vm.db_hospital_vm.model.Paciente;
import com.db_hospital_vm.db_hospital_vm.repository.PacienteRepository;
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
class PacienteServiceTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteService pacienteService;

    private Paciente paciente1;
    private Paciente paciente2;

    @BeforeEach
    void setUp() {
        paciente1 = new Paciente();
        paciente1.setId(1);
        paciente1.setRun("11111111-1");
        paciente1.setNombre("Ana");
        paciente1.setApellido("Soto");
        paciente1.setCorreo("ana.soto@example.com");

        paciente2 = new Paciente();
        paciente2.setId(2);
        paciente2.setRun("22222222-2");
        paciente2.setNombre("Luis");
        paciente2.setApellido("Perez");
        paciente2.setCorreo("luis.perez@example.com");
    }

    @Test
    void findAll_deberiaRetornarListaDePacientes() {
        List<Paciente> pacientesEsperados = Arrays.asList(paciente1, paciente2);
        when(pacienteRepository.findAll()).thenReturn(pacientesEsperados);

        List<Paciente> resultado = pacienteService.findAll();

        assertEquals(2, resultado.size());
        assertEquals("Ana", resultado.get(0).getNombre());
        verify(pacienteRepository, times(1)).findAll();
    }

    @Test
    void findById_deberiaRetornarPacienteCuandoExiste() {
        when(pacienteRepository.findById(1)).thenReturn(Optional.of(paciente1));

        Paciente resultado = pacienteService.findById(1);

        assertNotNull(resultado);
        assertEquals("Ana", resultado.getNombre());
        assertEquals("11111111-1", resultado.getRun());
        verify(pacienteRepository, times(1)).findById(1);
    }

    @Test
    void findById_deberiaLanzarExcepcionCuandoNoExiste() {
        when(pacienteRepository.findById(999)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            pacienteService.findById(999);
        });
        verify(pacienteRepository, times(1)).findById(999);
    }

    @Test
    void save_deberiaGuardarYRetornarPaciente() {
        when(pacienteRepository.save(any(Paciente.class))).thenReturn(paciente1);

        Paciente resultado = pacienteService.save(paciente1);

        assertNotNull(resultado);
        assertEquals("Ana", resultado.getNombre());
        verify(pacienteRepository, times(1)).save(paciente1);
    }

    @Test
    void delete_deberiaLlamarDeleteByIdUnaVez() {
        doNothing().when(pacienteRepository).deleteById(1);

        pacienteService.delete(1);

        verify(pacienteRepository, times(1)).deleteById(1);
    }
}
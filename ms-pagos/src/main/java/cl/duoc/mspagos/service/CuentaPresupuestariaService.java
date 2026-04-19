package cl.duoc.mspagos.service;

import org.springframework.stereotype.Service;

import cl.duoc.mspagos.model.CuentaPresupuestaria;
import cl.duoc.mspagos.repository.CuentaPresupuestariaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CuentaPresupuestariaService {

    private final CuentaPresupuestariaRepository cPstoRepository;

    public CuentaPresupuestaria obtenerCuentaPresupuestariaPorId(Long id) {
        return cPstoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta Presupuestaria no encontrada"));
    }
    
}

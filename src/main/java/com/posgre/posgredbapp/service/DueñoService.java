package com.posgre.posgredbapp.service;

import com.posgre.posgredbapp.DTO.DueñoMascotaDTO;
import com.posgre.posgredbapp.model.Dueño;
import com.posgre.posgredbapp.repository.IDueñoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DueñoService implements IDueñoService{

    @Autowired
    private IDueñoRepository dueñoRepository;

    @Override
    public List<Dueño> getDueños() {
        return dueñoRepository.findAll();
    }

    @Override
    public void createDueño(Dueño dueño) {
        dueñoRepository.save(dueño);

    }

    @Override
    public void deleteDueño(Long id_dueño) {
        dueñoRepository.deleteById(id_dueño);
    }

    @Override
    public Dueño findDueño(Long id_dueño) {
       Dueño dueñoEncontrado =  dueñoRepository.findById(id_dueño).orElse(null);
        return dueñoEncontrado;
    }

    @Override
    public void editDueño(Dueño dueño) {
        Dueño dueñoEncontrado = this.findDueño(dueño.getId_dueño());

        dueñoEncontrado.setDni(dueño.getDni());
        dueñoEncontrado.setNombre(dueño.getNombre());
        dueñoEncontrado.setApellido(dueño.getApellido());
        dueñoEncontrado.setCelular(dueño.getCelular());

        this.createDueño(dueñoEncontrado);
    }


    @Override
    public DueñoMascotaDTO mascotaDeDueño(Long id_dueño) {
        DueñoMascotaDTO dueñoMascotaDTO = new DueñoMascotaDTO();

        Dueño dueño = this.findDueño(id_dueño);

        dueñoMascotaDTO.setNombre_mascota(dueño.getMascota().getNombre());
        dueñoMascotaDTO.setEspecie(dueño.getMascota().getEspecie());
        dueñoMascotaDTO.setRaza(dueño.getMascota().getRaza());
        dueñoMascotaDTO.setNombre_dueño(dueño.getNombre());
        dueñoMascotaDTO.setApellido_dueño(dueño.getApellido());

        return dueñoMascotaDTO;
    }
}
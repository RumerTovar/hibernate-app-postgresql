package com.posgre.posgredbapp.service;

import com.posgre.posgredbapp.model.Mascota;
import com.posgre.posgredbapp.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaService implements IMascotaService{


    @Autowired
    private IMascotaRepository mascotaRepository;

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> mascotas = mascotaRepository.findAll();
        return mascotas;
    }

    @Override
    public void createMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        mascotaRepository.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        Mascota mascotaEncontrada = mascotaRepository.findById(id_mascota).orElse(null);
        return mascotaEncontrada;
    }

    @Override
    public void editMascota(Mascota mascota) {
        Mascota mascotaEncontada = this.findMascota(mascota.getId_mascota());

        mascotaEncontada.setNombre(mascota.getNombre());
        mascotaEncontada.setEspecie(mascota.getEspecie());
        mascotaEncontada.setRaza(mascota.getRaza());
        mascotaEncontada.setColor(mascota.getColor());

        this.createMascota(mascotaEncontada);
    }

    @Override
    public List<Mascota> findByRaceAndSpicies(String especie, String raza) {
        List<Mascota> mascotaList = this.getMascotas();
        List<Mascota> filterMascotas = new ArrayList<>();

        for (Mascota mascota : mascotaList){
            String compararEspecie = mascota.getEspecie();
            String compararRaza = mascota.getRaza();
            boolean containEspecie = compararEspecie.contains(especie);
            boolean containRaza = compararRaza.contains(raza);

            if(containEspecie == true && containRaza == true){
                filterMascotas.add(mascota);
            }
        }

        return filterMascotas;
    }
}

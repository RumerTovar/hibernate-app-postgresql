package com.posgre.posgredbapp.service;


import com.posgre.posgredbapp.model.Mascota;

import java.util.List;

public interface IMascotaService {
    public List<Mascota> getMascotas();

    public void createMascota(Mascota mascota);

    public void deleteMascota(Long id_mascota);

    public Mascota findMascota(Long id_mascota);

    public void editMascota(Mascota mascota);

    public List<Mascota> findByRaceAndSpicies(String especie, String raza);
}


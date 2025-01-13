package com.posgre.posgredbapp.controller;

import com.posgre.posgredbapp.model.Mascota;
import com.posgre.posgredbapp.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {

    @Autowired
    private IMascotaService mascotaService;

    @PostMapping("/mascota/crear")
    private String crearMascota(@RequestBody Mascota mascota){
        mascotaService.createMascota(mascota);
        return "Mascota creada correctamente";
    }

    @GetMapping("/mascotas")
    private List<Mascota> getMascotas(){
        return mascotaService.getMascotas();
    }

    @GetMapping("/mascota/{id_mascota}")
    private Mascota getMascota(@PathVariable Long id_mascota){
        return mascotaService.findMascota(id_mascota);
    }

    @PutMapping("/mascota/edit")
    private String editarMascota(@RequestBody Mascota mascota){
        mascotaService.editMascota(mascota);
        return "mascota editada correctamente";
    }

    @DeleteMapping("/mascota/delete/{id_mascota}")
    private String eliminarMascota(@PathVariable Long id_mascota){
        mascotaService.deleteMascota(id_mascota);
        return "mascota eliminada correctamente";
    }


}

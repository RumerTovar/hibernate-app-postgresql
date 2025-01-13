package com.posgre.posgredbapp.controller;

import com.posgre.posgredbapp.DTO.DueñoMascotaDTO;
import com.posgre.posgredbapp.model.Dueño;
import com.posgre.posgredbapp.service.IDueñoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DueñoController {

    @Autowired
    private IDueñoService dueñoService;

    @PostMapping("/dueño/crear")
    public String crearDueño(@RequestBody Dueño dueño){
        dueñoService.createDueño(dueño);
        return "Dueño creado correctamente";
    }

    @GetMapping("/dueño/{id_dueño}")
    public Dueño getDueño(@PathVariable Long id_dueño){
        Dueño dueño = dueñoService.findDueño(id_dueño);
        return dueño;
    }

    @GetMapping("/dueños")
    public List<Dueño> getDueños(){
        return dueñoService.getDueños();
    }

    @PutMapping("/dueño/edit")
    public String editDueño(@RequestBody Dueño dueño){
        dueñoService.editDueño(dueño);

        return "Dueño editado correctamente";
    }

    @DeleteMapping("/dueño/delete/{id_dueño}")
    public String deleteDueño(@PathVariable Long id_dueño){
        dueñoService.deleteDueño(id_dueño);

        return "Dueño eliminado correctamente";
    }
    @ResponseBody
    @GetMapping("/dueño/mascotaDeDueño/{id_dueño}")
    public DueñoMascotaDTO mascotaDeDueño(@PathVariable Long id_dueño){
        DueñoMascotaDTO dueñoMascotaDTO = dueñoService.mascotaDeDueño(id_dueño);

        return dueñoMascotaDTO;
    }
}

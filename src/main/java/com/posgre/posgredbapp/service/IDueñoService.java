package com.posgre.posgredbapp.service;

import com.posgre.posgredbapp.DTO.DueñoMascotaDTO;
import com.posgre.posgredbapp.model.Dueño;

import java.util.List;

public interface IDueñoService {
    public List<Dueño> getDueños();

    public void createDueño(Dueño dueño);

    public void deleteDueño(Long id_dueño);

    public Dueño findDueño(Long id_dueño);

    public void editDueño(Dueño dueño);

    public DueñoMascotaDTO mascotaDeDueño(Long id_dueño);
}

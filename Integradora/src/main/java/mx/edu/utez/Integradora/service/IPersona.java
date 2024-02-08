package mx.edu.utez.Integradora.service;

import mx.edu.utez.Integradora.model.dto.PersonaDto;
import mx.edu.utez.Integradora.model.entidad.PersonaBean;

import java.util.List;

public interface IPersona {
    PersonaBean save(PersonaDto persona);

    PersonaBean findById(Integer id);

    List<PersonaBean> findAll();
    void delete(PersonaBean persona);
}

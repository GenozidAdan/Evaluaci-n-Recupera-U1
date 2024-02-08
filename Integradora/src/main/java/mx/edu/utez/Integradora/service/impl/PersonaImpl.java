package mx.edu.utez.Integradora.service.impl;

import mx.edu.utez.Integradora.model.dao.PersonaDao;
import mx.edu.utez.Integradora.model.dto.PersonaDto;
import mx.edu.utez.Integradora.model.entidad.PersonaBean;
import mx.edu.utez.Integradora.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaImpl implements IPersona {

    @Autowired
    private PersonaDao personaDao;


    @Override
    public PersonaBean save(PersonaDto personaDto) {
        PersonaBean persona = PersonaBean.builder()
                .idpersona(personaDto.getIdpersona())
                .nombre(personaDto.getNombre())
                .apellido(personaDto.getApellido())
                .correo(personaDto.getCorreo())
                .telefono(personaDto.getTelefono())
                .direccion(personaDto.getDireccion())
                .build();
        return personaDao.save(persona);
    }

    @Override
    public PersonaBean findById(Integer id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    public List<PersonaBean> findAll() {
        return (List<PersonaBean>) personaDao.findAll();
    }

    @Override
    public void delete(PersonaBean persona) {
        personaDao.delete(persona);

    }
}

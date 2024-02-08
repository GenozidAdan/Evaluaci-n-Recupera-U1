package mx.edu.utez.Integradora.service;

import mx.edu.utez.Integradora.model.dto.PersonaDto;
import mx.edu.utez.Integradora.model.dto.UsuarioDto;
import mx.edu.utez.Integradora.model.entidad.PersonaBean;
import mx.edu.utez.Integradora.model.entidad.UsuarioBean;

import java.util.List;

public interface IUsuario {

    UsuarioBean save(UsuarioDto usuario);

    UsuarioBean findById(Integer id);

    List<UsuarioBean> findAll();

    void delete(UsuarioBean usuario);

}

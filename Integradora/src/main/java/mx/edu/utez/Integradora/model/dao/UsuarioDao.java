package mx.edu.utez.Integradora.model.dao;

import mx.edu.utez.Integradora.model.entidad.UsuarioBean;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<UsuarioBean, Integer>{
}

package mx.edu.utez.Integradora.model.dao;

import mx.edu.utez.Integradora.model.entidad.PersonaBean;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<PersonaBean, Integer> {
}

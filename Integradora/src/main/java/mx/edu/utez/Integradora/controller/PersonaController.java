package mx.edu.utez.Integradora.controller;

import lombok.AllArgsConstructor;
import mx.edu.utez.Integradora.model.dto.PersonaDto;
import mx.edu.utez.Integradora.model.entidad.PersonaBean;
import mx.edu.utez.Integradora.service.IPersona;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/persona")
public class PersonaController {
    private final IPersona personaService;


    @GetMapping("/")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<PersonaBean> getPersona() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public PersonaBean showById(@PathVariable Integer id) {
        return personaService.findById(id);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void delete(@PathVariable Integer id){
        PersonaBean persona = personaService.findById(id);
        personaService.delete(persona);
    }

    @PostMapping("/")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public PersonaDto create(@RequestBody PersonaDto personaDto){
        PersonaBean personaSave = personaService.save(personaDto);
        return PersonaDto.builder()
                .idpersona(personaSave.getIdpersona())
                .nombre(personaSave.getNombre())
                .apellido(personaSave.getApellido())
                .correo(personaSave.getCorreo())
                .telefono(personaSave.getTelefono())
                .direccion(personaSave.getDireccion())
                .build();
    }

    @PutMapping("/put")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public PersonaDto update(@RequestBody PersonaDto personaDto){
        PersonaBean personaUpdate = personaService.save(personaDto);
        return PersonaDto.builder()
                .idpersona(personaDto.getIdpersona())
                .nombre(personaDto.getNombre())
                .apellido(personaDto.getApellido())
                .correo(personaDto.getCorreo())
                .telefono(personaDto.getTelefono())
                .direccion(personaDto.getDireccion())
                .build();
    }
}



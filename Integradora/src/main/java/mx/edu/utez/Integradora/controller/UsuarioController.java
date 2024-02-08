package mx.edu.utez.Integradora.controller;

import lombok.AllArgsConstructor;
import mx.edu.utez.Integradora.model.dto.PersonaDto;
import mx.edu.utez.Integradora.model.dto.UsuarioDto;
import mx.edu.utez.Integradora.model.entidad.PersonaBean;
import mx.edu.utez.Integradora.model.entidad.UsuarioBean;
import mx.edu.utez.Integradora.service.IPersona;
import mx.edu.utez.Integradora.service.IUsuario;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    private final IUsuario usuarioService;

    @GetMapping("/")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<UsuarioBean> getUsuario() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public UsuarioBean showById(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void delete(@PathVariable Integer id){
        UsuarioBean usuario = usuarioService.findById(id);
        usuarioService.delete(usuario);
    }



    @PostMapping("/")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public UsuarioBean create(@RequestBody UsuarioDto usuarioDto) {
        String password = generarpass();

        usuarioDto.setPassword(password);
        UsuarioBean usuarioSave = usuarioService.save(usuarioDto);

        return UsuarioBean.builder()
                .idusuario(usuarioSave.getIdusuario())
                .username(usuarioSave.getUsername())
                .estado(usuarioSave.isEstado())
                .password(usuarioSave.getPassword())
                .build();
    }

    private String generarpass() {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCase = abc.toLowerCase();
        String numbers = "0123456789";
        String special = "!@#$%^&*()-_=+{}[]|;:',.<>?";

        String pass = abc + lowerCase + numbers + special;

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(pass.length());
            password.append(pass.charAt(randomIndex));
        }

        return password.toString();
    }



    @PutMapping("/put")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public UsuarioBean update(@RequestBody UsuarioDto usuarioDto){
        UsuarioBean usuarioUpdate = usuarioService.save(usuarioDto);
        return UsuarioBean.builder()
                .idusuario(usuarioDto.getIdusuario())
                .username(usuarioDto.getUsername())
                .estado(usuarioDto.isEstado())
                .password(usuarioDto.getPassword())
                .build();
    }
}

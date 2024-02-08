package mx.edu.utez.Integradora.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDto {
    private Integer idusuario;
    private String username;
    private boolean estado;
    private String password;
}

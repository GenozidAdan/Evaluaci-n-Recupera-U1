package mx.edu.utez.Integradora.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonaDto {
    private Integer idpersona;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
}

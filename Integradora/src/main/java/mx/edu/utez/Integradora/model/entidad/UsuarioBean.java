package mx.edu.utez.Integradora.model.entidad;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class UsuarioBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario", nullable = false)
    private Integer idusuario;
    @Column(name = "username", nullable = false, length = 45, unique = true)
    private String username;
    @Column(name = "estado", nullable = false)
    private boolean estado;
    @Column(name = "password", nullable = false, length = 60, unique = true)
    private String password;

}

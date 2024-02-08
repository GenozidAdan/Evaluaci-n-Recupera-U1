package mx.edu.utez.Integradora.model.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "persona")
public class PersonaBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpersona", nullable = false)
    private Integer idpersona;
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;
    @Column(name = "correo", nullable = false, length = 45)
    private String correo;
    @Column(name = "telefono", nullable = false, length = 45)
    private String telefono;
    @Column(name = "direccion", nullable = false, length = 45)
    private String direccion;

}

package upeu.edu.pe.hst.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "emergencias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emergencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nombreCompleto;

    @Column(nullable = false, length = 200)
    private String doctorAsignado;

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @Column(nullable = false, length = 50)
    private String estadoSalud;

    @Column(length = 1000)
    private String observaciones;
}

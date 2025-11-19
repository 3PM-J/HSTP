package upeu.edu.pe.hst.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Table(name = "doctores", charset = "utf8mb4", collate = "utf8mb4_unicode_ci")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, columnDefinition = "VARCHAR(100) CHARSET utf8mb4")
    private String nombre;

    @Column(nullable = false, length = 100, columnDefinition = "VARCHAR(100) CHARSET utf8mb4")
    private String apellido;

    @Column(nullable = false, unique = true, length = 8, columnDefinition = "VARCHAR(8) CHARSET utf8mb4")
    private String dni;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false, length = 20, columnDefinition = "VARCHAR(20) CHARSET utf8mb4")
    private String genero;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50) CHARSET utf8mb4")
    private String estadoCivil;

    @Column(length = 200, columnDefinition = "VARCHAR(200) CHARSET utf8mb4")
    private String universidad;

    @Column(nullable = false, length = 15, columnDefinition = "VARCHAR(15) CHARSET utf8mb4")
    private String telefono;

    @Column(nullable = false, length = 100, columnDefinition = "VARCHAR(100) CHARSET utf8mb4")
    private String email;

    @Column(nullable = false, length = 200, columnDefinition = "VARCHAR(200) CHARSET utf8mb4")
    private String direccion;

    @Column(nullable = false, length = 100, columnDefinition = "VARCHAR(100) CHARSET utf8mb4")
    private String especialidad;

    @Column(nullable = false, unique = true, length = 50, columnDefinition = "VARCHAR(50) CHARSET utf8mb4")
    private String numeroLicencia;

    @Column(nullable = false)
    private Integer anosExperiencia;

    @Column(columnDefinition = "LONGTEXT CHARSET utf8mb4")
    private String observaciones;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Integer getEdad() {
        if (fechaNacimiento == null) {
            return null;
        }
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}

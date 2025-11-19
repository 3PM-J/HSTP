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
@Table(name = "pacientes", charset = "utf8mb4", collate = "utf8mb4_unicode_ci")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

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

    @Column(nullable = false, length = 10, columnDefinition = "VARCHAR(10) CHARSET utf8mb4")
    private String tipoSangre;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50) CHARSET utf8mb4")
    private String estadoCivil;

    @Column(length = 100, columnDefinition = "VARCHAR(100) CHARSET utf8mb4")
    private String ocupacion;

    @Column(nullable = false, length = 15, columnDefinition = "VARCHAR(15) CHARSET utf8mb4")
    private String telefono;

    @Column(nullable = false, length = 200, columnDefinition = "VARCHAR(200) CHARSET utf8mb4")
    private String direccion;

    @Column(nullable = false, length = 100, columnDefinition = "VARCHAR(100) CHARSET utf8mb4")
    private String contactoEmergencia;

    @Column(nullable = false, length = 15, columnDefinition = "VARCHAR(15) CHARSET utf8mb4")
    private String telefonoEmergencia;

    @Column(nullable = false, length = 100, columnDefinition = "VARCHAR(100) CHARSET utf8mb4")
    private String caso;

    @Column(length = 500, columnDefinition = "VARCHAR(500) CHARSET utf8mb4")
    private String alergias;

    @Column(length = 500, columnDefinition = "VARCHAR(500) CHARSET utf8mb4")
    private String medicamentos;

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

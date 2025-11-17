package upeu.edu.pe.hst.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "pacientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, unique = true, length = 8)
    private String dni;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false, length = 20)
    private String genero;

    @Column(nullable = false, length = 10)
    private String tipoSangre;

    @Column(nullable = false, length = 50)
    private String estadoCivil;

    @Column(length = 100)
    private String ocupacion;

    @Column(nullable = false, length = 15)
    private String telefono;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(nullable = false, length = 100)
    private String contactoEmergencia;

    @Column(nullable = false, length = 15)
    private String telefonoEmergencia;

    @Column(nullable = false, length = 100)
    private String caso;

    @Column(length = 500)
    private String alergias;

    @Column(length = 500)
    private String medicamentos;

    @Column(length = 1000)
    private String observaciones;

    public Integer getEdad() {
        if (fechaNacimiento == null) {
            return null;
        }
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}

package upeu.edu.pe.hst.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "emergencias", charset = "utf8mb4", collate = "utf8mb4_unicode_ci")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emergencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200, columnDefinition = "VARCHAR(200) CHARSET utf8mb4")
    private String nombreCompleto;

    @Column(nullable = false, length = 200, columnDefinition = "VARCHAR(200) CHARSET utf8mb4")
    private String doctorAsignado;

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @Column(nullable = false, length = 50, columnDefinition = "VARCHAR(50) CHARSET utf8mb4")
    private String estadoSalud;

    @Column(columnDefinition = "LONGTEXT CHARSET utf8mb4")
    private String observaciones;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}

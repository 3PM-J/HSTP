-- Crear base de datos
CREATE DATABASE IF NOT EXISTS hst_db;
USE hst_db;

-- Tabla de Pacientes
CREATE TABLE IF NOT EXISTS pacientes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    dni VARCHAR(8) UNIQUE NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    genero VARCHAR(20) NOT NULL,
    tipo_sangre VARCHAR(10) NOT NULL,
    estado_civil VARCHAR(50) NOT NULL,
    ocupacion VARCHAR(100),
    telefono VARCHAR(15) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    contacto_emergencia VARCHAR(100) NOT NULL,
    telefono_emergencia VARCHAR(15) NOT NULL,
    caso VARCHAR(100) NOT NULL,
    alergias VARCHAR(500),
    medicamentos VARCHAR(500),
    observaciones LONGTEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla de Doctores
CREATE TABLE IF NOT EXISTS doctores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    dni VARCHAR(8) UNIQUE NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    genero VARCHAR(20) NOT NULL,
    estado_civil VARCHAR(50) NOT NULL,
    universidad VARCHAR(200),
    telefono VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    numero_licencia VARCHAR(50) UNIQUE NOT NULL,
    anos_experiencia INT NOT NULL,
    observaciones LONGTEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tabla de Emergencias
CREATE TABLE IF NOT EXISTS emergencias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_completo VARCHAR(200) NOT NULL,
    doctor_asignado VARCHAR(200) NOT NULL,
    fecha_hora DATETIME NOT NULL,
    estado_salud VARCHAR(50) NOT NULL,
    observaciones LONGTEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Indices para mejorar el rendimiento
CREATE INDEX idx_pacientes_dni ON pacientes(dni);
CREATE INDEX idx_pacientes_nombre ON pacientes(nombre, apellido);
CREATE INDEX idx_doctores_dni ON doctores(dni);
CREATE INDEX idx_doctores_especialidad ON doctores(especialidad);
CREATE INDEX idx_emergencias_fecha ON emergencias(fecha_hora);
CREATE INDEX idx_emergencias_estado ON emergencias(estado_salud);

-- Datos de ejemplo para Doctores
INSERT INTO doctores (nombre, apellido, dni, fecha_nacimiento, genero, estado_civil, universidad, telefono, email, direccion, especialidad, numero_licencia, anos_experiencia, observaciones)
VALUES
    ('Carlos', 'Rodriguez', '12345678', '1980-05-15', 'Masculino', 'Casado/a', 'Universidad Nacional Mayor de San Marcos', '987654321', 'carlos.rodriguez@hospital.com', 'Av. Principal 123', 'Medicina General', 'LIC-2024-001', 15, 'Doctor con amplia experiencia en medicina general'),
    ('Maria', 'Gonzalez', '87654321', '1985-08-20', 'Femenino', 'Soltero/a', 'Universidad Peruana Cayetano Heredia', '987654322', 'maria.gonzalez@hospital.com', 'Jr. Salud 456', 'Cardiología', 'LIC-2024-002', 10, 'Especialista en enfermedades cardiovasculares'),
    ('Juan', 'Perez', '45678912', '1978-03-10', 'Masculino', 'Casado/a', 'Universidad Nacional de Trujillo', '987654323', 'juan.perez@hospital.com', 'Calle Medica 789', 'Pediatría', 'LIC-2024-003', 18, 'Especialista en salud infantil');

-- Datos de ejemplo para Pacientes
INSERT INTO pacientes (nombre, apellido, dni, fecha_nacimiento, genero, tipo_sangre, estado_civil, ocupacion, telefono, direccion, contacto_emergencia, telefono_emergencia, caso, alergias, medicamentos, observaciones)
VALUES
    ('Ana', 'Lopez', '11223344', '1990-06-15', 'Femenino', 'O+', 'Soltero/a', 'Ingeniera', '912345678', 'Av. Los Alamos 123', 'Pedro Lopez', '923456789', 'Consulta General', 'Ninguna conocida', 'Ninguno', 'Paciente en buen estado general'),
    ('Luis', 'Martinez', '22334455', '1975-12-20', 'Masculino', 'A+', 'Casado/a', 'Contador', '934567890', 'Jr. Las Flores 456', 'Carmen Martinez', '945678901', 'Cardiología', 'Penicilina', 'Enalapril, Aspirina', 'Control de presión arterial'),
    ('Sofia', 'Garcia', '33445566', '2015-03-08', 'Femenino', 'B+', 'Soltero/a', 'Estudiante', '956789012', 'Calle Los Pinos 789', 'Rosa Garcia', '967890123', 'Pediatría', 'Polen', 'Ninguno', 'Control de rutina');

-- Datos de ejemplo para Emergencias
INSERT INTO emergencias (nombre_completo, doctor_asignado, fecha_hora, estado_salud, observaciones)
VALUES
    ('Roberto Sanchez', 'Carlos Rodriguez - Medicina General', '2025-01-15 14:30:00', 'Estable', 'Paciente atendido por dolor abdominal'),
    ('Isabel Torres', 'Maria Gonzalez - Cardiología', '2025-01-15 16:45:00', 'Crítico', 'Paciente con arritmia cardiaca'),
    ('Miguel Ramirez', 'Juan Perez - Pediatría', '2025-01-15 18:20:00', 'Grave', 'Menor con fiebre alta');

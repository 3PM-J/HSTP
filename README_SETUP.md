# Sistema RegHost - Guía de Configuración

## Solución del Error "Error starting ApplicationContext"

Este documento explica cómo resolver el error de inicio de la aplicación Spring Boot.

### Pasos de Configuración:

#### 1. Instalar MySQL
Descargar e instalar MySQL 8.0 o superior desde: https://dev.mysql.com/downloads/mysql/

#### 2. Iniciar MySQL
**Windows:**
```bash
net start MySQL80
```

**Linux:**
```bash
sudo service mysql start
```

**Mac (Homebrew):**
```bash
brew services start mysql
```

#### 3. Crear la Base de Datos

**Opción A - Automática (Recomendado):**
```bash
cd hst
mysql -u root -p < database/init.sql
```

Ingrese la contraseña de MySQL (dejar en blanco si no tiene contraseña).

**Opción B - Manual:**
```bash
mysql -u root -p
```

Luego ejecutar en MySQL:
```sql
CREATE DATABASE hst_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE hst_db;
```

Luego copiar y pegar el contenido de `database/init.sql`

#### 4. Configurar Variables de Entorno

**Archivo: .env**
```
DATABASE_URL=jdbc:mysql://localhost:3306/hst_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true
DATABASE_USERNAME=root
DATABASE_PASSWORD=
```

Cambiar `DATABASE_PASSWORD` por su contraseña de MySQL si la tiene.

#### 5. Compilar el Proyecto
```bash
cd hst
./mvnw clean install
```

#### 6. Ejecutar la Aplicación
```bash
./mvnw spring-boot:run
```

#### 7. Acceder a la Aplicación
Abra su navegador y vaya a: `http://localhost:8080`

### Credenciales de Prueba

| Usuario | Contraseña |
|---------|-----------|
| admin   | admin123  |
| user    | user123   |

### Solución de Problemas

Si encuentra el error "Error starting ApplicationContext", consulte: `TROUBLESHOOTING.md`

### Archivos Importantes

- **INSTRUCCIONES.txt** - Descripción general del proyecto
- **TROUBLESHOOTING.md** - Guía de problemas comunes
- **database/schema.sql** - Script SQL principal
- **database/init.sql** - Script SQL alternativo
- **.env** - Variables de entorno

### Características del Sistema

- Gestión de Pacientes
- Gestión de Doctores
- Gestión de Emergencias
- Autenticación y Seguridad
- Base de datos MySQL
- Interfaz web con Thymeleaf

### Requisitos Mínimos

- Java 17 o superior
- MySQL 8.0 o superior
- Maven 3.6 o superior

### Puertos Utilizados

- Aplicación: 8080
- MySQL: 3306

### Base de Datos

- Nombre: hst_db
- Charset: utf8mb4
- Collation: utf8mb4_unicode_ci
- Tablas: pacientes, doctores, emergencias

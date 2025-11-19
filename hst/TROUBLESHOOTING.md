# Guía de Solución de Problemas - HST

## Error: Error starting ApplicationContext

Este error generalmente indica que hay un problema de conexión con la base de datos o configuración.

### Soluciones:

#### 1. Verificar que MySQL está corriendo
```bash
# En Windows
net start MySQL80

# En Linux/Mac
sudo service mysql start
# o
brew services start mysql
```

#### 2. Verificar que la base de datos existe
```bash
mysql -u root -p
> SHOW DATABASES;
> USE hst_db;
```

Si no existe, crear la base de datos:
```bash
mysql -u root -p < database/schema.sql
```

#### 3. Verificar las credenciales en .env
```
DATABASE_URL=jdbc:mysql://localhost:3306/hst_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true
DATABASE_USERNAME=root
DATABASE_PASSWORD=(tu_contraseña)
```

#### 4. Ejecutar con debug
```bash
./mvnw spring-boot:run -Ddebug
```

Esto mostrará más detalles del error en la consola.

#### 5. Verificar el puerto
Asegúrese de que MySQL está en el puerto 3306:
```bash
mysql -u root -p -e "SELECT @@port;"
```

#### 6. Limpiar caché de Maven
```bash
./mvnw clean
./mvnw install
```

#### 7. Revisar los logs
- Busque mensajes de "Connection refused"
- Busque mensajes de "Access denied"
- Busque mensajes de "Unknown database"

## Error: Access denied for user 'root'@'localhost'

La contraseña de MySQL es incorrecta o no hay contraseña.

```bash
# Si MySQL no tiene contraseña
DATABASE_PASSWORD=

# Si tiene contraseña
DATABASE_PASSWORD=tu_contraseña_aqui
```

## Error: Unknown database 'hst_db'

La base de datos no existe. Crearla con:
```bash
mysql -u root -p < database/schema.sql
```

O manualmente:
```bash
mysql -u root -p
> CREATE DATABASE hst_db;
> USE hst_db;
```

## Puerto 8080 ya está en uso

Cambiar el puerto en application.properties:
```properties
server.port=8081
```

O matar el proceso que ocupa el puerto:
```bash
# En Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# En Linux/Mac
lsof -i :8080
kill -9 <PID>
```

## La aplicación se inicia pero las páginas están en blanco

Verificar que los archivos HTML están en:
```
src/main/resources/templates/
```

Asegúrese de que existen los archivos:
- Login.html
- menu.html
- pacientes/lista_pacientes.html
- pacientes/nuevo_paciente.html
- pacientes/editar_paciente.html
- doctores/lista_doctores.html
- doctores/nuevo_doctor.html
- doctores/editar_doctor.html
- emergencias/lista_emergencias.html
- emergencias/nueva_emergencia.html
- emergencias/editar_emergencia.html

## No puede iniciar sesión

Usuarios predefinidos:
- Usuario: admin
- Contraseña: admin123

O:
- Usuario: user
- Contraseña: user123

## Las tablas no se crean automáticamente

Verificar que en application.properties está configurado:
```properties
spring.jpa.hibernate.ddl-auto=update
```

Si aún no funciona, crear manualmente las tablas con:
```bash
mysql -u root -p hst_db < database/schema.sql
```

## Error de charset o caracteres especiales

Verificar que la base de datos usa utf8mb4:
```bash
mysql -u root -p -e "ALTER DATABASE hst_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;"
```

## El compilador no encuentra las clases

Ejecutar:
```bash
./mvnw clean compile
```

Si persiste el error, verificar que:
1. Java 17 o superior está instalado
2. JAVA_HOME está configurado correctamente
3. Maven está actualizado

## Otros problemas

Si el problema persiste:

1. Eliminar la carpeta `target`:
```bash
rm -rf target
```

2. Reinstalar dependencias:
```bash
./mvnw clean install
```

3. Reiniciar la aplicación:
```bash
./mvnw spring-boot:run
```

4. Revisar que MySQL está corriendo y accesible

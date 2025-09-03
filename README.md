# SecureUserApi

Una API REST profesional para gestión segura de usuarios con autenticación JWT, construida con tecnologías modernas de Spring Boot.

## 📋 Propósito del Proyecto

Esta aplicación proporciona un sistema completo de autenticación y gestión de usuarios con las siguientes características:

- **Registro de usuarios** con validación de datos
- **Autenticación** mediante credenciales (username/email y contraseña)
- **Autorización** basada en roles (RBAC - Role Based Access Control)
- **Tokens JWT** para sesiones seguras y stateless
- **Refresh tokens** para renovación automática de sesiones
- **Encriptación de contraseñas** con BCrypt
- **Documentación automática** de la API con Swagger/OpenAPI

## 🛠️ Tecnologías Utilizadas

### Backend Framework
- **Spring Boot 3.2.6** - Framework principal de aplicación
- **Java 17** - Lenguaje de programación
- **Maven** - Gestión de dependencias y construcción

### Persistencia de Datos
- **Spring Data JPA** - ORM y acceso a datos
- **MySQL** - Base de datos relacional
- **Hibernate** - Implementación JPA (incluida en Spring Data)

### Seguridad
- **Spring Security** - Framework de seguridad
- **JWT (JSON Web Tokens)** - Autenticación stateless
- **BCrypt** - Encriptación de contraseñas

### Documentación y Validación
- **Swagger/OpenAPI 3** - Documentación automática de API
- **Jakarta Validation API** - Validación de datos de entrada

### Arquitectura
- **Arquitectura por capas** (Controller, Service, Repository, Entity)
- **DTOs** para transferencia de datos
- **Configuración basada en anotaciones**

## 📋 Prerequisites

Antes de instalar y ejecutar la aplicación, asegúrate de tener instalado:

- **Java 17** o superior
- **Maven 3.6+** 
- **MySQL 8.0+** (o compatible)
- **Git** (para clonar el repositorio)

## ⚙️ Instalación y Configuración

### 1. Clonar el Repositorio
```bash
git clone https://github.com/Dieg0bl/AuthServiceDemo.git
cd AuthServiceDemo
```

### 2. Configurar la Base de Datos

1. **Crear la base de datos en MySQL:**
```sql
CREATE DATABASE secureuserapi;
CREATE USER 'usuario_demo'@'localhost' IDENTIFIED BY 'contraseña_demo';
GRANT ALL PRIVILEGES ON secureuserapi.* TO 'usuario_demo'@'localhost';
FLUSH PRIVILEGES;
```

2. **Configurar las credenciales** en `src/main/resources/application.properties`:
```properties
# Configuración de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/secureuserapi?useSSL=false&serverTimezone=UTC
spring.datasource.username=usuario_demo
spring.datasource.password=contraseña_demo
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

> **⚠️ Importante:** Cambia las credenciales por defecto antes de usar en producción.

### 3. Compilar el Proyecto
```bash
mvn clean compile
```

### 4. Ejecutar las Migraciones
```bash
mvn spring-boot:run
```

Al ejecutar por primera vez, Hibernate creará automáticamente las tablas necesarias:
- `users` - Información de usuarios
- `roles` - Roles del sistema
- `user_roles` - Relación many-to-many entre usuarios y roles
- `refresh_tokens` - Tokens de renovación

## 🚀 Cómo Ejecutar la Aplicación

### Opción 1: Con Maven (Desarrollo)
```bash
mvn spring-boot:run
```

### Opción 2: JAR Compilado (Producción)
```bash
# Compilar JAR
mvn clean package

# Ejecutar JAR
java -jar target/secureuser-api-0.0.1-SNAPSHOT.jar
```

### Opción 3: Con perfil de desarrollo
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## 📖 Acceso a la Documentación

Una vez que la aplicación esté ejecutándose:

- **Aplicación:** http://localhost:8080
- **Documentación Swagger UI:** http://localhost:8080/swagger-ui.html
- **API Docs JSON:** http://localhost:8080/v3/api-docs

## 🏗️ Estructura del Proyecto

```
src/main/java/com/diegobarreiro/secureuserapi/
├── config/          # Configuraciones (Swagger, etc.)
├── dto/             # Data Transfer Objects
│   ├── LoginRequest.java
│   └── RegisterRequest.java
├── entity/          # Entidades JPA
│   ├── User.java
│   ├── Role.java
│   └── RefreshToken.java
├── repository/      # Repositorios de datos
├── security/        # Configuración de seguridad
├── service/         # Lógica de negocio
│   ├── AuthService.java
│   └── JwtService.java
└── SecureUserApiApplication.java
```

## 🔧 Configuración Adicional

### Variables de Entorno (Opcional)
Puedes usar variables de entorno para la configuración:

```bash
export DB_URL=jdbc:mysql://localhost:3306/secureuserapi
export DB_USERNAME=tu_usuario
export DB_PASSWORD=tu_contraseña
```

### Perfiles de Spring
- `dev` - Desarrollo (logs detallados, H2 en memoria)
- `prod` - Producción (logs optimizados, validaciones estrictas)

## 📝 Estado del Desarrollo

Este proyecto está en desarrollo activo. Consulta `PLAN.md` para ver el roadmap completo.

### Características Implementadas ✅
- Configuración base del proyecto
- Entidades de datos (User, Role, RefreshToken)
- Repositorios JPA
- Servicios de autenticación y JWT
- Configuración de seguridad
- DTOs para requests
- Documentación Swagger

### Próximas Características 🚧
- Controladores REST
- Endpoints de autenticación
- Validaciones completas
- Tests unitarios e integración
- Dockerización

## 🤝 Contribución

Para contribuir al proyecto:

1. Fork el repositorio
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la licencia MIT. Ver el archivo `LICENSE` para más detalles.

## 👨‍💻 Autor

**Diego Barreiro** - [Dieg0bl](https://github.com/Dieg0bl)

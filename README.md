# SecureUserApi

🔐 **Demostración de API REST empresarial para gestión segura de usuarios**

Una implementación completa de un sistema de autenticación y gestión de usuarios utilizando las mejores prácticas de Spring Boot y tecnologías modernas. Ideal para proyectos empresariales que requieren autenticación robusta y gestión de roles.

## 🚀 Tecnologías Principales

- **Backend:** Spring Boot 3.2.6 + Java 17
- **Seguridad:** Spring Security + JWT Authentication
- **Base de datos:** MySQL + JPA/Hibernate
- **Documentación:** Swagger/OpenAPI 3
- **Build:** Maven
- **Cifrado:** BCrypt para contraseñas

## ✨ Características

- ✅ Autenticación JWT segura
- ✅ Sistema de roles y permisos
- ✅ Cifrado de contraseñas con BCrypt
- ✅ API REST documentada con Swagger
- ✅ Arquitectura empresarial escalable
- ✅ Validaciones robustas de entrada
- 🚧 Refresh tokens (en desarrollo)
- 🚧 Autenticación de dos factores (planificado)

## 🛠️ Configuración y Uso

1. **Configurar base de datos MySQL:**
   ```properties
   # Actualizar src/main/resources/application.properties
   spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```

2. **Compilar y ejecutar:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. **Acceder a la documentación API:**
   - Swagger UI: `http://localhost:8080/swagger-ui.html`

## 📋 Plan de Desarrollo

Ver `PLAN.md` para el roadmap completo de funcionalidades.

## 🎯 Propósito

Este proyecto demuestra competencias en desarrollo backend moderno, implementando patrones empresariales y mejores prácticas de seguridad. Perfecto para portfolios técnicos y como base para proyectos reales.

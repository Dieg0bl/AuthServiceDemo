# Servicio de Autenticación

Servicio REST para autenticación de usuarios con Spring Security y JWT.

## Requisitos

- Java 17
- Maven 3.6+
- MySQL 8.0 (para producción) o H2 (para tests)

## Configuración

Configura la base de datos en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/secureuserapi
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

## Ejecución

```bash
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`

## Uso básico

### Obtener token de acceso

```bash
curl -X POST http://localhost:8080/auth/login \
  -H "Content-Type: application/json" \
  -d '{"usernameOrEmail":"demo","password":"demo123"}'
```

### Renovar token

```bash
curl -X POST http://localhost:8080/auth/refresh \
  -H "Content-Type: application/json" \
  -d '{"refreshToken":"token_de_renovacion"}'
```

### Acceder al perfil

```bash
curl -X GET http://localhost:8080/me \
  -H "Authorization: Bearer tu_token_jwt"
```

## Documentación API

Accede a la documentación interactiva en: `http://localhost:8080/swagger-ui.html`

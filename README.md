````markdown
# Automatizaciones ResiReport

Proyecto de automatización de pruebas funcionales para la plataforma ResiReport utilizando:

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)

---

# Estructura del Proyecto

```text
Automatizaciones/
│
├── src/
│   └── test/
│       ├── java/
│       │   └── com/resireport/
│       │       ├── pages/
│       │       ├── tests/
│       │       └── utils/
│       │
│       └── resources/
│
├── screenshots/
├── target/
├── pom.xml
└── README.md
````

---

# Tecnologías Utilizadas

* Java 8+
* Selenium 4
* TestNG
* Maven
* WebDriverManager
* Apache POI

---

# Patrón de Diseño

El proyecto utiliza el patrón:

## Page Object Model (POM)

Separando:

* Tests
* Pages
* Utilidades
* Configuración

---

# Automatizaciones Implementadas

## 1. Login Residente

### Objetivo

Validar el inicio de sesión de un usuario residente.

### Flujo

* Abrir navegador
* Ingresar credenciales
* Iniciar sesión
* Validar redirección
* Capturar evidencia

### Evidencias

* Captura login
* Captura dashboard

---

## 2. Crear Denuncia

### Objetivo

Validar la creación de una denuncia por parte de un residente.

### Flujo

* Login residente
* Navegar a crear denuncia
* Completar formulario
* Enviar denuncia
* Validar creación exitosa
* Capturas estratégicas

### Evidencias

* Formulario diligenciado
* Denuncia creada

---

## 3. Editar Estado de Denuncia

### Objetivo

Cambiar el estado de una denuncia desde “Registrada” a “Analizando”.

### Flujo

* Login administrador
* Buscar denuncia registrada
* Abrir detalle
* Cambiar estado
* Confirmar cambio
* Validar actualización

### Estado trabajado

* Registrada
* Analizando

### Evidencias

* Login admin
* Tabla denuncias
* Detalle denuncia
* Modal confirmación
* Estado actualizado

---

# Capturas Automáticas

El proyecto genera screenshots automáticos en:

```text
/screenshots
```

Con timestamp para trazabilidad.

---

# Ejecución del Proyecto

## Ejecutar todas las pruebas

```bash
mvn test
```

## Ejecutar prueba específica

```bash
mvn test -Dtest=LoginTest
```

```bash
mvn test -Dtest=CrearDenunciaTest
```

```bash
mvn test -Dtest=EditarEstadoDenunciaTest
```

---

# Buenas Prácticas Aplicadas

* Esperas explícitas
* Reutilización de componentes
* Separación de responsabilidades
* Evidencias automáticas
* Código modular
* Manejo de excepciones
* Scroll automático
* Click por JavaScript como fallback

---

# Próximas Automatizaciones

* Rechazar denuncia
* Finalizar denuncia
* Editar perfil
* Gestión de usuarios
* Búsquedas y filtros
* Validaciones negativas
* Exportación de reportes
* Automatización de módulos administrativos

---

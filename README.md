````md
# Automatización QA - ResiReport

Proyecto de automatización de pruebas funcionales utilizando Selenium WebDriver con Java para validar flujos críticos del sistema ResiReport.

## Tecnologías Utilizadas

- Java
- Selenium WebDriver
- Maven
- TestNG
- Apache POI
- Page Object Model (POM)

---

# Estructura del Proyecto

```bash
src
└── test
    └── java
        └── com
            └── resireport
                ├── pages
                ├── tests
                └── utils
````

---

# Funcionalidades Automatizadas

## 1. Login Administrador

Automatización del inicio de sesión del administrador utilizando credenciales almacenadas en Excel.

### Validaciones

* Carga correcta del dashboard
* Capturas automáticas
* Esperas controladas

---

## 2. Cambio de Estado de Denuncia

### Flujo Automatizado

1. Login administrador
2. Identificar denuncia en estado "Registrada"
3. Abrir detalles de la denuncia
4. Validar estado actual
5. Cambiar estado a "Analizando"
6. Confirmar cambio en modal
7. Validar actualización del estado
8. Capturas de evidencia

### Validaciones Implementadas

* Estado inicial correcto
* Modal de confirmación
* Persistencia del cambio
* Validación posterior al cambio

---

## 3. Cambio de Prioridad de Denuncia

### Flujo Automatizado

1. Login administrador
2. Identificar denuncia con prioridad "Sin asignar"
3. Abrir detalles
4. Validar prioridad actual
5. Cambiar prioridad a "Baja"
6. Refrescar página
7. Validar actualización de prioridad
8. Generar capturas de evidencia

### Validaciones Implementadas

* Validación prioridad inicial
* Cambio exitoso de prioridad
* Persistencia tras refresh
* Validación prioridad final

---

# Capturas de Evidencia

Las evidencias se almacenan automáticamente en:

```bash
/screenshots
```

Ejemplo:

```bash
01_login_admin_20260516_013637.png
02_dashboard_admin_20260516_013647.png
03_prioridad_sin_asignar_20260516_013648.png
```

---

# Ejecución de Pruebas

## Ejecutar todas las pruebas

```bash
mvn test
```

---

## Ejecutar prueba de cambio de estado

```bash
mvn test -Dtest=EditarEstadoDenunciaTest
```

---

## Ejecutar prueba de cambio de prioridad

```bash
mvn test -Dtest=CambiarPrioridadDenunciaTest
```

---

# Características Técnicas

* Arquitectura POM (Page Object Model)
* Uso de Explicit Waits
* Capturas automáticas
* Datos externos desde Excel
* Validaciones con TestNG
* Automatización UI end-to-end
* Manejo de modales
* XPath dinámicos

---

# Estado del Proyecto

## Automatizaciones Completadas

* ✅ Login administrador
* ✅ Cambio de estado de denuncias
* ✅ Cambio de prioridad de denuncias

## Próximas Automatizaciones

* ⏳ Filtrado de denuncias
* ⏳ Creación de denuncias
* ⏳ Búsqueda avanzada
* ⏳ Gestión de usuarios
* ⏳ Validaciones de formularios

---

```
```

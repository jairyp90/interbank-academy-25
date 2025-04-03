# 📌 Procesamiento de Transacciones - Interbank

## 📖 Introducción
Este proyecto tiene como objetivo procesar transacciones bancarias a partir de un archivo CSV, generando un reporte con los datos procesados. Se implementó en **Java con Spring Boot** y utiliza **Apache Commons CSV** para la lectura del archivo.

## 🚀 Instrucciones de Ejecución
### 📦 Instalación de Dependencias
Asegúrate de tener instalado **Java 17** o superior y **Maven**. Luego, instala las dependencias ejecutando:

```sh
mvn clean install
```

### ▶️ Ejecución de la Aplicación
Para ejecutar el proyecto, utiliza el siguiente comando:

```sh
mvn spring-boot:run
```

La aplicación buscará el archivo `data.csv` en el classpath y procesará sus transacciones.

## 💡 Enfoque y Solución
### 🔹 Lógica Implementada
1. **Lectura del archivo CSV:** Se utiliza `CSVReaderUtil` para convertir los registros en objetos `Transaction`.
2. **Procesamiento de transacciones:** `TransactionController` gestiona las operaciones llamando al servicio de reportes.
3. **Generación de Reporte:** Se imprime en consola un resumen de las transacciones procesadas.

### 🛠️ Decisiones de Diseño
- **Spring Boot:** Se usó para facilitar la inyección de dependencias y la ejecución de la aplicación.
- **Apache Commons CSV:** Para leer archivos CSV de manera eficiente.

## 📂 Estructura del Proyecto
```
procesing-interbank/
│── src/
│   ├── main/java/com/cli/procesing/interbank/
│   │   ├── ProcesingTransactionApplication.java  # Punto de entrada
│   │   ├── controller/TransactionController.java # Controlador principal
│   │   ├── model/Transaction.java                # Modelo de transacción
│   │   ├── util/CSVReaderUtil.java               # Utilidad para leer CSV
│   ├── test/java/com/cli/procesing/interbank/
│   │   ├── ProcesingTransactionApplicationTest.java # Pruebas unitarias
│── data.csv   # Archivo de ejemplo para pruebas
│── pom.xml    # Archivo de configuración de Maven
```

## 📝 Notas Adicionales
- Para cambiar la ubicación del archivo CSV, modifícalo en `resources/` o ajusta el `classpath`.
- Se pueden agregar validaciones adicionales en `CSVReaderUtil` para evitar errores en el parsing.



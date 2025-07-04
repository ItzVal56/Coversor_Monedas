# 💱 Conversor de Monedas con API

Este proyecto es un conversor de monedas desarrollado en Java que permite convertir valores entre distintas divisas usando datos reales obtenidos desde una API externa (ExchangeRate-API). El usuario puede seleccionar diferentes monedas desde un menú interactivo en consola y obtener la conversión actualizada.

---

## 🚀 Funcionalidades

- Conexión a una API REST de tasas de cambio mediante `HttpClient`
- Creación y configuración de solicitudes HTTP con `HttpRequest`
- Manejo y análisis de respuestas con `HttpResponse`
- Parseo y manipulación de JSON usando `Gson`
- Filtrado de monedas específicas desde la respuesta
- Conversión de valores en tiempo real
- Interfaz en consola con menú interactivo

---

## 🛠️ Tecnologías y herramientas

- Lenguaje: Java 21
- Librerías:
  - `java.net.http.HttpClient`
  - `com.google.gson.Gson`
- Herramientas usadas:
  - IDE: IntelliJ IDEA
  - Postman (para pruebas de API)
  - Terminal

---

## 📦 Estructura del proyecto

```
Conversor_Monedas/
│
├── src/
│   ├── Main.java          # Clase principal con interfaz de usuario
│   ├── Conversor.java     # Lógica de conversión y consumo de API
│   └── TasaCambio.java    # Clase modelo para mapear JSON
│
├── README.md              # Este archivo
└── .gitignore             # (opcional)
```

---

## 📷 Ejemplo de uso

```
--- Conversor de Monedas ---
1. Dólar (USD) → Peso Argentino (ARS)
2. Peso Argentino (ARS) → Dólar (USD)
3. Dólar (USD) → Real Brasileño (BRL)
...

Seleccione una opción: 1
Ingrese el valor que desea convertir: 100
El valor de 100.00 equivale a 146903.00
```

---

## 🧠 Aprendizajes

- Cómo consumir APIs REST en Java con `HttpClient`
- Cómo estructurar solicitudes y manejar respuestas
- Análisis y transformación de JSON en objetos Java con Gson
- Diseño modular con clases separadas para lógica y presentación

---

## 📌 Requisitos para ejecutar

- Java 21+
- Tener conexión a Internet (para acceder a la API)
- Agregar la librería de Gson en el proyecto (por ejemplo, desde Maven Central o manualmente)

---

## ✨ Créditos

Proyecto desarrollado como parte del programa [Oracle Next Education (ONE)](https://www.oracle.com/lad/education/oracle-next-education/), en colaboración con Alura Latam.

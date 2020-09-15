# ms-shop
Desplegar una aplicación de Spring Boot + Gradle + Docker en Cloud Run
En este repositorio están los fuentes disponibles para desplegar una aplicación de Spring Boot con Gradle y Docker sobre Google Cloud Run.

La aplicación está basada en:

Spring Boot 2.0.5.RELEASE
Gradle
Docker
Cloud Build
Cloud Run
Si se hace un fork del repositorio, para desplegarla sería tan sencillo como en la configuración de Cloud Build apuntar al repositorio creado. Se lanzaría un trigger y automáticamente se desplegaría en Cloud Run. Previamente, en el fichero Cloudbuild.yaml habría que cambiar el nombre del proyecto de Google Cloud.
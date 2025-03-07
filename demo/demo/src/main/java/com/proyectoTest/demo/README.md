# Flujo del Código

El código sigue una arquitectura hexagonal, que separa la lógica de negocio (dominio), la orquestación (aplicación) y los detalles técnicos (infraestructura)

1. Capa de Infraestructura: `EpisodeApiClient`
Esta clase es responsable de consumir la API externa de "Rick and Morty".

Usa `RestTemplate` para hacer una solicitud HTTP GET a la URL de la API.

Mapea la respuesta JSON a un objeto de la clase `Episode`.

### Flujo:

- Se llama al método `getEpisodeById` con un `id` de episodio.
- Se construye la URL completa (por ejemplo, `https://rickandmortyapi.com/api/episode/28`.
- Se realiza una solicitud HTTP GET a la API.
- La respuesta JSON se convierte en un objeto `Episode`.

2. Capa de Aplicación: `EpisodeService`

Esta clase orquesta la interacción entre la infraestructura (`EpisodeApiClient`) y el dominio (`Episode`).

Expone un método `getEpisodeById` que llama al `EpisodeApiClient` para obtener los datos del episodio.

### Flujo:

- Se llama al método `getEpisodeById` del servicio con un `id` de episodio.
- El servicio llama al `EpisodeApiClient` para obtener los datos del episodio.
- Devuelve el objeto `Episode` obtenido.

3. Capa de Infraestructura: `EpisodeController`

Esta clase expone un endpoint REST para que los clientes (por ejemplo, un navegador o una aplicación móvil) puedan obtener información sobre un episodio.

Llama al `EpisodeService` para obtener los datos.

### Flujo:

- Un cliente hace una solicitud HTTP GET a `/episodes/28`.
- El controlador llama al `EpisodeService` para obtener los datos del episodio con `id = 28`.
- El servicio devuelve el objeto `Episode`, que el controlador envía como respuesta HTTP.

4. Capa de Dominio: `Episode`

Esta clase representa la entidad de negocio (un episodio de "Rick and Morty").

Contiene los campos que coinciden con la estructura de datos de la API.

### Flujo:

- Los datos JSON de la API se mapean automáticamente a un objeto Episode usando Jackson.
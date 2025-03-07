# Flujo de la Prueba (EpisodeServiceTest)

La prueba unitaria verifica que el EpisodeService funcione correctamente sin necesidad de llamar a la API real. Para ello, se utiliza Mockito para simular el comportamiento del EpisodeApiClient.

1. Configuración del Mock

Se crea un mock de `EpisodeApiClient` usando la anotación `@Mock`.

Se inyecta el mock en `EpisodeService` usando la anotación `@InjectMocks`.

```
@Mock
private EpisodeApiClient episodeApiClient;

@InjectMocks
private EpisodeService episodeService;
```

2. Simulación del Comportamiento

Se configura el mock para devolver un objeto `Episode` específico cuando se llame al método `getEpisodeById`.

```
@Test
public void testGetEpisodeById() {
    // Configura el mock
    Episode expectedEpisode = new Episode();
    expectedEpisode.setId(28);
    expectedEpisode.setName("The Ricklantis Mixup");
    expectedEpisode.setAir_date("September 10, 2017");
    expectedEpisode.setEpisode("S03E07");
    expectedEpisode.setCharacters(new ArrayList<>());
    expectedEpisode.setUrl("https://rickandmortyapi.com/api/episode/28");
    expectedEpisode.setCreated(ZonedDateTime.parse("2021-09-10T12:00:00Z"));

    when(episodeApiClient.getEpisodeById(28)).thenReturn(expectedEpisode);
}
```

### Flujo:

- Se crea un objeto `Episode` con datos de prueba.

- Se configura el mock para devolver este objeto cuando se llame a `getEpisodeById(28)`.

3. Ejecución del Método Bajo Prueba

Se llama al método `getEpisodeById` del `EpisodeService`.

```Episode actualEpisode = episodeService.getEpisodeById(28);```

### Flujo:

- El servicio llama al `EpisodeApiClient` (que está mockeado).

- El mock devuelve el objeto `Episode` configurado previamente.

4. Verificación del Resultado

Se verifica que el objeto devuelto por el servicio sea igual al objeto esperado.

```assertEquals(expectedEpisode, actualEpisode);```

### Flujo:

- Se compara el objeto `expectedEpisode` con el objeto `actualEpisode`.

- Si son iguales, la prueba pasa. Si no, la prueba falla.


# Hexa spring boot

## What we want:

* A `Repository` interface
* A `SqliteRepository` implementation that is used by the production code
* A `FakeRepository` implementation that is use by the tests

## How it's done

We create a `TestConfig` class:

```java
@TestConfiguration
public class TestConfig {

  @Bean
  Repository repository() {
    return new FakeRepository();
  }
}
```


We tell SprintBoot to import it during tests:

```java
@WebMvcTest()
@Import(TestConfig.class)
class FactsControllerTests{
   ...
}
```

And we auto-wire the `FakeRepository` class inside our tests:

```java
class FactsControllerTests {
  @Autowired
  private FakeRepository fakeRepository;
}
```

This gives us complete control to tests our controllers, like this:

```java
@Test
void getFact() {
   fakeRepository.addFact(1, "toto");

   // Perform GET /fact/1

   assertEquals("toto", response);
}
```


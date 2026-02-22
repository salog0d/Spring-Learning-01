### Spring Bean Wiring Notes

#### Context

Configuration class demonstrating manual bean registration, dependency resolution, qualifiers, and primary beans using Java records.

---

## Core Concepts

### **`@Configuration`**

Marks a class as a source of bean definitions. Spring processes this class and registers returned objects as managed beans.

Key behavior:

* Methods annotated with `@Bean` are intercepted by Spring (via proxy) to enforce singleton semantics.
* Direct method calls inside the configuration class do **not** create new instances; Spring returns the managed bean.

---

### **`@Bean`**

Declares an object managed by the Spring container.

```java
@Bean
public Person person() { ... }
```

Effects:

* The return value becomes a bean in the application context.
* Bean identity defaults to method name unless overridden.

---

### **Bean Naming**

Default:

```java
@Bean
public Address address() { ... }
```

Bean name → `"address"`

Override:

```java
@Bean(name = "address1")
```

Bean name → `"address1"`

Use explicit naming when:

* Multiple beans of same type exist
* External wiring clarity is needed

---

### **Dependency Injection (DI)**

Spring resolves dependencies by **type**, then disambiguates by:

1. `@Qualifier`
2. `@Primary`

---

## Wiring Patterns Demonstrated

### **1. Method Call Injection**

```java
@Bean
public Person person2MethodCall() {
    return new Person(name(), age(), address());
}
```

Important detail:

* Because the class is `@Configuration`, Spring intercepts calls.
* `name()`, `age()`, `address()` return container-managed beans, **not** new instances.

Without `@Configuration` → would create new objects.

---

### **2. Parameter Injection (Recommended Pattern)**

```java
@Bean
public Person person3Parameters(String name, int age, Address address)
```

Mechanism:

* Spring injects beans by matching parameter types.
* Cleaner, more explicit, avoids proxy-related confusion.

Preferred in production.

---

## Qualifiers

### **Problem: Multiple Candidates**

If two beans of same type exist:

```java
@Bean Address address()
@Bean Address address2()
```

Spring fails:

```
NoUniqueBeanDefinitionException
```

---

### **`@Qualifier`**

Explicitly selects a bean.

```java
@Bean
@Qualifier("adress1qualifuier")
public Address address()
```

Injection:

```java
public Person person3Parameters(..., @Qualifier("adress1qualifuier") Address address)
```

Rules:

* String must match exactly
* Typos silently break wiring

⚠ Your code contains a typo:

```
"adress1qualifuier"
```

Misspelling increases defect risk.

---

## Primary Beans

### **`@Primary`**

Defines default bean when ambiguity exists.

```java
@Bean
@Primary
public Address address2()
```

Behavior:

* Injected when no qualifier is specified
* Acts as fallback resolution strategy

---

## Resolution Order

When Spring injects by type:

1. Single match → inject
2. Multiple matches:

   * Qualifier present → inject matching bean
   * No qualifier → inject `@Primary`
   * No primary → exception

---

## Observations & Engineering Notes

### **Primitive Beans (`String`, `int`)**

```java
@Bean public String name()
@Bean public int age()
```

Technically valid but discouraged.

Issues:

* Ambiguity across configuration modules
* No semantic meaning
* Easy collision

Better:

```java
record PersonProperties(String name, int age) {}
```

---

### **Duplicate Bean Values**

Both addresses return identical values:

```java
new Address("Linda Vista", "Guadalupe");
```

Does not demonstrate real differentiation.

---

## Common Failure Modes

1. **Qualifier mismatch**
2. **Multiple beans without primary**
3. **Primitive bean collisions**
4. **Calling `@Bean` methods outside configuration context**
5. **Hidden object creation bypassing Spring**

---

## Recommended Practices

✔ Prefer parameter injection
✔ Minimize primitive beans
✔ Use qualifiers sparingly
✔ Use primary only for true defaults
✔ Keep bean identities meaningful
✔ Avoid magic strings (centralize constants)

---

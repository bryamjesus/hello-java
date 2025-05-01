# Single Responsibility Principle (SRP) o Principio de Responsabilidad Unica (PRU)

Una clase debe tener solo una razón para cambiar, lo que significa que debe tener solo un trabajo o responsabilidad.

---

## **Antes de SRP:**

Considere una`User`clase que maneja datos de usuario y también administra el almacenamiento de archivos.
[Ejemplo](no_srp/User.java)

```java
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Bad practice: Handling file storage within the User class
    public void saveToFile() {
        try (FileWriter fileWriter = new FileWriter(name + ".txt")) {
            fileWriter.write("Name: " + name + "\n");
            fileWriter.write("Email: " + email + "\n");
            System.out.println("User data saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        User user = new User("John Doe", "john.doe@example.com");
        user.saveToFile();
    }
}
```

**Producción:**

```
Los datos del usuario se guardaron en el archivo correctamente.
```

**Explicación:**
La `User`clase tiene dos responsabilidades: gestionar los datos del usuario y el almacenamiento de archivos. Esto viola
el principio de responsabilidad única, ya que un cambio en el mecanismo de almacenamiento de archivos requeriría
modificaciones en la`User`clase.

---

## **Después de SRP:**

Para adherirnos al SRP, deberíamos separar estas responsabilidades en diferentes clases.

```java
// User.java
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

// UserFileManager.java
import java.io.FileWriter;
import java.io.IOException;

public class UserFileManager {
    public void saveToFile(User user) {
        try (FileWriter fileWriter = new FileWriter(user.getName() + ".txt")) {
            fileWriter.write("Name: " + user.getName() + "\n");
            fileWriter.write("Email: " + user.getEmail() + "\n");
            System.out.println("User data saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe", "john.doe@example.com");
        UserFileManager fileManager = new UserFileManager();
        fileManager.saveToFile(user);
    }
}
```

**Producción:**

```bash
Los datos del usuario se guardaron en el archivo correctamente.
```

**Explicación:**La`User`clase ahora solo administra los datos del usuario, mientras que la`UserFileManager`clase
gestiona el almacenamiento de archivos. Esto se ajusta al principio de responsabilidad única, ya que cada clase ahora
tiene un solo motivo para cambiar.
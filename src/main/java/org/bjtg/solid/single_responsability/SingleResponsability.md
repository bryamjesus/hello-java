# Single Responsibility Principle (SRP) o Principio de Responsabilidad Unica (PRU)

Una clase debe tener solo una razón para cambiar, lo que significa que debe tener solo un trabajo o responsabilidad.

---

## **Antes de SRP:**

Considere una`User`clase que maneja datos de usuario y también administra el almacenamiento de archivos.

[UserNoSRP](no_srp/User.java)

```java
public class UserNoSRP {
    private String name;
    private String email;

    public UserNoSRP(String name, String email) {
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

[UserSRP](srp/UserSRP.java)

```java
public class UserSRP {
    private String name;
    private String email;

    public UserSRP(String name, String email) {
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
```

[UserSRP](srp/UserFileManager.java)

```java
import java.io.FileWriter;
import java.io.IOException;

public class UserFileManager {
    public void saveToFile(UserSRP userSRP) {
        try (FileWriter fileWriter = new FileWriter(userSRP.getName() + ".txt")) {
            fileWriter.write("Name: " + userSRP.getName() + "\n");
            fileWriter.write("Email: " + userSRP.getEmail() + "\n");
            System.out.println("User data saved to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
# Open/Closed Principle (OCP) o Principio Abierto/Cerrado (OCP)

Las entidades de software deben estar abiertas a la extensión pero cerradas a la modificación.

---

## Antes de OCP:

```java
public class DiscountCalculator {
    public double calculateDiscount(String customerType, double amount) {
        if (customerType.equals("Regular")) {
            return amount * 0.1;
        } else if (customerType.equals("Premium")) {
            return amount * 0.2;
        }
        return 0;
    }

    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        double regularDiscount = calculator.calculateDiscount("Regular", 100);
        double premiumDiscount = calculator.calculateDiscount("Premium", 100);

        System.out.println("Regular Discount: " + regularDiscount);
        System.out.println("Premium Discount: " + premiumDiscount);
    }
}
```

**Producción:**

```bash
Regular Discount: 10.0
Premium Discount: 20.0
```

**Explicación:**La`DiscountCalculator`clase viola el principio abierto/cerrado porque debe modificarse cada vez que se
agrega un nuevo tipo de descuento.
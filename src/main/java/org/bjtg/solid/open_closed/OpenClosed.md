# Open/Closed Principle (OCP) o Principio Abierto/Cerrado (OCP)

Las entidades de software deben estar abiertas a la extensión pero cerradas a la modificación.

---

## Antes de OCP:

Supongamos que tenemos una clase que calcula descuentos para diferentes tipos de clientes.

[DiscountCalculatorNoOC](no_oc/DiscountCalculatorNoOC.java)

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

---

## Después de OCP:

Para cumplir con OCP, podemos usar el polimorfismo para extender el comportamiento sin modificar el código existente.

[Discount.java](oc/Discount.java)

```java
public abstract class Discount {
    public abstract double calculate(double amount);
}
```

[RegularDiscount.java](oc/RegularDiscount.java)

```java
public class RegularDiscount extends Discount {
    @Override
    public double calculate(double amount) {
        return amount * 0.1;
    }
}
```

[PremiumDiscount.java](oc/PremiumDiscount.java)

```java
public class PremiumDiscount extends Discount {
    @Override
    public double calculate(double amount) {
        return amount * 0.2;
    }
}
```

[DiscountCalculatorOC.java](oc/DiscountCalculatorOC.java)

```java
public class DiscountCalculatorOC {
    public double calculateDiscount(Discount discount, double amount) {
        return discount.calculate(amount);
    }
}
```


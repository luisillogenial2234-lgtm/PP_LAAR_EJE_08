// Repositorio de GitHub: https://github.com/TU_USUARIO/PP_LAAR_EJE_08
// Nombre: Luis Alberto Acuña Ramírez

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("  EJERCICIOS DE PROGRAMACIÓN FUNCIONAL CON STREAMS");
        System.out.println("=================================================");

        // Listas de datos no primitivos
        List<Integer> numeros = Arrays.asList(15, -4, 22, 55, 8, 90, 3, 50, -12, 100, 42);
        List<Double> celsius = Arrays.asList(0.0, 20.0, 37.0, 100.0);
        List<String> nombres = Arrays.asList("Ana", "Carlos", "Beatriz", "Alejandro", "Sofia", "Alberto", "David");

        // ----------------------------------------------------
        // Nivel 1 — Operaciones básicas
        // ----------------------------------------------------
        System.out.println("\n--- Nivel 1 ---");

        // 1. Sumar elementos
        int suma = numeros.stream().reduce(0, Integer::sum);
        System.out.println("1. Suma total: " + suma);

        // 2. Obtener el máximo
        Optional<Integer> maximo = numeros.stream().max(Integer::compareTo);
        maximo.ifPresent(m -> System.out.println("2. Máximo: " + m));

        // 3. Obtener el mínimo
        Optional<Integer> minimo = numeros.stream().min(Integer::compareTo);
        minimo.ifPresent(m -> System.out.println("3. Mínimo: " + m));

        // 4. Contar elementos
        long totalElementos = numeros.stream().count();
        System.out.println("4. Cantidad de elementos: " + totalElementos);

        // ----------------------------------------------------
        // Nivel 2 — filter
        // ----------------------------------------------------
        System.out.println("\n--- Nivel 2 ---");

        // 5. Números pares
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("5. Números pares: " + pares);

        // 6. Números mayores que 50
        List<Integer> mayores50 = numeros.stream()
                .filter(n -> n > 50)
                .collect(Collectors.toList());
        System.out.println("6. Mayores que 50: " + mayores50);

        // 7. Contar números positivos
        long positivos = numeros.stream()
                .filter(n -> n > 0)
                .count();
        System.out.println("7. Total de números positivos: " + positivos);

        // 8. Obtener números dentro de un rango [10, 60]
        List<Integer> enRango = numeros.stream()
                .filter(n -> n >= 10 && n <= 60)
                .collect(Collectors.toList());
        System.out.println("8. Números en el rango [10, 60]: " + enRango);

        // ----------------------------------------------------
        // Nivel 3 — map
        // ----------------------------------------------------
        System.out.println("\n--- Nivel 3 ---");

        // 9. Elevar al cuadrado
        List<Integer> cuadrados = numeros.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("9. Cuadrados: " + cuadrados);

        // 10. Multiplicar por 10
        List<Integer> porDiez = numeros.stream()
                .map(n -> n * 10)
                .collect(Collectors.toList());
        System.out.println("10. Multiplicados por 10: " + porDiez);

        // 11. Convertir temperaturas (Celsius a Fahrenheit)
        Function<Double, Double> toFahrenheit = c -> (c * 9 / 5) + 32;
        List<Double> fahrenheit = celsius.stream()
                .map(toFahrenheit)
                .collect(Collectors.toList());
        System.out.println("11. Temperaturas en Fahrenheit: " + fahrenheit);

        // ----------------------------------------------------
        // Nivel 4 — Combinar operaciones
        // ----------------------------------------------------
        System.out.println("\n--- Nivel 4 ---");

        // 12. Pares elevados al cuadrado
        List<Integer> paresCuadrado = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("12. Pares elevados al cuadrado: " + paresCuadrado);

        // 13. Suma de números pares
        int sumaPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("13. Suma de números pares: " + sumaPares);

        // 14. Promedio de números mayores que 50
        OptionalDouble promedioMayores50 = numeros.stream()
                .filter(n -> n > 50)
                .mapToInt(Integer::intValue)
                .average();
        promedioMayores50.ifPresent(p -> System.out.println("14. Promedio de mayores que 50: " + p));

        // 15. Máximo de números pares
        Optional<Integer> maxPar = numeros.stream()
                .filter(n -> n % 2 == 0)
                .max(Integer::compareTo);
        maxPar.ifPresent(m -> System.out.println("15. Máximo de los pares: " + m));

        // ----------------------------------------------------
        // Nivel 5 — Ordenamiento
        // ----------------------------------------------------
        System.out.println("\n--- Nivel 5 ---");

        // 16. Ordenar de menor a mayor
        List<Integer> ascendente = numeros.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("16. Orden menor a mayor: " + ascendente);

        // 17. Ordenar de mayor a menor
        List<Integer> descendente = numeros.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("17. Orden mayor a menor: " + descendente);

        // 18. Tres números más grandes
        List<Integer> tresMasGrandes = numeros.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("18. Tres números más grandes: " + tresMasGrandes);

        // ----------------------------------------------------
        // Nivel 6 — String[]
        // ----------------------------------------------------
        System.out.println("\n--- Nivel 6 ---");

        // 19. Filtrar nombres (empiezan con 'A')
        List<String> empiezanConA = nombres.stream()
                .filter(nombre -> nombre.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("19. Nombres que empiezan con 'A': " + empiezanConA);

        // 20. Nombres con más de 5 caracteres
        List<String> masDe5 = nombres.stream()
                .filter(nombre -> nombre.length() > 5)
                .collect(Collectors.toList());
        System.out.println("20. Nombres con más de 5 caracteres: " + masDe5);

        // 21. Convertir a mayúsculas
        List<String> mayusculas = nombres.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("21. Nombres en mayúsculas: " + mayusculas);

        // 22. Ordenar nombres
        List<String> nombresOrdenados = nombres.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("22. Nombres ordenados alfabéticamente: " + nombresOrdenados);

        // ----------------------------------------------------
        // Nivel 7 — Búsquedas y Predicados
        // ----------------------------------------------------
        System.out.println("\n--- Nivel 7 ---");

        // 23. Buscar un número (22)
        int buscar = 22;
        Optional<Integer> encontrado = numeros.stream()
                .filter(n -> n == buscar)
                .findFirst();
        System.out.println("23. Búsqueda del número " + buscar + ": " +
                (encontrado.isPresent() ? "Encontrado (" + encontrado.get() + ")" : "No encontrado"));

        // 24. Determinar si todos cumplen una condición (todos > 0)
        boolean todosPositivos = numeros.stream()
                .allMatch(n -> n > 0);
        System.out.println("24. ¿Todos los números son positivos?: " + todosPositivos);

        // 25. Determinar si alguno cumple una condición (alguno < 0)
        boolean algunoNegativo = numeros.stream()
                .anyMatch(n -> n < 0);
        System.out.println("25. ¿Existe al menos un número negativo?: " + algunoNegativo);
    }
}

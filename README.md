# Ejercicio 01: Pantalla Aplicación Contador en Android

## Enunciado

Deberás recrear en android la aplicación del contador que se os proporciona. El diseño se os pasará por figma (abajo teneis el enlace). En este primer ejercicio solo debes hacer la parte visual, nada de lógica. Asegurate de que el resultado final sea identico al proporcionado, en tu criterio queda elegir el o los tipos de layouts que utilizarás. Mediante figma obtén el tipo de fuente, colores etc que debes utilizar en tu aplicación.


## Pantalla 1 

![Captura pantalla 1](https://i.imgur.com/MDcEvIf_d.webp?maxwidth=760&fidelity=grand)

Como vemos en la imagen consta de un título "CONTADOR", el número del contador "0", 3 botones "+", "RESET" y "-", y por último un texto footer con el nombre de la persona que lo ha realizado.
Para ello se ha utilizado un "Constraint Layout", y dos "Linear Layout" (Uno de ellos en vertical y el otro en horizontal).

# Ejercicio 02: Pantalla login y acceso a la pantalla del contador

## Enunciado

Crea la segunda pantalla en el mismo proyecto(investiga como). Deberás realizar un lógin tal y como se muestra en el figma, en el caso de que el usuario y contraseña sean admin en el TextView de abajo saldrá “Usuario y contraseña correcta” en caso contrario “Usuario o contraseña incorrecta”. Investigar por vuestra cuenta como iniciar la aplicación en la Activity login. Pista → se configura en el AndroidManifest.xml. Una vez que iniciemos el login deberá pasar a la pantalla del contador pasando el dato del nombre del usuario (aparecerá en la parte baja de la pantalla de contador donde ponía “by nombre_alumno”).

## Pantalla 2

![Captura pantalla 2](https://i.imgur.com/DW1dy8Q.png)![Captura pantalla 3](https://i.imgur.com/qPHpfSj.png)

## Descripción del ejercicio 

Tal y como se especificaba en el enunciado del ejercicio he realizado una nueva Activity llamada "Login", la cual se encarga de una pantalla de login con un título nombre, y contraseña (como se puede ver en las capturas de pantalla de la parte superior). Además esta Activity contiene un TextView en la parte inferior, que inicialmente está vacío, pero en caso de introducir un usuario o contraseña incorrectos muestra un mensaje de color rojo indicando el error (se puede observar en la segunda captura). De lo contrario, en caso de que el usuario introduzca el usuario y contraseña correctos se pasará a la Activity creada en el [Ejercicio 01](#), además de resetear el mensaje de error.

### Estructura Activity Login

Para que la Activity estuviera bien organizada y estructurada, además de asemejarse lo máximo posible al diseño dado, se ha optado por utilizar un LinearLayout, ya que todos los elementos están dispuestos de forma vertical en una columna. 

![Captura pantalla 4](https://i.imgur.com/gek4Bvq.png)

### Botón LOGIN

- Para el botón de login se ha optado por implementarle en el atributo "onClick" el método creado en el archivo "Login.java", de esta forma en el momento en el que el botón de Login se presione se llamará al método "iniciarSesion".

```xml
<Button
           ...
            android:onClick="iniciarSesion"
            android:text="LOGIN"
            ... />
```

### Lógica método iniciarSesion

- Este método de la clase "Login.java" se encarga de:
    - Tomar los valores de los EditText de Nombre y contraseña
    - Los compara con lo establecido como correcto (admin, admin)
        - En caso de que sea correcto reinicia el mensaje de error, guarda el valor del usuario en una variable y lanza el Activity según el Intent creado y pasándole el valor necesario.
        - En caso de que sea incorrecto le asigna el color rojo al texto del mensaje y le modifica el texto.

```java
public void iniciarSesion(View view) {

        EditText user = (EditText) findViewById(R.id.editTxtUser);
        EditText pass = (EditText) findViewById(R.id.editTxtPass);

        TextView mensaje = (TextView) findViewById(R.id.txtMensaje);

        if (user.getText().toString().equals("admin") && pass.getText().toString().equals("admin")){
            mensaje.setText("");
            String usuario = user.getText().toString();
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("user", usuario);
            startActivity(intent);
        } else {
            mensaje.setTextColor(0xFFFF0000);
            mensaje.setText("Usuario o contraseña incorrecta");

        }
    }
```

# Ejercicio 03: Fragments y contador funcional

## Enunciado

Cambia el proyecto para que el segundo activity en vez de ser el contador sea un activity con un FrameLayout en el que se verán los diferentes fragments (mínimo home, contador, salir) y por otra parte una barra de navegación con la que podamos viajar entre los diferentes fragments.

## Pantalla 1
La pantalla de login sigue igual, apareciendo la primera y comprobando que el usuario y la contraseña sean admin, de lo contrario no se podría acceder a la siguiente pantalla.

![Captura pantalla 1](https://i.imgur.com/QHnlOAy.png)

## Pantalla 2
Esta pantalla se trata del `HomeFragment`, es el primer fragment que se muestra. Como se puede observar en la parte inferior de la pantalla la aplicación dispone de un menú de navegación `BottomNavigationView` el cual cuenta con 3 botones "Inicio, Contador y Salir". Cada uno de estos botones representa un `fragment`.

![Captura pantalla 2](https://i.imgur.com/aGSTnoN.png)

# Pantalla 3

Esta pantalla se trata del `CounterFragment`. Este `fragment` representa el activity creado anteriormente del contador. La única diferencia es que en este caso sigue manteniedo la barra de navegación inferior y ya el contador es funcional.

![Captura pantalla 3](https://i.imgur.com/bE1Re6M.png)

# Pantalla 4

Esta pantalla se trata del `ExitFragment`. Este `fragment` representa una pantalla de salida de la aplicación.

![Captura pantalla 4](https://i.imgur.com/B7nd8SX.png)

## Descripción del ejercicio 

El ejercicio consiste en realizar modificaciones del proyecto Android para transformar el segundo Activity, que inicialmente representa un contador, en una nueva Activity que aloje un FrameLayout. Este FrameLayout se utilizará para mostrar diferentes fragments, entre los cuales se deben incluir al menos tres: "home", "contador" y "salir". Además, se debe implementar una barra de navegación que permita cambiar entre estos fragments de manera intuitiva.

Para lograr esto, se deben realizar ajustes en el diseño de la nueva Activity para alojar el FrameLayout y configurar la barra de navegación. Además, se deben crear los fragments correspondientes con sus respectivos diseños y funcionalidades. La barra de navegación deberá ser capaz de manejar la transición entre los fragments, proporcionando una experiencia de usuario fluida y accesible.


### Lógica contador funcional

Este código Java representa un fragmento en Android que se infla con un diseño específico (fragment_counter.xml). El fragmento contiene un contador y tres botones que permiten realizar operaciones (sumar, restar y restablecer) en el contador. Los métodos sumar, restar, reset y actualizarNumero se utilizan para manejar las operaciones y actualizar la interfaz de usuario en consecuencia.

- Incrementar el valor del contador y actualizar la interfaz de usuario.
```java
private void sumar() {
    contadorValue++;
    actualizarNumero();
}
```

- Decrementar el valor del contador y actualizar la interfaz de usuario.
```java
private void restar() {
    contadorValue--;
    actualizarNumero();
}
```

- Establecer el valor del contador en cero y actualizar la interfaz de usuario.
```java
private void reset() {
    contadorValue = 0;
    actualizarNumero();
}
```

- Actualizar el TextView que muestra el número del contador con el valor actual.
```java
private void actualizarNumero() {
    numeroContador.setText(String.valueOf(contadorValue));
}
```


# Ejercicio 04: Consumir API en el Log

## Enunciado

Añade un Fragment mas que se llame API y sigue el tutorial (para la parte del consumo de la API) proporcionado para consumir un API con android(en esta entrega no tendrás que reflejar los resultado en la interfaz gráfica, solo en el log). Por otro lado crea un microservicio con una sola entidad.

## Pantalla
Nuevo fragment creado para que en el momento en el que se acceda se consuma la api y muestre los resultados por la consola de Logs.

![Captura pantalla 1](https://i.imgur.com/l8DQlwL.png)

### Resultados de la API
![Resultados API](https://i.imgur.com/sYvtsg0.png)

## Modelado Entidad-Interfaz

- ### Entidad
Esta entidad se encarga de modelar el resultado obtenido de la API.
```java /**
 * Clase que representa un producto.
 */
package com.vedruna.ordunapenae01.model;

public class Producto {
    // Atributos
    private Long id;
    private String nombre;
    private float precio;

    // Constructor
    public Producto(Long id, String nombre, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Métodos de acceso (Getters y Setters)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    // Método toString para representación en cadena
    @Override
    public String toString() {
        return "Producto: " +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio;
    }
}
```

- ### Interefaz

```java
public interface CRUDInterface {

    @GET("api")
    Call<List<Producto>> getAllProducts();
}
```

## Implementación

Este fragmento de código corresponde a la implementación de un `Fragment` en Android para consumir una API REST que gestiona productos. El objetivo es obtener la lista de productos desde el servidor y mostrarla o realizar operaciones adicionales en la interfaz de usuario.

### Funcionalidad Principal

1. **Método `onCreate`:** Se llama al método `getAllProducts` al crear el fragmento. Este método se encarga de realizar la solicitud a la API para obtener todos los productos.

2. **Método `onCreateView`:** Infla el diseño del fragmento (`R.layout.fragment_api`) y lo retorna como la vista del fragmento.

3. **Método `getAllProducts`:** Utiliza Retrofit para realizar una solicitud HTTP GET a la API que proporciona la lista de productos. La URL base está definida como `http://192.168.153.1:8080/`. Se implementan callbacks para manejar las respuestas exitosas y los posibles errores.

4. **Callback `onResponse`:** En caso de una respuesta exitosa, se procesa la lista de productos recibida y se registran en el log.

5. **Callback `onFailure`:** En caso de error, se registra un mensaje de error en el log.

## Configuración de Retrofit

Retrofit es una biblioteca de cliente HTTP para Android y Java que simplifica la comunicación con servicios web RESTful. En este código, se configura Retrofit con la URL base del servidor y el convertidor Gson para manejar los datos en formato JSON.

```java
Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://192.168.153.1:8080/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();
```


## Recursos utilizados

- [Guía de Diseño de Android](https://developer.android.com/design)
- [Documentación de Layouts en Android](https://developer.android.com/guide/topics/ui/declaring-layout)

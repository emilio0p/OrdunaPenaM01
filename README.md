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


## Recursos utilizados

- [Guía de Diseño de Android](https://developer.android.com/design)
- [Documentación de Layouts en Android](https://developer.android.com/guide/topics/ui/declaring-layout)
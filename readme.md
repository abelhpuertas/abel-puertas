# Aplicación de grupos de Whatsapp

## Compilar y generar jar

```
mvn clean package
```

Generará un jar bajo el nombre `whatsapp-groups-1.0-SNAPSHOT.jar`

## Ejecutar aplicación

```
java -jar target/whatsapp-groups-1.0-SNAPSHOT.jar
```

El output de ejemplo será

```
Abel Tienes una nueva notificación: 
 Valeria te envió un nuevo mensaje: Hola! Cómo estan?


Marcos Tienes una nueva notificación: 
 Valeria te envió un nuevo mensaje: Hola! Cómo estan?
```

Código ejecutado en el ejemplo por defecto

```java
        WhatsappGroup group=new WhatsappGroup();

        //filling group with some participants...
        WhatsappParticipant abel=WhatsappParticipant.create("Abel","12345");
        WhatsappParticipant valeria=WhatsappParticipant.create("Valeria","12345");
        WhatsappParticipant marcos=WhatsappParticipant.create("Marcos","12345");
        group.addParticipant(abel);
        group.addParticipant(valeria);
        group.addParticipant(marcos);

        //send a message and alert participants!
        group.messageSent(valeria,"Hola! Cómo estan?");
```
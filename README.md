# Java RMI Example

This repository contains a simple example of RMI in Java.

## Compiling and Running on Linux

__Java Version: 13.0.2__

This commands must be executed inside ./java-rmi/ folder on the command prompt.

Compile the Registery Class (handle method requests) with the following command:

```
javac -d outputs phone-server-rmi/*.java
```

Inside outputs folder, run the registery class with the following command:

```
java Registery
```

Compile the Client Class (make method request to the server) with the following command:

```
javac -d outputs phone-client-rmi/*.java
```

Inside outputs folder, run the client class with the following command:

```
java PhoneBookClient
```

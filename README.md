# Serialization
Simple library to simplify Serialization process for classes and objects.

## Usage
Here is a simple class.

```java
var person = new Person(101, "mehdi");
var se = new Serialization<Person>("C:\\People\\mehdi", person);

if (se.isSerializable()) {
    se.serialize();
}
```

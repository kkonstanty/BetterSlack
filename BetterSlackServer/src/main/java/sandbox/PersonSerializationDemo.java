package sandbox;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class PersonSerializationDemo {
    public static void main(String[] args) throws IOException {
        Purchase purchase = new Purchase("laptop",5236.89);

        Person person = new Person("John", "Smith",30);
        person.addInteger(1);
        person.addInteger(2);
        person.addInteger(3);
        person.addPurchase(purchase);

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        String serialized = objectMapper.writeValueAsString(person);
        System.out.println(serialized);

        Person deserializePerson = objectMapper.readValue(serialized, Person.class);
        System.out.println(deserializePerson.getName());

    }
}

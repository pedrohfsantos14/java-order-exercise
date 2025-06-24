package entities;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Client {

    private static final DateTimeFormatter BIRTH_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String name;
    private String email;
    private LocalDate birthDate;

    public Client(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Client: " + name + " (" + BIRTH_DATE_FORMATTER.format(birthDate) + ")" + " - " + email;
    }
}

/**
 * Definir clase Address, para representar una dirección. Mejora la organizacion del codigo
 * al separar la logica relacionada con la direccion de la clase Human.
 */

public class Address {
    /**
     * Encapsula datos de la dirección como atributos privados.
     * Principio de encapsulación de SOLID, oculta los detalles de implementacion
     * y protege los datos de ser modificados directamente desde fuera de la clase.
     */
    private String country;
    private String city;
    private String street;
    private String house;
    private String quarter;

    /**
     * Constructor que permite la creacion de instancias de direcciones con
     * valores especificos para cada atributo.
     * Facilita la inicializacion de objetos Address con datos de direccion concretos.
     * @param country
     * @param city
     * @param street
     * @param house
     * @param quarter
     */
    public Address(String country, String city, String street, String house, String quarter) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.quarter = quarter;
    }

    /**
     * Metodo para obtener la direccion completa como una cadena.
     * Construye la direccion completa concatenando los diferentes atributos de
     * la direccion con formato adecuado utilizando un objeto StringBuilder.
     * @return
     */
    public String getFullAddress() {
        StringBuilder result = new StringBuilder();
        result.append(country).append(", ")
                .append(city).append(", ")
                .append(street).append(", ")
                .append(house).append(" ")
                .append(quarter);
        return result.toString();
    }
}


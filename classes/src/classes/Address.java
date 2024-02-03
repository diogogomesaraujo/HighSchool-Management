package classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Address implements Serializable
{
    String postalCode;
    String street;
    String residenceNumber;
    String parish; //freguesia
    String city;

    public Address()
    {
        postalCode = "";
        street = "";
        residenceNumber = "";
        city = "";
        parish = "";
    }

    public String getCity()
    {
        return city;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public String getResidenceNumber()
    {
        return residenceNumber;
    }

    public String getStreet()
    {
        return street;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setPostalCode(String postalCode)
    {
        this.postalCode = postalCode;
    }

    public void setResidenceNumber(String residenceNumber)
    {
        this.residenceNumber = residenceNumber;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getParish()
    {
        return parish;
    }

    public void setParish(String parish)
    {
        this.parish = parish;
    }

    private static String[] separatedAddressDetails(String input)
    {
        // Split the input string using the comma as a delimiter
        String[] addressDetails = input.split(", ");

        // Check if the input string has exactly five parts
        if (addressDetails.length != 5)
        {
            return null;
        }

        else return addressDetails;
    }

    public static Address anAddress() // ex: 4700-256, Rua do São Bentinho, n22, Maximínos, Aveiro
    {
        String s = "";
        while(true)
        {
            try
            {
                System.out.print("-> ");
                BufferedReader in = new BufferedReader ( new InputStreamReader(System.in));
                s = in.readLine();

                String[] details = separatedAddressDetails(s);

                if(details != null && isValidPostalCode(details[0]) && isValidStreetType(details[1]) && isValidResidenceNumber(details[2])
                        && isValidParish(details[3]) && isValidCity(details[4]))
                {
                    Address address = new Address();

                    address.setPostalCode(details[0]);
                    address.setStreet(details[1]);
                    address.setResidenceNumber(details[2]);
                    address.setParish(details[3]);
                    address.setCity(details[4]);

                    return address;
                }

                else System.out.println("\nInput Inválido!\n");
            }
            catch (IOException e)
            {
                System.out.print("\nErro de Input!\n");
                System.out.println();
            }
        }
    }

    public static boolean isValidPostalCode(String postalCode)
    {
        String postalCodePattern = "\\d{4}-\\d{3}";

        Pattern pattern = Pattern.compile(postalCodePattern);
        Matcher matcher = pattern.matcher(postalCode);

        return matcher.matches();
    }

    public static boolean isValidStreetType(String street)
    {
        String streetTypesPattern = "\\b(Rua|Av\\.?|Avenida|Praça|Largo|Alameda|Travessa|Tv\\.?|Beco|Calçada|Caminho|Rotunda)\\b";

        Pattern pattern = Pattern.compile(streetTypesPattern, Pattern.CASE_INSENSITIVE);

        return pattern.matcher(street).find();
    }

    public static boolean isValidParish(String parish) //For now it only checks to see if it has numbers
    {
        return !hasNumbers(parish);
    }

    public static boolean isValidResidenceNumber(String residenceNumber) //Only checking if it has digits because addresses in buildings tend to be more complicated
    {
        return hasNumbers(residenceNumber);
    }

    public static boolean isValidCity(String city)
    {
        return !hasNumbers(city);
    }

    public static boolean hasNumbers(String input) //Only checking if it has digits because addresses in buildings tend to be more complicated
    {
        // Regular expression to check for at least one digit
        return input.matches(".*\\d.*");
    }

    @Override
    public String toString()
    {
        return postalCode + ", " + street + ", " + residenceNumber + ", " + parish + ", " + city;
    }
}

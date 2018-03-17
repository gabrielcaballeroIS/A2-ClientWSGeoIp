package clientwsgeoip;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class ClientWSGeoIP {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Escribe una direccion ip: ");
        String direccionIp = input.next();
        
        Serializer serializer = new Persister();
        GeoIp geoIp = new GeoIp();
        serializer.read(geoIp,getGeoIp(direccionIp));
        
        System.out.println("ReturnCode: " + geoIp.getReturnCode());
        System.out.println("IP: " + geoIp.getIp());
        System.out.println("ReturnCodeDetails: " + geoIp.getReturnCodeDetails());
        System.out.println("CountryName: " + geoIp.getCountryName());
        System.out.println("CountryCode: " + geoIp.getCountryCode());
        
        System.out.println("\n.:TUS DATOS:.");
        serializer.read(geoIp, getGeoIPContext());
        
        System.out.println("ReturnCode: " + geoIp.getReturnCode());
        System.out.println("IP: " + geoIp.getIp());
        System.out.println("ReturnCodeDetails: " + geoIp.getReturnCodeDetails());
        System.out.println("CountryName: " + geoIp.getCountryName());
        System.out.println("CountryCode: " + geoIp.getCountryCode());
    }
    
    private static String getGeoIp(String ip) throws Exception{
        URL url = new URL("http://www.webservicex.net/geoipservice.asmx/GetGeoIP?IPAddress=" + ip);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        InputStreamReader input = new InputStreamReader(connection.getInputStream());
        try (BufferedReader reader = new BufferedReader(input)) {
            String line, result = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            return result;
        } 
    }
    
    private static String getGeoIPContext() throws Exception{
        URL url = new URL("http://www.webservicex.net/geoipservice.asmx/GetGeoIPContext?");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        InputStreamReader input = new InputStreamReader(connection.getInputStream());
        try (BufferedReader reader = new BufferedReader(input)) {
            String line, result = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            return result;
        }
    }
}

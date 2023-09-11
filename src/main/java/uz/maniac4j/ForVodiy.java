package uz.maniac4j;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.json.JSONObject;
import org.json.XML;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ForVodiy {

    private static final String WINDOWS1251 = "windows-1251";

    public static void main(String[] args) throws IOException {

        String base64String = "H4sIAAAAAAAEAI2Q0UvDMBDG3wX/h3CvkjXJGkyl2UhdNyaz2doO5pN0a6aVtoG2Ov98uzL1wRePD+44fvfBff70syrRh2nawtYS6IgAMvXB5kX9IuFU1Lk9tZgyTmE6ub7yY63Tc381WW6aiZ90jcmqZX206NjYSoJKtusFoDzrjARG2BgTr1dKyN0gcCa+c7nufbpsXxpUZ1VP6+AhvE8TOO8be0J6/2YO3fNiu5xJ8FwWcD6bY+byALs0FNhjtxSrQAgi5pS7hMP3STT4pdtHFamVilWsEUY7FaU6Dn+g+XtZ/gtUed6YtpWw0bHaqNVaL5ZJqiMUhwmgtW2Lrg9vJ4GPhBCeID9lbgihv8iTBHc0Fmz8B3HOPztDGMN0ifkLAkQm+Z4BAAA=";

        byte[] bytes = Base64.getDecoder().decode(base64String);
        byte[] s_selectdate = unzip(bytes);


        String sSelectDate = new String(s_selectdate, StandardCharsets.ISO_8859_1);

        System.out.println(String.format("Длина строки %d по интервалу дат", sSelectDate.length()));

        System.out.println(sSelectDate);

        System.out.println(convertXmlToJson(sSelectDate));
    }

    // Equivalent method for getting data from the web service.
    // Replace this with your actual web service interaction method.
    private static byte[] getAsupgData(int type, String guid, LocalDateTime startDate, LocalDateTime endDate) {
        // Implementation here
        return new byte[0];
    }

    public static byte[] zip(String str) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        try (GZIPOutputStream zipStream = new GZIPOutputStream(byteStream)) {
            zipStream.write(str.getBytes(WINDOWS1251));
        }
        return byteStream.toByteArray();
    }

    public static byte[] unzip(byte[] bytes) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        try (InputStream inputStream = new ByteArrayInputStream(bytes);
             GZIPInputStream zipStream = new GZIPInputStream(inputStream)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = zipStream.read(buffer)) != -1) {
                byteStream.write(buffer, 0, bytesRead);
            }
        }
        return byteStream.toByteArray();
    }

    public static byte[] decompress(byte[] compressedData) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (InputStream in = new GZIPInputStream(new ByteArrayInputStream(compressedData))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
        return out.toByteArray();
    }

    public static void json(String xml){
        try {
            ObjectMapper xmlMapper = new XmlMapper();
            Object json = xmlMapper.readValue(xml, Object.class);

            ObjectMapper jsonMapper = new ObjectMapper();
            jsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
            String jsonString = jsonMapper.writeValueAsString(json);

            System.out.println("JSON:");
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String convertXmlToJson(String xmlString) {
        int PRETTY_PRINT_INDENT_FACTOR = 4;
        JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
        return xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
    }
}


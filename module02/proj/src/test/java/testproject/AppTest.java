package testproject;

import static com.jayway.restassured.RestAssured.config;
import static com.jayway.restassured.config.DecoderConfig.decoderConfig;
import static org.junit.Assert.assertTrue;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.config.DecoderConfig;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.config.SSLConfig;
import com.jayway.restassured.filter.log.LogDetail;
import com.jayway.restassured.internal.RestAssuredResponseImpl;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.conn.EofSensorInputStream;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        String authCookie = ("admin" + ":" + "nimda");
        String authCookieEncoded =
                new String(Base64.encodeBase64(authCookie.getBytes()));
        RestAssured.useRelaxedHTTPSValidation();
        Response response = RestAssured.given()
                .relaxedHTTPSValidation()
                .config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()))
                .config(config().decoderConfig(decoderConfig().noContentDecoders()))
                .header("Authorization", "Basic " +authCookieEncoded)
                .when()
                .get("https://ecsd00300697.epam.com:9002/hac");



        String res = extractCsrfFromBody(response.getBody().asString());

       System.out.println(res);
    }

    private String extractCsrfFromBody(final String body) {
       // Pattern pattern = Pattern.compile("<meta name=\"_csrf\" content=\"([a-z0-9-]+?)\" />");
       // Pattern pattern = Pattern.compile("<meta name=\"_csrf\" content=\"8ae7931a-19ca-409c-aaba-97ea4dbefb10\"/>");
       // Pattern pattern = Pattern.compile("<meta name=\"_csrf\" content=\"[a-z0-9-]+?\"");
        Pattern pattern = Pattern.compile("<meta name=\"_csrf\" content=\"([a-z0-9-]+?)\"");
        Matcher matcher = pattern.matcher(body);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    @Test
    public void shouldAnswerWithTrue2()
    {
        String authCookie = ("[6768768]");
        authCookie =  authCookie.replaceAll("\\[\"(.*?)\"\\]", "$1");

        System.out.println(authCookie);
    }
}

package alishev.spring.course.go_play_footbikapi;


import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class JwtSecretKeyGeneratorTest {

    public static String generateSecretKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
    @Test
    public void TestGenerateSecretKey() throws Exception {
        String secretKey = generateSecretKey();
        System.out.println("Secret Key: " + "[" + secretKey + "]");
        Assert.notNull(secretKey, "Secret key cannot be null");
    }
}

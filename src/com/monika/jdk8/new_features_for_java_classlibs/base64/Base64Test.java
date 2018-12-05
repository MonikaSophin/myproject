package com.monika.jdk8.new_features_for_java_classlibs.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author: XueYing.Cao
 * @date: 2018/12/5
 * @description:
 *    在Java 8中，Base64编码已经成为Java类库的标准。
 *    Base64类同时还提供了对URL、MIME友好的编码器与解码器
 *（Base64.getUrlEncoder() / Base64.getUrlDecoder(),Base64.getMimeEncoder() / Base64.getMimeDecoder()）。
 */
public class Base64Test {
    public static void main(String[] args) {
        final String text = "Base64 finally in Java 8!";
        final String encoded = Base64
                .getEncoder()
                .encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println("encoded: " + encoded);
        final String decoded = new String(
          Base64.getDecoder().decode(encoded),
          StandardCharsets.UTF_8);
        System.out.println("decoded: " + decoded);
    }
}
/**输出：
 * encoded: QmFzZTY0IGZpbmFsbHkgaW4gSmF2YSA4IQ==
 * decoded: Base64 finally in Java 8!
 */
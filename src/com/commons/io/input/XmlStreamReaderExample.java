package com.commons.io.input;

import org.apache.commons.io.input.XmlStreamReader;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author XueYing.Cao
 * @date 2019/9/10
 */
public class XmlStreamReaderExample {

    public static void main(String[] args) throws IOException {

        String xmlPath = "D:/GithubRepository/myproject/src/com/commons/io/input/src/test.xml";

        /**
         * 1. XmlStreamReader与org.xml.sax.XMLReader没有任何关系，仅仅是一个字符流。
         *    XmlStreamReader类通过提供一组广泛的构造函数来处理文件、原始流和HTTP流中的XML文档的字符集编码。
         */
        XmlStreamReader xmlStreamReader1 = new XmlStreamReader(new File(xmlPath));
        XmlStreamReader xmlStreamReader2 = new XmlStreamReader(new URL("http://www.baidu.com"));
        String encoding1 = xmlStreamReader1.getEncoding();
        String encoding2 = xmlStreamReader2.getEncoding();

        System.out.println("file xml encoding: " + encoding1);
        System.out.println("url xml encoding: " + encoding2);
    }
}
/**output:
 * file xml encoding: UTF-8
 * url xml encoding: US-ASCII
 */
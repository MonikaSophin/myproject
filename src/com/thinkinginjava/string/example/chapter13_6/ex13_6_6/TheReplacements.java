package com.thinkinginjava.string.example.chapter13_6.ex13_6_6;

/*! Here's a block of text to use as input to
    the regular expression matcher. Note that we'll
    first extract the block of text by looking for
    the special delimiters, then process the
    extracted block. !*/

import com.thinkinginjava.string.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: monika
 * @Date: 2019/1/13 17:35
 * @Version: 1.0
 * @Description:
 */
public class TheReplacements {
    public static void main(String[] args) {
        String s = TextFile.read("src\\com\\thinkinginjava\\string\\example\\chapter13_6\\ex13_6_6\\TheReplacements.java");
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL)
                .matcher(s);
        if (mInput.find())
            s = mInput.group(1);
        s = s.replaceAll(" {2,}"," ");
        s = s.replaceAll("(?m)^ +","");
        System.out.println(s);
        System.out.println();

        s = s.replaceFirst("[aeiou]","(VOWEL1)");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        while (m.find())
            m.appendReplacement(sbuf,m.group().toUpperCase());
        m.appendTail(sbuf);
        System.out.println(sbuf);
    }
}
/**output:
 * Here's a block of text to use as input to
 * the regular expression matcher. Note that we'll
 * first extract the block of text by looking for
 * the special delimiters, then process the
 * extracted block.
 *
 * H(VOWEL1)rE's A blOck Of tExt tO UsE As InpUt tO
 * thE rEgUlAr ExprEssIOn mAtchEr. NOtE thAt wE'll
 * fIrst ExtrAct thE blOck Of tExt by lOOkIng fOr
 * thE spEcIAl dElImItErs, thEn prOcEss thE
 * ExtrActEd blOck.
 */
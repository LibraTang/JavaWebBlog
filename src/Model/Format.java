package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Format {
    public static boolean accountFormat(String account) {
        boolean result = false;
        Pattern pattern = Pattern.compile("^[a-zA-Z]{1,15}$"); //匹配不多于15个英文字母
        Matcher matcher = pattern.matcher(account); //匹配传进来的账号
        if(matcher.matches()) //若匹配成功
            result = true;
        return result;
    }

    public static boolean passFormat(String password) {
        boolean result = false;
        Pattern pattern = Pattern.compile("^[a-zA-Z]{1,16}$"); //匹配不多于16个英文字母
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches())
            result = true;
        return result;
    }
}

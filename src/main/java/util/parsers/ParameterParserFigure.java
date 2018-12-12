package util.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ParameterParserFigure implements ParameterParser {
    private List<Double> list = new ArrayList<Double>();
    public List<Double> parseParameters(String str){
        if (str == null) {
            return list;
        }
        double buff;
        Scanner in = new Scanner(str);
        in.useDelimiter("[,;]");
        in.useLocale(Locale.US);
        while(in.hasNext()){
            buff = in.nextDouble();
            list.add(buff);
        }
        return list;
    }
}

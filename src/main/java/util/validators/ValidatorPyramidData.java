package util.validators;

import exeptions.NotValidArgumentException;
import util.creators.CreatorFigure;
import util.creators.CreatorPyramid;
import util.parsers.ParameterParserFigure;
import util.parsers.ParameterParser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorPyramidData implements ValidatorFigure {
    public CreatorFigure getCreator() {
        return new CreatorPyramid();
    }

    /**
     * Regex checking of arguments : first 6 are double(2 points xyz coordinates),
     * 7th is int number of edges of pyramid basis
     * 8th is positive double edge size of pyramid basis
     * @param str
     * @return
     */
    private boolean isLegalArguments(String str){
        String patternStr = "(-?\\d+\\.?\\d*[,;]){6}[1-9]\\d*[,;]\\d+\\.?\\d*";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * The basis of pyramid will be parallel to plane XY,
     * so z coordinates of topPoint and middlePoint must be different
     * edgeSize must be positive
     * edgeNumber must be numerical
     * @param str
     * @return
     */
    public boolean isValid(String str) throws NotValidArgumentException {
        if (str == null){
            throw new NotValidArgumentException("null as argument has been detected");
        }
        ParameterParser parser = new ParameterParserFigure();
        if (!isLegalArguments(str)){
            return false;
        }
        List<Double> list = parser.parseParameters(str);
        double zTop = list.get(2);
        double zMiddle = list.get(5);
        if (zTop == zMiddle){
            return false;
        }
        double edgeSize = list.get(7);
        return (edgeSize > 0 );
    }
}

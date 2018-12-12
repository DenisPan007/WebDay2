package util.creators;

import entities.Point3d;
import entities.Pyramid;
import exeptions.NotValidArgumentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.parsers.ParameterParser;
import util.parsers.ParameterParserFigure;

import java.util.List;

public class CreatorPyramid implements CreatorFigure  {
    private static final Logger logger = LogManager.getLogger(ParameterParser.class);
    public Pyramid create(String str) throws NotValidArgumentException {
        if (str == null){
            logger.error("null as argument has been detected");
            throw new NotValidArgumentException("null as argument has been detected");
        }
        ParameterParser parser = new ParameterParserFigure();
        List<Double> paramList = parser.parseParameters(str);
        Point3d topPoint = new Point3d(paramList.get(0),paramList.get(1),paramList.get(2));
        Point3d middlePoint = new Point3d(paramList.get(3),paramList.get(4),paramList.get(5));
        int edgeNumber = (int)(double)paramList.get(6);
        double edgeSize = paramList.get(7);
        Pyramid pyramid = new Pyramid(topPoint,middlePoint,edgeNumber,edgeSize);
        return pyramid;
    }
}

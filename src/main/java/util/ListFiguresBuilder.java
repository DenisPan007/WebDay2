package util;
import exeptions.NotValidArgumentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.creators.CreatorFigure;
import entities.Figure;
import util.validators.ValidatorFigure;
import java.util.ArrayList;
import java.util.List;

public class ListFiguresBuilder {
    private static final Logger logger = LogManager.getLogger(ListFiguresBuilder.class);
    private static List<Figure> list = new ArrayList<Figure>();
    public static List<Figure> buildListFigures(List<String> strFile, ValidatorFigure validator)
            throws NotValidArgumentException {
        if (strFile == null || validator == null){
            logger.error("null as argument has been detected");
            throw new NotValidArgumentException("null as argument has been detected");
        }
        Figure figure;
        CreatorFigure creator = validator.getCreator();
        for (String str:strFile) {
            if(validator.isValid(str)){
                figure = creator.create(str);
                list.add(figure);
            }
        }
        return list;
    }
}

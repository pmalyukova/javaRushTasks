package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;
import com.sun.javafx.iio.ImageStorage;

import static com.javarush.task.task16.task1631.common.ImageTypes.*;
import static com.javarush.task.task16.task1631.common.ImageTypes.BMP;

/**
 * Created by IntelliJ IDEA.
 * User: PolinaMalyukova
 * Date: 02.07.2019
 * Time: 14:32
 */

public class ImageReaderFactory {


    public static ImageReader getImageReader(ImageTypes ext) {
        if (ext == ImageTypes.JPG)
            return new JpgReader();
        else if (ext == ImageTypes.BMP)
            return new BmpReader();
        else if (ext == ImageTypes.PNG)
            return new PngReader();
        throw new IllegalArgumentException("Неизвестный тип картинки");
    }
//            switch (types) {
//                case JPG:
//                    toReturn = new JpgReader();
//                    break;
//                case PNG:
//                    toReturn = new PngReader();
//                    break;
//                case BMP:
//                    toReturn = new BmpReader();
//                    break;
//                default:
//                    throw new IllegalArgumentException("Неизвестный тип картинки");
//            }

//        return toReturn;
//    }
}

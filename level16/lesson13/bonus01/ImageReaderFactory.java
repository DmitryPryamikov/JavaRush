package com.javarush.test.level16.lesson13.bonus01;

/**
 * Created by DimaMarina on 07.06.2016.
 */
import com.javarush.test.level16.lesson13.bonus01.common.BmpReader;
import com.javarush.test.level16.lesson13.bonus01.common.ImageReader;
import com.javarush.test.level16.lesson13.bonus01.common.ImageTypes;
import com.javarush.test.level16.lesson13.bonus01.common.JpgReader;
import com.javarush.test.level16.lesson13.bonus01.common.PngReader;

public class ImageReaderFactory {
    //
    public static ImageReader getReader(ImageTypes type)
    {
        if (type ==ImageTypes.BMP)
        {
            return new BmpReader();
        }
        else if (type==ImageTypes.JPG)
        {
            return new JpgReader();
        }
        else if (type==ImageTypes.PNG)
        {
            return new PngReader();
        }
        else
        {
            throw  new IllegalArgumentException("Неизвестный тип картинки");
        }
    }

}

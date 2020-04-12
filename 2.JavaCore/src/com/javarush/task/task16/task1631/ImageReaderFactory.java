package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type)  {

                if (ImageTypes.BMP.equals(type)) {
                    return  new BmpReader();
                    //   System.out.println("result = new BmpReader()");
                }
                else if (ImageTypes.JPG.equals(type))
                    return  new JpgReader();
                else if (ImageTypes.PNG.equals(type))
                    return  new PngReader();
                else {
             //   System.out.println("nulllll");
                throw new IllegalArgumentException("Неизвестный тип картинки");
            }
    }
}

package com.vodafone.vodafone_eshop_taf.utilities.image_reducer;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class ImageReducer {
    public static String reduce(byte[] image, int newWidth, int newHeight) throws IOException {
        InputStream inputStream = new ByteArrayInputStream(image);
        BufferedImage imageSrc = ImageIO.read(inputStream);
        imageSrc = Scalr.resize(imageSrc, Scalr.Method.QUALITY, newWidth, newHeight);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(imageSrc, "PNG", outputStream);
        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }
}

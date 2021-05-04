package lesson19HoWo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class ImageRSHoWo19
//extends FileHandler // с картинками работа, обычно одна программа только считывает,
// а другая программа уже собирает картинку
{
    protected File file;

        public ImageRSHoWo19(File file) {
            setFile(file);
        }

        public void setFile(File file)
        {
            this.file = file;
        }

        // если надо файл не png, а другой
        private String getExtension()
        {
            return Optional.of(file.getName()).filter(s -> s.contains("."))
                    .map(s -> s.substring(file.getName().lastIndexOf(".") + 1 ))
                    .orElse("png");
        }

        //@Override
        public boolean writeToFile(byte[] data) throws IOException // записать в файл прочитанное ранее изображение
        {
            try (ByteArrayInputStream stream = new ByteArrayInputStream(data)) // закроется клоузом так как это в ТРАЕ прописано
            {
                BufferedImage bufferedImage = ImageIO.read(stream); //надо закрывать close
                return ImageIO.write(bufferedImage,"png",file);
            }

        }

        //@Override
        public byte[] readFromFile() throws IOException
        {
            BufferedImage bufferedImage = ImageIO.read(file); // из какогото файла с изображением считали его
            // и создаём объект чтобы его обработать
            ByteArrayOutputStream stream = new ByteArrayOutputStream(); // создаём массив и в него пишем изображение
            // и после этого можем работать с байтами
            ImageIO.write(bufferedImage /*что мы пишем*/,"png",stream/*куда мы пишем*/);
            return stream.toByteArray();
        }
}


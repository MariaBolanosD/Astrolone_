package ayudas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private static final String CONFIG_FILE_PATH = "resources/config.properties";

    public static Properties loadConfig() {
        Properties properties = new Properties();
        FileHandle fileHandle = Gdx.files.internal(CONFIG_FILE_PATH);

        try {
            properties.load(fileHandle.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}

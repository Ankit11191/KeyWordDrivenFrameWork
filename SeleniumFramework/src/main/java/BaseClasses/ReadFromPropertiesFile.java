package BaseClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertiesFile {
    Properties  properties=new Properties();
    public String readProperties(String propName)
    {
        FileInputStream file=null;
        try {
            file = new FileInputStream(getClass().getClassLoader().getResource("configFile/config.properties").getPath());
            properties.load(file);
        }catch (IOException IOExe)
        {
            System.out.println(IOExe.getLocalizedMessage());
        }
        String value=properties.getProperty(propName);
        return  value;
    }
}

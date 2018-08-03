package BaseClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertiesFile {
    public String readProperties(String propName)
    {
        Properties  properties=new Properties();
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

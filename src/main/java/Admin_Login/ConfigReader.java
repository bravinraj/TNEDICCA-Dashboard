package Admin_Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        InputStream input = null;

        try {
           // input = getClass().getClassLoader().getResourceAsStream("/TNEDICCA_DASHBOARD_AUTOMATION/Configuration.properties");
        	input=new FileInputStream("Configuration.properties");
            // Load a properties file from the classpath
            properties.load(input);
            
            }catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*public String getdriverpath()
    {
    	return properties.getProperty("driver_path");
    }*/

    public String getUrl() {
        return properties.getProperty("URL");
    }

    public String getUsername() {
        return properties.getProperty("valid_username");
    }

    public String getPassword() {
        return properties.getProperty("valid_password");
    }
    public String getInvalidUsername() {
        return properties.getProperty("invalid_username");
    }
    public String getinvalidPassword() {
        return properties.getProperty("invalid_password");
    }

}


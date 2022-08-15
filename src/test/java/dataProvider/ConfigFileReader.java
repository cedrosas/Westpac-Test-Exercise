package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {


    private Properties properties;
    private final String propertyFilePath = "Configs//Configuration.properties";


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getLoginID() {
        String LoginID = properties.getProperty("Login");
        if(LoginID != null) return LoginID;
        else throw new RuntimeException("LoginID not specified in the Configuration.properties file.");
    }

    public String getFirstname() {
        String FirstName = properties.getProperty("FirstName");
        if(FirstName != null) return FirstName;
        else throw new RuntimeException("Firstname not specified in the Configuration.properties file.");
    }

    public String getLastname() {
        String LastName = properties.getProperty("LastName");
        if(LastName != null) return LastName;
        else throw new RuntimeException("LastName not specified in the Configuration.properties file.");
    }
    public String getPassword() {
        String Password = properties.getProperty("Password");
        if(Password != null) return Password;
        else throw new RuntimeException("LastName not specified in the Configuration.properties file.");
    }

    public String getConfirmPassword() {
        String ConfirmPassword = properties.getProperty("ConfirmPassword");
        if(ConfirmPassword != null) return ConfirmPassword;
        else throw new RuntimeException("LastName not specified in the Configuration.properties file.");
    }

    public String getGender() {
        String Gender = properties.getProperty("Gender");
        if(Gender != null) return Gender;
        else throw new RuntimeException("LastName not specified in the Configuration.properties file.");
    }

    public String getAge() {
        String Age = properties.getProperty("Age");
        if(Age != null) return Age;
        else throw new RuntimeException("LastName not specified in the Configuration.properties file.");
    }
    public String getAddress() {
        String Address = properties.getProperty("Address");
        if(Address != null) return Address;
        else throw new RuntimeException("LastName not specified in the Configuration.properties file.");
    }
    public String getPhone() {
        String Phone = properties.getProperty("Phone");
        if(Phone != null) return Phone;
        else throw new RuntimeException("LastName not specified in the Configuration.properties file.");
    }

    public String getHobby() {
        String Hobby = properties.getProperty("Hobby");
        if(Hobby != null) return Hobby;
        else throw new RuntimeException("LastName not specified in the Configuration.properties file.");
    }

    public String getnewPassword() {
        String newPassword = properties.getProperty("newPassword");
        if(newPassword != null) return newPassword;
        else throw new RuntimeException("LastName not specified in the Configuration.properties file.");
    }

    public String getComment() {
        String Comment = properties.getProperty("Comment");
        if(Comment != null) return Comment;
        else throw new RuntimeException("LastName not specified in the Configuration.properties file.");
    }


}
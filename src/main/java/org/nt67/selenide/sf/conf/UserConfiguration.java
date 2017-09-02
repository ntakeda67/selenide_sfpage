package org.nt67.selenide.sf.conf;

import org.nt67.selenide.sf.AppLog;
import org.nt67.selenide.sf.user.SFUser;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserConfiguration {
    private File file;

    public UserConfiguration(String ymlFile) {
        try {
            Path filePath = Paths.get(this.getClass().getClassLoader().getResource(ymlFile).toURI());
            file = filePath.toFile();
            AppLog.out.info(file.getAbsolutePath());
            if(!file.exists()) { throw new FileNotFoundException(); }
        } catch (URISyntaxException | FileNotFoundException e) {
            throw new IllegalArgumentException("Configuration file not found: " + ymlFile, e);
        }
    }

    public SFUser get(){
        Yaml yaml = new Yaml();
        try {
            return yaml.loadAs(new FileInputStream(file), SFUserYaml.class).to();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Configuration file not found", e);
        }
    }
}

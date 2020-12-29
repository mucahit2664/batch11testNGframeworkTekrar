package com.techproed.tests;

import com.techproed.utulities.TestBase;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class D15_FilePath extends TestBase {
    @Test
    public  void test(){
        System.out.println(System.getProperty("user.dir"));
        String anaPath=System.getProperty("user.home");

        String masausutuPath=anaPath +"\\DESKTOP";
        System.out.println("desktop yolu "+masausutuPath);
    }
    @Test
    public void isExist(){
        String homePath=System.getProperty("user.home");
        String filePath=homePath+"\\Desktop\\Flower.jpg";

        boolean dosyaVarmi= Files.exists(Paths.get(filePath));
        System.out.println(dosyaVarmi);
    }
}

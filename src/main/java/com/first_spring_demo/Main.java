package com.first_spring_demo;

import com.first_spring_demo.common.utils.Print;
import com.first_spring_demo.mbg.Generator;
import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * @author wxd
 */
public class Main {
    public static void main(String[] args) {
        try {
            startWebServer();
        } catch (Exception e) {
            Print.print(e.getMessage());
        }
    }

    private static void startWebServer() {
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(Integer.getInteger("port", 8080));
            tomcat.getConnector();
            Context ctx = tomcat.addWebapp("", new File("src/main/webapp").getAbsolutePath());
            WebResourceRoot resources = new StandardRoot(ctx);
            resources.addPreResources(
                    new DirResourceSet(resources, "/WEB-INF/classes", new File("target/classes").getAbsolutePath(), "/"));
            ctx.setResources(resources);
            tomcat.start();
            tomcat.getServer().await();
        } catch (Exception e) {
        }
    }

    private static void generateModelMapper() throws Exception {
        Generator.generateMapper();
    }
}

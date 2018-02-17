package ua.danit.Templates;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;

import static freemarker.template.Configuration.VERSION_2_3_21;

public class TemplateForLiked {

  public static void write(Writer out, Object user) throws IOException {
    try {
      getTemplate("LikedPeople.html").process(user, out);
    } catch (TemplateException e) {
      throw new RuntimeException(e);
    }
  }
  public static Template getTemplate(String name) throws IOException {
    Configuration config = new Configuration(VERSION_2_3_21);
    URL resource = TemplateWriteFile.class.getClassLoader().getResource(".");
    String path = resource.getPath();
    config.setDirectoryForTemplateLoading(new File(path));
    return config.getTemplate(name);
  }
}

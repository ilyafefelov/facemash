package ua.danit.Template;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;

import static freemarker.template.Configuration.VERSION_2_3_21;

public class Template {

  public static void write(String tmp, Writer out, Object user) throws IOException {
    try {
      getTemplate(tmp).process(user, out);
    } catch (TemplateException e) {
      throw new RuntimeException(e);
    }
  }
  public static freemarker.template.Template getTemplate(String name) throws IOException {
    Configuration config = new Configuration(VERSION_2_3_21);
    URL resource = Template.class.getClassLoader().getResource(".");
    String path = resource.getPath();
    config.setDirectoryForTemplateLoading(new File(path));
    return config.getTemplate(name);
  }
}

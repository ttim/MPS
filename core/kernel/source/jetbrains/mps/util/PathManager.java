/*
 * Copyright 2003-2010 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.util;

import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;
import jetbrains.mps.vfs.IFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PathManager {
  private static final Logger LOG = Logger.getLogger(PathManager.class);

  public static final String PROPERTY_HOME_PATH = "mps.home.path";

  private static final String FILE = "file";
  private static final String JAR = "jar";
  private static final String JAR_DELIMITER = "!";
  private static final String PROTOCOL_DELIMITER = ":";

  private static String ourHomePath;

  private static final Pattern MODEL_UID_PATTERN = Pattern.compile(ModelPersistence.MODEL_UID + "=\"(.*?)\"");

  public static String getHomePath() {
    if (ourHomePath != null) {
      return ourHomePath;
    }

    if (System.getProperty(PROPERTY_HOME_PATH) != null) {
      ourHomePath = getAbsolutePath(System.getProperty(PROPERTY_HOME_PATH));
      return ourHomePath;
    }

    final Class aClass = PathManager.class;

    String rootPath = getResourceRoot(aClass, "/" + aClass.getName().replace('.', '/') + ".class");
    if (rootPath != null) {
      File root = new File(rootPath);
      root = root.getAbsoluteFile();

      if (!root.isDirectory() || root.getName().toLowerCase().endsWith(".zip") || root.getName().toLowerCase().endsWith(".jar")) {
        root = new File(root.getParent()); // one step back to getCollectionClass folder
      }
      root = root.getAbsoluteFile();

      while (true) {
        if (isMpsDir(root)) break;
        if (root.getParentFile() == null) {
          break;
        }

        root = root.getParentFile();
      }

      ourHomePath = root.getAbsolutePath();    // one step back to getCollectionClass rid of "lib" or "classes" folder
      return ourHomePath;
    }

    return new File(".").getAbsolutePath(); //we need this for build server on which stuff written above
    //for somne reason doesn't work
  }

  public static String getBootstrapPath() {
    return getHomePath() + File.separator + "core";
  }

  public static String getPlatformPath() {
    return getHomePath() + File.separator + "platform";
  }

  //------------------

  public static SModelReference createModelReference(IFile modelFile, IFile root, String namespacePrefix) {
    SModelReference fromFile = getFileUID(modelFile);
    if (fromFile != null) return fromFile;
    String rawLongName = getModelReferenceString(modelFile, root, namespacePrefix);
    return SModelReference.fromString(rawLongName);
  }

  private static String getModelReferenceString(IFile modelFile, IFile root, String namespacePrefix) {
    String longName = cropModelPath(modelFile, root);
    if (longName == null) return null;

    String namespace = NameUtil.namespaceFromLongName(longName);
    namespace = namespace.replace(File.separatorChar, '.').replace('/', '.');

    if (namespacePrefix != null && namespacePrefix.length() > 0) {
      namespace = namespacePrefix + ((namespace.length() > 0) ? "." + namespace : "");
    }
    return namespace;
  }

  private static SModelReference getFileUID(IFile modelFile) {
    try {
      String secondLine = FileUtil.readLine(modelFile.openReader(), 1);
      if (secondLine == null) {
        return null;
      }

      Matcher m = MODEL_UID_PATTERN.matcher(secondLine);
      if (m.find()) {
        return SModelReference.fromString(m.group(1));
      }

      return null;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static String cropModelPath(IFile modelFile, IFile root) {
    String modelPath = modelFile.getCanonicalPath();
    String rootPath = root.getCanonicalPath();
    if (!modelPath.startsWith(rootPath)) return null;

    int length = rootPath.length();
    if (rootPath.endsWith(File.separator) || rootPath.endsWith("!")) {
      length--;
    }
    return modelPath.substring(length + 1);
  }

  //------------------

  private static boolean isMpsDir(File file) {
    return new File(file, "build.number").exists();
  }

  private static String getAbsolutePath(String path) {
    if (path.startsWith("~/") || path.startsWith("~\\")) {
      path = System.getProperty("user.home") + path.substring(1);
    }

    File file = new File(path);
    if (!file.exists()) return path;
    file = file.getAbsoluteFile();
    return FileUtil.getCanonicalPath(file.getAbsolutePath());
  }

  /**
   * Attempts to detect classpath entry which contains given resource
   */
  public static String getResourceRoot(Class context, String path) {
    URL url = context.getResource(path);
    if (url == null) {
      url = ClassLoader.getSystemResource(path.substring(1));
    }
    if (url == null) {
      return null;
    }
    return extractRoot(url, path);
  }

  /**
   * Attempts to extract classpath entry part from passed URL.
   */
  private static String extractRoot(URL resourceURL, String resourcePath) {
    if (!(resourcePath.startsWith("/") || resourcePath.startsWith("\\"))) {
      LOG.error("precondition failed for" + resourcePath);
      return null;
    }
    String protocol = resourceURL.getProtocol();
    String resultPath = null;

    if (FILE.equals(protocol)) {
      String path = resourceURL.getFile();
      String testPath = path.replace('\\', '/').toLowerCase();
      String testResourcePath = resourcePath.replace('\\', '/').toLowerCase();
      if (testPath.endsWith(testResourcePath)) {
        resultPath = path.substring(0, path.length() - resourcePath.length());
      }
    } else if (JAR.equals(protocol)) {
      String fullPath = resourceURL.getFile();
      int delimiter = fullPath.indexOf(JAR_DELIMITER);
      if (delimiter >= 0) {
        String archivePath = fullPath.substring(0, delimiter);
        if (archivePath.startsWith(FILE + PROTOCOL_DELIMITER)) {
          resultPath = archivePath.substring(FILE.length() + PROTOCOL_DELIMITER.length());
        }
      }
    }

    if (resultPath != null && resultPath.endsWith(File.separator)) {
      resultPath = resultPath.substring(0, resultPath.length() - 1);
    }

    resultPath = StringUtil.replace(resultPath, "%20", " ");
    return resultPath;
  }
}

package jetbrains.mps.smodel;

import jetbrains.mps.projectLanguage.ModelRoot;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Igoor
 * Date: Jul 27, 2005
 * Time: 8:15:44 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IOperationContext {

  ModelOwner getModelOwner();

  LanguageOwner getLanguageOwner();

  SModelDescriptor getModelDescriptor(SModelUID modelUID);

  SModelDescriptor getModelDescriptor(String modelName);

  List<SModelDescriptor> getModelDescriptors();

  List<SModelDescriptor> getModelDescriptors(String modelName);

  void registerModelDescriptor(SModelDescriptor modelDescriptor);

  void unRegisterModelDescriptor(SModelDescriptor model);

  Language getLanguage(String languageNamespace);

  List<Language> getLanguages();

  void dispose();

  <T> T getComponent(Class<T> clazz);

  /**
   * @deprecated
   */
  List<ModelRoot> getModelRoots();

  SModelDescriptor createModel(SModelUID uid, String path, String pathPrefix);

  List<String> getClassPath();

  String getHomePath();
}

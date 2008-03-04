package jetbrains.mps.smodel;

import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptLink;
import jetbrains.mps.util.Condition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;

/**
 * Igor Alshannikov
 * Date: Mar 5, 2007
 */
public interface INodeAdapter {
  @NotNull
  SNode getNode();

  String getDebugText();

  String getName();

  String getShortConceptName();

  SModel getModel();

  String getId();

  String getAlias();

  INodeAdapter getParent();

  <BA extends INodeAdapter> BA findParent(Class<BA> cls);

  <BA extends INodeAdapter> BA getParent(Class<BA> cls);

  <BA extends INodeAdapter> BA getParent(Class<BA> cls, boolean checkThis);

  INodeAdapter findParent(Condition<INodeAdapter> ba);

  INodeAdapter findFirstParent(Class[] classes);

  <T extends INodeAdapter> List<T> findParents(Class<T> aClass);

  AbstractConceptDeclaration getConceptDeclarationAdapter();

  void replaceChild(INodeAdapter oldChild, INodeAdapter newChild);

  INodeAdapter getContainingRoot();

  <BA extends INodeAdapter> List<BA> allChildren(Class<BA> cls, Condition<BA> cond);

  <BA extends INodeAdapter> List<BA> allChildren(Class<BA> cls);

  <BA extends INodeAdapter> List<BA> allChildren(Condition<BA> c);

  @NotNull
  <E extends INodeAdapter> List<E> getSubnodes(Condition<INodeAdapter> condition);

  void delete();

  void addNextSibling(INodeAdapter a);

  void addPrevSibling(INodeAdapter a);

  boolean hasConceptProperty(String propertyName);

  String getConceptProperty(String propertyName);

  String getProperty(@NotNull String propertyName);

  void setProperty(@NotNull String propertyName, String propertyValue);

  void removeChild(@NotNull INodeAdapter child);

  void addChild(@NotNull String role,
                @NotNull INodeAdapter child);

  void insertChild(@Nullable INodeAdapter anchorChild,
                   @NotNull String role,
                   @NotNull INodeAdapter child,
                   boolean insertBefore);

  void insertChild(@Nullable INodeAdapter anchorChild,
                   @NotNull String role,
                   @NotNull INodeAdapter child);

  int getChildCount(@NotNull String role);

  List<INodeAdapter> getChildren();

  @NotNull
    <N extends INodeAdapter> List<N> getChildren(Class<N> cls);

  <T extends INodeAdapter> List<T> getChildren(@NotNull String role);

  <T extends INodeAdapter> Iterator<T> children(@NotNull String role);

  @Nullable
  INodeAdapter getAttribute();

  List<INodeAdapter> getAllAttributes();

  @Nullable
  INodeAdapter getAttribute(String role);

  @NotNull
  List<? extends INodeAdapter> getAttributes(String role);

  void setAttribute(INodeAdapter adapter);

  void setAttribute(String role, INodeAdapter attribute);

  void addAttribute(String role, INodeAdapter attribute);

  INodeAdapter getPropertyAttribute(String propertyName);

  INodeAdapter getPropertyAttribute(String role, String propertyName);

  @NotNull
  List<? extends INodeAdapter> getPropertyAttributes(String role, String propertyName);

  void setPropertyAttribute(String role, String propertyName, INodeAdapter propertyAttribute);

  void addPropertyAttribute(String role, String propertyName, INodeAdapter propertyAttribute);

  INodeAdapter getLinkAttribute(String propertyName);

  INodeAdapter getLinkAttribute(String role, String propertyName);

  void setLinkAttribute(String role, String propertyName, INodeAdapter propertyAttribute);

  void addLinkAttribute(String role, String propertyName, INodeAdapter propertyAttribute);

  List<? extends INodeAdapter> getLinkAttributes(String role, String linkRole);

  String getRole_();

  Object getUserObject(@NotNull Object key);

  void removeUserObject(@NotNull Object key);

  void putUserObject(@NotNull Object key, @Nullable Object value);

  boolean isRoot();

  List<SNode> getConceptLinkTargets(String linkName, boolean lookupHierarchy);

  String getConceptFQName();
}

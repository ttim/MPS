package jetbrains.mps.project.io;

/*Generated by MPS */

import jetbrains.mps.vfs.IFile;
import org.jdom.Element;

public interface DescriptorIO<T> {
  public T readFromFile(IFile file) throws DescriptorIOException;
  public void writeToFile(T t, IFile file) throws DescriptorIOException;
  public T readFromXml(Element element, IFile anchorFile) throws DescriptorIOException;
  public void writeToXml(T t, Element element, IFile anchorFile) throws DescriptorIOException;
}

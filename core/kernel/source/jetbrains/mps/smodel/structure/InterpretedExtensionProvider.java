/*
 * Copyright 2003-2012 JetBrains s.r.o.
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
package jetbrains.mps.smodel.structure;

/**
 * Created by IntelliJ IDEA.
 * User: fyodor
 * Date: 1/20/12
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class InterpretedExtensionProvider extends DescriptorProvider<ExtensionDescriptor> {

  private static final InterpretedExtensionDesc INTERPRETED_EXTENSION = new InterpretedExtensionDesc();

  @Override
  public ExtensionDescriptor getDescriptor(String fqName) {
    return INTERPRETED_EXTENSION;
  }
  
  public static class InterpretedExtensionDesc implements ExtensionDescriptor {
    @Override
    public Iterable<? extends ExtensionPoint> getExtensionPoints() {
      // TODO implement me
      throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<? extends Extension> getExtensions() {
      // TODO implement me
      throw new UnsupportedOperationException();
    }
  }
}

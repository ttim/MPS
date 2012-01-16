/*
 * Copyright 2003-2011 JetBrains s.r.o.
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
package jetbrains.mps.plugins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: fyodor
 * Date: 12/9/11
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class PluginFactoriesRegistry {

  private static Collection<AbstractPluginFactory> myPluginFactories = Collections.synchronizedCollection(new ArrayList<AbstractPluginFactory>());

  public static void registerPluginFactory(AbstractPluginFactory contributor) {
    myPluginFactories.add(contributor);
  }

  public static Collection<AbstractPluginFactory> getPluginFactories() {
    return myPluginFactories;
  }

}

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

package jetbrains.mps.idea.core.project;

import com.intellij.openapi.module.Module;
import jetbrains.mps.project.Solution;
import jetbrains.mps.project.structure.modules.Dependency;
import jetbrains.mps.project.structure.modules.SolutionDescriptor;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.vfs.IFile;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shatalin
 * Date: 11/18/11
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class SolutionIdea extends Solution {

    private Module myModule;

    public SolutionIdea(Module module, SolutionDescriptor descriptor) {
        myModule = module;
        // TODO: simply set solution descriptor local variable?
        setSolutionDescriptor(descriptor, false);
    }

    @Override
    public boolean needReloading() {
        return false;
    }

    @Override
    protected SolutionDescriptor loadDescriptor() {
        return getModuleDescriptor();
    }

    @Override
    public List<Dependency> getDependencies() {
        return super.getDependencies();
    }

    @Override
    public void save() {
        // TODO: implement saving functionality here.
//        super.save();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public IFile getDescriptorFile() {
        return FileSystem.getInstance().getFileByPath(myModule.getModuleFilePath());
    }
}

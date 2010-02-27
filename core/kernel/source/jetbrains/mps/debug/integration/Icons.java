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
package jetbrains.mps.debug.integration;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 09.12.2009
 * Time: 18:22:38
 * To change this template use File | Settings | File Templates.
 */
public class Icons {
  public static final Icon BREAKPOINT = new ImageIcon(Icons.class.getResource("db_set_breakpoint.png"));
  public static final Icon INV_BREAKPOINT = new ImageIcon(Icons.class.getResource("db_invalid_breakpoint.png"));
  public static final Icon VARIABLE_PRIMITIVE = new ImageIcon(Icons.class.getResource("db_primitive.png"));
  public static final Icon VARIABLE_OBJECT = new ImageIcon(Icons.class.getResource("db_object.png"));
}

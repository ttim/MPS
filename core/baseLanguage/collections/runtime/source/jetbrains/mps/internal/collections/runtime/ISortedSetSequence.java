/*
 * Copyright 2003-2009 JetBrains s.r.o.
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
package jetbrains.mps.internal.collections.runtime;

import java.util.SortedSet;

public interface ISortedSetSequence<T> extends ISetSequence<T>, SortedSet<T> {

	ISortedSetSequence<T> headSet (T toElement);
	
	ISortedSetSequence<T> tailSet (T fromElement);
	
	ISortedSetSequence<T> subSet (T fromElement, T toElement);
	
	public ISortedSetSequence<T> addSequence(ISequence<? extends T> seq);
	
	public ISortedSetSequence<T> removeSequence(ISequence<? extends T> seq);
	
}

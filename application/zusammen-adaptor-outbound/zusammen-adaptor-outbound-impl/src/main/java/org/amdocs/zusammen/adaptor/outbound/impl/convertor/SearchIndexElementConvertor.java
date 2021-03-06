/*
 * Add Copyright © 2016-2017 European Support Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.amdocs.zusammen.adaptor.outbound.impl.convertor;

import org.amdocs.zusammen.core.api.types.CoreElement;
import org.amdocs.zusammen.datatypes.Space;
import org.amdocs.zusammen.datatypes.item.ElementContext;
import org.amdocs.zusammen.sdk.searchindex.types.SearchIndexElement;

public class SearchIndexElementConvertor {

  public static SearchIndexElement convertFromCoreElement(ElementContext elementContext,
                                                          CoreElement element, Space space) {
    SearchIndexElement searchIndexElement = new SearchIndexElement(elementContext.getItemId(),
        elementContext.getVersionId(), element.getNamespace(), element.getId());
    searchIndexElement.setSpace(space);
    searchIndexElement.setSearchableData(element.getSearchableData());
    return searchIndexElement;
  }
}

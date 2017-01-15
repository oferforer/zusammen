/*
 * Copyright © 2016 Amdocs Software Systems Limited 
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

package org.amdocs.tsuzammen.adaptor.outbound.impl.item;

import org.amdocs.tsuzammen.adaptor.outbound.api.item.ItemVersionStateAdaptor;
import org.amdocs.tsuzammen.adaptor.outbound.impl.OutboundAdaptorUtils;
import org.amdocs.tsuzammen.datatypes.Id;
import org.amdocs.tsuzammen.datatypes.SessionContext;
import org.amdocs.tsuzammen.datatypes.item.Info;
import org.amdocs.tsuzammen.datatypes.item.ItemVersion;

import java.util.Collection;

public class ItemVersionStateAdaptorImpl implements ItemVersionStateAdaptor {

  @Override
  public Collection<ItemVersion> listItemVersions(SessionContext context, Id itemId) {
    return OutboundAdaptorUtils.getStateStore(context).listItemVersions(context, itemId);
  }

  @Override
  public boolean isItemVersionExist(SessionContext context, Id itemId, Id versionId) {
    return OutboundAdaptorUtils.getStateStore(context)
        .isItemVersionExist(context, itemId, versionId);
  }

  @Override
  public ItemVersion getItemVersion(SessionContext context, Id itemId, Id versionId) {
    return OutboundAdaptorUtils.getStateStore(context).getItemVersion(context, itemId, versionId);
  }

  @Override
  public void createItemVersion(SessionContext context, Id itemId, Id baseVersionId,
                                Id versionId, Info versionInfo) {
    OutboundAdaptorUtils.getStateStore(context)
        .createItemVersion(context, itemId, baseVersionId, versionId, versionInfo);
  }

  @Override
  public void saveItemVersion(SessionContext context, Id itemId, Id versionId,
                              Info versionInfo) {

  }

  @Override
  public void deleteItemVersion(SessionContext context, Id itemId, Id versionId) {

  }
}

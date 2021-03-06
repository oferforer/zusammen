/*
 * Copyright © 2016-2017 European Support Limited
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

package org.amdocs.zusammen.adaptor.outbound.api.item;

import org.amdocs.zusammen.datatypes.Id;
import org.amdocs.zusammen.datatypes.SessionContext;
import org.amdocs.zusammen.datatypes.item.Info;
import org.amdocs.zusammen.datatypes.item.Item;
import org.amdocs.zusammen.datatypes.response.Response;

import java.util.Collection;

public interface ItemStateAdaptor {

  Response<Collection<Item>> listItems(SessionContext context);

  Response<Boolean> isItemExist(SessionContext context, Id itemId);

  Response<Item> getItem(SessionContext context, Id itemId);

  Response<Void> createItem(SessionContext context, Id itemId, Info itemInfo);

  Response<Void> updateItem(SessionContext context, Id itemId, Info itemInfo);

  Response<Void> deleteItem(SessionContext context, Id itemId);
}

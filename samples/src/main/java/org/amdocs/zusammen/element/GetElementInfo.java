package org.amdocs.zusammen.element;

import org.amdocs.zusammen.adaptor.inbound.api.types.item.ElementInfo;
import org.amdocs.zusammen.datatypes.Id;
import org.amdocs.zusammen.datatypes.SessionContext;
import org.amdocs.zusammen.datatypes.item.ElementContext;

public class GetElementInfo extends Element {


  public static void main(String[] args) {
    try {
      Id itemId = initItem(contextA);
      Id versionId = initVersion(contextA, itemId, null);
      Id elementId = initElement(contextA, itemId, versionId);

      GetElementInfo getElementInfo = new GetElementInfo();
      ElementInfo elementInfo = getElementInfo.getElement(contextA, itemId, versionId, elementId);
      printElement(elementInfo);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      System.exit(0);
    }

  }


  public ElementInfo getElement(SessionContext
                                    context, Id itemId, Id versionId,
                                Id elementId) {
    return getElementAdaptor(context)
        .getInfo(context, new ElementContext(itemId, versionId), elementId).getValue();
  }

}

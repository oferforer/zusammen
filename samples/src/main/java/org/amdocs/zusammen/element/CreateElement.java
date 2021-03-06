package org.amdocs.zusammen.element;

import org.amdocs.zusammen.adaptor.inbound.api.types.item.Element;
import org.amdocs.zusammen.adaptor.inbound.api.types.item.ElementInfo;
import org.amdocs.zusammen.datatypes.Id;
import org.amdocs.zusammen.datatypes.SessionContext;
import org.amdocs.zusammen.datatypes.item.ElementContext;

import java.util.Collection;

public class CreateElement extends org.amdocs.zusammen.element.Element {


  public static void main(String[] args) {

    Id itemId = initItem(contextA);
    Id versionId = initVersion(contextA, itemId, null);
    Id elementId = initElement(contextA, itemId, versionId);

    System.exit(0);
  }

  public Id execute(SessionContext context, Id itemId, Id versionId, Element element, String
      message, String identifier) {

    ElementContext elementContext = new ElementContext(itemId, versionId);
    if (identifier != null) {
      element.getInfo().getProperties().put("Identifier", identifier);
    }

    getElementAdaptor(context).save(context, elementContext, element, message);

    Id elementId = getElementId(context, itemId, versionId, identifier);
    return elementId;
  }

  public Id getElementId(SessionContext context, Id itemId, Id versionId, String
      identifier) {
    Collection<ElementInfo> list =
        getElementAdaptor(context).list(context, new ElementContext(itemId, versionId), null).getValue();
    for (ElementInfo elementInfo : list) {

      if (elementInfo.getInfo().getProperties().get("Identifier") != null && elementInfo.getInfo()
          .getProperties().get("Identifier").equals(identifier)) {
        return elementInfo.getId();
      }
    }

    return null;
  }


}

package org.amdocs.zusammen.element;

import org.amdocs.zusammen.datatypes.Id;
import org.amdocs.zusammen.datatypes.SessionContext;
import org.amdocs.zusammen.datatypes.item.ElementContext;
import org.amdocs.zusammen.utils.fileutils.FileUtils;
import org.amdocs.zusammen.utils.fileutils.json.JsonUtil;

public class GetElementData extends org.amdocs.zusammen.element.Element {



  public static void main(String[] args) {
    try {
      Id itemId = initItem(contextA);
      Id versionId = initVersion(contextA, itemId, null);
      Id elementId = initElement(contextA, itemId, versionId);

      GetElementData getElementData = new GetElementData();
      org.amdocs.zusammen.adaptor.inbound.api.types.item.Element element = getElementData
          .getElementData(contextA, itemId, versionId, elementId);
      printElementData(element);
    }catch (Exception e){
      e.printStackTrace();
    }
    finally {
      System.exit(0);
    }

  }



  public static void printElementData(org.amdocs.zusammen.adaptor.inbound.api.types.item.Element element) {
    System.out.println("==================element  =========================");
    System.out.println("elementId:" + element.getElementId());

        if (element.getInfo() != null) {
      System.out.println("element Info:" + JsonUtil.object2Json(element.getInfo()));
    }
    if (element.getRelations() != null) {
      System.out.println("element Relations:" + JsonUtil.object2Json(element.getRelations()));
    }

    if (element.getData() != null) {
      System.out.println("element Data:" + new String(FileUtils.toByteArray(element.getData
          ())));
    }

    if (element.getVisualization() != null) {
      System.out.println("element visualization:" + new String(FileUtils.toByteArray(element.getVisualization
          ())));
    }
    if (element.getSearchableData() != null) {
      System.out.println("element searchableData:" + new String(FileUtils.toByteArray(element
          .getSearchableData
          ())));
    }

    if (element.getSubElements() != null && element.getSubElements().size() > 0) {
      element.getSubElements().stream().forEach(subElementInfo -> System.out.println("sub " +
          "elementid:" + subElementInfo.getElementId()));
    }
    System.out.println("==================END=========================");
  }

  public org.amdocs.zusammen.adaptor.inbound.api.types.item.Element getElementData(SessionContext context, Id itemId, Id versionId,
                                                                                   Id elementId) {
    return getElementAdaptor(context)
        .get(context, new ElementContext(itemId, versionId), elementId).getValue();
  }

}

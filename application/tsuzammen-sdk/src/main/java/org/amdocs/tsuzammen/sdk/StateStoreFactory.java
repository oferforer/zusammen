package org.amdocs.tsuzammen.sdk;

import org.amdocs.tsuzammen.commons.datatypes.SessionContext;
import org.amdocs.tsuzammen.utils.facade.api.AbstractComponentFactory;
import org.amdocs.tsuzammen.utils.facade.api.AbstractFactory;

/**
 * Created by TALIG on 11/27/2016.
 */
public abstract class StateStoreFactory extends AbstractComponentFactory<StateStore> {

  public static StateStoreFactory getInstance() {
    return AbstractFactory.getInstance(StateStoreFactory.class);
  }

  public abstract StateStore createInterface(SessionContext context);
}

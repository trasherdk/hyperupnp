/*
 * Copyright (C) 2013 4th Line GmbH, Switzerland
 *
 * The contents of this file are subject to the terms of either the GNU
 * Lesser General Public License Version 2 or later ("LGPL") or the
 * Common Development and Distribution License Version 1 or later
 * ("CDDL") (collectively, the "License"). You may not use this file
 * except in compliance with the License. See LICENSE.txt for more
 * information.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */

package app.vbt.hyperupnp.upnp.cling.support.model.item;

import java.util.ArrayList;
import java.util.List;

import app.vbt.hyperupnp.upnp.cling.support.model.DIDLObject;
import app.vbt.hyperupnp.upnp.cling.support.model.DescMeta;
import app.vbt.hyperupnp.upnp.cling.support.model.Res;
import app.vbt.hyperupnp.upnp.cling.support.model.WriteStatus;
import app.vbt.hyperupnp.upnp.cling.support.model.container.Container;

/**
 * @author Christian Bauer
 */
public class Item extends DIDLObject {

    protected String refID;

    public Item() {
    }

    public Item(Item other) {
        super(other);
        setRefID(other.getRefID());
    }

    public Item(String id, String parentID, String title, String creator, boolean restricted, WriteStatus writeStatus, Class clazz, List<Res> resources, List<Property> properties, List<DescMeta> descMetadata) {
        super(id, parentID, title, creator, restricted, writeStatus, clazz, resources, properties, descMetadata);
    }

    public Item(String id, String parentID, String title, String creator, boolean restricted, WriteStatus writeStatus, Class clazz, List<Res> resources, List<Property> properties, List<DescMeta> descMetadata, String refID) {
        super(id, parentID, title, creator, restricted, writeStatus, clazz, resources, properties, descMetadata);
        this.refID = refID;
    }

    public Item(String id, Container parent, String title, String creator, DIDLObject.Class clazz) {
        this(id, parent.getId(), title, creator, false, null, clazz, new ArrayList(), new ArrayList(), new ArrayList());
    }

    public Item(String id, Container parent, String title, String creator, DIDLObject.Class clazz, String refID) {
        this(id, parent.getId(), title, creator, false, null, clazz, new ArrayList(), new ArrayList(), new ArrayList(), refID);
    }

    public Item(String id, String parentID, String title, String creator, DIDLObject.Class clazz) {
        this(id, parentID, title, creator, false, null, clazz, new ArrayList(), new ArrayList(), new ArrayList());
    }

    public Item(String id, String parentID, String title, String creator, DIDLObject.Class clazz, String refID) {
        this(id, parentID, title, creator, false, null, clazz, new ArrayList(), new ArrayList(), new ArrayList(), refID);
    }

    public String getRefID() {
        return refID;
    }

    public void setRefID(String refID) {
        this.refID = refID;
    }
}

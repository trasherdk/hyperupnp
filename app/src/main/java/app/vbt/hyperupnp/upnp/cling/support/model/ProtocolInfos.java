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

package app.vbt.hyperupnp.upnp.cling.support.model;

import java.util.ArrayList;

import app.vbt.hyperupnp.upnp.cling.model.ModelUtil;
import app.vbt.hyperupnp.upnp.cling.model.types.InvalidValueException;

/**
 * @author Christian Bauer
 */
public class ProtocolInfos extends ArrayList<ProtocolInfo> {

    public ProtocolInfos(ProtocolInfo... info) {
        for (ProtocolInfo protocolInfo : info) {
            add(protocolInfo);
        }
    }

    public ProtocolInfos(String s) throws InvalidValueException {
        String[] infos = ModelUtil.fromCommaSeparatedList(s);
        if (infos != null)
            for (String info : infos)
                add(new ProtocolInfo(info));
    }

    @Override
    public String toString() {
        return ModelUtil.toCommaSeparatedList(toArray(new ProtocolInfo[size()]));
    }
}

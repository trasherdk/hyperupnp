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

package app.vbt.hyperupnp.upnp.cling.support.igd.callback;

import app.vbt.hyperupnp.upnp.cling.controlpoint.ActionCallback;
import app.vbt.hyperupnp.upnp.cling.controlpoint.ControlPoint;
import app.vbt.hyperupnp.upnp.cling.model.action.ActionInvocation;
import app.vbt.hyperupnp.upnp.cling.model.meta.Service;
import app.vbt.hyperupnp.upnp.cling.support.model.PortMapping;

/**
 * @author Christian Bauer
 */
public abstract class PortMappingAdd extends ActionCallback {

    final protected PortMapping portMapping;

    public PortMappingAdd(Service service, PortMapping portMapping) {
        this(service, null, portMapping);
    }

    protected PortMappingAdd(Service service, ControlPoint controlPoint, PortMapping portMapping) {
        super(new ActionInvocation(service.getAction("AddPortMapping")), controlPoint);

        this.portMapping = portMapping;

        getActionInvocation().setInput("NewExternalPort", portMapping.getExternalPort());
        getActionInvocation().setInput("NewProtocol", portMapping.getProtocol());
        getActionInvocation().setInput("NewInternalClient", portMapping.getInternalClient());
        getActionInvocation().setInput("NewInternalPort", portMapping.getInternalPort());
        getActionInvocation().setInput("NewLeaseDuration", portMapping.getLeaseDurationSeconds());
        getActionInvocation().setInput("NewEnabled", portMapping.isEnabled());
        if (portMapping.hasRemoteHost())
            getActionInvocation().setInput("NewRemoteHost", portMapping.getRemoteHost());
        if (portMapping.hasDescription())
            getActionInvocation().setInput("NewPortMappingDescription", portMapping.getDescription());

    }

}

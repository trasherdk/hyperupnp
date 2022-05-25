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

package app.vbt.hyperupnp.upnp.cling.support.avtransport.callback;

import java.util.logging.Logger;

import app.vbt.hyperupnp.upnp.cling.controlpoint.ActionCallback;
import app.vbt.hyperupnp.upnp.cling.model.action.ActionInvocation;
import app.vbt.hyperupnp.upnp.cling.model.meta.Service;
import app.vbt.hyperupnp.upnp.cling.model.types.UnsignedIntegerFourBytes;
import app.vbt.hyperupnp.upnp.cling.support.model.DeviceCapabilities;

/**
 * @author Christian Bauer
 */
public abstract class GetDeviceCapabilities extends ActionCallback {

    private static final Logger log = Logger.getLogger(GetDeviceCapabilities.class.getName());

    public GetDeviceCapabilities(Service service) {
        this(new UnsignedIntegerFourBytes(0), service);
    }

    public GetDeviceCapabilities(UnsignedIntegerFourBytes instanceId, Service service) {
        super(new ActionInvocation(service.getAction("GetDeviceCapabilities")));
        getActionInvocation().setInput("InstanceID", instanceId);
    }

    public void success(ActionInvocation invocation) {
        DeviceCapabilities caps = new DeviceCapabilities(invocation.getOutputMap());
        received(invocation, caps);
    }

    public abstract void received(ActionInvocation actionInvocation, DeviceCapabilities caps);

}
/*
 * Copyright (c) 2017 Bosch Software Innovations GmbH.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/org/documents/epl-2.0/index.php
 *
 * Contributors:
 *    Bosch Software Innovations GmbH - initial contribution
 */
package org.eclipse.ditto.signals.commands.live.query;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;

import org.eclipse.ditto.model.base.headers.DittoHeaders;
import org.eclipse.ditto.signals.commands.base.Command;
import org.eclipse.ditto.signals.commands.things.query.RetrieveThing;

/**
 * An immutable implementation of {@link RetrieveThingLiveCommand}.
 */
@ParametersAreNonnullByDefault
@Immutable
final class RetrieveThingLiveCommandImpl extends AbstractQueryLiveCommand<RetrieveThingLiveCommand,
        RetrieveThingLiveCommandAnswerBuilder> implements RetrieveThingLiveCommand {

    private RetrieveThingLiveCommandImpl(final RetrieveThing command) {
        super(command);
    }

    /**
     * Returns an instance of {@code RetrieveThingLiveCommandImpl}.
     *
     * @param command the command to base the result on.
     * @return the instance.
     * @throws NullPointerException if {@code command} is {@code null}.
     * @throws ClassCastException if {@code command} is not an instance of {@link RetrieveThing}.
     */
    @Nonnull
    public static RetrieveThingLiveCommandImpl of(final Command<?> command) {
        return new RetrieveThingLiveCommandImpl((RetrieveThing) command);
    }

    @Override
    public RetrieveThingLiveCommand setDittoHeaders(final DittoHeaders dittoHeaders) {
        final RetrieveThing twinCommand = RetrieveThing.getBuilder(getThingId(), dittoHeaders)
                .withSelectedFields(getSelectedFields().orElse(null))
                .build();
        return of(twinCommand);
    }

    @Nonnull
    @Override
    public RetrieveThingLiveCommandAnswerBuilder answer() {
        return RetrieveThingLiveCommandAnswerBuilderImpl.newInstance(this);
    }

    @Nonnull
    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + super.toString() + "]";
    }

}

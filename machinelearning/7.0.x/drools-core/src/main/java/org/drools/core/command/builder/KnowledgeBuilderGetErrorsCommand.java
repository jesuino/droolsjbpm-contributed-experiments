/*
 * Copyright 2010 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.core.command.builder;

import org.drools.core.command.impl.ExecutableCommand;
import org.drools.core.command.impl.RegistryContext;
import org.drools.core.runtime.impl.ExecutionResultImpl;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderErrors;
import org.kie.api.runtime.Context;

public class KnowledgeBuilderGetErrorsCommand
    implements
    ExecutableCommand<KnowledgeBuilderErrors> {

    private String outIdentifier;

    public KnowledgeBuilderGetErrorsCommand() {
    }
    
    public KnowledgeBuilderGetErrorsCommand(String outIdentifier) {
        this.outIdentifier = outIdentifier;
    }

    public KnowledgeBuilderErrors execute(Context context) {
        KnowledgeBuilder kbuilder = ((RegistryContext) context).lookup( KnowledgeBuilder.class );
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if ( this.outIdentifier != null ) {
            ((RegistryContext) context).lookup( ExecutionResultImpl.class ).setResult( this.outIdentifier, errors );
        }
        return errors;
    }

}
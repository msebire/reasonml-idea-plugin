package com.reason.ide.repl;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ui.configuration.projectRoot.ProjectSdksModel;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReplRunConfiguration extends RunConfigurationBase {
    @Nullable
    private Sdk m_sdk;

    ReplRunConfiguration(Project project, ConfigurationFactory factory, String name) {
        super(project, factory, name);
        ProjectSdksModel model = new ProjectSdksModel();
        model.reset(getProject());
        for (Sdk sdk : model.getSdks()) {
            if ("OCaml SDK".equals(sdk.getSdkType().getName())) {
                m_sdk = sdk;
                return;
            }
        }
    }

    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new ReplRunSettingsEditor(getProject());
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {
        if (m_sdk == null)
            throw new RuntimeConfigurationException("No SDK selected");
    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment executionEnvironment) throws ExecutionException {
        return new ReplGenericState(executionEnvironment);
    }

    @Nullable
    public Sdk getSdk() {
        return m_sdk;
    }

    public void setSdk(Sdk selectedJdk) {
        m_sdk = selectedJdk;
    }

    @Override
    public void writeExternal(@NotNull Element element) throws WriteExternalException {
        super.writeExternal(element);
        element.addContent(new Element("sdk").setAttribute("name", m_sdk == null ? "" : m_sdk.getName()));
    }

    @Override
    public void readExternal(@NotNull Element element) throws InvalidDataException {
        super.readExternal(element);
        Element node = element.getChild("sdk");
        if (node != null) {
            String sdkName = node.getAttributeValue("name");
            if (!sdkName.isEmpty()) {
                ProjectSdksModel model = new ProjectSdksModel();
                model.reset(getProject());
                for (Sdk sdk : model.getSdks()) {
                    if (sdkName.equals(sdk.getName())) {
                        m_sdk = sdk;
                        return;
                    }
                }
            }
        }
    }
}
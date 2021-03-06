package com.reason.ide.search;

import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import com.reason.lang.core.psi.PsiModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class ModuleCompIndex extends StringStubIndexExtension<PsiModule> {
    private static final int VERSION = 1;
    private static final ModuleCompIndex INSTANCE = new ModuleCompIndex();

    @NotNull
    public static ModuleCompIndex getInstance() {
        return INSTANCE;
    }

    @Override
    public int getVersion() {
        return super.getVersion() + VERSION;
    }

    @NotNull
    @Override
    public StubIndexKey<String, PsiModule> getKey() {
        return IndexKeys.MODULES_COMP;
    }

    @Nullable
    public PsiModule getUnique(@NotNull String fqn, @NotNull Project project, @NotNull GlobalSearchScope scope) {
        Collection<PsiModule> psiModules = get(fqn, project, scope);
        return psiModules.isEmpty() ? null : psiModules.iterator().next();
    }
}

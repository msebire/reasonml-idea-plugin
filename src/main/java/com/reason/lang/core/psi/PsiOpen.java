package com.reason.lang.core.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import static com.reason.lang.RmlTypes.MODULE_PATH;

public class PsiOpen extends ASTWrapperPsiElement {

    public PsiOpen(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String getName() {
        PsiElement name = findChildByType(MODULE_PATH);
        return name == null ? "" : name.getText();
    }

    @Override
    public String toString() {
        return "Open(" + getName() + ")";
    }
}

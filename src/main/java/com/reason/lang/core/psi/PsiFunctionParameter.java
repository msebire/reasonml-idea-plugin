package com.reason.lang.core.psi;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import com.reason.lang.core.psi.impl.PsiSignatureImpl;
import com.reason.lang.core.type.ORTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PsiFunctionParameter extends ASTWrapperPsiElement implements PsiNamedElement {

    private final ORTypes m_types;

    public PsiFunctionParameter(ORTypes m_types, ASTNode node) {
        super(node);
        this.m_types = m_types;
    }

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        PsiElement firstChild = getFirstChild();
        if (firstChild != null && firstChild.getNode().getElementType() == m_types.TILDE) {
            return firstChild.getNextSibling();
        }
        return firstChild;
    }

    @Override
    public String getName() {
        PsiElement identifier = getNameIdentifier();
        return identifier == null ? "" : identifier.getText();
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        return this;
    }

    @Override
    public String toString() {
        return "Function parameter " + getName();
    }

    @NotNull
    public PsiSignature getSignature() {
        PsiSignature signature = PsiTreeUtil.findChildOfType(this, PsiSignature.class);
        return signature == null ? PsiSignatureImpl.EMPTY : signature;
    }
}
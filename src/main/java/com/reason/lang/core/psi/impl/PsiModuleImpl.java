package com.reason.lang.core.psi.impl;

import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import com.reason.icons.Icons;
import com.reason.lang.core.psi.PsiModule;
import com.reason.lang.core.psi.PsiModuleName;
import com.reason.lang.core.psi.PsiLet;
import com.reason.lang.core.psi.PsiScopedExpr;
import com.reason.lang.core.stub.ModuleStub;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Collection;

public class PsiModuleImpl extends StubBasedPsiElementBase<ModuleStub> implements PsiModule {

    //region Constructors
    public PsiModuleImpl(ASTNode node) {
        super(node);
    }

    public PsiModuleImpl(ModuleStub stub, IStubElementType nodeType) {
        super(stub, nodeType);
    }
    //endregion

    //region NamedElement
    @Override
    public String getName() {
        ModuleStub moduleStub = getStub();
        if (moduleStub != null) {
            return moduleStub.getName();
        }

        PsiElement nameIdentifier = getNameIdentifier();
        return nameIdentifier == null ? "" : nameIdentifier.getText();
    }

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        return findChildByClass(PsiModuleName.class);
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        return this; // Use PsiModuleReference.handleElementRename()
    }
    //endregion

    @Override
    public PsiReference getReference() {
        PsiElement nameIdentifier = getNameIdentifier();
        if (nameIdentifier != null && nameIdentifier instanceof PsiModuleName) {
            return new PsiModuleReference((PsiModuleName) nameIdentifier);
        }

        return null;
    }

    @Nullable
    public PsiScopedExpr getModuleBody() {
        return findChildByClass(PsiScopedExpr.class);
    }

    public Collection<PsiLet> getLetExpressions() {
        return PsiTreeUtil.findChildrenOfType(this, PsiLet.class);
    }

    public ItemPresentation getPresentation() {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return Icons.MODULE;
            }
        };
    }

    @Override
    public String toString() {
        return "Module(" + getName() + ")";
    }
}

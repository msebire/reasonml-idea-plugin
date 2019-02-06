package com.reason.lang.core.psi.impl;

import java.util.*;
import java.util.stream.*;
import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.reason.lang.ModulePathFinder;
import com.reason.lang.core.psi.PsiTagName;
import com.reason.lang.core.type.ORTypes;
import com.reason.lang.ocaml.OclModulePathFinder;
import com.reason.lang.reason.RmlModulePathFinder;
import com.reason.lang.reason.RmlTypes;

import static java.util.stream.Collectors.*;

public class PsiTagNameImpl extends PsiToken<ORTypes> implements PsiTagName {

    //region Constructors
    public PsiTagNameImpl(@NotNull ORTypes types, @NotNull ASTNode node) {
        super(types, node);
    }
    //endregion

    @NotNull
    @Override
    public String getName() {
        return Stream.of(getChildren()).map(PsiElement::getText).collect(joining("."));
    }

    @NotNull
    @Override
    public String toString() {
        return "TagName " + getName();
    }

    public List<String> getPotentialPaths() {
        ModulePathFinder modulePathFinder = m_types instanceof RmlTypes ? new RmlModulePathFinder() : new OclModulePathFinder();

        return modulePathFinder.extractPotentialPaths(this).stream().
                map(item -> item + "." + getName()).
                collect(toList());
    }
}

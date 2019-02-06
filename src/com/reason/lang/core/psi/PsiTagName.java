package com.reason.lang.core.psi;

import java.util.*;
import org.jetbrains.annotations.NotNull;
import com.intellij.psi.PsiElement;

public interface PsiTagName extends PsiElement {
    @NotNull
    String getName();

    List<String> getPotentialPaths();
}

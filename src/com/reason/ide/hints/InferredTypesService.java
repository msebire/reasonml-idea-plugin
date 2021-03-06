package com.reason.ide.hints;

import com.intellij.lang.Language;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.reason.hints.InsightManager;
import com.reason.ide.docs.DocumentationProvider;
import com.reason.ide.files.FileBase;
import com.reason.ide.files.FileHelper;
import com.reason.lang.ocaml.OclLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.file.FileSystems;

public class InferredTypesService {

    private static final Logger LOG = Logger.getInstance("ReasonML.types.inferredService");

    private InferredTypesService() {
    }

    public static void queryForSelectedTextEditor(@NotNull Project project) {
        try {
            Editor selectedTextEditor = FileEditorManager.getInstance(project).getSelectedTextEditor();
            if (selectedTextEditor != null) {
                Document document = selectedTextEditor.getDocument();
                PsiFile psiFile = PsiDocumentManager.getInstance(project).getPsiFile(document);
                if (psiFile != null) {
                    VirtualFile sourceFile = psiFile.getVirtualFile();
                    FileType fileType = sourceFile.getFileType();
                    if (FileHelper.isCompilable(fileType) && !FileHelper.isInterface(fileType)) {
                        InsightManager insightManager = project.getComponent(InsightManager.class);

                        // All file names are unique, use that to get the corresponding cmt
                        String moduleName = ((FileBase) psiFile).asModuleName();
                        PsiFile[] cmtFiles = FilenameIndex.getFilesByName(project, moduleName + ".cmt", GlobalSearchScope.allScope(project));

                        if (cmtFiles.length == 1) {
                            insightManager.queryTypes(sourceFile, FileSystems.getDefault().getPath(cmtFiles[0].getVirtualFile().getPath()), types -> ApplicationManager.getApplication().runReadAction(() -> annotatePsiExpressions(project, psiFile.getLanguage(), types, sourceFile)));
                        } else {
                            LOG.info("File module for " + moduleName + ".cmt is NOT FOUND");
                        }
                    }
                }
            }
        } catch (Error e) {
            // might produce an AssertionError when project is disposed but the invokeLater still process that code
        }
    }

    static void annotateFile(@NotNull Project project, @NotNull Language lang, @Nullable InferredTypes types, @Nullable VirtualFile sourceFile) {
        ApplicationManager.getApplication().runWriteAction(() -> annotatePsiExpressions(project, lang, types, sourceFile));
    }

    private static void annotatePsiExpressions(@NotNull Project project, @NotNull Language lang, @Nullable InferredTypes types, @Nullable VirtualFile sourceFile) {
        if (types == null || sourceFile == null) {
            return;
        }

        TextEditor selectedEditor = (TextEditor) FileEditorManager.getInstance(project).getSelectedEditor(sourceFile);

        if (selectedEditor != null) {
            CodeLensView.CodeLensInfo userData = getCodeLensData(project, sourceFile);
            long timestamp = sourceFile.getTimeStamp();

            userData.putAll(sourceFile, types.signaturesByLines(OclLanguage.INSTANCE), timestamp);

            PsiFile psiFile = PsiManager.getInstance(project).findFile(sourceFile);
            if (psiFile != null) {
                psiFile.putUserData(DocumentationProvider.SIGNATURE_CONTEXT, types.typesByIdents());
            }
        }
    }

    @NotNull
    private static CodeLensView.CodeLensInfo getCodeLensData(@NotNull Project project, @Nullable VirtualFile sourceFile) {
        CodeLensView.CodeLensInfo userData = project.getUserData(CodeLensView.CODE_LENS);
        if (userData == null) {
            userData = new CodeLensView.CodeLensInfo();
            project.putUserData(CodeLensView.CODE_LENS, userData);
        } else if (sourceFile != null) {
            userData.clearInternalData(sourceFile);
        }
        return userData;
    }
}

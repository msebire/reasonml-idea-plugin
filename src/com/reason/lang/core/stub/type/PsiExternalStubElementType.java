package com.reason.lang.core.stub.type;

import com.intellij.lang.Language;
import com.intellij.psi.stubs.*;
import com.reason.ide.search.IndexKeys;
import com.reason.lang.core.psi.PsiExternal;
import com.reason.lang.core.psi.impl.PsiExternalImpl;
import com.reason.lang.core.stub.PsiExternalStub;
import com.reason.lang.core.type.ORTypes;
import com.reason.lang.ocaml.OclTypes;
import com.reason.lang.reason.RmlLanguage;
import com.reason.lang.reason.RmlTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class PsiExternalStubElementType extends IStubElementType<PsiExternalStub, PsiExternal> {

    public PsiExternalStubElementType(@NotNull String name, @Nullable Language language) {
        super(name, language);
    }

    @NotNull
    public PsiExternalImpl createPsi(@NotNull PsiExternalStub stub) {
        ORTypes types = getLanguage() instanceof RmlLanguage ? RmlTypes.INSTANCE : OclTypes.INSTANCE;
        return new PsiExternalImpl(types, stub, this);
    }

    @NotNull
    public PsiExternalStub createStub(@NotNull PsiExternal psi, StubElement parentStub) {
        return new PsiExternalStub(parentStub, this, psi.getName(), psi.isFunction());
    }

    public void serialize(@NotNull PsiExternalStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
        dataStream.writeBoolean(stub.isFunction());
    }

    @NotNull
    public PsiExternalStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        return new PsiExternalStub(parentStub, this, dataStream.readName(), dataStream.readBoolean());
    }

    public void indexStub(@NotNull PsiExternalStub stub, @NotNull IndexSink sink) {
        String name = stub.getName();
        if (name != null) {
            sink.occurrence(IndexKeys.EXTERNALS, name);
        }
    }

    @NotNull
    public String getExternalId() {
        return getLanguage() + "." + super.toString();
    }
}

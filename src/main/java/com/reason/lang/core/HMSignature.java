package com.reason.lang.core;

import com.reason.Joiner;
import com.reason.lang.core.psi.impl.PsiSignatureItem;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * Hindley-Milner signature
 */
public class HMSignature {

    public static final HMSignature EMPTY = new HMSignature("");

    @NotNull
    private final SignatureType[] m_types;
    @NotNull
    private final String m_signature;

    public static class SignatureType {
        String value;
        boolean mandatory = false;
        String defaultValue = "";

        @Override
        public String toString() {
            return value;
        }
    }

    public HMSignature(@NotNull Collection<PsiSignatureItem> items) {
        m_types = new SignatureType[items.size()];
        int i = 0;
        for (PsiSignatureItem item : items) {
            String[] tokens = item.getText().split("=");
            SignatureType signatureType = new SignatureType();
            signatureType.value = tokens[0];
            signatureType.mandatory = !tokens[0].contains("option") && tokens.length == 1;
            signatureType.defaultValue = 2 == tokens.length ? tokens[1] : "";

            m_types[i] = signatureType;
            i++;
        }

        if (m_types.length < 3) {
            m_signature = Joiner.join(" -> ", m_types);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for (int j = 0; j < m_types.length - 1; j++) {
                SignatureType m_type = m_types[j];
                if (0 < j) {
                    sb.append(", ");
                }
                sb.append(m_type);
            }
            sb.append(") -> ").append(m_types[m_types.length - 1]);
            m_signature = sb.toString();
        }
    }

    public HMSignature(@NotNull String signature) {
        String normalized = signature.
                trim().
                replaceAll("\n", "").
                replaceAll("\\s+", " ").
                replaceAll("=>", "->");

        String[] items = normalized.split("->");
        m_types = new SignatureType[items.length];
        for (int i = 0; i < items.length; i++) {
            String[] tokens = items[i].trim().split("=");
            m_types[i] = new SignatureType();
            m_types[i].value = tokens[0];
            m_types[i].mandatory = !tokens[0].contains("option") && tokens.length == 1;
            m_types[i].defaultValue = 2 == tokens.length ? tokens[1] : "";
        }

        // Always use thin arrow
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m_types.length; i++) {
            if (0 < i) {
                sb.append(" -> ");
            }
            SignatureType type = m_types[i];
            sb.append(type.value);
        }
        m_signature = sb.toString();
    }

    @Override
    public String toString() {
        return m_signature;
    }

    public boolean isFunctionSignature() {
        return 1 < m_types.length;
    }

    public boolean isEmpty() {
        return m_signature.isEmpty();
    }

    public boolean isMandatory(int index) {
        return m_types.length <= index || m_types[index].mandatory;
    }

    public SignatureType[] getTypes() {
        return m_types;
    }
}
